import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'videoBasedIntro.dart';
import 'package:assets_audio_player/assets_audio_player.dart';
import 'articleBasedIntro.dart';
import 'audioBasedIntro.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({Key key, this.user}) : super(key: key);
  final FirebaseUser user;
  HomeScreenState createState() {
    return HomeScreenState();
  }
}

class HomeScreenState extends State<HomeScreen> {
  double screenHeight;
  Widget upperHalf(BuildContext context) {
    return Container(
      height: 320,
      decoration: BoxDecoration(
          image: DecorationImage(
        image: AssetImage('images/background4.jpg'),
      )),
    );
  }

  Widget loginCard(BuildContext context) {
    return Form(
        child: Column(
      children: <Widget>[
        Container(
          height: 450.0,
          color: Colors.white,
          margin: EdgeInsets.only(top: screenHeight / 3),
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
                      height: 50.0,
                      child: RaisedButton(
                          child: Text(
                            "Play Video Based Quiz",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Colors.indigoAccent,
                          textColor: Colors.white,
                          splashColor: Colors.indigo[700],
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => VideoBasedIntroPage(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  Align(
                    alignment: Alignment.topCenter,
                    child: Container(
                      width: double.infinity,
                      height: 50.0,
                      child: RaisedButton(
                          child: Text(
                            "Play Audio Based Quiz",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Colors.indigoAccent,
                          textColor: Colors.white,
                          splashColor: Colors.indigo[700],
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => AudioBasedIntroPage(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  Align(
                    alignment: Alignment.topCenter,
                    child: Container(
                      width: double.infinity,
                      height: 50.0,
                      child: RaisedButton(
                          child: Text(
                            "Play Article Based Quiz",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Colors.indigoAccent,
                          textColor: Colors.white,
                          splashColor: Colors.indigo[700],
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => ArticleBasedIntroPage(),
                            ));
                          }),
                    ),
                  ),
                  Align(
                    alignment: Alignment.topCenter,
                    child: Container(
                      child: Image.asset(
                        'images/cheerup.gif',
                        fit: BoxFit.contain,
                        height: 150.0,
                      ),
                    ),
                  ),
                ],
              )),
        ),
      ],
    ));
  }

  AssetsAudioPlayer _assetsAudioPlayer;

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
          children: <Widget>[upperHalf(context), loginCard(context)],
        ),
      ),
    );
  }
}
