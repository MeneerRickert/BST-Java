package com.rickert.bst.tree;

import com.rickert.bst.exceptions.NodeNotInTreeException;
import com.rickert.bst.exceptions.WrongInputException;
import com.rickert.bst.nodes.TreeNode;
import com.rickert.bst.util.Checker;

public class Tree implements ITree {

    private TreeNode root;

    @Override
    // insert node with value value
    public void insert(Object value) throws WrongInputException {
        if (Checker.isConvertible(value)) {
            if (root != null) {
                // inserting a new node
                root.insert(value);
            } else {
                // If root doesn't exist, create it
                root = new TreeNode(null, value);
            }
        } else {
            throw new WrongInputException();
        }
    }

    @Override
    // delete node with value value
    public void delete(Object value) {
        root = delete(this.root, value);
    }

    // delete node with value value
    private TreeNode delete(TreeNode subTreeRoot, Object value) {
        // Catching null
        if (!Checker.isConvertible(value)) {
            return null;
        }

        // searching for the value
        if (Checker.getFloat(value) < Checker.getFloat(subTreeRoot.getValue())) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (Checker.getFloat(value) > Checker.getFloat(subTreeRoot.getValue())) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            // case 1 & 2: when 0 or 1 child(ren)
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            // case 3: 2 children
            subTreeRoot.setValue(subTreeRoot.getLeftChild().maxValue());
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), subTreeRoot.getLeftChild().maxValue()));
        }

        return subTreeRoot;
    }

    @Override
    // get TreeNode with value value
    public TreeNode get(Object value) throws WrongInputException {
        return root.get(value);
    }

    @Override
    // get lowest value in tree
    public Object minValue() {
        return root != null ? root.minValue() : null;
    }

    @Override
    // get lowest value in tree
    public TreeNode minNode() {
        return root != null ? root.minNode() : null;
    }

    @Override
    // get maximum value in tree
    public Object maxValue() {
        return root != null ? root.maxValue() : null;
    }

    @Override
    // get maximum value in tree
    public TreeNode maxNode() {
        return root != null ? root.maxNode() : null;
    }

    @Override
    // get the successor of node
    public TreeNode successor(TreeNode node) throws WrongInputException, NodeNotInTreeException {
        if (inTree(node)) {
            return node.successor();
        } else {
            throw new NodeNotInTreeException();
        }
    }

    @Override
    // get the predecessor of node
    public TreeNode predecessor(TreeNode node) throws WrongInputException, NodeNotInTreeException {
        if (inTree(node)) {
            return node.predecessor();
        } else {
            throw new NodeNotInTreeException();
        }
    }

    private boolean inTree(TreeNode node) throws WrongInputException {
        return (this.get(node.getValue()) != null);
    }

    @Override
    // print preorder walk
    public void preOrderWalk() {
        if (root != null) {
            root.preOrderWalk();
        }
    }

    @Override
    // print postorder walk
    public void postOrderWalk() {
        if (root != null) {
            root.postOrderWalk();
        }
    }

    @Override
    // print inorder walk
    public void inOrderWalk() {
        if (root != null) {
            root.inOrderWalk();
        }
    }
}