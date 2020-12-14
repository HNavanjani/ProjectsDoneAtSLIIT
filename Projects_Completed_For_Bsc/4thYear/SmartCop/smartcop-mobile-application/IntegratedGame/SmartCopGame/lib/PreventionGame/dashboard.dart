import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/allusers.dart';
import 'package:researchresponsegame/PreventionGame/services/usermanagement.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:researchresponsegame/PreventionGame/appbar.dart';

class DashboardPage extends StatefulWidget {
  const DashboardPage({Key key, this.user}) : super(key: key);

  final FirebaseUser user;

  @override
  _DashboardPageState createState() => _DashboardPageState();
}

class _DashboardPageState extends State<DashboardPage> {
  GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();
  SharedPreferences logindata;
  String loggedEmail;

  @override
  void initState() {
    super.initState();
    initial();
  }

  void initial() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggedEmail = logindata.getString('email');
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
//        appBar: AppBar(
//          title: Text("Dashboard"),
//          centerTitle: true,
//        ),
//        drawer: Drawer(
//          child: ListView(
//            children: <Widget>[
//              new UserAccountsDrawerHeader(
//                accountName: new Text(
//                  loggedEmail.split('@').removeAt(0).toUpperCase(),
//                  style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
//                ),
//                accountEmail: new Text(loggedEmail),
//                currentAccountPicture: new CircleAvatar(
//                  backgroundImage: new NetworkImage(
//                      "data:image/png;base64,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"),
//                ),
//              ),
//              new ListTile(
//                title: new Text("Home"),
//                onTap: () {
//                  Navigator.of(context).pop();
//                  Navigator.push(
//                      context,
//                      new MaterialPageRoute(
//                          builder: (BuildContext context) =>
//                              new AllusersPage()));
//                },
//              ),
//              new ListTile(
//                title: new Text("All Users Page"),
//                onTap: () {
//                  Navigator.of(context).pop();
//                  Navigator.push(
//                      context,
//                      new MaterialPageRoute(
//                          builder: (BuildContext context) =>
//                              new AllusersPage()));
//                },
//              ),
//              new ListTile(
//                title: new Text("Add New Word"),
//                onTap: () {
//                  UserManagement().authorizeAccess(context);
//                },
//              ),
//              new ListTile(
//                title: new Text("Logout"),
//                onTap: () {
//                  UserManagement().signOut();
//                },
//              ),
//            ],
//          ),
//        ),
        appBar: GetAppBar().getAppBar(),
        body: Center(
          child: Text("Dashboard"),
        ));
  }
}
