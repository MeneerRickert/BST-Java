package com.rickert.bst;

public class Tree {

    private TreeNode root;

    // insert node with value value
    public void insert(int value) {
        if (root != null) {
            // inserting a new node
            root.insert(value);
            return;
        }

        // If root doesn't exist, create it
        root = new TreeNode(value);
    }

    // delete node with value value
    public void delete(int value) {
        root = delete(this.root, value);
    }

    // delete node with value value
    private TreeNode delete(TreeNode subTreeRoot, int value) {
        // Catching null
        if (subTreeRoot == null) {
            return null;
        }

        // searching for the value
        if (value < subTreeRoot.getValue()) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (value > subTreeRoot.getValue()) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            // case 1 & 2: when 0 or 1 child(ren)
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            // case 3: 2 children
            subTreeRoot.setValue(subTreeRoot.getLeftChild().max());
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), subTreeRoot.getLeftChild().max()));
        }

        return subTreeRoot;
    }

    // get TreeNode with value value
    public TreeNode get(int value) {
        return root.get(value);
    }

    // get lowest value in tree
    public int min() {
        return root != null ? root.min() : Integer.MIN_VALUE;
    }

    // get maximum value in tree
    public int max() {
        return root != null ? root.max() : Integer.MAX_VALUE;
    }

    // print preorder walk
    public void preOrderWalk() {
        if (root != null) {
            root.preOrderWalk();
        }
    }

    // print postorder walk
    public void postOrderWalk() {
        if (root != null) {
            root.postOrderWalk();
        }
    }

    // print inorder walk
    public void inOrderWalk() {
        if (root != null) {
            root.inOrderWalk();
        }
    }
}