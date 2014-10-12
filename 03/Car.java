import java.util.Scanner;

public class Car{
  static Scanner reader = new Scanner(System.in);
  static boolean ignition;
  static char color;
  static int positionX;
  static int positionY;

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
        ignition = changeIgnition(ignition);
      }
      else if(input.charAt(0) == '2'){
        //do something for position
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
    //show user the change result
    report(color, ignition, positionX, positionY);
    //everything fine, then ask for change again
    askForSomething();
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
        positionX = askForPosition(positionX, "left");
      }else if(input.charAt(0) == 'V' || input.charAt(0) == 'v'){
        //then ask how far to move and set the positionY
        positionY = askForPosition(positionY, "up");
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

  //this function is for asking fo how much to move
  public static int askForPosition(int oldPosition, String direction){
     System.out.println("How far to move "+ direction +"?");
     String input = reader.next();
     int n;
     try{
      n = Integer.parseInt(input);
      //set the position from a method
      return position(ignition, oldPosition, n);
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