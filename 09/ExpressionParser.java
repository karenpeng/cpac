import java.util.ArrayList;

public class ExpressionParser {

  public static void test() {
    // Assume the entered expression has only the expected characters otherwise they are ignored
    String input = "(400+8) * (6-5)/((311-2) *(2+2)) xxx";

    // Parse input
    ArrayList<String> infix = parse(input);

    // Print the output
    for(String element : infix) {
      System.out.print(element + " ");
    }
  }

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