package com.rickert.bst.trees;

import com.rickert.bst.WrongInputException;
import com.rickert.bst.nodes.DoubleTreeNode;
import com.rickert.bst.nodes.IntegerTreeNode;
import com.rickert.bst.nodes.TreeNode;

public class DoubleTree extends Tree {

    public boolean insert(Object value) throws WrongInputException {
        if (value instanceof Double) {
            if (!super.insert(value)) {
                // If root doesn't exist, create it
                root = new DoubleTreeNode((double) value);
            }
            return true;
        } else {
            throw new WrongInputException("Input is not a Double");
        }
    }

    // delete node with value value
    @Override
    protected TreeNode delete(TreeNode subTreeRoot, Object value) {
        // Catching null
        if (!(value instanceof Integer) || !(subTreeRoot instanceof IntegerTreeNode)) {
            return null;
        }

        // searching for the value
        if ((double) value < (double) subTreeRoot.getValue()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if ((double) value > (double) subTreeRoot.getValue()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            return super.casesDeletion(subTreeRoot);
        }

        return subTreeRoot;
    }
}