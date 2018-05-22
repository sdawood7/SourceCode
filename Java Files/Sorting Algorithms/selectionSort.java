
public class selectionSort extends SortTester {

	// selection sorting algorithm that only requires
	// an int array as its arguments
	void selectionSorter(int array[]) {
		// declaration of all necessary variables
		int i, j, minIndex, temp, n = array.length;
		for(i = 0; i < n; i++) {
			// captures lowest index of unsorted array
			minIndex = i;
			for(j = i + 1; j < n; j++)
				// checks if theres a lower value in the array than the
				// current one
				if(array[j] < array[minIndex])
					// captures index of smallest value in array
					minIndex = j;
			// swaps the value of the current index with the
			// value of the index with the smallest value
			temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
	// selection sorts a newly created array of size n
	void callSelect(int n) {
		// creates object "select"
		selectionSort select = new selectionSort();
		// creates the array
		int array[] = select.createArray(n);
		System.out.println("Selection sort!");
		// prints unsorted array
		select.printArray(array);
		System.out.printf("Sorting... ");
		// selection sorts the array
		select.selectionSorter(array);
		System.out.printf("Sorted!\n");
		// prints sorted array
		select.printArray(array);
	}
}
