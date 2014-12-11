import java.util.ArrayList;

public class ExpressionParser {

  public static ArrayList<String> parse(String _input) {
    char[] input = _input.toCharArray();
    ArrayList<String> parsed = new ArrayList<String>();
    for (int i = 0; i < input.length; ++i) {
      char c = input[i];
      if (Character.isDigit(c)) {
      String number = input[i] + "";
      for (int j = i + 1; j < input.length; ++j) {
        if (Character.isDigit(input[j])) {
          number += input[j];
          i = j;
        } else {
          break;
        }
      }
      parsed.add(number);
      } else if (c == '*' || c == '/' ||
        c == '+' || c == '^' ||
        c == '-' || c == '(' || c == ')') {
        parsed.add(c + "");
      }
      // else ignore other characters
    }
    return parsed;
  }

}