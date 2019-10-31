#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//node from lecture slides
struct node
{
    int data;
    struct node *left;
    struct node *right;
};


struct node* newNode(int data)
{
    // make room in memory for new node
    struct node* node = (struct node*)malloc(sizeof(struct node));

    //populate the node
    node->data = data;

    // New nodess choldren are null
    node->left = NULL;
    node->right = NULL;
    //then we finally return the node
    return(node);
}

//specification suggest in-order traversal must be used
void printInorder(struct node* node)
{
    if (node == NULL)
        return;
    printInorder(node->left);

    printf("%d ", node->data);

    printInorder(node->right);
}

struct node* insertLevelOrder(int arr[], struct node* root, int i, int n) {
    // Base case for recursion
    if (i < n)
    {
        struct node* temp = newNode(arr[i]);
        root = temp;

        // insert left child
        root->left = insertLevelOrder(arr,
                                      root->left, 2 * i + 1, n);

        // insert right child
        root->right = insertLevelOrder(arr,
                                       root->right, 2 * i + 2, n);
    }
    return root;
}

int main()
{
//    int arr[] = {1,2,3,2,4,5,3,6,7,4,8,9,6,-1,-1,5,-1,-1,6,-1,-1,7,-1,-1,8,-1,-1,9,-1,-1};

    int* list = malloc(10 * sizeof(int));
    if(list == NULL) {}
    list = realloc(list, 20 * sizeof(int));

    //read file, storing the contents to 'line'
    char line[1000];
    FILE *fptr;
    if ((fptr = fopen("binaryTree.txt", "r")) == NULL)
    {
        printf("Error! opening file");
        // Program exits if file pointer returns NULL.
        exit(1);
    }
    // reads text until newline
    fscanf(fptr,"%[^\n]", line);
    printf("Data from the file:\n%s", line);
    fclose(fptr);

    //line gets converted to an array of integers
    char *pt;
    pt = strtok (line,",");
    int i=0;
    printf("\n");
    while (pt != NULL) {
        int a = atoi(pt);

//        printf("%d\n", a);
        //here we add the int a to our int array
        list[i] = a;
        i++;
        pt = strtok (NULL, ",");
    }

    int n = sizeof(arr)/sizeof(arr[0]);

    //array of integers get added to binary tree one-by-one
    struct node *root = insertLevelOrder(list, root, 0, n);

    //finally, we print the binar tree
    printInorder(root);

    getchar();

    free(list);
    return 0;
}
