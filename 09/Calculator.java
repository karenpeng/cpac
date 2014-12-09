import java.util.Scanner;
import java.util.ArrayList;

public class Calculator{

  static Scanner reader = new Scanner(System.in);
  static ExpressionParser parser = new ExpressionParser();
  static Converter converter = new Converter();

  public static void main(String[] args){
    ArrayList<String> infixInput = askForInput();
    converter.toPostFix(infixInput);
    //evaluation();
  }

  public static ArrayList<String> askForInput(){
    System.out.println("type your infix expression");

    //use nextLine instead of next
    //in order to make scanner sees things after space
    String input = reader.nextLine();

    //System.out.println("input as " + input);

    // parse input
    ArrayList<String> infix = parser.parse(input);

    return infix;
  }



  public static double evaluation(ArrayList<String> postfixExpression){
    double result = 0.0;

    //this will be a lot
    //
    //recursive :-)

    return result;
  }

  public static void report(){
    System.out.println("converted to postfix: " + "something");
    System.out.println("answer is ");
  }

}