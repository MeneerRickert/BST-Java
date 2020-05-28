package com.rickert.bst.nodes;

import com.rickert.bst.WrongInputException;

public abstract class TreeNode {

    protected Object value;
    protected TreeNode leftChild;
    protected TreeNode rightChild;

    public TreeNode(Object value) {
        this.value = value;
    }

    public abstract void insert(Object value) throws WrongInputException;

    public abstract TreeNode get(Object value) throws WrongInputException;

    public abstract Object min();

    public abstract Object max();

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

    public Object getValue() {
        return value;
    }

    public abstract void setValue(Object value);

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