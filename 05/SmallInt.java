/**
 * Name: Jiaying Peng
 * Date: 11/01/2014
 * Assignment: #05
 * Summary: This assignment asks you to write a Java class called SmalInt (similar to a wrapper class).
**/
import java.util.*;

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

  }

  public String getHex(){

  }

}
