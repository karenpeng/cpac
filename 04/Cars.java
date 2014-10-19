/**
 * Name: Jiaying Peng
 * Date: 10/17/2014
 * Assignment: #04
 * Summary: Write a program that simulates and stores the qualities of an array of ten cars.
**/

import java.util.Scanner;

public class Cars{
  static Scanner reader = new Scanner(System.in);
  static boolean [] ignitions = new boolean [10];
  static char [] colors = new char [10];
  static int [] positionXs = new int [10];
  static int [] positionYs = new int [10];
  static int currentIndex;

  public static int positionRandomizer(){
    //return value between 1 to 20
    return (int)Math.floor(Math.random()*20+1);
  }

  public static char colorRandomizer(){
    double colorRandom = Math.random();
    if(colorRandom < 0.2){
      //double quote is for string, single quote is for char
      return 'R';
    }else if(colorRandom < 0.4){
      return 'G';
    }else if(colorRandom < 0.6){
      return 'B';
    }else if(colorRandom < 0.8){
      return 'W';
    }else{
      return 'S';
    }
  }

  //initiate ignition, color and position for each car
  public static void init(){
    for(int i = 0; i< 10; i++){
      ignitions[i]  = false;
      colors[i] = colorRandomizer();
      positionXs[i] = positionRandomizer();
      positionYs[i] = positionRandomizer();
    }
  }

  public static void main(String args[]){
    init();
    //ask for change
    askForSomething();
  }

  public static void askForSomething(){
    //ask which car is about to change
    askForCarIndex();
    //show user the chosen car status
    report(colors[currentIndex], ignitions[currentIndex], positionXs[currentIndex], positionYs[currentIndex], currentIndex);
    //ask for how to change it
    askForCarChanging();
    //show user the change result
    report(colors[currentIndex], ignitions[currentIndex], positionXs[currentIndex], positionYs[currentIndex], currentIndex);
    //everything fine, then ask for change again
    askForSomething();
  }

  public static void askForCarIndex(){
    System.out.println("Which car would you like to use(1-10)?");
    String input = reader.next();
    try{
      //see if the input is an integer from 1 to 10
      int n = Integer.parseInt(input);
      if(n > 0 && n < 11){
        //index is 0-9 while the user inputs 1-10
        currentIndex = n - 1;
      }else{
        System.out.print("Oops, can't find the car you want.");
        askForCarIndex();
        return;
      }
    }catch(Exception event){
      System.out.print("Oops, can't find the car you want.");
      askForCarIndex();
      return;
    }
  }

public static void askForCarChanging(){
    System.out.println("What would you like to do next?");
    //ask for ignition decision based on the current ignition state
    if(!ignitions[currentIndex]){
      System.out.println("1: turn the ignition on");
    }else{
      System.out.println("1: turn the ignition off");
    }
    System.out.println("2: change the position of car");
    System.out.println("3: quit this program");
    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == '1'){
        ignitions[currentIndex] = changeIgnition(ignitions[currentIndex]);
      }
      else if(input.charAt(0) == '2'){
        //do something for position
        changePosition();
      }
      else if(input.charAt(0) == '3'){
        System.exit(0);
      }else{
        System.out.print("I'm not sure what you mean. ");
        //ask again if misinput
        askForCarChanging();
        return;
      }
    }else{
      System.out.print("I'm not sure what you mean. ");
      //ask again if misinput
      askForCarChanging();
      return;
    }
}

  public static boolean changeIgnition(boolean ignition){
    return !ignition;
  }

  //this function is for asking for H / W direction to move the car
  public static void changePosition(){
    System.out.println("In which direction would you like to move the car?");
    System.out.println("H: horizontal");
    System.out.println("V: vertical");

    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == 'H' || input.charAt(0) == 'h'){
        //then ask how far to move and set the positionX
        positionXs[currentIndex] = askForPosition(positionXs[currentIndex], "left");
      }else if(input.charAt(0) == 'V' || input.charAt(0) == 'v'){
        //then ask how far to move and set the positionY
        positionYs[currentIndex] = askForPosition(positionYs[currentIndex], "up");
      }else{
        System.out.print("I'm not sure what you mean. ");
        //ask again for misinput
        changePosition();
        return;
      }
    }else{
      //ask again for misinput
      System.out.print("I'm not sure what you mean. ");
      changePosition();
      return;
    }
  }

  //this function is for asking fo how much to move,
  //and pass how far to move to the position function to return the position after changes
  public static int askForPosition(int oldPosition, String direction){
     System.out.println("How far to move "+ direction +"?");
     String input = reader.next();
     try{
      int n = Integer.parseInt(input);
      //set the position from a method
      return position(ignitions[currentIndex], oldPosition, n);
     }catch(Exception e){
      //if it's not an integer, ask again
      System.out.print("I'm not sure what you mean. ");
      return askForPosition(oldPosition, direction);
     }
  }

  //this function returns the position after change
  public static int position(boolean ignition, int position, int number){
    if(!ignition){
      System.out.println("You have to ignite the car before moving it!");
      return position;
      //the gird index is 0 - 19, but position is 1 - 20, so need to minus one
    }else if(position - 1 - number < 0 || position - 1 - number > 19 ){
      System.out.println("Oops, the car can't be moved off the 20 by 20 grid!");
      return position;
    }else{
      return position - number;
    }
  }

  public static void report(char color, boolean ignition, int positionX, int positionY, int index){
    //also showing which car is chosen
    System.out.println("#" +(index+1)+ " Car Status:");
    //report color
    switch(color){
      case 'R':
        System.out.println("Color: red");
        break;
      case 'G':
        System.out.println("Color: green");
        break;
      case 'B':
        System.out.println("Color: blue");
        break;
      case 'W':
        System.out.println("Color: white");
        break;
      case 'S':
        System.out.println("Color: silver");
        break;
    }
    //report ignition
    if(ignition){
      System.out.println("Ignition: on");
    }else{
      System.out.println("Ignition: off");
    }
    //report location
    System.out.println("Location: ("+ positionX+", "+positionY+")");
    for(int i = 0; i < 20; i++){
      for(int j = 0; j < 20; j++){
        //the gird index is 0 - 19, but position is 1 - 20, so need to minus one
        if(i == positionY - 1 && j == positionX - 1){
          if(j == 19){
            System.out.println(color);
          }else{
            System.out.print(color+" ");
          }
        }
        else if(j == 19){
          System.out.println("-");
        }else{
          System.out.print("- ");
        }
      }
    }
  }

}