#include <stdio.h>

int fib(int n);
int range(int n);

int main(void)
{
  int firstQ = 0, x = 0, rangeQ = 0;
  printf("How would you like to find a Fibonacci number?\n");
  printf("Enter '1' to test the highest Fibonacci number under a certain range.\n");
  printf("Enter '2' to find the 'n-th' Fibonacci number.\n");
  scanf("%d", &firstQ);
  switch(firstQ)
    {
      case 1:
      {
        printf("Enter the highest integer for your range.\n");
        scanf("%d", &rangeQ);
        x = range(rangeQ);
        printf("The Fibonacci under your range is %d", x);
        break;
      }
      case 2:
      {
        printf("Which Fibonacci number would you like to find?\n");
        scanf("%d", &rangeQ);
        x = fib(rangeQ);
        printf("The %dth Fibonacci number is %d.\n", rangeQ, x);
        break;
      }
    }
/*  printf("Which Fibonacci number would you like to find?\n");
  scanf("%d", &rangeQ);
  x = fib(range);
  printf("The %dth Fibonacci number is %d.\n", range, x);
*/

  return 0;
}

int fib(int n)
{
  int a = 0, b = 1, temp = 0, counter = 0;
  while(counter < n)
    {
      temp = a + b;
      b = a;
      a = temp;
      counter++;
    }
  return temp;
}

int range(int n)
{
  int a = 0, b = 1, temp = 0, returnValue = 0;
  do
    {
      returnValue = temp;
      temp = a + b;
      b = a;
      a = temp;

    }
  while(temp < n);
  return returnValue;
}
