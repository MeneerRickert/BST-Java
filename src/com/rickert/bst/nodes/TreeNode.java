package com.rickert.bst.nodes;

import com.rickert.bst.exceptions.WrongInputException;
import com.rickert.bst.util.Checker;

public class TreeNode implements ITreeNode {

    private Object key;
    private Object value;
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(TreeNode parent, Object key) throws WrongInputException {
        if (Checker.isConvertible(key)) {
            this.parent = parent;
            this.key = key;
        } else {
            throw new WrongInputException();
        }
    }

    @Override
    // inserting new node
    public void insert(Object value) throws WrongInputException {
        if (Checker.isConvertible(value)) {
            // filter duplicate values
            if (value == this.key) {
                return;
            }

            // checking if value must be in left or right subtree
            // if the subtree does not exist add node, otherwise search further
            if (Checker.getFloat(value) < Checker.getFloat(this.key)) {
                if (this.leftChild == null) {
                    this.leftChild = new TreeNode(this, value);
                } else {
                    this.leftChild.insert(value);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new TreeNode(this, value);
                } else {
                    this.rightChild.insert(value);
                }
            }
        } else {
            throw new WrongInputException();
        }
    }

    @Override
    // Getting node
    public TreeNode get(Object value) throws WrongInputException {
        if (Checker.isConvertible(value)) {
            // return when value found
            if (value == this.key) {
                return this;
            }

            // check whether value is in left or right subtree en search further
            if (Checker.getFloat(value) < Checker.getFloat(this.key)) {
                if (leftChild != null) {
                    return leftChild.get(value);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.get(value);
                }
            }
        } else {
            throw new WrongInputException();
        }

        // returning null if value not found
        return null;
    }

    @Override
    // Getting minimum value in subtree
    public Object minValue() {
        return this.leftChild != null ? this.leftChild.minValue() : this.key;
    }

    @Override
    // Getting minimum node in subtree
    public TreeNode minNode() {
        return this.leftChild != null ? this.leftChild.minNode() : this;
    }

    @Override
    // Getting maximum value in subtree
    public Object maxValue() {
        return this.rightChild != null ? this.rightChild.maxValue() : this.key;
    }

    @Override
    // Getting maximum node in subtree
    public TreeNode maxNode() {
        return this.rightChild != null ? this.rightChild.maxNode() : this;
    }

    public TreeNode successor() {
        if (this.rightChild != null) {
            return this.rightChild.minNode();
        }

        TreeNode parentNode = this.parent;
        TreeNode searchNode = this;
        while (parentNode != null && searchNode == parentNode.rightChild) {
            searchNode = parentNode;
            parentNode = parentNode.parent;
        }

        return parentNode;
    }

    public TreeNode predecessor() {
        if (this.leftChild != null) {
            return this.leftChild.minNode();
        }

        TreeNode parentNode = this.parent;
        TreeNode searchNode = this;
        while (parentNode != null && searchNode == parentNode.leftChild) {
            searchNode = parentNode;
            parentNode = parentNode.parent;
        }

        return parentNode;
    }

    @Override
    // Print method for preOrderWalk
    public void preOrderWalk() {
        System.out.print(key + ", ");
        if (this.leftChild != null) {
            this.leftChild.preOrderWalk();
        }
        if (this.rightChild != null) {
            this.rightChild.preOrderWalk();
        }
    }

    @Override
    // Print method for postOrderWalk
    public void postOrderWalk() {
        if (this.leftChild != null) {
            this.leftChild.postOrderWalk();
        }
        if (this.rightChild != null) {
            this.rightChild.postOrderWalk();
        }
        System.out.print(key + ", ");
    }

    @Override
    // Print method for inOrderWalk
    public void inOrderWalk() {
        if (this.leftChild != null) {
            this.leftChild.inOrderWalk();
        }
        System.out.print(key + ", ");
        if (this.rightChild != null) {
            this.rightChild.inOrderWalk();
        }
    }

    @Override
    public Object getKey() {
        return key;
    }

    @Override
    public void setKey(Object key) {
        if (Checker.isConvertible(key)) {
            this.key = key;
        }
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public TreeNode getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}