import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:researchresponsegame/PreventionGame/screens/game/game.dart';
import 'package:researchresponsegame/PreventionGame/login.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:carousel_pro/carousel_pro.dart';
import 'package:researchresponsegame/PreventionGame/globals.dart';
import "dart:math";
import 'package:researchresponsegame/PreventionGame/services/usermanagement.dart';
import 'package:researchresponsegame/PreventionGame/myprofile.dart';
import 'package:researchresponsegame/PreventionGame/about.dart';
import 'package:researchresponsegame/PreventionGame/allusers.dart';
import 'package:researchresponsegame/PreventionGame/leaderbord.dart';
import 'package:researchresponsegame/PreventionGame/appbar.dart';

class Home extends StatefulWidget {
  const Home({Key key, this.user}) : super(key: key);

  final FirebaseUser user;

  @override
  HomeState createState() {
    return HomeState();
  }
}

final FirebaseAuth _firebaseAuth = FirebaseAuth.instance;
_signOut(BuildContext context) async {
  await _firebaseAuth.signOut();
  Navigator.push(context, MaterialPageRoute(builder: (context) => LoginPage()));
}

Future getQFromDB() async {
  databaseReference
      .collection("questions")
      .getDocuments()
      .then((QuerySnapshot snapshot) {
    snapshot.documents.forEach((f) => list.add(f.data.values.toString()));

    final _random = new Random();

    var element = list[_random.nextInt(list.length)];
    print("//////getQFromDBLIST//////");
    print(list);
    print("******getQFromDBGENERATED QUESTION AND HINT*******");
    print(element);
    generatedQuestion = element
        .toString()
        .split('=>')
        .removeAt(0)
        .toString()
        .replaceAll('(', '')
        .trim();

    print("******getQFromDBQUESTION*******");
    print(generatedQuestion);

    hint = element
        .toString()
        .split("=>")
        .removeAt(1)
        .toString()
        .replaceAll(')', '')
        .trim();
  });
  return generatedQuestion;
}

Future getLevel1QuestionsFromDB() async {
  print("******NEXTTgetNextLevelQFromDB*******");
  Firestore.instance
      //.collection("level1_Questions")
      .collection("easyQuestions")
      .getDocuments()
      .then((QuerySnapshot snapshot) {
    snapshot.documents.forEach((f) => listLevel1.add(f.data.values.toString()));
  });
  return listLevel1;
}

Future getLevel2QuestionsFromDB() async {
  Firestore.instance
      //.collection("level2_Questions")
      .collection("difficultQuestions")
      .getDocuments()
      .then((QuerySnapshot snapshot) {
    snapshot.documents.forEach((f) => listLevel2.add(f.data.values.toString()));
  });
  return listLevel2;
}

Future getLevel3QuestionsFromDB() async {
  Firestore.instance
      .collection("level3_Questions")
      .getDocuments()
      .then((QuerySnapshot snapshot) {
    snapshot.documents.forEach((f) => listLevel3.add(f.data.values.toString()));
  });
  return listLevel3;
}

class HomeState extends State<Home> {
  GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();
  SharedPreferences logindata;
  String loggedEmail;

  @override
  void initState() {
    super.initState();
    initial();
    getQFromDB();
    getLevel1QuestionsFromDB();
    getLevel2QuestionsFromDB();
    getLevel3QuestionsFromDB();
  }

  void initial() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggedEmail = logindata.getString('email');
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget titleSection = Container(
      padding: const EdgeInsets.all(20),
      child: Row(
        children: [
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                  padding: const EdgeInsets.only(bottom: 1),
                  child: Text(
                    'Welcome to SmartCop',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 20,
                    ),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Text(
                  '✓ Enhance your road accident prevention awareness level\n'
                  '✓ Analyse awareness progress\n'
                  '✓ Facilitate to review the overall public awareness for Sri Lanka Police\n'
                  '✓ Game Equally impressive and engaing for both children and adults\n'
                  '✓ Contains a game instruction tutorial\n'
                  '✓ Includes most of the road accident causing factors\n'
                  '✓ Decides next level difficulty according to player specific skill levels',
                  style: TextStyle(color: Colors.black, fontSize: 16),
                ),
              ],
            ),
          ),
        ],
      ),
    );

    Color color = Theme.of(context).primaryColor;


    Widget slideSection = Container(
        padding: const EdgeInsets.all(20),
        child: SizedBox(
          height: 280.0,
          width: 300.0,
          child: Carousel(
            boxFit: BoxFit.cover,
            autoplay: false,
            animationCurve: Curves.fastOutSlowIn,
            animationDuration: Duration(milliseconds: 1000),
            dotSize: 6.0,
            dotIncreasedColor: Color(0xFFFF335C),
            dotBgColor: Colors.transparent,
            dotPosition: DotPosition.topRight,
            dotVerticalPadding: 10.0,
            showIndicator: true,
            indicatorBgPadding: 7.0,
            images: [
              NetworkImage(
                  'https://roadsafetyfacts.eu/uploads/2019/04/speeding-how-can-active-safety-help-to-prevent-accidents.png'),
              NetworkImage(
                  'https://thumbnails-visually.netdna-ssl.com/tips-to-prevent-a-car-accident_5407e486e4fc3_w1500.jpg'),
              NetworkImage(
                  'https://www.mcintyrefirm.com/wp-content/uploads/2018/01/Top5-Truck-Accidents-01.jpg'),
              NetworkImage(
                  'https://www.demystifyinsurance.com/wp-content/uploads/2013/12/Drive-Safely-and-stay-away-from-accidents-infographics.jpg'),
            ],
          ),
        ));

//    Widget bottomSection = Container(
//      padding: const EdgeInsets.all(20),
//      child: FlatButton.icon(
//        color: Colors.green,
//        icon: Icon(Icons.book, color: Colors.white),
//        label: Text('Let\'s Start Playing',
//            style: TextStyle(
//                fontSize: 12, fontWeight: FontWeight.bold, color: Colors.white),
//            textAlign: TextAlign.center),
//        onPressed: () {
//          Navigator.pushAndRemoveUntil(
//              context,
//              MaterialPageRoute(
//                builder: (context) => Game(answer: generatedQuestion),
//              ),
//              (Route<dynamic> route) => false);
//        },
//      ),
//    );

    return new Scaffold(
      resizeToAvoidBottomInset: false,
      key: _scaffoldKey,
      //appBar: GetAppBar().getAppBar(),
      appBar: AppBar(
        titleSpacing: 0.0,
        elevation: 5.0,
        backgroundColor: Colors.blueAccent, //Color.fromRGBO(51, 193, 255, 100),
        leading: IconButton(
          icon: Icon(Icons.menu),
          onPressed: () {
            _scaffoldKey.currentState.openDrawer();
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
      body: ListView(
        children: [
          titleSection,
          slideSection,
          //bottomSection,
        ],
      ),

      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(
                //color: Color.fromRGBO(51, 193, 255, 100),
                image: const DecorationImage(
                  image: NetworkImage(
                      'https://media.prleap.com/image/52110/full/Road-Safety-Transport_Canada.png'),
                  fit: BoxFit.cover,
                ),
              ),
            ),
            SizedBox(height: 1.0),
            ListTile(
              title: Text(
                "Welcome" +
                    " " +
                    loggedEmail.split('@').removeAt(0).toUpperCase(),
                style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
              ),
            ),
            SizedBox(height: 1.0),
            ListTile(
              leading: Icon(
                Icons.video_library,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: new Text("Watch Tutorial"),
              onTap: () {
                /*
                Navigator.of(context).pop();
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (BuildContext context) => new AllusersPage()));

                 */
                //Navigate to Home
                Navigator.push(
                    context, MaterialPageRoute(builder: (context) => AllusersPage()));
              },
            ),

            SizedBox(height: 1.0),
            ListTile(
              leading: Icon(
                Icons.videogame_asset,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: new Text("Play the Game"),
              onTap: () {
                //Launch the game screen

                Navigator.pushAndRemoveUntil(
                    context,
                    MaterialPageRoute(
                      builder: (context) => Game(answer: generatedQuestion),
                    ),
                        (Route<dynamic> route) => false);
              },
            ),
            SizedBox(height: 1.0),
            ListTile(
              leading: Icon(
                Icons.add,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: new Text("Add New Word"),
              onTap: () {
                UserManagement().authorizeAccess(context);
              },
            ),
            SizedBox(height: 1.0),
            ListTile(
              leading: Icon(
                Icons.home,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: Text("Home"),
              onTap: () {
                //Navigate to Home
                Navigator.push(
                    context, MaterialPageRoute(builder: (context) => Home()));
              },
            ),
            SizedBox(height: 10.0),
            ListTile(
              leading: Icon(
                Icons.account_circle,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: Text("My Profile"),
              onTap: () {
                Navigator.push(context,
                    MaterialPageRoute(builder: (context) => MyProfilePage()));
              },
            ),
            SizedBox(height: 10.0),
            ListTile(
              leading: Icon(
                Icons.flag,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: Text("Leaderboard"),
              onTap: () {
                Navigator.push(
                    context, MaterialPageRoute(builder: (context) => LeaderboardView()));
              },
            ),
            SizedBox(height: 10.0),
            ListTile(
              leading: Icon(
                Icons.info,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: Text("About"),
              onTap: () {
                Navigator.push(
                    context, MaterialPageRoute(builder: (context) => About()));
              },
            ),
            SizedBox(height: 10.0),
            ListTile(
              leading: Icon(
                Icons.power_settings_new,
                color: Color.fromRGBO(51, 193, 255, 100),
              ),
              title: Text("Logout"),
              onTap: () {
                _signOut(context);
                attemptCounter = 0;
              },
            ),
          ],
        ),
      ),
    );
  }
}
