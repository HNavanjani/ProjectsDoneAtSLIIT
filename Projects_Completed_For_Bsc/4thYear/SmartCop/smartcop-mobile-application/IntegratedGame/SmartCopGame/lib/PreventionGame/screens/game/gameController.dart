import 'dart:async';
import 'package:flutter/widgets.dart';
import 'package:flutter/foundation.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:researchresponsegame/PreventionGame/globals.dart';

class GameController {
  String answer;

  int _errorCount = 0;

  int _score = 10;

  final int maxErrorCount = 7;

  final db = Firestore.instance;

  String latestRecord = null;

  String imagePath = 'assets/images/hangman_0.png';

  List<String> wrongLetters = List<String>();

  List<String> rightLetters;

  List<String> puzzleLetters = List<String>();

  StreamController<String> onSomething = StreamController();

  void takeShot(String letter) {
    if (!alreadyTried(letter)) {
      if (answer.toLowerCase().contains(letter.toLowerCase())) {
        _success(letter);
      } else {
        _error(letter);
      }
    }
  }

  void _error(String letter) {
    this._errorCount++;

    this._score--;

    String tag = alreadyLost() ? '[lose]' : '[error]';

    this.updateImagePath();

    this.wrongLetters.add(letter);

    this.onSomething.add(tag);
  }

  void _success(String letter) {
    rightLetters.add(letter);

    updatePuzzle();

    String tag = puzzleLetters.contains(' ') ? '[success]' : '[win]';

    onSomething.add('$tag');
  }

  void updatePuzzle() {
    List<String> letters = List<String>();

    for (int i = 0; i < answerLength; i++) {
      rightLetters.contains(answer[i])
          ? letters.add(answer[i])
          : letters.add(' ');
    }

    puzzleLetters = letters;
  }

  void updateImagePath() {
    this.imagePath = alreadyLost()
        ? 'assets/images/hangman_lose.png'
        : alreadyWon()
            ? 'assets/images/hangman_win.png'
            : 'assets/images/hangman_$_errorCount.png';
  }

  bool alreadyWon() {
    return !puzzleLetters.contains(' ');
  }

  bool alreadyTried(String letter) {
    return wrongLetters.contains(letter) || wrongLetters.contains(letter);
  }

  int getScore() {
    return _score;
  }

  int getElapsedTime() {
    print("!!!!!!!Elapsed Time: " + counterValue.toString());
    return counterValue;
  }

  bool alreadyLost() {
    timerValue.cancel();
    return this._errorCount >= this.maxErrorCount;
  }

  int get answerLength => answer.length;

  GameController({@required this.answer}) {
    rightLetters = List<String>();

    updatePuzzle();
  }

  Future addPlayerDetails() async {
    print("/////////////Adding Player Details////////////////////////");
    await db.collection("playerDetails").add({
      'score': _score,
    }).then((documentReference) {
      print("LATESET RECORD IS: " + documentReference.documentID);
      latestRecord = documentReference.documentID;
    }).catchError((e) {
      print(e);
    });
    return latestRecord;
  }
}
