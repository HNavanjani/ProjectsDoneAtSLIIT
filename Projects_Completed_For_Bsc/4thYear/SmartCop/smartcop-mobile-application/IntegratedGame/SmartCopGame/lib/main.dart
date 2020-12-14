import 'package:flutter/material.dart';
import 'package:researchresponsegame/ReponseGame/smartcop.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'SmartCop',
      theme: ThemeData(
        primarySwatch: Colors.indigo,
      ),
      home: SmartcopScreen(),
    );
  }
}
