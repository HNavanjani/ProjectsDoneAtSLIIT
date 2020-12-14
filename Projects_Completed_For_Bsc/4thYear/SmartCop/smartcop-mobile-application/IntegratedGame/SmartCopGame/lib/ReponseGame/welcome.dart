import 'dart:async';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/dashBoard.dart';
import 'package:assets_audio_player/assets_audio_player.dart';
import 'package:shared_preferences/shared_preferences.dart';

class welcomeScreen extends StatefulWidget {
  @override
  _welcomeScreenState createState() => _welcomeScreenState();
}

class _welcomeScreenState extends State<welcomeScreen> {
  FirebaseAuth _auth = FirebaseAuth.instance;
  SharedPreferences logindata;
  bool newuser;
  AssetsAudioPlayer _assetsAudioPlayer;
  @override
  void initState() {
    super.initState();
    _assetsAudioPlayer = AssetsAudioPlayer();
    _assetsAudioPlayer.open(
      Audio("assets/smartcopTune.mp3"),
    );
    _assetsAudioPlayer.playOrPause();
    check_if_already_login();
  }

  @override
  void dispose() {
    _assetsAudioPlayer = null;
    super.dispose();
  }

  void check_if_already_login() async {
    logindata = await SharedPreferences.getInstance();
    newuser = (logindata.getBool('login') ?? true);
    print(newuser);
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(left: 20.0, right: 20.0, bottom: 40.0),
      alignment: Alignment.bottomCenter,
      decoration: BoxDecoration(
          image: DecorationImage(
              image: AssetImage('images/two.png'), fit: BoxFit.fill)),
      child: Container(
        width: double.infinity,
        height: 50.0,
        padding: EdgeInsets.only(left: 20.0, right: 20.0, bottom: 10.0),
        child: RaisedButton(
          onPressed: () async {
            bool res = await loginWithGoogle();
            if (!res) print('Error login with google');
          },
          child: new Text("START",
              style: TextStyle(
                  color: Colors.white, fontFamily: "Quando", fontSize: 30.0)),
          color: Colors.lightBlue,
          shape:
              RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
        ),
      ),
    );
  }

  Future<bool> loginWithGoogle() async {
    try {
      GoogleSignIn googleSignIn = GoogleSignIn();
      GoogleSignInAccount account = await googleSignIn.signIn();
      if (account == null) return false;
      AuthResult res = await _auth.signInWithCredential(
          GoogleAuthProvider.getCredential(
              idToken: (await account.authentication).idToken,
              accessToken: (await account.authentication).accessToken));
      if (res.user == null) {
        return false;
      } else {
        print(res.user.uid.toString());
        print(res.user.displayName.toString());
        logindata.setString('userName', res.user.displayName.toString());
        logindata.setString('uid', res.user.uid.toString());
        logindata.setString('url', res.user.photoUrl.toString());
        logindata.setString('email', res.user.email.toString());
        Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) => DashBoardScreen(user: res.user)));
        return true;
      }
    } catch (e) {
      print("Error login with google");
      return false;
    }
  }
}
