import 'package:flutter/material.dart';

GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();

class GetAppBar {
  getAppBar() {
      return AppBar(
        key: _scaffoldKey,
        titleSpacing: 0.0,
        elevation: 5.0,
        backgroundColor: Colors.blueAccent,
        //Color.fromRGBO(51, 193, 255, 100),
        
        title: Row(
          children: <Widget>[
            SizedBox(
              width: 15,
            ),
            Container(
                margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
                child: CircleAvatar(
                  backgroundImage: NetworkImage(
                      "https://i.pinimg.com/originals/ac/47/03/ac4703dff7a37608748767be7f50fd34.jpg"),
                  radius: 25.0,
                ),
                decoration: new BoxDecoration(
                  border: new Border.all(
                    color: Colors.pink,
                    width: 1.0,
                  ),
                  borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
                )),
            Container(
              //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Container(
                      child: Text(
                        'SmartCop',
                        style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
                      ),
                    ),
                    SizedBox(height: 4.0),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: <Widget>[
                        Icon(
                          Icons.arrow_forward_ios,
                          color: Colors.white,
                          size: 12.0,
                        ),
                        SizedBox(width: 4.0),
                        Text('Road Accident Prevention Game',
                            style: TextStyle(fontSize: 12.0))
                      ],
                    ),
                  ]),
            )
          ],
        ),
        actionsIconTheme:
        IconThemeData(size: 30.0, color: Colors.white, opacity: 100.0),
      );
    }
  }
