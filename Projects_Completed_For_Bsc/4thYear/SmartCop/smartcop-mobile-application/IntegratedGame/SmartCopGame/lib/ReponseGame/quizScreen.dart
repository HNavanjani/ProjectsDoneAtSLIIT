import 'dart:async';
import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/marks.dart';
import 'api.dart';
import 'resultScreen.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'prediction.dart';

class getjson extends StatelessWidget {
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: DefaultAssetBundle.of(context)
          .loadString("questions/videobased.json"),
      builder: (context, snapshot) {
        List questionlist = json.decode(snapshot.data.toString());
        if (questionlist == null) {
          return Scaffold(
            body: Center(
              child: Text(
                "Loading",
              ),
            ),
          );
        } else {
          return quizScreen(questionlist: questionlist);
        }
      },
    );
  }
}

class getaudiojson extends StatelessWidget {
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: DefaultAssetBundle.of(context)
          .loadString("questions/audiobased.json"),
      builder: (context, snapshot) {
        List Audioquestionlist = json.decode(snapshot.data.toString());
        if (Audioquestionlist == null) {
          return Scaffold(
            body: Center(
              child: Text(
                "Loading",
              ),
            ),
          );
        } else {
          return quizScreen(questionlist: Audioquestionlist);
        }
      },
    );
  }
}

class getarticlejson extends StatelessWidget {
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: DefaultAssetBundle.of(context)
          .loadString("questions/articlebased.json"),
      builder: (context, snapshot) {
        List Articlequestionlist = json.decode(snapshot.data.toString());
        if (Articlequestionlist == null) {
          return Scaffold(
            body: Center(
              child: Text(
                "Loading",
              ),
            ),
          );
        } else {
          return quizScreen(questionlist: Articlequestionlist);
        }
      },
    );
  }
}

class quizScreen extends StatefulWidget {
  var questionlist;

  quizScreen({Key key, @required this.questionlist}) : super(key: key);
  _quizScreenState createState() => _quizScreenState(questionlist);
}

class _quizScreenState extends State<quizScreen> {
  var questionlist;

  _quizScreenState(this.questionlist);
  SharedPreferences logindata;
  String loggeduser, loggeduid;
  Color colortoShow = Colors.indigoAccent;
  Color rightAnswer = Colors.green;
  Color wrongAnswer = Colors.red;
  int questionNumber = 1;
  int marks = 0;
  int timer = 50;
  int qus = 1;
  int ansStatus;
  String predictedDifficulty = null;
  int time;
  int qnumber = 1;
  String showTimer = "50";
  Map<String, Color> btnColor = {
    "a": Colors.indigoAccent,
    "b": Colors.indigoAccent,
    "c": Colors.indigoAccent,
    "d": Colors.indigoAccent,
  };
  bool cancelTimer = false;
  bool isEditing = false;
  Marks playername;
  DocumentSnapshot data;
  void loggedUsername() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggeduser = logindata.getString('userName');
      loggeduid = logindata.getString('uid');
    });
  }

  add() {
    if (isEditing) {
      updateMarks(playername, marks);
      setState(() {
        isEditing = false;
      });
    } else {
      storeMarks(loggeduser, marks, loggeduid);
    }
  }

  Future<void> generateNextQuestion() async {
    cancelTimer = false;
    //timer=50;
    var Timebody = [
      [
        {
          "CurrentQuestion": qus,
          "TimeTakenToAnswer": time,
          "AnswerStatus": ansStatus,
          "TimeGiven": timer
        }
      ]
    ];
    int newtime = await predictTime(Timebody);
    timer = newtime;
    var body = [
      [
        {
          "CurrentQuestion": qus,
          "TimeTakenToAnswer": time,
          "AnswerStatus": ansStatus
        }
      ]
    ];

    print(newtime);
    var resp = await predictDifficultyLevel(body);
    print(resp);
    print(predictedDifficulty);
    predictedDifficulty =
        predictedDifficulty.replaceAll("[", "").replaceAll("]", "");
    predictedDifficulty = predictedDifficulty.replaceAll("\"", "");

    setState(() {
      if (questionNumber < 2 && int.parse(predictedDifficulty) == 4) {
        questionNumber++;
        //qus++;
        qus = 4;
      } else if (questionNumber < 2 && int.parse(predictedDifficulty) == 3) {
        questionNumber++;
        qus = 3;
      } else if (questionNumber < 2 && int.parse(predictedDifficulty) == 2) {
        questionNumber++;
        qus = 2;
      } else if (questionNumber < 2 && int.parse(predictedDifficulty) == 1) {
        questionNumber++;
        qus = 1;
      } else {
        add();
        Navigator.of(context).pushReplacement(MaterialPageRoute(
          builder: (context) => resultScreen(marks: marks),
        ));
      }
      btnColor["a"] = Colors.indigoAccent;
      btnColor["b"] = Colors.indigoAccent;
      btnColor["c"] = Colors.indigoAccent;
      btnColor["d"] = Colors.indigoAccent;
    });
    startTimer();
  }

  @override
  Future<void> initState() {
    startTimer();
    super.initState();
    loggedUsername();
  }

  void startTimer() async {
    const onesec = Duration(seconds: 1);
    Timer.periodic(onesec, (Timer t) {
      setState(() {
        if (timer < 1) {
          t.cancel();
          generateNextQuestion();
        } else if (cancelTimer == true) {
          t.cancel();
        } else {
          timer = timer - 1;
        }
        showTimer = timer.toString();
      });
    });
  }

  void checkAnswer(String answer) {
    print(questionlist[2][qus.toString()][questionNumber.toString()]);
    if (answer == questionlist[2][qus.toString()][questionNumber.toString()]) {
      marks = marks + 20;
      print(marks);
      colortoShow = rightAnswer;
      ansStatus = 1;
    } else {
      colortoShow = wrongAnswer;
      ansStatus = 0;
    }
    setState(() {
      btnColor[answer] = colortoShow;
      print(timer);
      cancelTimer = true;
      if (timer > 40 && timer < 50) {
        time = 1;
      } else if (timer > 20 && timer <= 40) {
        time = 2;
      } else if (timer >= 1 && timer <= 20) {
        time = 3;
      }
    });
    Timer(Duration(seconds: 2), generateNextQuestion);
  }

  //METHOD TO PREDICT PRICE
//  Future predictQuestion(var body) async {
//    var client = new http.Client();
//    var uri = Uri.parse("https://research-1-app.herokuapp.com/predict");
//    Map<String, String> headers = {"Content-type": "application/json"};
//    String jsonString = json.encode(body);
//    try {
//      var resp = await client.post(uri, headers: headers, body: jsonString);
//      //var resp=await http.get(Uri.parse("http://192.168.1.101:5000"));
//      if (resp.statusCode == 200) {
//        print("DATA FETCHED SUCCESSFULLY");
//        var result = json.decode(resp.body);
////        print(result);
////        print(result["prediction"]);
//        return result;
//      }
//    } catch (e) {
//      print("EXCEPTION OCCURRED: $e");
//      return null;
//    }
//    return null;
//  }
//ML Model
  Future<http.Response> predictDifficultyLevel(var body) async {
    try {
      var url = "https://research-1-app.herokuapp.com/predict";
      //encode Map to JSON
      var body1 = jsonEncode(body);
      print(body1);
      var response = await http.post(url,
          headers: {"Content-Type": "application/json"}, body: body1);
      print(response);
      print("${response.statusCode}");
      print("${response.body}");
      var responsebody = response.body;

      predictedDifficulty = responsebody
          .toString()
          .replaceAll("{", "")
          .replaceAll("}", "")
          .split("\"prediction\":")
          .removeLast();
      print("*****************************");
      print(predictedDifficulty);

      return response;
    } catch (e) {
      print(e);
    }
  }

  Widget choiceAnswer(String answer) {
    return Padding(
      padding: EdgeInsets.symmetric(
        vertical: 10.0,
        horizontal: 20.0,
      ),
      child: MaterialButton(
        onPressed: () async {
          checkAnswer(answer);
          print(answer);
        },
        child: Text(
          questionlist[1][qus.toString()][questionNumber.toString()][answer],
          style: TextStyle(
              fontFamily: "Alike", color: Colors.white, fontSize: 16.0),
        ),
        color: btnColor[answer],
        splashColor: Colors.indigo[700],
        highlightColor: Colors.indigo[700],
        minWidth: 200.0,
        height: 45.0,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(20.0),
        ),
      ),
    );
  }

  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Column(
        children: <Widget>[
          Expanded(
            flex: 3,
            child: Container(
              padding: EdgeInsets.all(15.0),
              alignment: Alignment.bottomLeft,
              child: Text(
                questionlist[0][qus.toString()][questionNumber.toString()],
                style: TextStyle(
                  color: Colors.black,
                  fontFamily: "Quando",
                  fontSize: 16.0,
                ),
              ),
            ),
          ),
          Expanded(
            flex: 6,
            child: Container(
                width: 500.0,
                child: Column(
                  //mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    choiceAnswer("a"),
                    choiceAnswer("b"),
                    choiceAnswer("c"),
                    choiceAnswer("d"),
                  ],
                )),
          ),
          Expanded(
            flex: 1,
            child: Container(
              alignment: Alignment.topCenter,
              child: Center(
                child: Text(
                  showTimer,
                  style: TextStyle(
                    color: Colors.black,
                    fontSize: 35.0,
                    fontWeight: FontWeight.w700,
                    fontFamily: "Times New Roman",
                  ),
                ),
              ),
            ),
          )
        ],
      ),
    );
  }
}
