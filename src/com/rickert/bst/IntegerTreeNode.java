package com.rickert.bst;

public class IntegerTreeNode extends TreeNode {

    private int value;

    public IntegerTreeNode(int value) {
        super(value);
        this.value = value;
    }

    // inserting new node
    @Override
    public void insert(Object value) {
        if (value instanceof Integer) {
            // filter duplicate values
            if ((int) value == this.value) {
                return;
            }


            // checking if value must be in left or right subtree
            // if the subtree does not exist add node, otherwise search further
            if ((int) value < this.value) {
                if (this.leftChild == null) {
                    this.leftChild = new IntegerTreeNode((int) value);
                } else {
                    this.leftChild.insert(value);
                }
            } else {
                if (this.rightChild == null) {
                    this.rightChild = new IntegerTreeNode((int) value);
                } else {
                    this.rightChild.insert(value);
                }
            }
        }
    }

    // Getting node
    @Override
    public TreeNode get(Object value) {
        if (value instanceof Integer) {
            // return when value found
            if ((int) value == this.value) {
                return this;
            }

            // check whether value is in left or right subtree en search further
            if ((int) value < this.value) {
                if (leftChild != null) {
                    return leftChild.get(value);
                }
            } else {
                if (rightChild != null) {
                    return rightChild.get(value);
                }
            }
        }

        // returning null if value not found
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}