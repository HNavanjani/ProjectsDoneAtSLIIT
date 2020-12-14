import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:researchresponsegame/ReponseGame/welcome.dart';
import 'marks.dart';

String collectionName = "ScoreDetail";

storeMarks(String Name, int Score, String id) {
  Marks marksDetail = Marks(playerName: Name, marks: Score);
  try {
    Firestore.instance.runTransaction(
      (Transaction transaction) async {
        await Firestore.instance
            .collection(collectionName)
            .document(id)
            .setData(marksDetail.toJson());
      },
    );
  } catch (e) {
    print(e.toString());
  }
}

updateMarks(Marks player, int newScore) {
  try {
    Firestore.instance.runTransaction((transaction) async {
      await transaction.update(player.reference, {'Score': newScore});
    });
  } catch (e) {
    print(e.toString());
  }
}

getScoreDetails() {
  return Firestore.instance.collection(collectionName).snapshots();
}

final GoogleSignIn _googleSignIn = new GoogleSignIn();
signOut(BuildContext context) async {
  _googleSignIn.signOut();
  Navigator.push(
      context, MaterialPageRoute(builder: (context) => welcomeScreen()));
}
