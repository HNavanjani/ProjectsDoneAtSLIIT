import 'package:firebase_auth/firebase_auth.dart';
import 'package:researchresponsegame/PreventionGame/home.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/signup.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'signup.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => new _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  String _email, _password;
  double screenHeight;

  showMessage(BuildContext context) {
    Widget okButton = FlatButton(
      child: Text("OK"),
      onPressed: () {
        Navigator.pop(context);
      },
    );

    AlertDialog alert = AlertDialog(
      title: Text("SmartCop"),
      content: Text("Invalid credentials ! Try again ...."),
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

  SharedPreferences logindata;
  bool newuser;
  @override
  void initState() {
    super.initState();
    check_if_already_login();
  }

  void check_if_already_login() async {
    logindata = await SharedPreferences.getInstance();
    newuser = (logindata.getBool('login') ?? true);
    print(newuser);
  }

  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;

    return Scaffold(
      body: SingleChildScrollView(
        child: Stack(
          children: <Widget>[
            lowerHalf(context),
            upperHalf(context),
            loginCard(context)
          ],
        ),
      ),
    );
  }

  Widget upperHalf(BuildContext context) {
    return Container(
      height: screenHeight / 2,
      child: Image.network(
        'https://www.smartmotorist.com/wp-content/uploads/2019/01/Car-Accidents-5-e1551875083176.jpg',
        fit: BoxFit.cover,
      ),
    );
  }

  Widget lowerHalf(BuildContext context) {
    return Align(
      alignment: Alignment.bottomCenter,
      child: Container(
        height: screenHeight / 2,
        color: Color(0xFFECF0F3),
      ),
    );
  }

  @override
  Widget loginCard(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
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
                          child: Center(
                              child: Text(
                                  'SmartCop \n Road Accident Prevention Game',
                                  style: TextStyle(
                                      fontSize: 22,
                                      fontWeight: FontWeight.bold),
                                  textAlign: TextAlign.center)),
                        ),
                        SizedBox(
                          height: 20,
                        ),
                        TextFormField(
                          validator: (input) {
                            if (input.isEmpty) {
                              return 'Please enter your email address';
                            }
                          },
                          decoration: InputDecoration(labelText: 'Email'),
                          onSaved: (input) => _email = input,
                        ),
                        TextFormField(
                          validator: (input) {
                            if (input.length < 6) {
                              return 'Please enter the password';
                            }
                          },
                          decoration: InputDecoration(labelText: 'Password'),
                          onSaved: (input) => _password = input,
                          obscureText: true,
                        ),
                        SizedBox(height: 18.0),
                        Row(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            children: <Widget>[
                              RaisedButton(
                                onPressed: () {
                                  signIn();
                                  logindata.setString('email', _email);
                                },
                                child: Text('Sign in'),
                                color: Color.fromRGBO(51, 193, 255,
                                    100), //Color.fromRGBO(61, 212, 125, 100),
                                textColor: Colors.white,
                                padding: EdgeInsets.only(
                                    left: 38, right: 38, top: 15, bottom: 15),
                                shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(5)),
                              ),
                            ])
                      ],
                    )),
              ),
            ),
            Container(
                child: Row(
              children: <Widget>[
                Text('Create account?'),
                FlatButton(
                  textColor: Colors.blue,
                  child: Text(
                    'Sign Up',
                    style: TextStyle(fontSize: 20),
                  ),
                  onPressed: () {
                    //Navigate  to signup screen
                    Navigator.push(context,
                        MaterialPageRoute(builder: (context) => SignupPage()));
                  },
                )
              ],
              mainAxisAlignment: MainAxisAlignment.center,
            ))
          ],
        ));
  }

  void signIn() async {
    if (_formKey.currentState.validate()) {
      _formKey.currentState.save();
      try {
        final FirebaseAuth _firebaseAuth = FirebaseAuth.instance;
        FirebaseUser user = (await _firebaseAuth.signInWithEmailAndPassword(
                email: _email, password: _password))
            .user;
        Navigator.push(
            //context, MaterialPageRoute(builder: (context) => DashboardPage(user: user)));
            context,
            MaterialPageRoute(builder: (context) => Home(user: user)));
      } catch (e) {
        showMessage(context);
        print(e.message);
      }
    }
  }
}
