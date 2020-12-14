import 'package:flutter/material.dart';

class PuzzleSection extends StatelessWidget {
  final List<String> puzzleLetters;

  final int wordLength;

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.symmetric(vertical: 0.0),
      child: Wrap(
          direction: Axis.horizontal,
          alignment: WrapAlignment.center,
          children: List.generate(wordLength, (int index) {
            return Padding(
              padding: const EdgeInsets.symmetric(horizontal: 10.0),
              child: Text(
                puzzleLetters[index],
                style: TextStyle(
                    decoration: TextDecoration.underline,
                    fontSize: 50.0,
                    fontWeight: FontWeight.bold),
              ),
            );
          })),
    );
  }

  PuzzleSection({@required this.puzzleLetters, @required this.wordLength});
}
