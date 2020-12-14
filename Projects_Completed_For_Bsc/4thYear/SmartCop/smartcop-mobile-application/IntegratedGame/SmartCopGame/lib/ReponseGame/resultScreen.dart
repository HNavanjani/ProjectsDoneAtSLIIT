import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/home.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'api.dart';
import 'dashBoard.dart';

class resultScreen extends StatefulWidget {
  int marks;
  resultScreen({Key key, @required this.marks}) : super(key: key);
  @override
  _resultScreenState createState() => _resultScreenState(marks);
}

class _resultScreenState extends State<resultScreen> {
  SharedPreferences logindata;
  String loggeduser;
  List<String> images = [
    "images/award.jpg",
    "images/award.jpg",
    "images/award.jpg"
  ];

  String message;
  String image;

  @override
  void initState() {
    if (marks < 20) {
      image = images[2];
      message = "You Should Try Hard\n" + "You scored $marks marks";
    } else if (marks < 35) {
      image = images[1];
      message = "You Can Do Better\n" + "You scored $marks marks";
    } else {
      image = images[0];
      message = "You Did Very Well\n" + "You scored $marks marks";
    }
    super.initState();
    loggedUsername();
  }

  int marks;
  //Store logged user's username
  void loggedUsername() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggeduser = logindata.getString('userName');
    });
  }

  _resultScreenState(this.marks);
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          leading: IconButton(
            icon: Icon(Icons.arrow_back, color: Colors.white),
            onPressed: () => Navigator.push(context,
                MaterialPageRoute(builder: (context) => DashBoardScreen())),
          ),
          title: Text("Safe Life Quiz Result"),
          actions: [
            IconButton(
              icon: Icon(
                Icons.power_settings_new,
                color: Colors.white,
              ),
              onPressed: () {
                signOut(context);
              },
            ),
          ],
          backgroundColor: Colors.indigoAccent,
        ),
        body: Column(
          children: <Widget>[
            Expanded(
              flex: 18,
              child: Card(
                color: Colors.blue,
                child: Container(
                  padding: EdgeInsets.all(32.0),
                  child: Column(
                    children: <Widget>[
                      Material(
                        color: Colors.blue,
                        child: Container(
                          width: 300.0,
                          height: 300.0,
                          alignment: Alignment.center,
                          child: ClipRect(
                            child: Image(
                              image: AssetImage(
                                image,
                              ),
                            ),
                          ),
                        ),
                      ),
                      Padding(
                        padding: EdgeInsets.symmetric(
                          vertical: 8.0,
                          horizontal: 15.0,
                        ),
                        child: Center(
                          child: Text(
                            loggeduser + ' ' + message,
                            style: TextStyle(
                              fontSize: 16.0,
                              fontFamily: "Quando",
                              color: Colors.white,
                            ),
                          ),
                        ),
                      )
                    ],
                  ),
                ),
              ),
            ),
            Expanded(
              flex: 4,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  RaisedButton(
                    onPressed: () {
                      Navigator.of(context).pushReplacement(MaterialPageRoute(
                        builder: (context) => HomeScreen(),
                      ));
                    },
                    color: Colors.indigoAccent,
                    textColor: Colors.white,
                    child: Text(
                      "Continue",
                      style: TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                    ),
                    padding: EdgeInsets.symmetric(
                      vertical: 10.0,
                      horizontal: 20.0,
                    ),
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10)),
                    splashColor: Colors.indigoAccent,
                  )
                ],
              ),
            )
          ],
        ));
  }
}
