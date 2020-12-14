import 'package:audioplayers/audio_cache.dart';
import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/quizScreen.dart';

typedef void OnError(Exception exception);

class AudioPage extends StatefulWidget {
  @override
  AudioPageState createState() => AudioPageState();
}

class AudioPageState extends State<AudioPage> {
  Duration _duration = new Duration();
  Duration _position = new Duration();
  AudioPlayer advancedPlayer;
  AudioCache audioCache;

  @override
  void initState() {
    super.initState();
    initPlayer();
  }

  void initPlayer() {
    advancedPlayer = new AudioPlayer();
    audioCache = new AudioCache(fixedPlayer: advancedPlayer);

    advancedPlayer.durationHandler = (d) => setState(() {
          _duration = d;
        });

    advancedPlayer.positionHandler = (p) => setState(() {
          _position = p;
        });
  }

  String localFilePath;

  Widget _tab(List<Widget> children) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Container(
          padding: EdgeInsets.all(16.0),
          child: Column(
            children: children
                .map((w) => Container(child: w, padding: EdgeInsets.all(6.0)))
                .toList(),
          ),
        ),
      ],
    );
  }

  Widget _btn(String txt, VoidCallback onPressed) {
    return ButtonTheme(
      minWidth: 48.0,
      child: Container(
        width: 150,
        height: 45,
        child: RaisedButton(
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(25)),
            child: Text(txt),
            color: Colors.indigoAccent,
            textColor: Colors.white,
            onPressed: onPressed),
      ),
    );
  }

  Widget slider() {
    return Slider(
        activeColor: Colors.indigoAccent,
        inactiveColor: Colors.pink,
        value: _position.inSeconds.toDouble(),
        min: 0.0,
        max: _duration.inSeconds.toDouble(),
        onChanged: (double value) {
          setState(() {
            seekToSecond(value.toInt());
            value = value;
          });
        });
  }

  Widget LocalAudio() {
    return _tab([
      _btn('Play', () => audioCache.play('audioA.mp3')),
      //_btn('Pause', () => advancedPlayer.pause()),
      _btn('Quiz', () => quiz()),
      slider()
    ]);
  }

  void quiz() {
    advancedPlayer.pause();
    Navigator.of(context).pushReplacement(MaterialPageRoute(
      builder: (context) => getaudiojson(),
    ));
  }

  void seekToSecond(int second) {
    Duration newDuration = Duration(seconds: second);

    advancedPlayer.seek(newDuration);
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 1,
      child: Scaffold(
        backgroundColor: Colors.white,
        appBar: AppBar(
          elevation: 1.0,
          //backgroundColor: Colors.teal,
          title: Center(child: Text('Listen carefully')),
        ),
        body: TabBarView(
          children: [LocalAudio()],
        ),
      ),
    );
  }
}
