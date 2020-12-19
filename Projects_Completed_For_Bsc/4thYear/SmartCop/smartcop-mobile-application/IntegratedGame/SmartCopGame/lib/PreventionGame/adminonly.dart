import 'dart:async';
import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:researchresponsegame/PreventionGame/globals.dart';
import 'package:researchresponsegame/PreventionGame/home.dart';


class WordCharacteristics {
  const WordCharacteristics(this.id, this.description);
  final String id;
  final String description;
}

class Post {
  final int no_of_char;
  final int syllable_count;
  final int frequency_of_occurrence;
  final int presence_of_ch_sh_th_st_f;
  final int part_of_speech;
  final int pronounce_g_j;
  final int pronounce_c_k;

  Post({
    this.no_of_char,
    this.syllable_count,
    this.frequency_of_occurrence,
    this.presence_of_ch_sh_th_st_f,
    this.part_of_speech,
    this.pronounce_g_j,
    this.pronounce_c_k,
  });

  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      no_of_char: json['no_of_char'],
      syllable_count: json['syllable_count'],
      frequency_of_occurrence: json['frequency_of_occurrence'],
      presence_of_ch_sh_th_st_f: json['presence_of_ch_sh_th_st_f'],
      part_of_speech: json['part_of_speech'],
      pronounce_g_j: json['pronounce_g_j'],
      pronounce_c_k: json['pronounce_c_k'],
    );
  }

  Map toMap() {
    var map = new Map<String, dynamic>();
    map["no_of_char"] = no_of_char;
    map["syllable_count"] = syllable_count;
    map["frequency_of_occurrence"] = frequency_of_occurrence;
    map["presence_of_ch_sh_th_st_f"] = presence_of_ch_sh_th_st_f;
    map["part_of_speech"] = part_of_speech;
    map["pronounce_g_j"] = pronounce_g_j;
    map["pronounce_c_k"] = pronounce_c_k;

    return map;
  }
}

Future<Post> createPost(String url, {Map body}) async {
  return http.post(url, body: body).then((http.Response response) {
    final int statusCode = response.statusCode;

    if (statusCode < 200 || statusCode > 400 || json == null) {
      throw new Exception("Error while fetching data");
    }
    return Post.fromJson(json.decode(response.body));
  });
}

Future addDefaultQuestions() async {
  print("/////////////Adding Default Questions////////////////////////");
  await databaseReference.collection("questions").add({
    'question': newlyAddedWord + " => " + hintOfNewlyAddedWord,
  }).then((documentReference) {
    print("INSERTED RECORD IS: " + documentReference.documentID);
  }).catchError((e) {
    print(e);
  });
}

Future addDifficultQuestions() async {
  print("/////////////Adding Difficult Questions////////////////////////");
  await databaseReference.collection("difficultQuestions").add({
    'question': newlyAddedWord + " => " + hintOfNewlyAddedWord,
  }).then((documentReference) {
    print("INSERTED RECORD IS: " + documentReference.documentID);
  }).catchError((e) {
    print(e);
  });
}

Future addEasyQuestions() async {
  print("/////////////Adding Easy Questions////////////////////////");
  await databaseReference.collection("easyQuestions").add({
    'question': newlyAddedWord + " => " + hintOfNewlyAddedWord,
  }).then((documentReference) {
    print("INSERTED RECORD IS: " + documentReference.documentID);
  }).catchError((e) {
    print(e);
  });
}

class AdminPage extends StatefulWidget {
  @override
  AdminPageState createState() {
    return AdminPageState();
  }

  final Future<Post> post;

  AdminPage({Key key, this.post}) : super(key: key);
}

final CREATE_POST_URL = 'https://predictworddifficulty.herokuapp.com/';

TextEditingController wordControler = new TextEditingController();
TextEditingController hintControler = new TextEditingController();
TextEditingController no_of_charControler = new TextEditingController();
TextEditingController syllable_countControler = new TextEditingController();
TextEditingController frequency_of_occurrenceControler =
    new TextEditingController();
TextEditingController presence_of_ch_sh_th_st_fControler =
    new TextEditingController();
TextEditingController part_of_speechControler = new TextEditingController();
TextEditingController pronounce_g_jControler = new TextEditingController();
TextEditingController pronounce_c_kControler = new TextEditingController();

class AdminPageState extends State<AdminPage> {
  int _groupValue1 = -1;
  int _groupValue2 = -2;
  int _groupValue3 = -3;
  int _groupValue4 = -4;
  int _groupValue5 = -5;
  int _groupValue6 = -6;
  int _groupValue7 = -7;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "WEB SERVICE",
      theme: ThemeData(
        primaryColor: Colors.blueAccent,
      ),
      home: Scaffold(
/*
          appBar: AppBar(
            title: Text('Add a New Word'),
          ),
*/
//          appBar: AppBar(
//            titleSpacing: 0.0,
//            elevation: 5.0,
//            backgroundColor: Colors.blueAccent,
//            //Color.fromRGBO(51, 193, 255, 100),
//            leading: IconButton(
//              icon: Icon(Icons.arrow_back),
//              onPressed: () {
//                Navigator.push(
//                    context, MaterialPageRoute(builder: (context) => Home()));
//              },
//            ),
//            title: Row(
//              children: <Widget>[
//                SizedBox(
//                  width: 15,
//                ),
//                Container(
//                    margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
//                    child: CircleAvatar(
//                      backgroundImage: NetworkImage(
//                          "https://i.pinimg.com/originals/ac/47/03/ac4703dff7a37608748767be7f50fd34.jpg"),
//                      radius: 25.0,
//                    ),
//                    decoration: new BoxDecoration(
//                      border: new Border.all(
//                        color: Colors.pink,
//                        width: 1.0,
//                      ),
//                      borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
//                    )),
//                Container(
//                  //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
//                  child: Column(
//                      mainAxisAlignment: MainAxisAlignment.center,
//                      crossAxisAlignment: CrossAxisAlignment.start,
//                      children: <Widget>[
//                        Container(
//                          child: Text(
//                            'SmartCop',
//                            style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
//                          ),
//                        ),
//                        SizedBox(height: 4.0),
//                        Row(
//                          mainAxisAlignment: MainAxisAlignment.start,
//                          children: <Widget>[
//                            Icon(
//                              Icons.arrow_forward_ios,
//                              color: Colors.white,
//                              size: 12.0,
//                            ),
//                            SizedBox(width: 4.0),
//                            Text('Road Accident Prevention Game',
//                                style: TextStyle(fontSize: 12.0))
//                          ],
//                        ),
//                      ]),
//                )
//              ],
//            ),
//            actionsIconTheme:
//            IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
//          ),
          body: new Container(
        margin: const EdgeInsets.only(left: 8.0, right: 8.0),
        child: new Column(
          children: <Widget>[
            SizedBox(
              height: 50,
            ),
            _NumberOfCharactersRadioButton(
              title: "1.) Number of Characters less than 5",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue1 = newValue),
            ),
            _NumberOfCharactersRadioButton(
              title: "1.) Number of Characters grater than 5",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue1 = newValue),
            ),
            _SyllableCountRadioButton(
              title: "2.) Syllable Count less than 5",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue2 = newValue),
            ),
            _SyllableCountRadioButton(
              title: "2.) Syllable Count grater than 5",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue2 = newValue),
            ),
            _FrequencyOfOccurrenceRadioButton(
              title: "3.) Frequency of Occurrence is low",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue3 = newValue),
            ),
            _FrequencyOfOccurrenceRadioButton(
              title: "3.) Frequency of Occurrence is high",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue3 = newValue),
            ),
            _PresenceOf_ch_sh_th_st_f_RadioButton(
              title: "4.) Presence of ch,sh,th,st,f is low",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue4 = newValue),
            ),
            _PresenceOf_ch_sh_th_st_f_RadioButton(
              title: "4.) Presence of ch,sh,th,st,f is high",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue4 = newValue),
            ),
            _PartOfSpeechRadioButton(
              title: "5.) Part of Speech is low",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue5 = newValue),
            ),
            _PartOfSpeechRadioButton(
              title: "5.) Part of Speech is high",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue5 = newValue),
            ),
            _Pronounce_g_j_RadioButton(
              title: "6.) Pronounce g j is low",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue6 = newValue),
            ),
            _Pronounce_g_j_RadioButton(
              title: "6.) Pronounce g j is high",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue6 = newValue),
            ),
            _Pronounce_c_k_RadioButton(
              title: "7.) Pronounce c k is low",
              value: 0,
              onChanged: (newValue) => setState(() => _groupValue7 = newValue),
            ),
            _Pronounce_c_k_RadioButton(
              title: "7.) Pronounce c k is high",
              value: 1,
              onChanged: (newValue) => setState(() => _groupValue7 = newValue),
            ),
            new RaisedButton(
              onPressed: () async {
                try {
                  var url = CREATE_POST_URL;
                  //newlyAddedWord = wordControler.text;
                  //hintOfNewlyAddedWord = hintControler.text;
                  //encode Map to JSON
                  var body = jsonEncode(<String, int>{
                    'no_of_char':
                        _groupValue1, //int.parse(no_of_charControler.text),
                    'syllable_count':
                        _groupValue2, //int.parse(syllable_countControler.text),
                    'frequency_of_occurrence':
                        _groupValue3, // int.parse(frequency_of_occurrenceControler.text),
                    'presence_of_ch_sh_th_st_f':
                        _groupValue4, //int.parse(presence_of_ch_sh_th_st_fControler.text),
                    'part_of_speech':
                        _groupValue5, //int.parse(part_of_speechControler.text),
                    'pronounce_g_j':
                        _groupValue6, //int.parse(pronounce_g_jControler.text),
                    'pronounce_c_k':
                        _groupValue7, //int.parse(pronounce_c_kControler.text)
                  });
                  print(body);

                  var response = await http.post(url,
                      headers: {"Content-Type": "application/json"},
                      body: body);
                  print(response);
                  print("${response.statusCode}");
                  print("${response.body}");
                  var responsebody = response.body;

                  var predictedDifficulty = responsebody
                      .toString()
                      .replaceAll("{", "")
                      .replaceAll("}", "")
                      .split("\"results\":")
                      .removeLast();
                  print("%%%%%%%%%%%%%%%%%%%%%%%%%");
                  print(newlyAddedWord);
                  print("*****************************");
                  print(predictedDifficulty);

                  if (int.parse(predictedDifficulty) == 1) {
                    print("1111111111111111111111111");
                    addDifficultQuestions();
                  } else if (int.parse(predictedDifficulty) == 0) {
                    print("0000000000000000000000000");
                    addEasyQuestions();
                  }

                  showMessage(BuildContext context) {
                    Widget okButton = FlatButton(
                      child: Text("OK"),
                      onPressed: () {
                        Navigator.pop(context);
                        Navigator.push(context,
                            MaterialPageRoute(builder: (context) => Home()));
                      },
                    );

                    AlertDialog alert = AlertDialog(
                      title: Text("SmartCop"),
                      content: Text("New Word Successfully Added ...."),
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

                  return response;
                } catch (e) {
                  print(e);
                }
              },
              child: const Text(
                "ADD",
                style: TextStyle(
                    fontSize: 12,
                    fontWeight: FontWeight.bold,
                    color: Colors.white),
              ),
              color: Colors.blue,
            )
          ],
        ),
      )),
    );
  }

  Widget _NumberOfCharactersRadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue1,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _SyllableCountRadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue2,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _FrequencyOfOccurrenceRadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue3,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _PresenceOf_ch_sh_th_st_f_RadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue4,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _PartOfSpeechRadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue5,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _Pronounce_g_j_RadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue6,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }

  Widget _Pronounce_c_k_RadioButton(
      {String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue7,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }
}
