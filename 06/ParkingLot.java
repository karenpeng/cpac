/**
 * Name: Jiaying Peng
 * Date: 11/08/2014
 * Assignment: #06
 * Summary: Write a program that creates Car objects.
**/

import java.util.Scanner;

public class ParkingLot{

  static Scanner reader = new Scanner(System.in);
  public static Car[] cars = new Car[10];
  public static int currentIndex;

  public static void main(String[] argv){
    for(int i = 0; i< 10; i++){
      // you have to make a new Car for every element in the array
      cars[i] = new Car();
    }
    while( 0 != 1 ){
      askForIndex();
      askForCarChanging(cars[currentIndex]);
    }
  }

  public static void askForIndex(){
    System.out.println("Which car would you like to use next(1-10)?");
    String input = reader.next();
     try{
      //see if the input is an integer from 1 to 10
      int n = Integer.parseInt(input);
      if(n > 0 && n < 11){
        //index is 0-9 while the user inputs 1-10
        currentIndex = n - 1;
        cars[currentIndex].report();
      }else{
        System.out.print("Oops, can't find the car you want.");
        askForIndex();
        return;
      }
    }catch(Exception event){
      System.out.print("Oops, can't find the car you want.");
      askForIndex();
      return;
    }
  }

  public static void askForCarChanging(Car c){
    System.out.println("What would you like to do next?");
    //ask for ignition decision based on the current ignition state
    if(!c.getIgnition()){
      System.out.println("1: turn the ignition on");
    }else{
      System.out.println("1: turn the ignition off");
    }
    System.out.println("2: change the position of car");
    System.out.println("3: quit this program");
    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == '1'){
        c.changeIgnition();
        c.report();
      }
      else if(input.charAt(0) == '2'){
        //do something for position
        askForPositionChanging(c);
      }
      else if(input.charAt(0) == '3'){
        System.exit(0);
      }else{
        System.out.print("I'm not sure what you mean. ");
        //ask again if misinput
        askForCarChanging(c);
        return;
      }
    }else{
      System.out.print("I'm not sure what you mean. ");
      //ask again if misinput
      askForCarChanging(c);
      return;
    }
  }

  public static void askForPositionChanging(Car c){
    System.out.println("In which direction would you like to move the car?");
    System.out.println("H: horizontal");
    System.out.println("V: vertical");

    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == 'H' || input.charAt(0) == 'h'){
        //then ask how far to move and set the positionX
        askForHowFarToMove(c, 'x');
      }else if(input.charAt(0) == 'V' || input.charAt(0) == 'v'){
        //then ask how far to move and set the positionY
        askForHowFarToMove(c, 'y');
      }else{
        System.out.print("I'm not sure what you mean. ");
        //ask again for misinput
        askForPositionChanging(c);
        return;
      }
    }else{
      //ask again for misinput
      System.out.print("I'm not sure what you mean. ");
      askForPositionChanging(c);
      return;
    }
  }

  public static void askForHowFarToMove(Car c, char axis){
    String direction;
    if(axis == 'x'){
      direction = "right";
    }else{
      direction = "down";
    }
     System.out.println("How far to move "+ direction +"?");
     String input = reader.next();
     try{
      int n = Integer.parseInt(input);
      //set the position from a method
        if(axis == 'x'){
          c.moveHorizontally(n);
          c.report();
        }else{
          c.moveVertically(n);
          c.report();
        }
     }catch(Exception e){
      //if it's not an integer, ask again
      System.out.print("I'm not sure what you mean. ");
      askForHowFarToMove(c, axis);
     }
  }
}