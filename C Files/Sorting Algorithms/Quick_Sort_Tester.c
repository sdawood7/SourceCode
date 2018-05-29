#include "Quick_Sort.h"

int main(void)
{
  int numVals;
  int *array;
  printf("How many values do you want in your array?\n");
  scanf("%d", &numVals);
  if((array = createArray(numVals)) == NULL)
  {
    printf("Failed to create array :(\n"); 
    return 0;
  }
  printf("Unsorted array:\n");
  printArray(array, numVals);
  quickSorter(array, 0, numVals - 1);
  printf("Sorted array:\n");
  printArray(array, numVals);
  return 0;
}
