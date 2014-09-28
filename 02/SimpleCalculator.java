/**
 * Name: Jiaying Peng
 * Date: 09/26/2014
 * Assignment: #02
 * Summary: Write a simple calculator program that can do addition, subtraction, multiplication and division.
**/

import java.util.Scanner;
import java.util.*;

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
    System.out.println(result);

    askForSomething();
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

  public static void askForNumber(){
    float f = 0.f;
    System.out.println("Give me a number:");
    String input = reader.next();

    if(input.length() == 1){
      char c = input.charAt(0);
      if(c == 'x'){
        System.exit(0);
      }else if(c == 'c'){
        result = 0.f;
      }else if(isDigit(c)){
        f = Float.parseFloat(input);
      }else{
        System.out.println("Unknown number "+ c);
        System.out.print("Try again, ");
        askForNumber();
      }

    }else{
      for(int i = 0; i < input.length(); i++){
        if(i == 0 && input.charAt(i) == '-'){
          i++;
        }
        char c = input.charAt(i);
        if(!isDigit(c) && c != '.'){
          System.out.println("Unknown number "+ c);
          System.out.print("Try again, ");
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
          System.out.println("division by zero");
        }else {
          result /= f;
        }
      }

  }

  public static void askForOperator(){
    System.out.println("Give me an operator:");
    String input = reader.next();
    if(input.length() == 1 && isOperator(input.charAt(0))){
      mode = input.charAt(0);
    }else {
      System.out.println("Unknown operator "+ input);
      System.out.print("Try again, ");
      askForOperator();
    }
  }


}