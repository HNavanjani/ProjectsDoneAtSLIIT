import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/widgets.dart';
import 'package:researchresponsegame/PreventionGame/adminonly2.dart';
import 'package:researchresponsegame/PreventionGame/loginpage.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/login.dart';

class UserManagement {
  Widget handleAuth() {
    return new StreamBuilder(
        stream: FirebaseAuth.instance.onAuthStateChanged,
        builder: (BuildContext context, snapshot) {
          if (snapshot.hasData) {
            return LoginPage(); //DashboardPage();
          }
          return SignInPage();
        });
  }

  authorizeAccess(BuildContext context) {
    FirebaseAuth.instance.currentUser().then((user) {
      Firestore.instance
          .collection('/users')
          .where('uid', isEqualTo: user.uid)
          .getDocuments()
          .then((docs) {
        if (docs.documents[0].exists) {
          if (docs.documents[0].data['role'] == 'admin') {
            Navigator.of(context).push(new MaterialPageRoute(
                builder: (BuildContext context) => new AdminPage2()));
            print('Authorized');
          } else {
            showMessage(BuildContext context) {
              Widget okButton = FlatButton(
                child: Text("OK"),
                onPressed: () {
                  Navigator.pop(context);
                },
              );

              AlertDialog alert = AlertDialog(
                title: Text("SmartCop"),
                content: Text("Not Authorized ...."),
                actions: [
                  okButton,
                ],
              );

              showDialog(
                context: context,
                builder: (BuildContext context) {
                  return alert;
                },
              );
            }

            showMessage(context);

            print('Not Authorized');
          }
        }
      });
    });
  }

  signOut() {
    FirebaseAuth.instance.signOut();
  }
}
