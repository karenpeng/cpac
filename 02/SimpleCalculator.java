/**
 * Name: Jiaying Peng
 * Date: 09/26/2014
 * Assignment: #02
 * Summary: Write a simple calculator program that can do addition, subtraction, multiplication and division.
**/

import java.util.Scanner;

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
      }

    }else{
      int pointCount = 0;
      for(int i = 0; i < input.length(); i++){
        if(i == 0 && input.charAt(i) == '-'){
          i++;
        }
        char c = input.charAt(i);
        if(c == '.'){
          pointCount ++;
        }
        if((!isDigit(c) && c != '.') || pointCount > 1){
          System.out.println("Unknown number "+ c);
          System.out.print("Try again. ");
          askForNumber();
        }
      }
      f = Float.parseFloat(input);
    }

      if(mode == 'n' || mode =='+') {result += f;}
      if(mode == '-') {result -= f;}
      if(mode == '*') {result *= f;}
      if(mode == '/') {
        if(f == 0.f){
          System.out.println("Division by zero.");
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
      System.out.print("Try again, ");
      askForOperator();
     }
    }else{
      System.out.println("Unknown operator "+ input);
      System.out.print("Try again, ");
      askForOperator();
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
    if(c == 'c'){
     System.exit(0);
     return true;
    }else if(c == 'x'){
      result = 0.f;
      return true;
    }else{
      return false;
    }
  }


}