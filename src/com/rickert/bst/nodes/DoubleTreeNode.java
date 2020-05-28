package com.rickert.bst.nodes;

import com.rickert.bst.WrongInputException;

public class DoubleTreeNode extends TreeNode {

    public DoubleTreeNode(double value) {
        super(value);
        this.value = value;
    }

    // inserting new node
    @Override
    public void insert(Object value) throws WrongInputException {
        if (value instanceof Double) {
            // filter duplicate values
            if ((double) value == (double) this.value) {
                return;
            }

            // checking if value must be in left or right subtree
            // if the subtree does not exist add node, otherwise search further
            if ((double) value < (double) this.value) {
                if (this.leftChild == null) {
                    this.leftChild = new DoubleTreeNode((double) value);
                } else {
                    this.leftChild.insert(value);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new DoubleTreeNode((double) value);
                } else {
                    this.rightChild.insert(value);
                }
            }
        } else {
            throw new WrongInputException("Input is not a Double");
        }
    }

    // Getting node
    @Override
    public TreeNode get(Object value) throws WrongInputException {
        if (value instanceof Double) {
            // return when value found
            if ((double) value == (double) this.value) {
                return this;
            }

            // check whether value is in left or right subtree en search further
            if ((double) value < (double) this.value) {
                if (leftChild != null) {
                    return leftChild.get(value);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.get(value);
                }
            }
        } else {
            throw new WrongInputException("Input is not a Double");
        }

        // returning null if value not found
        return null;
    }

    // Getting minimum value in subtree
    public Object min() {
        return this.leftChild != null ? this.leftChild.min() : (double) this.value;
    }

    // Getting maximum value in subtree
    public Object max() {
        return this.rightChild != null ? this.rightChild.max() : (double) this.value;
    }

    public void setValue(Object value) {
        if (value instanceof Double) {
            this.value = value;
        }
    }
}