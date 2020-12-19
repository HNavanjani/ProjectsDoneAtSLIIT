import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/screens/game/widgets/upperSection.dart';
import 'package:researchresponsegame/PreventionGame/screens/game/widgets/puzzleSection.dart';
import 'gameController.dart';
import 'package:researchresponsegame/PreventionGame/globals.dart';
import 'package:researchresponsegame/PreventionGame/home.dart';
import 'dart:async';
import 'package:flutter/widgets.dart';
import 'package:flutter/foundation.dart';
import "dart:math";
import 'package:path_provider/path_provider.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:researchresponsegame/PreventionGame/appbar.dart';

class Game extends StatefulWidget {
  final String answer;

  @override
  _GameState createState() => _GameState();

  Game({@required this.answer});
}

class _GameState extends State<Game> {
  GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();
  double screenHeight;

  int _counter = 60;
  Timer _timer;
  bool isGameOver = false;

  SharedPreferences logindata;
  String loggedEmail;

  int noOfGameAttempts;

  void initial() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggedEmail = logindata.getString('email');
    });
  }

  void _startTimer() {
    _counter = 60;
    if (_timer != null) {
      isGameOver = true;
      _timer.cancel();
    }
    _timer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        if (_counter > 0) {
          _counter--;
        } else {
          isGameOver = true;
          _timer.cancel();
        }
      });
    });
  }

  GameController gameController;

  String letter;

  String filePath;

  UpperSection _upperSection;

  PuzzleSection _puzzleSection;

  TextEditingController _textEditingController;

  int latestScore;

  List<String> list22 = [];

  TextEditingController emailControler = new TextEditingController();

  showMessage(BuildContext context) {
    Widget okButton = FlatButton(
      child: Text("Next Game"),
      onPressed: () {
        displayHint();
        Navigator.pushAndRemoveUntil(
            context,
            MaterialPageRoute(
              builder: (context) => Game(answer: generatedQuestion),
            ),
            (Route<dynamic> route) => false);
      },
    );
  }

  @override
  void initState() {
    _textEditingController = TextEditingController(text: letter);

    gameController = GameController(answer: widget.answer);

    _upperSection = UpperSection(incorrectLetters: []);

    _puzzleSection = PuzzleSection(
      wordLength: gameController.answerLength,
      puzzleLetters: gameController.puzzleLetters,
    );

    gameController.onSomething.stream.listen((String data) {
      manageGameEvents(data);
    });

    super.initState();
    initial();

    WidgetsBinding.instance.addPostFrameCallback((_) => _startTimer());

    startCountDownTimer();
    _incrementStartup();
  }



  Future<int> _getIntFromSharedPref() async {
    final prefs = await SharedPreferences.getInstance();
    final startupNumber = prefs.getInt('startupNumber');
    if (startupNumber == null) {
      return 0;
    }
    return startupNumber;
  }

  Future<void> _resetCounter() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt('startupNumber', 0);
  }

  Future<void> _incrementStartup() async {
    final prefs = await SharedPreferences.getInstance();

    int lastStartupNumber = await _getIntFromSharedPref();
    int currentStartupNumber = ++lastStartupNumber;

    await prefs.setInt('startupNumber', currentStartupNumber);

    setState(() => noOfGameAttempts = currentStartupNumber);
  }

  manageGameEvents(String event) {
    setState(() {
      gameController.updateImagePath();

      _puzzleSection = PuzzleSection(
        wordLength: gameController.answerLength,
        puzzleLetters: gameController.puzzleLetters,
      );

      _upperSection = UpperSection(
        incorrectLetters: gameController.wrongLetters,
      );
    });
  }

  _restrictTextToOne(String value) {
    setState(() {
      letter = value[value.length - 1];

      _textEditingController.text = letter;

      _textEditingController.selection =
          TextSelection.fromPosition(TextPosition(offset: value.length - 1));
    });
  }

  void submit(String letter) {
    gameController.takeShot(letter);

    letter = '';

    _textEditingController.text = '';

    FocusScope.of(context).requestFocus(new FocusNode());
  }

  Future generateNextQuestion() async {
    latestScore = gameController.getScore();

    print("#########################listLevel10000000000000000000000");
    print(listLevel1);
    print(listLevel2);
    print(listLevel3);

    if (int.parse(predictedDifficulty) == 0) {
      print(predictedDifficulty +
          "#### Low level difficulty - EASY question suggested");
      print(listLevel1);
      final _random = new Random();
      element = listLevel1[_random.nextInt(listLevel1.length)];
    } else if (int.parse(predictedDifficulty) == 1 ||
        int.parse(predictedDifficulty) == 2) {
      print(predictedDifficulty +
          "#### Medium level difficulty - DIFFICULT question suggested");
      print(listLevel2);
      final _random = new Random();
      element = listLevel2[_random.nextInt(listLevel2.length)];
    }

    print("******latestScoreGENERATED QUESTION AND HINT*******");
    print(element);
    generatedQuestion = element
        .toString()
        .split('=>')
        .removeAt(0)
        .toString()
        .replaceAll('(', '')
        .trim();

    print("******latestScoreQUESTION*******");
    print(generatedQuestion);

    hint = element
        .toString()
        .split("=>")
        .removeAt(1)
        .toString()
        .replaceAll(')', '')
        .trim();

    return generatedQuestion;
  }

  String displayHintF() {
    print("////NextQHINT///");
    print(hint);
    return hint;
  }

  String displayHint() {
    print("////HINT///");
    print(hint);
    return hint;
  }

  Future addPlayerDetails() async {
    print("/////////////Adding Player Details////////////////////////");
    await databaseReference.collection("playerDetails").add({
      'score': gameController.getScore(),
      'nextLevelQuestion': generatedQuestion,
      'elapsedTime': _counter,
    }).then((documentReference) {
      print("INSERTED RECORD IS: " + documentReference.documentID);
      latestRecord = documentReference.documentID;
    }).catchError((e) {
      print(e);
    });
    return latestRecord;
  }

  Future addProgressDetails() async {
    print(
        "/////////////Adding Player Progress Details////////////////////////");
    await databaseReference.collection("progressData").add({
      'attempt': "Attempt " +
          (noOfGameAttempts)
              .toString(), //"Attempt"+FieldValue.increment(1).toString(),
      'colorVal': "0xffb74093",
      'email': loggedEmail,
      'score': gameController.getScore(),
    }).then((documentReference) {
      print("INSERTED RECORD IS: " + documentReference.documentID);
      latestRecord = documentReference.documentID;
    }).catchError((e) {
      print(e);
    });
    return latestRecord;
  }

  int getscore_val() {
    //score_val = 1;
    if (gameController.getScore() < 5) {
      score_val = 0;
    } else if (gameController.getScore() >= 5) {
      score_val = 1;
    }
    print("?????????????????????????");
    print(score_val);
    return score_val;
  }

  int gettime_val() {
    //time_val = 0;
    if (_counter < 30) {
      time_val = 0;
    } else if (_counter >= 30) {
      time_val = 1;
    }
    print("?????????????????????????");
    print(time_val);
    return time_val;
  }

  //ML Model
  Future<http.Response> predictDifficultyLevel() async {
    getscore_val();
    gettime_val();

    try {
      var url = "https://predictquestiondifficulty.herokuapp.com/";
      //encode Map to JSON
      body = jsonEncode(
          <String, int>{'scoreLevel': score_val, 'timeLevel': time_val});
      print(body);

      var response = await http.post(url,
          headers: {"Content-Type": "application/json"}, body: body);
      print(response);
      print("${response.statusCode}");
      print("${response.body}");
      responsebody = response.body;

      predictedDifficulty = responsebody
          .toString()
          .replaceAll("{", "")
          .replaceAll("}", "")
          .split("\"results\":")
          .removeLast();
      print("*****************************");
      print(predictedDifficulty);

      return response;
    } catch (e) {
      print(e);
    }
  }

  //Add predicted val to db
  Future addPredictedDifficulty() async {
    await databaseReference.collection("predictedDifficulties").add({
      'features': body,
      'predictedDifficulty': predictedDifficulty, //responsebody,
      'suggestedQuestion': element,
    }).then((documentReference) {
      print("INSERTED RECORD IS: " + documentReference.documentID);
    }).catchError((e) {
      print(e);
    });
  }

  int getpredictedDifficulty() {
    predictedDifficulty = responsebody.toString();
    //predictedDifficulty = responsebody.toString().split("{\"results\":").removeLast();
    print("*****************************");
    print(predictedDifficulty);
  }

  Future<String> get _localPath async {
    final directory = await getApplicationSupportDirectory();

    return directory.absolute.path;
  }

  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    Widget _buildTextField(BuildContext context) {
      return Container(
        width: 300.0,
        child: TextField(
            controller: _textEditingController,
            onChanged: (String value) {
              _restrictTextToOne(value);
            },
            style: Theme.of(context).textTheme.title.copyWith(fontSize: 20.0),
            decoration: InputDecoration(
              labelText: 'Enter Next Letter:',
              border: InputBorder.none,
            ),
            onSubmitted: submit),
      );
    }

    final answeredPuzzle = PuzzleSection(
      wordLength: gameController.answerLength,
      puzzleLetters: gameController.answer.split(''),
    );

    if (gameController.alreadyWon()) {
      //*new additions
      isGameOver = true;
      addProgressDetails();
      //*new additions
      _timer.cancel();
      addPlayerDetails();
      attemptCounter++;
      //addProgressDetails();
      //getProgressDetails();
      predictDifficultyLevel();
      addPredictedDifficulty();
    }

    Widget _buildPuzzle(bool alreadyLost) {
      if (alreadyLost) {
        isGameOver = true;
        _timer.cancel();
        //addPlayerDetails();
        //addProgressDetails();
        //getProgressDetails();
        predictDifficultyLevel();
        addPredictedDifficulty();

        return Column(
          children: <Widget>[
            Text(
              'Answer',
              style: Theme.of(context).textTheme.subhead,
            ),
            answeredPuzzle,
          ],
        );
      } else {
        return _puzzleSection;
      }
    }

    return new Scaffold(
      key: _scaffoldKey,
      //appBar: GetAppBar().getAppBar(),

      appBar: AppBar(
        titleSpacing: 0.0,
        elevation: 5.0,
        backgroundColor: Colors.blueAccent,
        //Color.fromRGBO(51, 193, 255, 100),
        leading: IconButton(
          icon: Icon(Icons.arrow_back),
          onPressed: () {
            Navigator.push(
                context, MaterialPageRoute(builder: (context) => Home()));
          },
        ),
        title: Row(
          children: <Widget>[
            SizedBox(
              width: 15,
            ),
            Container(
                margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
                child: CircleAvatar(
                  backgroundImage: NetworkImage(
                      "https://i.pinimg.com/originals/ac/47/03/ac4703dff7a37608748767be7f50fd34.jpg"),
                  radius: 25.0,
                ),
                decoration: new BoxDecoration(
                  border: new Border.all(
                    color: Colors.pink,
                    width: 1.0,
                  ),
                  borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
                )),
            Container(
              //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Container(
                      child: Text(
                        'SmartCop',
                        style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
                      ),
                    ),
                    SizedBox(height: 4.0),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: <Widget>[
                        Icon(
                          Icons.arrow_forward_ios,
                          color: Colors.white,
                          size: 12.0,
                        ),
                        SizedBox(width: 4.0),
                        Text('Road Accident Prevention Game',
                            style: TextStyle(fontSize: 12.0))
                      ],
                    ),
                  ]),
            )
          ],
        ),
        actionsIconTheme:
            IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
      ),
      body: Container(
        color: Color.fromRGBO(51, 193, 255, 100),
        child: ListView(
          children: [
            SizedBox(height: 5.0),
            Container(
              padding: EdgeInsets.symmetric(vertical: 5.0, horizontal: 10.0),
              child: FlatButton(
                color: Colors.green,
                textColor: Colors.white,
                onPressed: () => {},
                child: Text(
                  //"Your Score is: " + gameController.getScore().toString(),noOfGameAttempts
                    "Attempt No: "+ noOfGameAttempts.toString()+ " , Your Score is: " + gameController.getScore().toString(),
                  style: TextStyle(fontSize: 20.0),
                ),
              ),

              /*
              child: Text(
                "Your Score is: " + gameController.getScore().toString(),
              ),

               */
            ),
            SizedBox(height: 1.0),

            (!isGameOver)
                ? Container(
                    padding:
                        EdgeInsets.symmetric(vertical: 5.0, horizontal: 10.0),
                    child: FlatButton(
                      onPressed: () => {},
                      color: Colors.yellowAccent,
                      child: Text(
                        "Remaining Time: " + '$_counter',
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 20,
                        ),
                      ),
                    ))

                /*: FlatButton(
              onPressed: () => {},
              color: Colors.yellowAccent,
              child: Text(
                "Game Over",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 20,
                ),
              ),
            ),
*/

                : AlertDialog(
                    title: Text("SmartCop"),
                    content: Text("Game Over ...."),
                    actions: [
                        FlatButton(
                            child: Text("Try Again"),
                            onPressed: () {
                              //Launch game screen

                              generateNextQuestion();
                              displayHintF();
                              
                              Navigator.pushAndRemoveUntil(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) => Game(answer: generatedQuestion),
                                  ),
                                      (Route<dynamic> route) => false);
                            })
                      ]),

            SizedBox(height: 2.0),
            Container(
              padding: EdgeInsets.symmetric(vertical: 1.0, horizontal: 20.0),
              child: Text(
                "Hint for the question: ",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Colors.black.withOpacity(1.0),
                  fontSize: 22,
                ),
              ),
            ),
            SizedBox(height: 2.0),
            Container(
              child: FlatButton(
                child: Text(
                  displayHint().toString(),
                  style: TextStyle(
                    color: Colors.black.withOpacity(1.0),
                    fontSize: 18,
                  ),
                ),
              ),
            ),
            SizedBox(height: 2.0),
            _upperSection,
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 10.0),
              child: Image.asset(
                '${gameController.imagePath}',
                width: double.infinity,
                height: 300.0,
              ),
            ),
            _buildPuzzle(gameController.alreadyLost()),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.end,
              children: gameController.alreadyWon()
                  ? []
                  : gameController.alreadyLost()
                      ? []
                      : <Widget>[
                          _buildTextField(context),
                        ],
            ),
//            Container(
//              width: double.infinity,
//              padding: EdgeInsets.symmetric(vertical: 5.0, horizontal: 10.0),
//              alignment: Alignment.center,
//              child: FlatButton(
//                color: Colors.orange,
//                textColor: Colors.black,
//                child: Text(
//                  'Proceed to Next Level >>',
//                  style: TextStyle(fontSize: 28.0),
//                ),
//                onPressed: () {
//                  //addPlayerDetails();
//                  generateNextQuestion();
//                  displayHintF();
//                  //****getCsv();
//                  addProgressDetails();
//                  Navigator.pushAndRemoveUntil(
//                      context,
//                      MaterialPageRoute(
//                        builder: (context) => Game(answer: generatedQuestion),
//                      ),
//                      (Route<dynamic> route) => false);
//                },
//              ),
//            ),
            //SizedBox(height: 20.0),
          ],
        ),
      ),
    );
  }
}
