
public class bubbleSort extends SortTester {

	// bubble sorting algorithm that only requires
	// an int array as its arguments
	void bubbleSorter(int array[]) {
		// declaration of all necessary variables
		int i, j = 0, temp, n = array.length;
		boolean swap = true;
		while(swap) {
			// modifies swap to false until changed to true
			// to prevent next loop from occurring if not changed
			// back to true
			swap = false;
			// bubble sorts the array and keeps getting
			// smaller since the largest values get sorted
			// to the end of the array
			for(i = 0; i < n - 1 - j; i++) {
				if(array[i] > array[i + 1]) {
					// swaps larger value with next index in array
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swap = true;
				}
			}
			// increments how many sorted values are at
			// the end of the array
			j++;
		}
	}
	// bubble sorts a newly created array of size n
	void callBubble(int n) {
		// creates object "bubble"
		bubbleSort bubble = new bubbleSort();
		// creates the array
		int array[] = bubble.createArray(n);
		System.out.println("Bubble sort!");
		// prints unsorted array
		bubble.printArray(array);
		System.out.printf("Sorting... ");
		// bubble sorts the array
		bubble.bubbleSorter(array);
		System.out.printf("Sorted!\n");
		// prints sorted array
		bubble.printArray(array);
	}
}
