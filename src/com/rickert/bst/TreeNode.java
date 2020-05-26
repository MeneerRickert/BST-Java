package com.rickert.bst;

public class TreeNode {

    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
    }

    // inserting new node
    public void insert(int value) {
        // filter duplicate values
        if (value == this.value) {
            return;
        }

        // checking if value must be in left or right subtree
        // if the subtree does not exist add node, otherwise search further
        if (value < this.value) {
            if (this.leftChild == null) {
                this.leftChild = new TreeNode(value);
            } else {
                this.leftChild.insert(value);
            }
        } else {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(value);
            } else {
                this.rightChild.insert(value);
            }
        }
    }

    // Getting node
    public TreeNode get(int value) {
        // return when value found
        if (value == this.value) {
            return this;
        }

        // check whether value is in left or right subtree en search further
        if (value < this.value) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        // returning null if value not found
        return null;
    }

    // Getting minimum value in subtree
    public int min() {
        return this.leftChild != null ? this.leftChild.min() : this.value;
    }

    // Getting maximum value in subtree
    public int max() {
        return this.rightChild != null ? this.rightChild.max() : this.value;
    }

    // Print method for preOrderWalk
    public void preOrderWalk() {
        System.out.print(value + ", ");
        if (this.leftChild != null) {
            this.leftChild.preOrderWalk();
        }
        if (this.rightChild != null) {
            this.rightChild.preOrderWalk();
        }
    }

    // Print method for postOrderWalk
    public void postOrderWalk() {
        if (this.leftChild != null) {
            this.leftChild.postOrderWalk();
        }
        if (this.rightChild != null) {
            this.rightChild.postOrderWalk();
        }
        System.out.print(value + ", ");
    }

    // Print method for inOrderWalk
    public void inOrderWalk() {
        if (this.leftChild != null) {
            this.leftChild.inOrderWalk();
        }
        System.out.print(value + ", ");
        if (this.rightChild != null) {
            this.rightChild.inOrderWalk();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }


}
