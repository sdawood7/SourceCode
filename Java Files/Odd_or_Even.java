import java.util.*;

public class Odd_or_Even
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter an integer to test:");
		int i = scan.nextInt();
		if(i%2 == 1)
			System.out.println("The integer you entered is odd.");
		else
			System.out.println("The integer you entered is even.");
	}

}
