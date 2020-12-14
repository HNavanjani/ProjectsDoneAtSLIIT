import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:researchresponsegame/ReponseGame/api.dart';

import 'dashBoard.dart';

class LeaderBoardPage extends StatefulWidget {
  @override
  _LeaderBoardPageState createState() => _LeaderBoardPageState();
}

class _LeaderBoardPageState extends State<LeaderBoardPage> {
  List<LeaderBoardItem> _leaderBoardItems = List<LeaderBoardItem>();

  @override
  Widget build(BuildContext context) {
    generateDummyData();
    return Scaffold(
      backgroundColor: Colors.indigo,
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(Icons.arrow_back, color: Colors.white),
          onPressed: () => Navigator.push(context,
              MaterialPageRoute(builder: (context) => DashBoardScreen())),
        ),
        title: Text("Safe Life Quiz Leaderboard"),
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
      body: ListView.builder(
          itemCount: _leaderBoardItems.length,
          itemBuilder: (BuildContext ctxt, int index) =>
              buildList(ctxt, index)),
    );
    // );
  }

  Widget buildList(BuildContext ctxt, int index) {
    int ind = index + 1;
    Widget crown;

    if (ind == 1) {
      crown = Padding(
          padding: const EdgeInsets.only(right: 0.0),
          child: Stack(
            alignment: Alignment.center,
            children: <Widget>[
              Center(
                  child: Icon(
                FontAwesomeIcons.crown,
                size: 36,
                color: Colors.yellow,
              )),
              Padding(
                padding: const EdgeInsets.only(left: 8.0, top: 6),
                child: Center(
                    child: Text(
                  '1',
                  style: TextStyle(fontSize: 17, fontWeight: FontWeight.bold),
                )),
              )
            ],
          ));
    } else if (ind == 2) {
      crown = Padding(
          padding: const EdgeInsets.only(right: 0.0),
          child: Stack(
            alignment: Alignment.center,
            children: <Widget>[
              Center(
                  child: Icon(
                FontAwesomeIcons.crown,
                size: 36,
                color: Colors.grey[300],
              )),
              Padding(
                padding: const EdgeInsets.only(left: 8.0, top: 6),
                child: Center(
                    child: Text(
                  '2',
                  style: TextStyle(fontSize: 17, fontWeight: FontWeight.bold),
                )),
              )
            ],
          ));
    } else if (ind == 3) {
      crown = Padding(
          padding: const EdgeInsets.only(right: 0.0),
          child: Stack(
            alignment: Alignment.center,
            children: <Widget>[
              Center(
                  child: Icon(
                FontAwesomeIcons.crown,
                size: 36,
                color: Colors.orange[300],
              )),
              Padding(
                padding: const EdgeInsets.only(left: 8.0, top: 6),
                child: Center(
                    child: Text(
                  '3',
                  style: TextStyle(fontSize: 17, fontWeight: FontWeight.bold),
                )),
              )
            ],
          ));
    } else {
      crown = CircleAvatar(
          backgroundColor: Colors.grey,
          radius: 13,
          child: Text(
            ind.toString(),
            style: TextStyle(
                color: Colors.black, fontWeight: FontWeight.bold, fontSize: 15),
          ));
    }

    return Padding(
      padding: const EdgeInsets.only(left: 8.0, right: 8.0, top: 10),
      child: Container(
        height: 100,
        decoration: BoxDecoration(
            color: Colors.white,
            borderRadius: BorderRadius.all(Radius.circular(15.0)),
            boxShadow: [BoxShadow(color: Colors.indigoAccent)]),
        child: Row(
          children: <Widget>[
            Expanded(
              child: Align(
                alignment: Alignment.centerLeft,
                child: Padding(
                  padding: const EdgeInsets.only(right: 0.0),
                  child: Row(
                    children: <Widget>[
                      Align(
                        alignment: Alignment.centerLeft,
                        child: Padding(
                          padding: const EdgeInsets.only(left: 15.0, right: 25),
                          child: crown,
                        ),
                      ),

//                      Align(
//                        child: CircleAvatar(
//                          backgroundColor: Colors.red.shade800,
//                          child: Text('GI'),
//                          radius: 30,
//                        ),
//                      ),

                      Align(
                          child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: <Widget>[
                          Padding(
                            padding: const EdgeInsets.only(left: 8.0, top: 5),
                            child: Text(
                              _leaderBoardItems[index].name,
                              style: TextStyle(
                                  color: Colors.black,
                                  fontWeight: FontWeight.bold,
                                  fontSize: 18),
                            ),
                          ),
                        ],
                      )),
                    ],
                  ),
                ),
              ),
            ),
            Align(
              alignment: Alignment.centerRight,
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Text(
                  _leaderBoardItems[index].marks,
                  style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                      fontSize: 18),
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  void generateDummyData() {
    _leaderBoardItems = List<LeaderBoardItem>();
    final List<String> names = <String>[
      'Sha Shangavie',
      'Shan Rajkumar',
      'abie abilachinee',
      'Hari Sasi'
    ];
    final List<String> marks = <String>['20', '60', '80', '100'];
    for (var i = 0; i < 4; i++) {
      LeaderBoardItem lbi = LeaderBoardItem('${names[i]}', '${marks[i]}');

      _leaderBoardItems.add(lbi);
    }

    _leaderBoardItems = _leaderBoardItems.reversed.toList();
  }
}

class LeaderBoardItem {
  LeaderBoardItem(this.name, this.marks);
  final String name;
  final String marks;
}
