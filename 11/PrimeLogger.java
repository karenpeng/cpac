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
         int i = Integer.parseInt(line);
         printPrime(i);
      }catch(Exception e){
         System.out.println();
         //System.out.print("Oops, this is not an integer.");
         throw e;
      }
      System.out.println();
      System.out.print("Try another integer? (Y=Yes): ");
      more = s.next();
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

  public static void printPrime(int n){

    LinkedUnbndQueue<Integer> buffer = new LinkedUnbndQueue<Integer>();
    LinkedUnbndQueue<Integer> prime = new LinkedUnbndQueue<Integer>();

    for(int i = 2; i <= n; i++){
      buffer.enqueue(i);
    }

    LLNode<Integer> nn = buffer.front;
    int p = nn.getInfo();
    prime.enqueue(p);

    while(p < Math.sqrt(n)){


      // while(p)
      // go through the queue of numbers, eliminating numbers divisible by p.
      // for(LLNode<Integer> node = buffer.front; node.getInfo() < p; node = node.getLink()){

      //   System.out.println("in side the loop:" + node.getInfo());

      //   if(p % node.getInfo() == 0){
      //     //buffer.dequeue(node);
      //     System.out.println("get rid of "+p);
      //     //prime.dequeue();
      //     break;
      //   }
      // }

      // if(prime.rear.getInfo() == 2){
      //   prime.enqueue(3);
      // }else{
      nn = nn.getLink();
      p = nn.getInfo();

      int num = 0;

      for(LLNode<Integer> node = prime.front; node.getInfo() < Math.sqrt(p) && node.getLink()!= null; node = node.getLink()){
        if(p % node.getInfo() == 0){
          num ++;
          break;
        }
      }
      if(num == 0){
        prime.enqueue(p);
      }
      //}

      printThings(prime);
      System.out.println("");
      // nn = nn.getLink();
      // p = nn.getInfo();

    }

    System.out.println("Primes up to "+ n +" are as follows:");
    printThings(prime);
  }

  public static void printThings(LinkedUnbndQueue<Integer> meh){
    LLNode<Integer> node = meh.front;
    do{
      System.out.print(node.getInfo() + " ");
      node = node.getLink();
    }while(node != null);
  }

}