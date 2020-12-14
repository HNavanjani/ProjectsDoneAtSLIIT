import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/services/usermanagement.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Road Accidents Prevention',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: UserManagement().handleAuth(),
    );
  }
}
