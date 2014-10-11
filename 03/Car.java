import java.util.Scanner;

public class Car{
  static Scanner reader = new Scanner(System.in);
  static boolean ignition;
  static char color;
  static int positionX;
  static int positionY;

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

  public static int positionRandomizer(){
    return (int)Math.floor(Math.random()*20);
  }

  //initiate ignition, color and position. It only runs once
  public static void init(){
    ignition  = false;
    color = colorRandomizer();
    positionX = positionRandomizer();
    positionY = positionRandomizer();
  }

  public static void main(String[] args){
    init();
    //show user what the initiatate values are
    report(color, ignition, positionX, positionY);
    //then ask for change
    askForSomething();
  }

  public static void askForSomething(){
    System.out.println("What would you like to do?");
    //ask for ignition decision based on the current ignition state
    if(!ignition){
      System.out.println("1: turn the ignition on");
    }else{
      System.out.println("1: turn the ignition off");
    }
    System.out.println("2: change the position of car");
    System.out.println("Q: quit this program");

    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == '1'){
        changeIgnition();
      }
      else if(input.charAt(0) == '2'){
        changePosition();
      }
      else if(input.charAt(0) == 'Q'){
        System.exit(0);
      }else{
        System.out.print("I'm not sure what you mean. ");
        //ask again if misinput
        askForSomething();
        return;
      }
    }else{
      System.out.print("I'm not sure what you mean. ");
      //ask again if misinput
      askForSomething();
      return;
    }
    //everything fine, then ask for change again
    askForSomething();
  }

  public static void changeIgnition(){
    ignition = !ignition;
    //show user the change result
    report(color, ignition, positionX, positionY);
  }

  public static void changePosition(){
    System.out.println("In which direction would you like to move the car?");
    System.out.println("H: horizontal");
    System.out.println("W: vertical");

    String input = reader.next();
    if(input.length() == 1){
      if(input.charAt(0) == 'H'){
        askForHorizontalPosition();
      }else if(input.charAt(0) == 'W'){
        askForVerticalPosition();
      }else{
        System.out.print("I'm not sure what you mean. ");
        changePosition();
        return;
      }
    }else{
      System.out.print("I'm not sure what you mean. ");
      changePosition();
      return;
    }
  }

  public static void askForHorizontalPosition( ){
     System.out.println("How far to move up?");
     String input = reader.next();
     int n;
     try{
      n = Integer.parseInt(input);
      //get the positionY from a method
      positionY = position(ignition, positionY, n);
      //show user the change result
      report(color, ignition, positionX, positionY);
     }catch(Exception e){
      //if it's not an integer, ask again
      System.out.print("I'm not sure what you mean. ");
      askForHorizontalPosition();
     }
  }

  public static void askForVerticalPosition(){
    System.out.println("How far to move left?");
    String input = reader.next();
    int n;
    try{
      n = Integer.parseInt(input);
      //get the positionX from a method
      positionX = position(ignition, positionX, n);
      //show user the change result
      report(color, ignition, positionX, positionY);
    }catch(Exception e){
      //if it's not an integer, ask again
      System.out.print("I'm not sure what you mean. ");
      askForVerticalPosition();
    }
  }

  public static int position(boolean ignition, int position, int number){
    if(!ignition){
      System.out.println("You have to ignite the car before moving it!");
      return position;
    }else if(position - number < 0 || position - number >= 20 ){
      System.out.println("Oops, the car can't be moved off the 20 by 20 grid!");
      return position;
    }else{
      return position - number;
    }
  }

  public static void report(char color, boolean ignition, int positionX, int positionY){
    System.out.println("Car Information");
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
    for(int i = 0; i< 20; i++){
      for(int j = 0; j< 20; j++){
        if(i == positionY && j == positionX){
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