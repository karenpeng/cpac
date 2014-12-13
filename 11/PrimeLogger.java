import java.util.Scanner;

public class PrimeLogger{

  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String line = null;          // string to be evaluated
    String more = null;
    do{
      System.out.println("Give me an integer");
      line = s.next();
      try{
         int i = Integer.parseInt(s);
         printPrime(i);
      }catch(Exception e){
         System.out.println();
         System.out.print("Oops, this is not an integer.")
      }
      System.out.println();
      System.out.print("Try another integer? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while(more.equalsIgnoreCase("y"));
  }

/*
  public static boolean isInteger(String s){

  /*
  method #1: loop through the char and check if it is an integer
   */
  //   char[] chars = s.toCharArray();
  //   for(char c: chars){
  //     if(!Character.isDigit(c)){
  //       return false;
  //     }
  //   }
  //   return true;
  // }

  /*
  method #2: use exception to tell if it is an integer
   */
/*
    try{
      int i = Integer.parseInt(s);
      //from test, i learn that return i won't be called if there's an exception
      //it jumps right down to catch
      //good thing to learn
      return true;
    }catch(Exception e){
      System.out.print("Oops, this is not an integer.")
      return false;
    }
  }
*/

  public static void printPrime(int i){
    LinkedUnbndQueue<Integer> buffer = new LinkedUnbndQueue<Integer>();
    LinkedUnbndQueue<Integer> prime = new LinkedUnbndQueue<Integer>();
    for(int it = 2, it <= i; it++){
      buffer.enqueue(it);
    }
    do{
      int p = buffer.front;
      buffer.dequeue();
      prime.enque(p);
      // while(p)
      // go through the queue of numbers, eliminating numbers divisible by p.
    }while(p<Math.sqrt(i));

  }
}