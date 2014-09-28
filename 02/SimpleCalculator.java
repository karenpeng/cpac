/**
 * Name: Jiaying Peng
 * Date: 09/26/2014
 * Assignment: #02
 * Summary: Write a simple calculator program that can do addition, subtraction, multiplication and division.
**/

//I wrote three solutions to solve this problem because
//after I wrote one, I found a simplier way, and then I wrote another, and then found another simplier way

//The algorithm is a little bit different than the assignment description because I want the user to know the error immediately
//In all the below code, I will keep asking for a number / operator if the user types in an unknown input

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Version 1, I am looping through the string of input to determine if it is number / operator
/*
public class SimpleCalculator {

 static boolean init = false;
 static Scanner reader = new Scanner(System.in);
 static float result = 0.f;
 static char mode = 'n';

  public static void main(String[] args){
    askForSomething();
  }

  public static void askForSomething(){
    if(!init){
      askForNumber();
      init = true;
      System.out.println(result);
    }

    askForOperator();
    System.out.println(result);

    askForNumber();
    System.out.println("The result is "+result);

    askForSomething();
  }

  public static void askForNumber(){
    float f = 0.f;
    System.out.println("Give me a number:");
    String input = reader.next();

    if(input.length() == 1){
      char c = input.charAt(0);
      if(isSpecialCommand(c)){

      }else if(isDigit(c)){
        f = Float.parseFloat(input);
      }else{
        System.out.println("Unknown number "+ c);
        System.out.print("Try again. ");
        askForNumber();
        return;
      }

    }else{
      int pointCount = 0;
      for(int i = 0; i < input.length(); i++){
        if(i == 0 && input.charAt(i) == '-'){
          continue;
        }
        char c = input.charAt(i);
        if(c == '.'){
          pointCount ++;
          continue;
        }
        else if(!isDigit(c) || pointCount > 1){
          System.out.println("Unknown number "+ c);
          System.out.print("Try again. ");
          askForNumber();
          return;
        }
      }
      f = Float.parseFloat(input);
    }

    if(mode == 'n' || mode =='+') {result += f;}
    if(mode == '-') {result -= f;}
    if(mode == '*') {result *= f;}
    if(mode == '/') {
      if(f == 0.f){
        System.out.println("Division by zero!");
      }else {
        result /= f;
      }
    }

  }

  public static void askForOperator(){
    System.out.println("Give me an operator:");
    String input = reader.next();

    if(input.length() == 1){
      char c = input.charAt(0);
      if(isSpecialCommand(c)){

      }else if(isOperator(c)){
        mode = c;
      }else{
      System.out.println("Unknown operator "+ input);
      System.out.print("Try again. ");
      askForOperator();
      return;
     }
    }else{
      System.out.println("Unknown operator "+ input);
      System.out.print("Try again. ");
      askForOperator();
      return;
    }
  }

    public static boolean isDigit(char c){
    if(c == '0' || c == '1'|| c == '2' || c == '3' || c == '4' || c == '5'|| c == '6' || c == '7' || c == '8' || c == '9' ){
      return true;
    }else{
      return false;
    }
  }

  public static boolean isOperator(char c){
    if(c == '+' || c == '-'|| c == '*' || c == '/'){
      return true;
    }else{
      return false;
    }
  }

  public static boolean isSpecialCommand(char c){
    if(c == 'x'){
     System.exit(0);
     return true;
    }else if(c == 'c'){
      result = 0.f;
      return true;
    }else{
      return false;
    }
  }
}
*/

//Version 2, using regular expression
public class SimpleCalculator {

 static boolean init = false;
 static Scanner reader = new Scanner(System.in);
 static float result = 0.f;
 static char mode = 'n';

 static String numberPattern = "^-?\\+?\\d+\\.?\\d*$";
 static Pattern np = Pattern.compile(numberPattern);

 static String operatorPattern = "[\\+\\-\\*/]";
 static Pattern op = Pattern.compile(operatorPattern);

  public static void main(String[] args){
    askForSomething();
  }

  public static void askForSomething(){
    if(!init){
      askForNumber();
      init = true;
      System.out.println(result);
    }

    askForOperator();
    System.out.println(result);

    askForNumber();
    System.out.println("The result is "+result);

    askForSomething();
  }

 public static void askForNumber(){
    System.out.println("Give me an number:");
    String input = reader.next();

    if(input.length()==1){
      if(isSpecialCommand(input.charAt(0))){
        return;
      };
    }

    float f = 0.f;

    Matcher m = np.matcher(input);
    if(m.find()){
      f = Float.parseFloat(input);
    }else{
      System.out.println("Unknown number "+ input);
      System.out.print("Try again. ");
      askForNumber();
      return;
    }

    if(mode == 'n' || mode =='+') {result += f;}
    if(mode == '-') {result -= f;}
    if(mode == '*') {result *= f;}
    if(mode == '/') {
      if(f == 0.f){
        System.out.println("Division by zero!");
      }else {
        result /= f;
      }
    }

  }

  public static void askForOperator(){
    System.out.println("Give me an operator:");
    String input = reader.next();

    if(input.length()==1){
      if(isSpecialCommand(input.charAt(0))){
        return;
      };
    }

    Matcher m = op.matcher(input);
    if(m.find()){
      mode = input.charAt(0);
    }else{
      System.out.println("Unknown operator "+ input);
      System.out.print("Try again. ");
      askForOperator();
    }
  }

  public static boolean isSpecialCommand(char c){
    if(c == 'x'){
     System.exit(0);
     return true;
    }else if(c == 'c'){
      result = 0.f;
      return true;
    }else{
      return false;
    }
  }
}