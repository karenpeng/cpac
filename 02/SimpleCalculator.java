/**
 * Name: Jiaying Peng
 * Date: 09/26/2014
 * Assignment: #02
 * Summary: Write a simple calculator program that can do addition, subtraction, multiplication and division.
**/

/*
I wrote three solutions to solve this problem because
after I wrote one, I found a simplier way, and I wrote another, and then found another simplier way

The algorithm is a little bit different than the assignment description because I want the user to know the error immediately
In all the below code, I will keep asking for a number / operator if the user types in an unknown input
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Version 1, looping through the string of input to determine if it is number / operator
*/

// public class SimpleCalculator {

//  static boolean init = false;
//  static Scanner reader = new Scanner(System.in);
//  static float result = 0.f;
//  static char mode = 'n';

//   public static void main(String[] args){
//     //the whole application is to ask for things
//     askForSomething();
//   }

//   public static void askForSomething(){

//     if(!init){
//       askForNumber();
//       init = true;
//     }

//     askForOperator();

//     askForNumber();

//     //keep calling itself until user quits this application
//     askForSomething();
//   }

//   public static void askForOperator(){
//     System.out.println("Give me an operator:");
//     String input = reader.next();

//     if(input.length() == 1){
//       char c = input.charAt(0);
//       if(isSpecialCommand(c)){
//         //check if it's 'c' or 'x'
//       }else if(isOperator(c)){
//         //check if it's operator, if it is, change the global mode
//         mode = c;
//       }else{
//       //anything else is misinput
//       System.out.println("Unknown operator "+ input);
//       System.out.print("Try again. ");
//       //keep asking until user type in correct input
//       askForOperator();
//       return;
//      }
//     }else{
//       //more than 1 char is misinput for an operator
//       System.out.println("Unknown operator "+ input);
//       System.out.print("Try again. ");
//       askForOperator();
//       return;
//     }
//   }

//   public static void askForNumber(){
//     //f is going to hold the input float
//     float f = 0.f;
//     System.out.println("Give me a number:");
//     String input = reader.next();

//     if(input.length() == 1){
//       char c = input.charAt(0);
//       if(isSpecialCommand(c)){
//         //check if it is 'x' or 'c'
//       }else if(isDigit(c)){
//         //check if it is a digit, if it is, put it into f
//         f = Float.parseFloat(input);
//       }else{
//         //anything else is misinput for a number
//         System.out.println("Unknown number "+ c);
//         System.out.print("Try again. ");
//         askForNumber();
//         return;
//       }

//     }else{
//       //ppintCount is going to count how many '.' the user types in
//       int pointCount = 0;

//       for(int i = 0; i < input.length(); i++){
//         //if the first char is '-' or '+', ignore it and continue to check the following char
//         if(i == 0 && ( input.charAt(i) == '-' || input.charAt(i) == '+')){
//           continue;
//         }

//         char c = input.charAt(i);
//         if(c == '.'){
//           pointCount ++;
//           //more than 1 '.' is misinput for a number
//           if(pointCount > 1){
//             System.out.println("Unknown number "+ c);
//             System.out.print("Try again. ");
//             askForNumber();
//             return;
//           }
//           //any char else should be a digit, if not, it's misinput
//         }else if(!isDigit(c)){
//           System.out.println("Unknown number "+ c);
//           System.out.print("Try again. ");
//           askForNumber();
//           return;
//         }
//       }
//       //if the program runs here, it means the input is a number. Convert it to float for calculation
//       f = Float.parseFloat(input);
//     }

//     //change result according to the mode and the input float f
//     if(mode == 'n' || mode =='+') {result += f;}
//     if(mode == '-') {result -= f;}
//     if(mode == '*') {result *= f;}
//     if(mode == '/') {
//       if(f == 0.f){
//         System.out.println("Division by zero!");
//         return;
//       }else {
//         result /= f;
//       }
//     }
//     if(init){
//       //output the result
//       System.out.println("The result is "+result);
//     }

//   }

//   public static boolean isDigit(char c){
//     if(c == '0' || c == '1'|| c == '2' || c == '3' || c == '4' || c == '5'|| c == '6' || c == '7' || c == '8' || c == '9' ){
//       return true;
//     }else{
//       return false;
//     }
//   }

//   public static boolean isOperator(char c){
//     if(c == '+' || c == '-'|| c == '*' || c == '/'){
//       return true;
//     }else{
//       return false;
//     }
//   }

//   public static boolean isSpecialCommand(char c){
//     if(c == 'x'){
//      System.exit(0);
//      return true;
//     }else if(c == 'c'){
//       result = 0.f;
//       return true;
//     }else{
//       return false;
//     }
//   }
// }


/*
Version 2, using regular expression
*/

// public class SimpleCalculator {

//  static boolean init = false;
//  static Scanner reader = new Scanner(System.in);
//  static float result = 0.f;
//  static char mode = 'n';

//  //for a number, the first char could be '+' or '-'.
//  //a number could be '.09', or '09.', but not just'.'
//  //^[-\\+]?(\\d+\\.?\\d*)|(\\d*\\.?\\d+)$ is not correct b/c it will match '0..', which is not a float
//  static String numberPattern = "^[-\\+]?(\\d+\\.?\\d*)$|^[-\\+]?(\\d*\\.?\\d+)$";
//  static Pattern np = Pattern.compile(numberPattern);

//  static String operatorPattern = "[\\+\\-\\*/]";
//  static Pattern op = Pattern.compile(operatorPattern);

//   public static void main(String[] args){
//     askForSomething();
//   }

//   public static void askForSomething(){
//     if(!init){
//       askForNumber();
//       init = true;
//     }

//     askForOperator();

//     askForNumber();

//     askForSomething();
//   }

//   public static void askForOperator(){
//     System.out.println("Give me an operator:");
//     String input = reader.next();

//     if(input.length()==1){
//       if(isSpecialCommand(input.charAt(0))){
//         //check if it's 'c' or 'x'
//         return;
//       };
//     }

//     Matcher m = op.matcher(input);
//     if(m.find()){
//       //if it mathces the operator pattern, it's an operator, change the mode
//       mode = input.charAt(0);
//     }else{
//       //does not match means misinput
//       System.out.println("Unknown operator "+ input);
//       System.out.print("Try again. ");
//       askForOperator();
//     }
//   }

//  public static void askForNumber(){
//     System.out.println("Give me an number:");
//     String input = reader.next();

//     if(input.length()==1){
//       if(isSpecialCommand(input.charAt(0))){
//         return;
//       };
//     }

//     float f = 0.f;

//     Matcher m = np.matcher(input);
//     if(m.find()){
//       //it's a number
//       f = Float.parseFloat(input);
//     }else{
//       //misinput
//       System.out.println("Unknown number "+ input);
//       System.out.print("Try again. ");
//       askForNumber();
//       return;
//     }

//     if(mode == 'n' || mode =='+') {result += f;}
//     if(mode == '-') {result -= f;}
//     if(mode == '*') {result *= f;}
//     if(mode == '/') {
//       if(f == 0.f){
//         System.out.println("Division by zero!");
//         return;
//       }else {
//         result /= f;
//       }
//     }

//     if(init){
//      System.out.println("The result is "+result);
//     }

//   }

//   public static boolean isSpecialCommand(char c){
//     if(c == 'x'){
//      System.exit(0);
//      return true;
//     }else if(c == 'c'){
//       result = 0.f;
//       return true;
//     }else{
//       return false;
//     }
//   }

// }


/*
Version 3, simply let the function Float.parseFloat(String a) to tell me whether it's a float or not :)
*/

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
    }
    askForOperator();
    askForNumber();
    askForSomething();
  }

  public static void askForOperator(){
    System.out.println("Give me an operator:");
    String input = reader.next();

    if(input.length()==1){
      char c = input.charAt(0);
      if(isSpecialCommand(c)){
        return;
      };
      //single quot is for char, double quot is for String
      if(c == '+' || c == '-' || c == '*' || c == '/'){
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
    }
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
    try{
      f = Float.parseFloat(input);
    }
    catch(Exception e){
      System.out.println("Unknown operator "+ input);
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
        return;
      }else {
        result /= f;
      }
    }

    if(init){
     System.out.println("The result is "+result);
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