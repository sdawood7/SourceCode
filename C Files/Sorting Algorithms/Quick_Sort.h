#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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

// Function to quickly swap two values
void swapVals(int *a, int *b)
{
  int temp = *a;
  *a = *b;
  *b = temp;
}

// Helper function for quickSorter
int quickSorterHelper(int *array, int lo, int hi)
{
  int i = lo - 1, j, piv = array[hi];
  for(j = lo; j < hi; j++)
    if(array[j] <= piv)
      swapVals(&array[++i], &array[j]);
  swapVals(&array[i + 1], &array[hi]);
  return (i+1);
}

// Function to implement Quick Sort algorithm
void quickSorter(int *array, int lo, int hi)
{
  int part;
  if(lo < hi)
  {
    part = quickSorterHelper(array, lo, hi);
    quickSorter(array, lo, part - 1);
    quickSorter(array, part + 1, hi);
  }
}
