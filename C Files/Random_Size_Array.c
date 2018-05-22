#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int *createArray(int count, int x)
{
  if(count < 0 || x < 0)
    return NULL;
  int i;
  int *array = malloc(sizeof(int) * count);
  for(i = 0; i < count; i++)
    array[i] = rand()%x;
  return array;
}

void printArray(int *array, int count)
{
  int i;
  printf("The array is:\n");
  for(i = 0; i < count; i++)
    printf("Cell %d is: %d\n", i, array[i]);
}

int main(void)
{
  srand(time(NULL));
  int x = 0;
  int y = 0;
  int count = 0;
  int i;
  int *array;
  printf("How many times would you like to run this random number generator?\n");
  scanf("%d", &count);
  malloc(sizeof(int)*count);
  printf("How large do you want the range of this generator to be?\n");
  scanf("%d", &x);
  if((array = createArray(count, x)) == NULL)
  {
    printf("Failed to create array :(\n");
    return 0;
  }
  else
    printf("Array created!\n");
  printArray(array, count);
  return 0;
}
