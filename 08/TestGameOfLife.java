import java.util.Scanner;

public class TestGameOfLife{

  static Scanner reader = new Scanner(System.in);
  static GameOfLife game;

  public static void main(String[] args){
    System.out.println("Which file do you want to open? 1-5");
    String input = reader.next();

    while(input.length() != 1){
      System.out.println("Oops, no such book. Which file do you want to open? 1-5");
      input = reader.next();
    }

    char num = input.charAt(0);
    while(num != '1' && num != '2' && num != '3' && num != '4' && num != '5'){
      System.out.println("Oops, no such book. Which file do you want to open? 1-5");
      input = reader.next();
      num = input.charAt(0);
    }

    //convert char into int
    int index = Character.getNumericValue(num) - 1;
    game = new GameOfLife(index);

    while(1 > 0){
      next();
    }

  }

  public static void next(){
    System.out.println("Could you like to evolve? y/n");
    String input =  reader.next();

    while(input.length() != 1){
      System.out.println("What do you mean? Could you like to evolve? y/n");
      input =  reader.next();
    }

    while(input.charAt(0) != 'y' && input.charAt(0) != 'Y' && input.charAt(0) != 'n' && input.charAt(0) != 'N'){
      System.out.println("What do you mean? Could you like to evolve? y/n");
      input =  reader.next();
    }

    if( input.charAt(0) == 'y' || input.charAt(0) == 'Y'){
    game.evolve();
    game.report();
    }else if(input.charAt(0) == 'n' || input.charAt(0) == 'N'){
      System.exit(1);
    }

  }

}