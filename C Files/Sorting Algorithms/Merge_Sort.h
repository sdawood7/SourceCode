#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to go through entire
// array to check if it is unsorted
int isSorted(int *array, int n)
{
  int i;
  if(array == NULL || n <= 0)
    return -1;
  for(i = 0; i < n - 1; i++)
    if(array[i] > array[i+1])
      return 0;
  return 1;
}

// Function to create an array
// size of length 'n'
int *createArray(int n)
{
  int i, randVal;
  int *array;
  srand(time(NULL));
  if(n <= 0)
    return NULL;
  array = malloc(sizeof(int) * n);
  for(i = 0; i < n; i++)
    array[i] = rand()%500 + 1;
  return array;
}

// Function to print an array
void printArray(int *array, int n)
{
  int i;
  if(array == NULL || n <= 0)
  {
    printf("Array does not exist :(\n");
    return;
  }
  printf("The array is: \n");
  for(i = 0; i < n; i++)
		printf("%d%c", array[i], (i == n - 1) ? '\n' : ' ');
}

// Function that implements Merge Sort algorithm
void mergeSorter(int *array, int lo, int hi)
{
  int mid = lo + (hi - lo) / 2, i = lo, j = mid + 1, k = 0;
	int *aux = NULL;
	if (lo >= hi)
		return;
	mergeSorter(array, lo, mid);
	mergeSorter(array, mid+1, hi);
	aux = malloc(sizeof(int) * (hi - lo + 1));
	while (i <= mid || j <= hi)
	{
		if (i > mid || (j <= hi && array[j] < array[i]))
			aux[k++] = array[j++];
		else
			aux[k++] = array[i++];
	}
  for (i = lo; i <= hi; i++)
    array[i] = aux[i - lo];
  free(aux);
}
