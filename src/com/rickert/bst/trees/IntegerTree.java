package com.rickert.bst.trees;

import com.rickert.bst.nodes.IntegerTreeNode;
import com.rickert.bst.nodes.TreeNode;

public class IntegerTree extends Tree {

    public boolean insert(Object value) {
        if (!super.insert(value)) {
            // If root doesn't exist, create it
            root = new IntegerTreeNode((int) value);
        }
        return true;
    }

    // delete node with value value
    @Override
    protected TreeNode delete(TreeNode subTreeRoot, Object value) {
        // Catching null
        if (!(value instanceof Integer) || !(subTreeRoot instanceof IntegerTreeNode)) {
            return null;
        }

        // searching for the value
        if ((int) value < (int) subTreeRoot.getValue()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if ((int) value > (int) subTreeRoot.getValue()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            return super.casesDeletion(subTreeRoot);
        }

        return subTreeRoot;
    }
}