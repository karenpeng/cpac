import java.util.Scanner;
import java.util.ArrayList;

public class Calculator{

  static Converter converter = new Converter();

  public static void main(String[] args){
    Scanner conIn = new Scanner(System.in);

    String line = null;          // string to be evaluated
    String more = null;          // used to stop or continue processing
    float result;                  // result of evaluation

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter a infix expression to be evaluated: ");
      line = conIn.nextLine();

      // Obtain and output result of expression evaluation.
      try
      {

        String postfix = converter.toPostFix(line);
        System.out.println("converted to postfix: "+postfix);
        result = evaluate(postfix);
        System.out.println("answer is: "+result);

      }
      catch (PostFixException error)
      {
        // Output error message.
        System.out.println();
        System.out.println("Error in expression - " + error.getMessage());
      }

      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }

  public static float evaluate(String _expression){
    float result = 0.0f;

    String[] expression = _expression.split(" ");

    ArrayListStack<String>stack = new ArrayListStack<String>();
    ArrayListStack<String>output = new ArrayListStack<String>();

    for(int i = expression.length - 1; i >= 0; i--){
      stack.push(expression[i]);
    }

    while(!stack.isEmpty()){

      while(!isOperator(stack.top())){
        output.push(stack.top());
        stack.pop();
      }


      String operator = stack.top();
      stack.pop();

      float operand2 = Float.parseFloat(output.top());
      output.pop();

      float operand1 = Float.parseFloat(output.top());
      output.pop();


      if (operator.equals("/"))
        result = operand1 / operand2;
      else
      if(operator.equals("*"))
        result = operand1 * operand2;
      else
      if(operator.equals("+"))
        result = operand1 + operand2;
      else
      if(operator.equals("-"))
        result = operand1 - operand2;
      else
      if(operator.equals("^"))
        result = (int)Math.pow(operand1, operand2);
      else{
        throw new PostFixException("Illegal symbol: " + operator);
      }

      output.push(result+"");

    }

    return result;
  }

  public static boolean isOperator(String s){
    char c = s.toCharArray()[0];
    return !Character.isDigit(c);
  }

}