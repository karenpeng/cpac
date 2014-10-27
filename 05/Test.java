import java.util.*;

public class Test{
  static double sum = 0.0;
  static int numRows = 10;
  public static void main(String args[]){
    //System.out.print(sum());
    pyramid(test());
    System.out.print(sum);
    int[] a = {
      1,2,3
    };
    int [] b = {
      2,3,5,6
    };
    ArrayList<integer> result = new ArrayList<integer>();
    append(a,b);
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

  public static void append (int [] a , int [] b){

    for(int i=0; i< a.length; i++){
      int aItem = a[i];
      boolean isDuplicate = false;
      for(int j=0; j<b.length; j++){
        int bItem = b[j];
        if(aItem == bItem){
          isDuplicate = true;
          break;
        }
      }
      if(!isDuplicate){
        result.add(aItem);
      }
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

    //return result;

  }

}