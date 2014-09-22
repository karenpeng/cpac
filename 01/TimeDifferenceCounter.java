/**
 * Name: Jiaying Peng
 * Date: 09/22/2014
 * Assignment: #01
 * Summary: Write a program that accepts user input of two time values and computes the difference between them.
**/

//java packages
//program uses Scanner
import java.util.Scanner;

//main function
public class TimeDifferenceCounter {
  public static void main(String[] args) {

    //input of two times
    Scanner firstInput = new Scanner(System.in);
    System.out.println("Please enter the first time in HHMMSS format:");
    int firstTime = firstInput.nextInt();

    Scanner secondInput = new Scanner(System.in);
    System.out.println("Please enter the second time in HHMMSS format:");
    int secondTime = secondInput.nextInt();

    //processing the input

    //break down to hour, minute and second
    int firstTimeHour = firstTime / 10000;
    int firstTimeMinute = (firstTime % 10000) / 100;
    int firstTimeSecond = firstTime % 10000 % 100;

    int secondTimeHour = secondTime / 10000;
    int secondTimeMinute = (secondTime % 10000) / 100;
    int secondTimeSecond = secondTime % 10000 % 100;

    //get the total seconds
    int firstTotalSeconds = firstTimeHour * 60 * 60 + firstTimeMinute * 60 + firstTimeSecond;
    int secondTotalSeconds = secondTimeHour * 60 * 60 + secondTimeMinute * 60 + secondTimeSecond;

    //calculate the total seconds difference
    int totalSecondsDifference = firstTotalSeconds - secondTotalSeconds;

    //mark down if the time difference is negative
    boolean negativeDifference = totalSecondsDifference >= 0;

    //convert time difference back to hour, minute and second
    totalSecondsDifference = Math.abs(totalSecondsDifference);
    int finalHour = totalSecondsDifference / 3600;
    int finalMinute = totalSecondsDifference % 3600 / 60;
    int finalSecond = totalSecondsDifference % 3600 % 60;

    //ouput the time difference
    //if the time difference is negative, put a negative sign in front of the result
    if(negativeDifference){
      System.out.println("The time difference is "+ finalHour + finalMinute + finalSecond);
    }else{
      System.out.println("The time difference is "+ "-" +finalHour + finalMinute + finalSecond);
    }

  }
}