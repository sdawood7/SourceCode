#include "Binary_Search_Trees.h"

int main(void)
{
  int numVals;
  node *root;
  printf("How many values do you want to insert into the tree?\n");
  scanf("%d", &numVals);
  if((root = createBST(numVals)) == NULL)
  {
    printf("Failed to create tree :(\n");
    return 0;
  }
  printPreorder(root);
  printInorder(root);
  printPostorder(root);
  findAndPrintMax(root);
  root = chopTheTree(root);
  return 0;
}
