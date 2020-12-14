import 'dart:async';
import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:researchresponsegame/PreventionGame/appbar.dart';


class Job {
  final String id;
  final String email;
  final int score;

  Job({this.id, this.email, this.score});

  factory Job.fromJson(Map<String, dynamic> json) {
    return Job(
      id: json['id'],
      email: json['email'],
      score: json['score'],
    );
  }
}

class LeaderboardView extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: GetAppBar().getAppBar(),
        body: FutureBuilder<List<Job>>(
      future: _fetchJobs(),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          List<Job> data = snapshot.data;
          return _jobsListView(data);
        } else if (snapshot.hasError) {
          return Text("${snapshot.error}");
        }
        return CircularProgressIndicator();
      },
    ));
  }

  Future<List<Job>> _fetchJobs() async {
    final jobsListAPIUrl = 'https://us-central1-road-accident-response-game.cloudfunctions.net/app/api/leaderboard';
    final response = await http.get(jobsListAPIUrl);

    if (response.statusCode == 200) {
      List jsonResponse = json.decode(response.body);
      return jsonResponse.map((job) => new Job.fromJson(job)).toList();
    } else {
      throw Exception('Failed to load Leaderboard from API');
    }
  }

  ListView _jobsListView(data) {
    return ListView.builder(
        itemCount: data.length,
        itemBuilder: (context, index) {
          return _tile(data[index].email,
              data[index].score,
              Icons.stars);
        });
  }

  ListTile _tile(String email, int score, IconData icon) => ListTile(
        title: Text(email.split('@').removeAt(0).toUpperCase(),
            style: TextStyle(
              fontWeight: FontWeight.w500,
              fontSize: 20,
            )),
        subtitle: Text("Obtained Score "+score.toString()),
        leading: Icon(
          icon,
            color: Colors.orange,
        ),
      );
}
