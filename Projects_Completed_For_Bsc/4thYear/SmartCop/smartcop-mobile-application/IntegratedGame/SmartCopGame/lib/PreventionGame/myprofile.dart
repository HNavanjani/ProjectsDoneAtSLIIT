import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:researchresponsegame/PreventionGame/progress.dart';
import 'package:charts_flutter/flutter.dart' as charts;
import 'package:shared_preferences/shared_preferences.dart';
import 'package:researchresponsegame/PreventionGame/appbar.dart';


class MyProfilePage extends StatefulWidget {
  @override
  _MyProfilePageState createState() {
    return _MyProfilePageState();
  }
}

class _MyProfilePageState extends State<MyProfilePage> {
  List<charts.Series<Progress, String>> _seriesBarData;
  List<Progress> mydata;

  SharedPreferences logindata;
  String loggedEmail;

  void initial() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggedEmail = logindata.getString('email');
    });
  }

  _generateData(mydata) {
    _seriesBarData = List<charts.Series<Progress, String>>();
    _seriesBarData.add(
      charts.Series(
        domainFn: (Progress progress, _) => progress.attempt.toString(),
        measureFn: (Progress progress, _) => progress.score,
        colorFn: (Progress progress, _) =>
            charts.ColorUtil.fromDartColor(Color(int.parse(progress.colorVal))),
        id: 'Progress',
        data: mydata,
        labelAccessorFn: (Progress row, _) => "${row.attempt}",
      ),
    );
  }

  void initState() {
    super.initState();
    initial();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
//      appBar: AppBar(title: Text('Progress')),
      appBar: GetAppBar().getAppBar(),
      body: _buildBody(context),
    );
  }

  Widget _buildBody(BuildContext context) {
    return StreamBuilder<QuerySnapshot>(
      stream: Firestore.instance
          .collection('progressData')
          .where("email", isEqualTo: loggedEmail)
          .snapshots(),
      builder: (context, snapshot) {
        if (!snapshot.hasData) {
          return LinearProgressIndicator();
        } else {
          List<Progress> progress = snapshot.data.documents
              .map(
                  (documentSnapshot) => Progress.fromMap(documentSnapshot.data))
              .toList();
          return _buildChart(context, progress);
        }
      },
    );
  }

  Widget _buildChart(BuildContext context, List<Progress> saledata) {
    mydata = saledata;
    _generateData(mydata);
    return Padding(
      padding: EdgeInsets.all(8.0),
      child: Container(
        child: Center(
          child: Column(
            children: <Widget>[
              Text(
                'Progress by User',
                style: TextStyle(fontSize: 24.0, fontWeight: FontWeight.bold),
              ),
              SizedBox(
                height: 10.0,
              ),
              Expanded(
                child: charts.BarChart(
                  _seriesBarData,
                  animate: true,
                  animationDuration: Duration(seconds: 5),
                  behaviors: [
                    new charts.DatumLegend(
                      entryTextStyle: charts.TextStyleSpec(
                          color: charts.MaterialPalette.purple.shadeDefault,
                          fontFamily: 'Georgia',
                          fontSize: 18),
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
