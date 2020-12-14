import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/about.dart';
import 'package:researchresponsegame/ReponseGame/home.dart';
import 'package:researchresponsegame/ReponseGame/userprofile.dart';
import 'audioBasedIntro.dart';
import 'leaderBoard.dart';

class DashBoardScreen extends StatefulWidget {
  const DashBoardScreen({Key key, this.user}) : super(key: key);
  final FirebaseUser user;
  DashBoardScreenState createState() {
    return DashBoardScreenState();
  }
}

class DashBoardScreenState extends State<DashBoardScreen> {
  double screenHeight;
  Widget loginCard(BuildContext context) {
    return Form(
        child: Column(
      children: <Widget>[
        Container(
          height: 600.0,
          color: Colors.white,
          margin: EdgeInsets.only(top: screenHeight / 10),
          padding: EdgeInsets.only(left: 10, right: 10),
          child: Padding(
              padding: const EdgeInsets.all(30.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  Align(
                    alignment: Alignment.topCenter,
                    child: Container(
                      width: double.infinity,
                      height: 100.0,
                      child: RaisedButton(
                          child: Text(
                            "PLAY QUIZ",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Color(0xffed622b),
                          textColor: Colors.white,
                          splashColor: Color(0xffed622b),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => HomeScreen(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Align(
                    alignment: Alignment.topLeft,
                    child: Container(
                      width: 140.0,
                      height: 100.0,
                      child: RaisedButton(
                          child: Text(
                            "USER PROFILE",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Color(0xff26cb3c),
                          textColor: Colors.white,
                          splashColor: Color(0xff26cb3c),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => Profile(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 10.0,
                  ),
                  Align(
                    alignment: Alignment.topRight,
                    child: Container(
                      width: 140.0,
                      height: 100.0,
                      child: RaisedButton(
                          child: Text(
                            "LEADER BOARD",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Color(0xffff3266),
                          textColor: Colors.white,
                          splashColor: Color(0xffff3266),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => LeaderBoardPage(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 20.0,
                  ),
                  Align(
                    alignment: Alignment.topRight,
                    child: Container(
                      width: double.infinity,
                      height: 100.0,
                      child: RaisedButton(
                          child: Text(
                            "ABOUT",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Color(0xff3399fe),
                          textColor: Colors.white,
                          splashColor: Color(0xffff3266),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => About(),
                            ));
                          }),
                    ),
                  ),
                ],
              )),
        ),
      ],
    ));
  }

  @override
//  void initState() {
//    super.initState();
//    _assetsAudioPlayer = AssetsAudioPlayer();
//    _assetsAudioPlayer.open(
//      Audio("assets/startup.mp3"),
//    );
//    _assetsAudioPlayer.playOrPause();
//  }
//
//  @override
//  void dispose() {
//    _assetsAudioPlayer = null;
//    super.dispose();
//  }

  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      backgroundColor: Colors.white,
      body: SingleChildScrollView(
        child: Stack(
          children: <Widget>[loginCard(context)],
        ),
      ),
    );
  }
}
