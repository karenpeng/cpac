/**
 * Name: Jiaying Peng
 * Date: 11/01/2014
 * Assignment: #05
 * Summary: This assignment asks you to write a Java class called SmalInt (similar to a wrapper class).
**/

public class SmallInt {

  private int value;
  public static final int MAXVALUE = 1000;

  public SmallInt(int num){
    check(num);
  }

  public void check(int num){
    if(num < 0 || num > MAXVALUE){
      System.out.println("Ooops, the number exceeds the proper range.");
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
    if(value == 0){
      return "0";
    }else{
      String binary = "";
      int quotient = value;
      while(quotient > 0){
        int remainder = quotient % 2;
        quotient = (int) quotient / 2;
        //System.out.println(quotient);
        //this is string concatenate, no need to use arraylist!
        //be careful to put remainder in front of binary b/c you want the new one on the right
        binary = remainder + binary;
      }
    return binary;
   }
  }

  public String getHex(){
    if(value == 0){
      return "0";
    }else{
      String hex = "";
      int quotient = value;
      while(quotient > 0){
        int remainder = quotient % 16;
        quotient = (int) quotient / 16;
        if(remainder < 10){
          hex = remainder + hex;
        }else{
          //if number is [10,16)
          //convert it to hex with alphabet
          String remainder_hex;
          switch(remainder - 10){
            case 1:
              remainder_hex = "b";
              break;
            case 2:
              remainder_hex = "c";
              break;
            case 3:
              remainder_hex = "d";
              break;
            case 4:
              remainder_hex = "e";
              break;
            case 5:
              remainder_hex = "f";
              break;
            default:
              remainder_hex = "a";
              break;
          }
          hex = remainder_hex + hex;
        }
      }
      return hex;
    }
  }
}