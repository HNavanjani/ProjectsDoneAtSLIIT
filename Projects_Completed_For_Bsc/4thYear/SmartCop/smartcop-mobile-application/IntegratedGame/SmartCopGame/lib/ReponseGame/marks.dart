import 'package:cloud_firestore/cloud_firestore.dart';

class Marks {
  String playerName;
  int marks;
  DocumentReference reference;

  Marks({this.playerName, this.marks});

  Marks.fromMap(Map<String, dynamic> map, {this.reference}) {
    playerName = map["Name"];
    marks = map["Score"];
  }

  Marks.fromSnapshot(DocumentSnapshot snapshot)
      : this.fromMap(snapshot.data, reference: snapshot.reference);
  toJson() {
    return {'Name': playerName, 'Score': marks};
  }
}
