import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/welcome.dart';
import 'leaderBoard.dart';
import 'package:researchresponsegame/PreventionGame/services/usermanagement.dart';

class OptionScreen extends StatefulWidget {
  OptionScreenState createState() {
    return OptionScreenState();
  }
}

class OptionScreenState extends State<OptionScreen> {
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
                    alignment: Alignment.topLeft,
                    child: Container(
                      width: 160.0,
                      height: 200.0,
                      child: RaisedButton(
                          child: Text(
                            "SAFE LIFE QUIZ",
                            style:
                                TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                            textAlign: TextAlign.center,
                          ),
                          color: Color(0xff3399fe),
                          textColor: Colors.white,
                          splashColor: Color(0xff26cb3c),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10)),
                          onPressed: () {
                            Navigator.of(context)
                                .pushReplacement(MaterialPageRoute(
                              builder: (context) => welcomeScreen(),
                            ));
                          }),
                    ),
                  ),
                  SizedBox(
                    height: 30.0,
                  ),
                  Align(
                    alignment: Alignment.topRight,
                    child: Container(
                      width: 160.0,
                      height: 200.0,
                      child: RaisedButton(
                          child: Text(
                            "Prevention Game",
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
                              builder: (context) =>
                                  UserManagement().handleAuth(),
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
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return Container(
      decoration: BoxDecoration(
        image: DecorationImage(
            image: AssetImage('images/smartcop_cover.jpg'), fit: BoxFit.cover),
      ),
      child: Padding(
          padding: const EdgeInsets.only(top: 80.0, left: 30.0, right: 30.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Align(
                alignment: Alignment.topLeft,
                child: Container(
                  width: 200.0,
                  height: 200.0,
                  child: RaisedButton(
                      //child: Text("SAFE LIFE QUIZ",style: TextStyle(fontSize: 20.0,fontFamily: "Alike"),textAlign: TextAlign.center,),
                      child: Image(
                        image: AssetImage('images/two.png'),
                        fit: BoxFit.contain,
                        height: 200.0,
                      ),
                      //color: Color(0xff3399fe),
                      color: Colors.white30,
                      textColor: Colors.white,
                      splashColor: Color(0xff26cb3c),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10)),
                      onPressed: () {
                        Navigator.of(context).pushReplacement(MaterialPageRoute(
                          builder: (context) => welcomeScreen(),
                        ));
                      }),
                ),
              ),
              SizedBox(
                height: 30.0,
              ),
              Align(
                alignment: Alignment.topRight,
                child: Container(
                  width: 160.0,
                  height: 200.0,
                  child: RaisedButton(
                      child: Text(
                        "Prevention Game",
                        style: TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                        textAlign: TextAlign.center,
                      ),
                      color: Color(0xffff3266),
                      textColor: Colors.white,
                      splashColor: Color(0xffff3266),
                      shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(10)),
                      onPressed: () {
                        Navigator.of(context).pushReplacement(MaterialPageRoute(
                          builder: (context) => UserManagement().handleAuth(),
                        ));
                      }),
                ),
              ),
            ],
          )),
    );
  }
}
