import 'package:flutter/material.dart';

class UpperSection extends StatelessWidget {
  final List<String> incorrectLetters;

  UpperSection({@required this.incorrectLetters});

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.symmetric(vertical: 5.0, horizontal: 10.0),
      color: Colors.redAccent,
      height: 45.0,
      margin: EdgeInsets.only(bottom: 15.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: List.generate(
            incorrectLetters.length > 0 ? incorrectLetters.length + 1 : 1,
            (int index) {
          if (index != 0) {
            return Padding(
              padding: const EdgeInsets.symmetric(horizontal: 5.0),
              child: Text(
                incorrectLetters[index - 1],
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Colors.white.withOpacity(1.0),
                  fontSize: 18,
                ),
              ),
            );
          } else {
            return Padding(
              padding: EdgeInsets.symmetric(horizontal: 3.0, vertical: 5.0),
              child: Text(
                'Incorrect Guesses: ',
                textAlign: TextAlign.center,
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Colors.white.withOpacity(1.0),
                  fontSize: 20,
                ),
              ),
            );
          }
        }),
      ),
    );
  }
}
