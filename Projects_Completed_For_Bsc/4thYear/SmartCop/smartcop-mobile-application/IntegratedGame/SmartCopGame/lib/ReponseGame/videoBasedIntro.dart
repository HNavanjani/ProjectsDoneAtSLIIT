import 'dart:async';
import 'package:flutter/material.dart';
import 'playingVideo.dart';
import 'package:video_player/video_player.dart';

class VideoBasedIntroPage extends StatefulWidget {
  VideoBasedIntroPageState createState() => VideoBasedIntroPageState();
}

class VideoBasedIntroPageState extends State<VideoBasedIntroPage> {
  VideoPlayerController _controller;
  int duration;
  void initState() {
    super.initState();
    _controller = VideoPlayerController.asset('video/videobased.mp4')
      ..initialize().then((_) {
        setState(() {
          duration = _controller.value.duration.inSeconds;
          print(duration);
          Timer(Duration(seconds: duration), () {
            Navigator.of(context).pushReplacement(MaterialPageRoute(
              builder: (context) => VideoPage(),
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
