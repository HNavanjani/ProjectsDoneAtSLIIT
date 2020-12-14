import 'dart:async';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/quizScreen.dart';
import 'package:video_player/video_player.dart';
import 'dart:math';

class VideoPage extends StatefulWidget {
  @override
  VideoPageState createState() => VideoPageState();
}

class VideoPageState extends State<VideoPage> {
  VideoPlayerController _controller;
  int duration;

  void initState() {
    super.initState();
    var random = new Random();
    int videoNumber = random.nextInt(2);
    String videoName = "video" + videoNumber.toString();
    print(videoNumber);
    print(videoName);
    _controller = VideoPlayerController.asset('video/' + videoName + '.mp4')
      ..initialize().then((_) {
        setState(() {
          duration = _controller.value.duration.inSeconds;
          print(duration);
          Timer(Duration(seconds: duration), () {
            Navigator.of(context).pushReplacement(MaterialPageRoute(
              builder: (context) => getjson(),
            ));
          });
        });
      });
    _controller.play();
    _controller.setLooping(false);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Stack(
          fit: StackFit.expand,
          children: <Widget>[
            Container(
              child: _controller.value.initialized
                  ? AspectRatio(
                      aspectRatio: _controller.value.aspectRatio,
                      child: VideoPlayer(_controller),
                    )
                  : Container(),
            )
          ],
        ),
      ),
    );
  }
}
