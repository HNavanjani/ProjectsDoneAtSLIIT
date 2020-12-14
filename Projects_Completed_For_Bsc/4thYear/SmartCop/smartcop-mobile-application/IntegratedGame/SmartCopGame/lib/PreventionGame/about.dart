import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/appbar.dart';

class About extends StatefulWidget {
  @override
  AboutState createState() {
    return AboutState();
  }
}

class AboutState extends State<About> {
  GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();

  double screenHeight;
  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return new Scaffold(
      key: _scaffoldKey,
//      appBar: AppBar(
//        titleSpacing: 0.0,
//        elevation: 5.0,
//        backgroundColor: Colors.blueAccent, //Color.fromRGBO(51, 193, 255, 100),
//        leading: IconButton(
//          icon: Icon(Icons.menu),
//          onPressed: () {
//            _scaffoldKey.currentState.openDrawer();
//          },
//        ),
//        title: Row(
//          children: <Widget>[
//            SizedBox(
//              width: 15,
//            ),
//            Container(
//                margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
//                child: CircleAvatar(
//                  backgroundImage: NetworkImage(
//                      "https://i.pinimg.com/originals/ac/47/03/ac4703dff7a37608748767be7f50fd34.jpg"),
//                  radius: 25.0,
//                ),
//                decoration: new BoxDecoration(
//                  border: new Border.all(
//                    color: Colors.pink,
//                    width: 1.0,
//                  ),
//                  borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
//                )),
//            Container(
//              //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
//              child: Column(
//                  mainAxisAlignment: MainAxisAlignment.center,
//                  crossAxisAlignment: CrossAxisAlignment.start,
//                  children: <Widget>[
//                    Container(
//                      child: Text(
//                        'SmartCop',
//                        style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
//                      ),
//                    ),
//                    SizedBox(height: 4.0),
//                    Row(
//                      mainAxisAlignment: MainAxisAlignment.start,
//                      children: <Widget>[
//                        Icon(
//                          Icons.arrow_forward_ios,
//                          color: Colors.white,
//                          size: 12.0,
//                        ),
//                        SizedBox(width: 4.0),
//                        Text('Road Accident Prevention Game',
//                            style: TextStyle(fontSize: 12.0))
//                      ],
//                    ),
//                  ]),
//            )
//          ],
//        ),
//        actionsIconTheme:
//            IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
//      ),
      appBar: GetAppBar().getAppBar(),

      body: ListView(
        children: <Widget>[
          SizedBox(height: 50.0),
          ListTile(
              title: Text(
                  'SmartCop Road Accident Prevention Game - A mobile game to enhance road accident prevention awareness among public')),
          SizedBox(height: 18.0),
          ListTile(
            title: Text(
                'SmartCop  Road Accident Prevention Game helps you to enhance your awareness level of road accident prevention in a more appealing and interesting way.'),
          ),
          ListTile(
            title: Text('Logged-in users can:'),
          ),
          ListTile(
            leading: Icon(
              Icons.video_library,
              color: Colors.blue,
            ),
            title: Text(
                'Get overview idea of the game by watching the initial tutorial'),
          ),
          ListTile(
            leading: Icon(
              Icons.star_half,
              color: Colors.blue,
            ),
            title: Text(
                'Obtain custom tailored next game levels suits with the real time user performance'),
          ),
          ListTile(
            leading: Icon(
              Icons.message,
              color: Colors.blue,
            ),
            title: Text('Enhance memorization skills'),
          ),
          ListTile(
            leading: Icon(
              Icons.show_chart,
              color: Colors.blue,
            ),
            title: Text('Review previous attempts and analyze progress'),
          ),
          ListTile(
            leading: Icon(
              Icons.supervised_user_circle,
              color: Colors.blue,
            ),
            title: Text('Review their position in game leaderboard'),
          ),
          ListTile(
            leading: Icon(
              Icons.feedback,
              color: Colors.blue,
            ),
            title: Text(
                'Learn more details on road safety from provided feedbacks'),
          ),
        ],
      ),
    );
  }
}
