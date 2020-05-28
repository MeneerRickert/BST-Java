package com.rickert.bst.nodes;

public class IntegerTreeNode extends TreeNode {

    public IntegerTreeNode(int value) {
        super(value);
        this.value = value;
    }

    // inserting new node
    @Override
    public void insert(Object value) {
        if (value instanceof Integer) {
            // filter duplicate values
            if ((int) value == (int) this.value) {
                return;
            }

            // checking if value must be in left or right subtree
            // if the subtree does not exist add node, otherwise search further
            if ((int) value < (int) this.value) {
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
            if ((int) value == (int) this.value) {
                return this;
            }

            // check whether value is in left or right subtree en search further
            if ((int) value < (int) this.value) {
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

    // Getting minimum value in subtree
    public Object min() {
        return this.leftChild != null ? this.leftChild.min() : (int) this.value;
    }

    // Getting maximum value in subtree
    public Object max() {
        return this.rightChild != null ? this.rightChild.max() : (int) this.value;
    }

    public void setValue(Object value) {
        if (value instanceof Integer) {
            this.value = value;
        }
    }
}