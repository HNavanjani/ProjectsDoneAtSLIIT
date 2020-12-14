import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/services/usermanagement.dart';
import 'package:researchresponsegame/ReponseGame/welcome.dart';


void main() {
  runApp(MaterialApp(
    home: SmartcopScreen(),
  ));
}

class SmartcopScreen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _SmartcopScreenState();
  }
}

class _SmartcopScreenState extends State<SmartcopScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromRGBO(51, 193, 255, 100), //Color(0xFF21BFBD),
      body: ListView(
        children: <Widget>[
          SizedBox(height: 25.0),
          Padding(
            padding: EdgeInsets.only(left: 40.0),
            child: Row(
              children: <Widget>[
                Text('SmartCop',
                    style: TextStyle(
                        fontFamily: 'Montserrat',
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        fontSize: 25.0)),
                SizedBox(width: 10.0),
                Text('Mitigate Road Accidents',
                    style: TextStyle(
                        fontFamily: 'Montserrat',
                        color: Colors.white,
                        fontSize: 17.0))
              ],
            ),
          ),
          SizedBox(height: 40.0),
          Container(
            height: MediaQuery.of(context).size.height - 185.0,
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.only(topLeft: Radius.circular(75.0)),
            ),
            child: ListView(
              primary: false,
              padding: EdgeInsets.only(left: 25.0, right: 20.0),
              children: <Widget>[
                Padding(
                    padding: EdgeInsets.only(top: 20.0),
                    child: Container(
                        height: MediaQuery.of(context).size.height - 200.0,
                        child: ListView(children: [
                          Card(
                            semanticContainer: true,
                            clipBehavior: Clip.antiAliasWithSaveLayer,
                            child: Image.network(
                              'https://bohatala.com/wp-content/uploads/2018/10/Impact-of-Traffic-Intervention-on-Road-Safety.jpg',
                              fit: BoxFit.fill,
                            ),
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(10.0),
                            ),
                            elevation: 5,
                            margin: EdgeInsets.all(10),
                          ),
                          Card(
                              semanticContainer: true,
                              clipBehavior: Clip.antiAliasWithSaveLayer,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(10.0),
                              ),
                              elevation: 5,
                              margin: EdgeInsets.all(10),
                              child: Column(
                                  mainAxisSize: MainAxisSize.min,
                                  children: <Widget>[
                                    ListTile(
                                      leading: const Icon(
                                        Icons.videogame_asset,
                                        color:
                                            Color.fromRGBO(51, 193, 255, 100),
                                      ),
                                      title: Text('SmartCop'),
                                      subtitle:
                                          Text('Road Accident Prevention Game'),
                                    ),
                                    FlatButton(
                                      color: Colors.lightBlueAccent,
                                      child: const Text('Launch the Game'),
                                      onPressed: () {
                                        Navigator.of(context).pushReplacement(MaterialPageRoute(
                                          builder: (context) => UserManagement().handleAuth(),
                                        ));
                                      },
                                    ),

                                  ])),
                          Card(
                              semanticContainer: true,
                              clipBehavior: Clip.antiAliasWithSaveLayer,
                              shape: RoundedRectangleBorder(
                                borderRadius: BorderRadius.circular(10.0),
                              ),
                              elevation: 5,
                              margin: EdgeInsets.all(10),
                              child: Column(
                                  mainAxisSize: MainAxisSize.min,
                                  children: <Widget>[
                                    ListTile(
                                      leading: const Icon(
                                        Icons.videogame_asset,
                                        color:
                                        Color.fromRGBO(51, 193, 255, 100),
                                      ),
                                      title: Text('Safe Life'),
                                      subtitle:
                                      Text('Road Accident Response Game'),
                                    ),
                                    FlatButton(
                                      color: Colors.lightBlueAccent,
                                      child: const Text('Launch the Game'),
                                      onPressed: () {
                                        Navigator.of(context)
                                            .pushReplacement(MaterialPageRoute(
                                          builder: (context) => welcomeScreen(),
                                        ));
                                      },
                                    ),
                                  ]))
                        ]))),
              ],
            ),
          )
        ],
      ),
    );
  }
}
