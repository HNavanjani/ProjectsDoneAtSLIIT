import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;

String predictedDifficultyTime = null;

Future<http.Response> predictDifficultyLevelTime(var body) async {
  try {
    var url = "https://timeprediction.herokuapp.com/predictTime";
    //encode Map to JSON
    var body1 = jsonEncode(body);
    print(body1);
    var response = await http.post(url,
        headers: {"Content-Type": "application/json"}, body: body1);
    print(response);
    print("${response.statusCode}");
    print("${response.body}");
    var responsebody = response.body;

    predictedDifficultyTime = responsebody
        .toString()
        .replaceAll("{", "")
        .replaceAll("}", "")
        .split("\"prediction\":")
        .removeLast();
    print("*****************************");
    print(predictedDifficultyTime);

    return response;
  } catch (e) {
    print(e);
  }
}

Future<int> predictTime(var body) async {
  var time = await predictDifficultyLevelTime(body);
  print(time);
  print(predictedDifficultyTime);
  predictedDifficultyTime =
      predictedDifficultyTime.replaceAll("[", "").replaceAll("]", "");
  predictedDifficultyTime = predictedDifficultyTime.replaceAll("\"", "");

  int newTime = int.parse(predictedDifficultyTime);
  return newTime;
}
