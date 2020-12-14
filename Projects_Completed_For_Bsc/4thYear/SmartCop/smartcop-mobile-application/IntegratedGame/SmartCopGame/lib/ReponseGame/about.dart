import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'api.dart';
import 'dashBoard.dart';

class About extends StatefulWidget {
  @override
  AboutState createState() {
    return AboutState();
  }
}

class AboutState extends State<About> {
  double screenHeight;

  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return new Scaffold(
      appBar: AppBar(
        elevation: 20.0,
        backgroundColor: Colors.indigoAccent,
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.white),
          onPressed: () => Navigator.push(context,
              MaterialPageRoute(builder: (context) => DashBoardScreen())),
        ),
        title: Row(
          children: <Widget>[
            SizedBox(
              width: 15,
            ),
            Container(
                margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
//                child: CircleAvatar(
//                  backgroundImage: ExactAssetImage('images/logo.png'),
//                  radius: 25.0,
//                ),
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
                    Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: <Widget>[
                        Text('Safe Life Quiz',
                            style: TextStyle(
                                fontSize: 20.0, fontFamily: "Quando")),
                        IconButton(
                          padding: EdgeInsets.only(left: 80),
                          icon: Icon(
                            Icons.power_settings_new,
                            color: Colors.white,
                          ),
                          onPressed: () {
                            signOut(context);
                          },
                        ),
                      ],
                    ),
                  ]),
            )
          ],
        ),
        actionsIconTheme:
            IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
      ),
      body: ListView(
        children: <Widget>[
          SizedBox(height: 18.0),
          ListTile(
              title: Text(
                  'Safe Life Quiz is based on 100 Questions with answers on post road accident responsibility on the spot.',
                  style: TextStyle(fontSize: 15.0, fontFamily: 'Alike'))),
          SizedBox(height: 18.0),
          ListTile(
            title: Text(
                'Safe Life Quiz covers almost all the topics which are related to post road accident responsibility o the spot of incident. This can be help for our general routine life. Those who are already have basic post road accident knowledge can check their memory by go through all the 100 questions and see where they stand. The special feature of this game is questions will change by analyzing the player previous performance. So, this can help player to attempt different question everytime. The game contains video, audio and article based questions.',
                style: TextStyle(fontSize: 15.0, fontFamily: 'Alike')),
          ),
          ListTile(
            title: Text('Logged-in users can:'),
          ),
          ListTile(
            leading: Icon(
              Icons.play_arrow,
              color: Colors.indigoAccent,
            ),
            title: Text('Play quiz'),
          ),
          ListTile(
            leading: Icon(
              Icons.equalizer,
              color: Colors.indigoAccent,
            ),
            title: Text('View leaderboard'),
          ),
          ListTile(
            leading: Icon(
              Icons.supervisor_account,
              color: Colors.indigoAccent,
            ),
            title: Text('view user profile'),
          ),
        ],
      ),
    );
  }
}
