#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define str "JONI"
// Password to be tested

// 9512 4 digit hashy modulo
// 727 3 digit hashy

unsigned long int hasher(unsigned long int left, unsigned long int right)
{
  return ((727 * left) + right) % 9512;
  // Random numbers I generated with random number generator
}

int main(void)
{
  int i, j, k, l, strhash, collisionChecker = 0;
  unsigned long int hpass = 0, lefthash, righthash;
  char left[3], right[3], tester[5];
  // Declaration of all variables to be used in program
  lefthash = (str[0] * 100) + str[1];
  // calculates left side of the str hash
  righthash = (str[2] * 100) + str[3];
  // calculates right side of the str hash
  strhash = hasher(lefthash, righthash);
  // captures the str hash
  for(i = 'A'; i <= 'Z'; i++)
  {
    tester[0] = i;
    // first letter of brute force
    for(j = 'A'; j <= 'Z'; j++)
    {
      tester[1] = j;
      // second letter of brute force
      for(k = 'A'; k <= 'Z'; k++)
      {
        tester[2] = k;
        // third letter of brute force
        for(l = 'A'; l <= 'Z'; l++)
        {
          tester[3] = l;
          // fourth letter of brute force
          tester[4] = '\0';
          // pads the tester with null terminator
          if(strcmp(str, tester) == 0)
          // does not allow the collision to occur with the str itself
            continue;
          lefthash = (tester[0] * 100) + tester[1];
          // calculates left side of test hash
          righthash = (tester[2] * 100) + tester[3];
          // calculates right side of test hash
          hpass = hasher(lefthash, righthash);
          // captures the test hash
          if(strhash == hpass)
          // compare strhash and test hash for collision
          {
            printf("Collision: %s.\n", tester);
            collisionChecker = 1;
            // keeps track if there was ever a collision or not
          }
        }
      }
    }
  }
  if(!collisionChecker)
  // check if a collision ever occurred
    printf("No duplicate hash found... :(\n");
  return 0;
  // return 0
}
