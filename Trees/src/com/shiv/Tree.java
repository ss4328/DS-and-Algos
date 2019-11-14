//credits: GeeksForGeeks.org

package com.shiv;

public class Tree {
    Node root;

    public void insert(int key){
        root = insert(key, root);
    }

    public Node insert(int key, Node root){

        //root in 1st traversal
        if(root==null){
            root = new Node(key);
            return root;
            //actually assign node
        }

        if(key<root.key){
            root.leftChild = insert(key, root.leftChild);
        }
        else if(key>root.key){
            root.rightChild = insert(key, root.rightChild);
        }

        return root;
    }


    public Node delete(int key, Node root){
        if(root == null) return root;

        if(key<root.key){
            root.leftChild = delete(key,root.leftChild);
        }
        else if(key > root.key){
            root.rightChild = delete(key,root.rightChild);
        }

        else{
            //one child
            if(root.leftChild == null){
                return root.rightChild;
            }
            else if(root.rightChild == null){
                return root.leftChild;
            }

            //both children attached
            root.key = minValue(root.rightChild);
            root.rightChild = delete(root.key, root.rightChild);
        }
        return root;
    }

    int minValue(Node root)
    {
        int minv = root.key;
        while (root.leftChild != null)
        {
            minv = root.leftChild.key;
            root = root.leftChild;
        }
        return minv;
    }

    public void preOrder(Node passed){
        if (passed == null)
            return;
        System.out.print(passed.key + " ");
        preOrder(passed.leftChild);
        preOrder(passed.rightChild);
    }

    public void postOrder(Node passed){
        if (passed == null)
            return;
        postOrder(passed.leftChild);
        postOrder(passed.rightChild);
        System.out.print(passed.key + " ");
    }

    public void inOrder(Node passed){
        if (passed == null)
            return;
        inOrder(passed.leftChild);
        System.out.print(passed.key + " ");
        inOrder(passed.rightChild);
    }

    public Node printPath(int key, Node root){
        if(key==root.key || root==null){
            System.out.print(" Found ");
            return root;
        }
        if (key < root.key){
            System.out.print("L");
            return printPath(key, root.leftChild);
        }


        // val is less than root's key
        System.out.print("R");
        return printPath(key, root.rightChild);
    }

    public boolean isSameTree(Node p, Node q) {
        if(p==null && q ==null) return true;
        if(p==null || q==null) return false;
        if(p.key!=q.key) return false;
        return(isSameTree(p.leftChild,q.leftChild) && isSameTree(p.rightChild,q.rightChild));
    }

    public boolean isValidBST(Node root) {
        if(isChildless(root))
        {
            return true;
        }        
        return isValidSubtree(root, null, null);        
    }
    
    public boolean isValidSubtree(Node node, Integer lower, Integer upper){
        if(node == null){
            return true;
        }
        
        //basically fancy way to check for node.val<lower, and node.val>upper cases
        if (lower != null && node.key <= lower) return false;
        if (upper != null && node.key >= upper) return false;
        
        //verify that left subtree is valid
        if (!isValidSubtree(node.leftChild, lower, node.key)){
            return false;
        }
        //verify that right subtree is valid
        if(!isValidSubtree(node.rightChild, node.key, upper)){
            return false;
        }
        
        return true;
    }
    
    private boolean isChildless(Node node){
        if (node==null) return true;
        if(node.leftChild == null && node.rightChild == null){
            return true;
        }
        else return false;
    }

}
