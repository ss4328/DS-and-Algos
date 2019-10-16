# Trees

Trees are, in essence, a very specific set of graphs which follow certain rules. As we know, graphs are just a collection of nodes, their data, and pointers to other nodes with data. Trees are minimally connected graphs, having only one path between any two vertices(Graphs can contain vertices with multiple paths: Unidirectional, bi-directional, etc).

##Properties
- Trees contain no loops, no circuits, no self-loops
- Exactly one ROOT node
- n-1 edges
- Tree is a Hierarchical model

##Run-times, Types and other important facts

- Trees are traversed by Pre-order, In-order, and Post order Traversals. 

For a Binary Tree: 
- Searching: O(n)
- Insertion: O(n)
- Deletion: O(n)

Special types of trees: Binary Trees, BST, AVL, Heaps

Height of a tree: 
If there are n nodes in binary tree, maximum height of the binary tree is n-1 and minimum height is floor(log2n).

BST: Special type of Tree in which Left child of the tree has value less than parent and right side has a value greater than parent.
For a given tree of height h,
- Searching: Worst-Case -> O(n), General-Case -> O(h) 
- Insertion: Worst-Case -> O(n), General-Case -> O(h) 
- Deletion: Worst-Case -> O(n), General-Case -> O(h) 

AVL/Height Balanced Tree: Special Type of BST with additional property that    Height(Left subtree) - Height(Right Subtree) <=1
- Searching: Worst-Case -> O(Log2 n), Where Log2 is binary log function
- Insertion: Worst-Case -> O(Log2 n), Where Log2 is binary log function
- Deletion: Worst-Case -> O(Log2 n), Where Log2 is binary log function


##Relationships/Distinctions from other DS
- Trees are specifically DAG: Directed Acyclic Graphs