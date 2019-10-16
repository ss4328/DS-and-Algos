package com.shiv;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Running Tree program");
        Tree myTree = new Tree();
        myTree.insert(5);
        myTree.insert(4);
        myTree.insert(6);
        myTree.insert(8);
        myTree.insert(4);
        myTree.preOrder(myTree.root);
        System.out.println();
        myTree.postOrder(myTree.root);
        System.out.println();
        myTree.inOrder(myTree.root);
        System.out.println();
        myTree.printPath(8, myTree.root);
        myTree.delete(8, myTree.root);
        myTree.preOrder(myTree.root);
        System.out.println();
        myTree.postOrder(myTree.root);
        System.out.println();
        myTree.inOrder(myTree.root);
        System.out.println();
    }
}
