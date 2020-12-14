import 'package:cloud_firestore/cloud_firestore.dart';
import 'dart:async';

final databaseReference = Firestore.instance;
List<String> list = [];
List<String> listTest = [];
List<String> listLevel1 = [];
List<String> listLevel2 = [];
List<String> listLevel3 = [];
List<String> progressDataList = [];
String generatedQuestion;
String hint;
var element;
var latestScore;
var latestRecord;
var body;
var responsebody;
int score_val;
int time_val;
var predictedDifficulty;
int counterValue = 10;
Timer timerValue;
String newlyAddedWord;
String hintOfNewlyAddedWord;
List<DocumentSnapshot> ProgressData;
int attemptCounter = 0;

void startCountDownTimer() {
  counterValue = 60;
  if (timerValue != null) {
    timerValue.cancel();
  }
  timerValue = Timer.periodic(Duration(seconds: 1), (timer) {
    //setState(() {
    if (counterValue > 0) {
      counterValue--;
    } else {
      timerValue.cancel();
    }
    //});
  });
}

