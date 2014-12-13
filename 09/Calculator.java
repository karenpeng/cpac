import java.util.Scanner;

public class Calculator{

  static Converter converter = new Converter();

  public static void main(String[] args){
    Scanner conIn = new Scanner(System.in);

    String line = null;          // string to be evaluated
    String more = null;          // used to stop or continue processing

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
        double result = evaluate(postfix);
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

  public static double evaluate(String _expression){
    double result = 0.0;

    String[] expression = _expression.split(" ");

    LinkedStack<String>stack = new LinkedStack<String>();
    LinkedStack<String>output = new LinkedStack<String>();

    //the left of the string is the top of the stack
    for(int i = expression.length - 1; i >= 0; i--){
      stack.push(expression[i]);
    }

    while(!stack.isEmpty()){

      //put number into output
      while(!isOperator(stack.top())){
        output.push(stack.top());
        stack.pop();
      }

      //until we hit an operator
      String operator = stack.top();
      stack.pop();

      double operand2 = Double.parseDouble(output.top());
      output.pop();

      double operand1 = Double.parseDouble(output.top());
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
        result = Math.pow(operand1, operand2);
      else{
        throw new PostFixException("Illegal symbol: " + operator);
      }

      //put the result back to the top of the output
      output.push(result+"");

    }

    return result;
  }

  public static boolean isOperator(String s){
    char c = s.toCharArray()[0];
    return !Character.isDigit(c);
  }

}