import java.util.Scanner;
import java.util.Random;

public class Guess_the_Number
{

  public static void main(String[] args)
  {
    int low = 0, high = 0, number = 0, count = 0, guess = 0, result = 0;
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    System.out.println("Can you guess the number within 3 attempts?");
    System.out.println("Pick a lower bound for your range!");
    low = scan.nextInt();
    System.out.println("Pick an upper bound for your range!");
    high = scan.nextInt();
    number = rand.nextInt((high - low) + 1) + low;
    System.out.printf("\nI'm thinking of a number between %d and %d... Take a guess!\n", low, high);
    while(count < 3)
    {
      guess = scan.nextInt();
      if(guess == number)
      {
        count = 3;
        result = 1;
      }
      else
        count++;
      if(count < 3)
        System.out.printf("Try again! (attempt %d/3)\n", count);
    }
    if(result == 1)
      System.out.println("You guessed correctly! Good job!");
    else
      System.out.println("You didn't guess the number :(");

  }
}
