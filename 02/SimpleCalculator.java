/**
 * Name: Jiaying Peng
 * Date: 09/26/2014
 * Assignment: #02
 * Summary: Write a simple calculator program that can do addition, subtraction, multiplication and division.
**/

import java.util.Scanner;
import java.util.*;

public class SimpleCalculator {

 float result = 0.f;
 char mode = 'n';

  public static void main(String[] args){

    boolean init = false;
    Scanner reader = new Scanner(System.in);
    ArrayList arr = new ArrayList();

    if(!init){
      System.out.println("Give me a number");
      init = true;
      String input0 = reader.next();
      //process(input0);
      System.out.println(result);
    }

    System.out.println("Give me an operator");
    String input1 = reader.next();
    System.out.println(result);
    //process(input1);

    System.out.println("Give me a number");
    String input2 = reader.next();
    //process(input2);

    System.out.println(result);

  }

  public boolean isDigit(char c){
    if(c == '0' || c == '1'|| c == '2' || c == '3' || c == '4' || c == '5'|| c == '6' || c == '7' || c == '8' || c == '9' || c == '.'){
      return true;
    }else{
      return false;
    }
  }
/*
  public void scan(String input){
    for(int i = 0; i< input.length(); i++){
      if(!isFloat(input.charAt(i))){

      }
      arr.add(input.charAt(i));
    }
  }
*/
  public void process(String input){

    if(input.length() == 1){
      char c = input.charAt(0);
      if(c == 'x'){
        System.exit(0);
      }else if(c == 'c'){
        result = 0.f;
      }else if(c == '+' || c == '-'|| c == '*' || c == '/'){
        mode = c;
      }else if(c == '0' || c == '1'|| c == '2' || c == '3' || c == '4' || c == '5'|| c == '6' || c == '7' || c == '8' || c == '9'){
        result += (float)c;
      }else{
        System.out.println("Unknown operator "+ c);
      }
    }else{
      boolean isNagetive = false;
      boolean isFloat = true;
      for(int i = 0; i < input.length(); i++){
        if(input.charAt(0) == '-'){
          isNagetive = true;
          i++;
        }
        char c = input.charAt(i);
        if(!isDigit(c)){
          System.out.println("Unknown operator "+ c);
          isFloat = false;
          break;
        }
      }
      float f;
      if(isFloat){
        f = Float.parseFloat(input);
        if(isNagetive){
          f = -f;
        }
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
  }

}