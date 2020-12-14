import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/quizScreen.dart';

class articleScreen extends StatefulWidget {
  articleScreenState createState() => articleScreenState();
}

class articleScreenState extends State<articleScreen> {
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      body: Column(
        children: <Widget>[
          Expanded(
            flex: 1,
            child: Container(
              padding: EdgeInsets.all(15.0),
              alignment: Alignment.bottomLeft,
              child: Text(
                "Jack witnesses a road traffic accident. He is the first on the scene. There is a motobike rider and a car involved. He pre-warns the traffic by putting on his hazard "
                "warning lights.\nThere are two casualties. The rider is lying in the middle of the road and is bleeding heavily from his leg and the"
                "other injured person has minor injuries but appears to be in shock.He calls the emergency services and deals with the rider.\n"
                "An ambulance and a police car arrive at the scene moments later. Whilst the paramedics deal with the casualties.Jack is giving information to the police.",
                style: TextStyle(
                  color: Colors.black,
                  fontFamily: "Quando",
                  fontSize: 13.0,
                ),
              ),
            ),
          ),
          Expanded(
            flex: 1,
            child: Container(
              alignment: Alignment.topCenter,
              child: Center(
                child: RaisedButton(
                    child: Text(
                      "Quiz",
                      style: TextStyle(fontSize: 20.0, fontFamily: "Alike"),
                      textAlign: TextAlign.center,
                    ),
                    color: Colors.indigoAccent,
                    textColor: Colors.white,
                    splashColor: Colors.indigo[700],
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(10)),
                    onPressed: () {
                      Navigator.of(context).pushReplacement(MaterialPageRoute(
                        builder: (context) => getarticlejson(),
                      ));
                    }),
              ),
            ),
          )
        ],
      ),
    );
  }
}
