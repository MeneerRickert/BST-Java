package com.rickert.bst;

public abstract class TreeNode {

    private int value;
    protected TreeNode leftChild;
    protected TreeNode rightChild;

    public TreeNode(int value) {
        this.value = value;
    }

    public abstract void insert(Object value);

    public abstract TreeNode get(Object value);

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