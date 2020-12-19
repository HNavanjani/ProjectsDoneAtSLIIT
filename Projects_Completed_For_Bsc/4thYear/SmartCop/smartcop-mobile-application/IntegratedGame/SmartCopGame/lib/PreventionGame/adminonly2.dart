import 'dart:async';
import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:researchresponsegame/PreventionGame/globals.dart';
import 'package:researchresponsegame/PreventionGame/adminonly.dart';
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
    //map["userId"] = userId;
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

class AdminPage2 extends StatefulWidget {
  @override
  AdminPageState createState() {
    return AdminPageState();
  }

  final Future<Post> post;

  AdminPage2({Key key, this.post}) : super(key: key);
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

class AdminPageState extends State<AdminPage2> {
  int _groupValue01 = -1;

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
//            appBar: AppBar(
//              titleSpacing: 0.0,
//              elevation: 5.0,
//              backgroundColor: Colors.blueAccent,
//              //Color.fromRGBO(51, 193, 255, 100),
//              leading: IconButton(
//                icon: Icon(Icons.arrow_back),
//                onPressed: () {
//                  Navigator.push(
//                      context, MaterialPageRoute(builder: (context) => Home()));
//                },
//              ),
//              title: Row(
//                children: <Widget>[
//                  SizedBox(
//                    width: 15,
//                  ),
//                  Container(
//                      margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
//                      child: CircleAvatar(
//                        backgroundImage: NetworkImage(
//                            "https://i.pinimg.com/originals/ac/47/03/ac4703dff7a37608748767be7f50fd34.jpg"),
//                        radius: 25.0,
//                      ),
//                      decoration: new BoxDecoration(
//                        border: new Border.all(
//                          color: Colors.pink,
//                          width: 1.0,
//                        ),
//                        borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
//                      )),
//                  Container(
//                    //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
//                    child: Column(
//                        mainAxisAlignment: MainAxisAlignment.center,
//                        crossAxisAlignment: CrossAxisAlignment.start,
//                        children: <Widget>[
//                          Container(
//                            child: Text(
//                              'SmartCop',
//                              style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
//                            ),
//                          ),
//                          SizedBox(height: 4.0),
//                          Row(
//                            mainAxisAlignment: MainAxisAlignment.start,
//                            children: <Widget>[
//                              Icon(
//                                Icons.arrow_forward_ios,
//                                color: Colors.white,
//                                size: 12.0,
//                              ),
//                              SizedBox(width: 4.0),
//                              Text('Road Accident Prevention Game',
//                                  style: TextStyle(fontSize: 12.0))
//                            ],
//                          ),
//                        ]),
//                  )
//                ],
//              ),
//              actionsIconTheme:
//              IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
//            ),
            body: new Container(
                margin: const EdgeInsets.only(left: 8.0, right: 8.0),
                child: new Column(children: <Widget>[
                  SizedBox(
                    height: 50,
                  ),
                  Text(
                    'Add New Word to the Game',
                    style:
                        TextStyle(fontSize: 24.0, fontWeight: FontWeight.bold),
                  ),
                  SizedBox(
                    height: 20,
                  ),
//                  _RadioButton(
//                    title: "Default Level Question",
//                    value: 0,
//                    onChanged: (newValue) =>
//                        setState(() => _groupValue01 = newValue),
//                  ),
//                  _RadioButton(
//                    title: "Difficult/Easy Level Question",
//                    value: 1,
//                    onChanged: (newValue) =>
//                        setState(() => _groupValue01 = newValue),
//                  ),
                  new TextField(
                    controller: wordControler,
                    decoration: InputDecoration(
                        hintText: "Enter the word....", labelText: 'Word'),
                  ),
                  SizedBox(
                    height: 50,
                  ),
                  new TextField(
                    controller: hintControler,
                    decoration: InputDecoration(
                        hintText: "Enter the hint....", labelText: 'Hint'),
                  ),
                  SizedBox(
                    height: 50,
                  ),

                  new RaisedButton(
                    child: const Text(
                      "Add Default Level Question >>",
                      style: TextStyle(
                          fontSize: 12,
                          fontWeight: FontWeight.bold,
                          color: Colors.white),
                    ),
                    color: Colors.orange,
                    onPressed: () {
                      newlyAddedWord = wordControler.text;
                      hintOfNewlyAddedWord = hintControler.text;
                      addDefaultQuestions();

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


                    },
                  ),

                  new RaisedButton(
                    child: const Text(
                      "Add Difficult/Easy Level Question >>",
                      style: TextStyle(
                          fontSize: 12,
                          fontWeight: FontWeight.bold,
                          color: Colors.white),
                    ),
                    color: Colors.green,
                    onPressed: () {
                      newlyAddedWord = wordControler.text;
                      hintOfNewlyAddedWord = hintControler.text;
                      Navigator.of(context).push(new MaterialPageRoute(
                          builder: (BuildContext context) => new AdminPage()));
                    },
                  )
                ]))));
  }

  Widget _RadioButton({String title, int value, Function onChanged}) {
    return RadioListTile(
      value: value,
      groupValue: _groupValue01,
      onChanged: onChanged,
      dense: true,
      title: Text(title, style: TextStyle(fontSize: 12.0)),
    );
  }
}
