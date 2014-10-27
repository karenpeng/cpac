import java.util.*;
import java.util.ArrayList;

public class Test{
  static double sum = 0.0;
  static int numRows = 10;
  public static void main(String args[]){
    //System.out.print(sum());
    pyramid(test());
    System.out.println(sum);
    int[] a = {
      1,2,3,8,9,11
    };
    int [] b = {
      2,3,5,6
    };
    System.out.print(append(a,b));
  }
  public static int sum(){
    return 100;
  }

  public static void pyramid(int a){
    for(int row = 1; row <= a; row++){
      for( int col = 1; col <= row; col++){
        System.out.print("*");
      }
    System.out.println("break!");
    }
  }

  public static int test(){
    return 10;
  }

  public static ArrayList<Integer> append (int [] a , int [] b){
  ArrayList<Integer> result = new ArrayList<Integer>();

  for(int i=0; i<a.length; i++){
    result.add(a[i]);
  }

  for(int i=0; i< b.length; i++){
    int bItem = b[i];
    boolean isDuplicate = false;
    for(int j=0; j<a.length; j++){
      int aItem = a[j];
      if(bItem == aItem){
        isDuplicate = true;
        break;
      }
    }
    if(!isDuplicate){
      result.add(bItem);
    }
  }
  return result;

  }

}