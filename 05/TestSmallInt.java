/**
 * Name: Jiaying Peng
 * Date: 11/01/2014
 * Assignment: #05
 * Summary: This assignment asks you to write a Java class called SmalInt (similar to a wrapper class).
**/
import java.util.Scanner;

public class TestSmallInt{

  static Scanner reader = new Scanner(System.in);

  public static void main(String[] args){
    ask();
  }

  public static void ask(){
    System.out.println("Please give me an integer between 0 to "+ (SmallInt.MAXVALUE + "") + ", dear.");
    String input = reader.next();
    try{
      int i = Integer.parseInt(input);
      SmallInt test = new SmallInt(i);
      System.out.println("binary: " + test.getBin());
      System.out.println("hex   : " + test.getHex());
      //keep asking user for input
      ask();
    }catch(Exception e){
      //if it is not an integer
      System.out.print("Oooops are you sure this is an integer? ");
      ask();
    }
  }
}