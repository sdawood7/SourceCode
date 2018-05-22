import java.util.Random;
import java.util.Scanner;

public class SortTester {

	// prints the array
	void printArray(int array[]) {
		int i, n = array.length;
		for(i = 0; i < n; i++)
			System.out.printf("Array[%d] = %d\n", i, array[i]);
	}
	// creates array size n populated with random
	// integers between 0 and 99
	int[] createArray(int n) {
		Random rand = new Random();
		int i, array[] = new int[n];
		for(i = 0; i < n; i++)
			array[i] = rand.nextInt(100);
		return array;
	}

	// print menu of options of which sorting algorithms to use
	void printMenu() {
		System.out.printf("Print Menu: \n(SS = Selection Sort, BS = Bubble Sort, IS = Insertion Sort)\n");
		System.out.printf("Enter 0 to exit\n");
		System.out.printf("Enter 1 for SS\n");
		System.out.printf("Enter 2 for BS\n");
		System.out.printf("Enter 3 for SS & BS\n");
		System.out.printf("Enter 4 for IS\n");
		System.out.printf("Enter 5 for SS & IS\n");
		System.out.printf("Enter 6 for BS & IS\n");
		System.out.printf("Enter 7 for  SS, BS, & IS\n");
	}
	// interprets the option entered from the user
	// using bitwise operator "&"
	void callSort(int x, int n) {
		if(x > 7 || x < 0) {
			System.out.printf("Invalid call to callSort.\n");
			return;
		}
		if(x == 0) {
			System.out.printf("Bye!\n");
			return;
		}
		if((x & 1) == 1) {
			selectionSort select = new selectionSort();
			select.callSelect(n);
		}
		if((x & 2) == 2) {
			bubbleSort bubble = new bubbleSort();
			bubble.callBubble(n);
		}
		if((x & 4) == 4) {
			insertionSort insert = new insertionSort();
			insert.callInsert(n);
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		SortTester sort = new SortTester();
		int n;
		System.out.printf("How long do you want your array to be?\n");
		n = scan.nextInt();
		sort.printMenu();
		sort.callSort(scan.nextInt(), n);
		scan.close();
	}
}
