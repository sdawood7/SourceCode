#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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
  array = malloc(sizeof(int)*count);
  printf("How large do you want the range of this generator to be?\n");
  scanf("%d", &x);
  for(i=0; i<count; i++)
    array[i] = rand()%x;
  for(i=0; i<count; i++)
    printf("Cell %d is: %d\n", i, array[i]);

  return 0;
}
