/**
 * Name: Jiaying Peng
 * Date: 11/01/2014
 * Assignment: #05
 * Summary: This assignment asks you to write a Java class called SmalInt (similar to a wrapper class).
**/
import java.util.*;
import java.util.ArrayList;

public class SciCalculator{

  public static void main(String args[]){

  }

  public class SmallInt {

    private int value;
    public static int MAXVALUE;

    public SamllInt(int num){
      MAXVALUE = 1000;
      check(num);
    }

    public void check(int num){
      if(num < 0 || num > MAXVALUE){
        System.out.println("Ooops, the number exceed the proper range.");
        value = 0;
      }else{
        value = num;
      }
    }

    public String getDec(){
      String empty = "";
      String result = empty+value;
      return result;
    }

    public void setDec(int num){
      check(num);
    }

    public String getBin(){
      String num = getDec();
      Strin empty = "";
      int sum = 0;
      for(int i = num.length() - 1 ; i >= 0; i--){
        int index = 0;
        Char ca = num.charAt(i);
        int bin = Math.pow(2,i) * Integer.parseInt(ca);
        sum += bin;
        index ++;
      }
      return sum+empty;
    }

    public String getHex(){
      String num = getDec();
      Strin empty = "";
      int sum = 0;
      for(int i = num.length() - 1 ; i >= 0; i--){
        int index = 0;
        Char ca = num.charAt(i);
        int hex = Math.pow(16,i) * Integer.parseInt(ca);
        sum += hex;
        index ++;
      }
      return sum+empty;
    }

  }

}