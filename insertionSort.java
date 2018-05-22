
public class insertionSort extends SortTester {

	// insertion sorting algorithm that only requires
	// an int array as its arguments
	void insertionSorter(int array[]) {
		// declaration of all necessary variables
		int i, temp, j, n = array.length;
		// insertion sorts the array since the smallest values
		// end up at the start of the array and the outer loop
		// looks at the unsorted portion of the array
		for(i = 0; i < n; i++) {
			// captures the first value of the array and sorts it
			temp = array[i];
			// allows the sorting of the array as long as the
			// index is greater than 0
			for(j = i; j > 0 && temp < array[j-1]; j--)
				array[j] = array[j-1];
			array[j] = temp;
		}
	}
	// insertion sorts a newly created array of size n
	void callInsert(int n) {
		// creates object "insert"
		insertionSort insert = new insertionSort();
		// creates the array
		int array[] = insert.createArray(n);
		System.out.println("Insertion sort!");
		// prints unsorted array
		insert.printArray(array);
		System.out.printf("Sorting... ");
		// insertion sorts the array
		insert.insertionSorter(array);
		System.out.printf("Sorted!\n");
		// prints sorted array
		insert.printArray(array);
	}
}
