import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';// use firebase as database
import 'package:firebase_auth/firebase_auth.dart'; // use firbase authentication to store user signup detail(Here email and password is used for registeration)
import 'package:email_validator/email_validator.dart'; //To validate the email
import 'login.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: SignupPage(),
    );
  }
}

class SignupPage extends StatefulWidget {
  SignupPage() : super();
  SignupPageState createState() => SignupPageState();
}

class SignupPageState extends State<SignupPage> {
  double screenHeight;
  bool showTextField = false;
  String _email,_password;
  final GlobalKey<FormState> _formKey= GlobalKey<FormState>();
//Sigup using firebase authentication
  /*Title:Flutter- Firebase Tutorial Part 2 | Welcome page and sign in
   *Author:R Brunhage
   * Date:2018
   * Availability:https://www.youtube.com/watch?v=bXlMNfwhlwg
   */
  void Signup() async
  {
    if(_formKey.currentState.validate()){
      _formKey.currentState.save();
      try
      {
        //Store signup details using firebase authentication
          FirebaseUser user = (await FirebaseAuth.instance.createUserWithEmailAndPassword(email: _email, password: _password)).user;
          user.sendEmailVerification();
          //To display welcome message and redirect to login page after click on the "ok" button
          showSuccessMessage(context);
      }
      catch(e)
    {
      print(e.message);
    }
    }
  }

  Widget buildBody(BuildContext context) {
    return StreamBuilder<QuerySnapshot>(
      builder: (context, snapshot) {
        if(snapshot.hasError) {
          return Text('Error ${snapshot.error}');
        }
        return CircularProgressIndicator();
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      resizeToAvoidBottomPadding: false,
      body: Form(
        key: _formKey,
        child: Stack(
          children: <Widget>[
            lowerSection(context),
            upperSection(context),
            signupSection(context)
          ],
        ),
      ),
    );
  }
  //Design for top section of login screen
  Widget upperSection(BuildContext context) {
    return Container(
      height: screenHeight / 2,
      child: Image.asset(
        'images/flower1.jpg',
        fit: BoxFit.cover,
      ),
    );
  }
  //Design for bottom section of login screen
  Widget lowerSection(BuildContext context) {
    return Align(
      alignment: Alignment.bottomCenter,
      child: Container(
        height: screenHeight / 3,
        color: Color(0xFFECF0F3),
      ),
    );
  }
  //Design for add new flower details form
  Widget signupSection(BuildContext context) {
    return Column(
      children: <Widget>[
        Container(
          margin: EdgeInsets.only(top: screenHeight / 4),
          padding: EdgeInsets.only(left: 10, right: 10),
          child: Card(
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(10),
            ),
            elevation: 8,
            child: Padding(
              padding: const EdgeInsets.all(30.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  Align(
                    alignment: Alignment.topCenter,
                    child: Text(
                      "WELCOME TO FlowerSnap",
                      style: TextStyle(
                        color: Colors.purpleAccent,
                        fontSize: 14,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 15,
                  ),
                  TextFormField(
                    // ignore: missing_return
                    validator: (input)=> !EmailValidator.validate(input,true) || input.isEmpty
                      ? 'Please provide a valid email address': null,
                    onSaved: (input) => _email=input,
                    decoration: InputDecoration(
                        labelText: "Email", hasFloatingPlaceholder: true),
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  TextFormField(
                    validator: (input){
                      if(input.length<6){
                        return 'You need to provide a password with atleast 6 charcters';
                      }
                    },
                    onSaved: (input) => _password=input,
                    decoration: InputDecoration(
                        labelText: "Password", hasFloatingPlaceholder: true),
                    obscureText: true,
                  ),
                  SizedBox(
                    height: 50,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: <Widget>[
                      RaisedButton(
                        child: Text("CANCEL"),
                          color: Color.fromRGBO(61, 212, 125, 100),
                          textColor: Colors.white,
                        padding: EdgeInsets.only(
                            left: 38, right: 38, top: 15, bottom: 15),
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(5)),
                        onPressed: () {
                          Navigator.of(context).pop();
                        }
                      ),
                      RaisedButton(
                          child: Text("SIGN UP"),
                          color:Color.fromRGBO(61, 212, 125, 100),
                          textColor: Colors.white,
                          padding: EdgeInsets.only(
                              left: 38, right: 38, top: 15, bottom: 15),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(5)),
                          onPressed: () {
                            Signup();
                          }
                      )
                    ],
                  )
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }
//Display an welcome message
  /*Title: How to make an AlertDialog in Flutter
   * Date:2019
   * Availability:https://stackoverflow.com/questions/53844052/how-to-make-an-alertdialog-in-flutter
   */
  showSuccessMessage(BuildContext context) {
    // set up the button
    Widget okButton = FlatButton(
      child: Text("OK"),
      onPressed: () {
        Navigator.push(context, MaterialPageRoute(builder: (context) => LoginPage()));
      },
    );
    // set up the SuccessDialog
    AlertDialog alert = AlertDialog(
      title: Text("FlowerSnap"),
      content: Text("Your account is created successfully! Welcome to the FlowerSnap"),
      actions: [
        okButton,
      ],
    );

    // show the dialog
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return alert;
      },
    );
  }
}