#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Struct for Binary Search Tree (BST)
typedef struct node
{
  int data;
  struct node *left, *right;
} node;

// Function to create a node with the data in it
node *createNode(int data)
{
  node *newNode = calloc(1, sizeof(node));  // Initializes left and right nodes
  newNode->data = data;                     // to NULL, and inserts data
  return newNode;
}

// Helper function for printing preorder
// traversal of the BST
void printPreorderHelper(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printf("%d ", root->data);
  printPreorderHelper(root->left);
  printPreorderHelper(root->right);
}

// Function to recursively print preorder
// traversal of the BST
void printPreorder(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printf("Preorder of the tree: ");
  printPreorderHelper(root);
  printf("\n");
}

// Helper function for printing inorder
// traversal of the BST
void printInorderHelper(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printInorderHelper(root->left);
  printf("%d ", root->data);
  printInorderHelper(root->right);
}

// Function to recursively print inorder
// traversal of the BST
void printInorder(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printf("Inorder of the tree: ");
  printInorderHelper(root);
  printf("\n");
}

// Helper function for printing postorder
// traversal of the BST
void printPostorderHelper(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printPostorderHelper(root->left);
  printPostorderHelper(root->right);
  printf("%d ", root->data);
}

// Function to recursively print postorder
// traversal of the BST
void printPostorder(node *root)
{
  if(root == NULL)  // NULL check
    return;
  printf("Postorder of the tree: ");
  printPostorderHelper(root);
  printf("\n");
}

// Function to iteratively find and also print
// the max value in the BST
void findAndPrintMax(node *root)
{
  if(root == NULL)  // NULL check
  {
    printf("No tree to find a max in.\n");
    return;
  }
  while(root->right != NULL)  // The max value should be the
    root = root->right;       // rightmost node
  printf("The max value in the tree is %d.\n", root->data);
}

// Function to recursively add the data into the
// appropriate part of the BST
node *growTheTree(node *root, int data)
{
  if(root == NULL)  // NULL check
    return createNode(data);
  if(data < root->data)
    root->left = growTheTree(root->left, data);
  else if(data > root->data)
    root->right = growTheTree(root->right, data);
  else
    ;
  return root;
}

// Function to recursively free up any dynamically
// allocated memory used up by the BST
node *chopTheTree(node *root)
{
  if(root == NULL)  // NULL check
    return NULL;
  chopTheTree(root->left);
  chopTheTree(root->right);
  free(root);
  return NULL;
}

// Function to create the random values
// in range from 1-500 that will be
// inserted into the BST
node *createBST(int numVals)
{
  int i, randVal;
  node *root;
  srand(time(NULL));
  if(numVals <= 0)
    return NULL;
  for(i = 0; i < numVals; i++)
  {
    randVal = rand()%500 + 1;
    printf("Inserting %d... ", randVal);
    root = growTheTree(root, randVal);
    printf("Inserted!\n");
  }
  return root;
}
