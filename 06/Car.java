/**
 * Name: Jiaying Peng
 * Date: 11/08/2014
 * Assignment: #06
 * Summary: Write a program that creates Car objects.
**/

public class Car{

  public char color;
  public boolean ignition;
  public int positionX;
  public int positionY;

  public Car(){
    ignition = false;
    color = colorAssign();
    positionX = positionAssign();
    positionY = positionAssign();
  }

  public char colorAssign(){
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

  public int positionAssign(){
    return (int)Math.floor( Math.random() * 20 + 1 );
  }

  public void changeIgnition(){
    ignition = !ignition;
  }

  public void moveHorizontally(int space){
    if(!ignition){
      System.out.println("You have to ignite the car before moving it!");
        //the gird index is 0 - 19, but position is 1 - 20, so need to minus one
      }else {
        if(positionX - 1 + space < 0 || positionX - 1 + space > 19 ){
          System.out.println("Oops, the car can't be moved off the 20 by 20 grid!");
        }else{
          positionX += space;
        }
      }
  }

  public void moveVertically(int space){
    if(!ignition){
      System.out.println("You have to ignite the car before moving it!");
        //the gird index is 0 - 19, but position is 1 - 20, so need to minus one
      }else {
        if(positionY - 1 + space < 0 || positionY - 1 + space > 19 ){
          System.out.println("Oops, the car can't be moved off the 20 by 20 grid!");
        }else{
          positionY += space;
        }
      }
  }

  public char getColor(){
    return color;
  }

  public boolean getIgnition(){
    return ignition;
  }

  public int getXPosition(){
    return positionX;
  }

  public int getYPosition(){
    return positionY;
  }

  public String toString(){
    String result = "";
    result += "Car Information \n";
    //report color
    switch(getColor()){
      case 'R':
        result += "Color: red \n";
        break;
      case 'G':
        result += "Color: green \n";
        break;
      case 'B':
        result += "Color: blue \n";
        break;
      case 'W':
        result += "Color: white \n";
        break;
      case 'S':
        result += "Color: silver \n";
        break;
    }
    //report ignition
    if(getIgnition()){
      result += "Ignition: on \n";
    }else{
      result += "Ignition: off \n";
    }
    //report location
    result += ("Location: (" + getXPosition() + ", " + getYPosition() + ") \n");
    for(int i = 0; i < 20; i++){
      for(int j = 0; j < 20; j++){
        //the gird index is 0 - 19, but position is 1 - 20, so need to minus one
        if(i == getYPosition() - 1 && j == getXPosition() - 1){
          if(j == 19){
            result += getColor()+"\n";
          }else{
            result += getColor()+" ";
          }
        }
        else if(j == 19){
          result += "- \n";
        }else{
          result += "- ";
        }
      }
    }
    return result;
  }

}