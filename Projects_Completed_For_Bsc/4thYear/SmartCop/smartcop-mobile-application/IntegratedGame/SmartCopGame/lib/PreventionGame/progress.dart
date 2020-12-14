class Progress {
  final int score;
  final String attempt;
  final String colorVal;
  Progress(this.score, this.attempt, this.colorVal);

  Progress.fromMap(Map<String, dynamic> map)
      : assert(map['score'] != null),
        assert(map['attempt'] != null),
        assert(map['colorVal'] != null),
        score = map['score'],
        colorVal = map['colorVal'],
        attempt = map['attempt'];

  @override
  String toString() => "Record<$score:$attempt:$colorVal>";
}
