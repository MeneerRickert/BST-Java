package com.rickert.bst.trees;

import com.rickert.bst.nodes.TreeNode;

public abstract class Tree {

    protected TreeNode root;

    // insert node with value value
    public boolean insert(Object value) {
        if (root != null) {
            // inserting a new node
            root.insert(value);
            return true;
        }
        return false;
    }

    // delete node with value value
    public void delete(Object value) {
        root = delete(this.root, value);
    }

    protected abstract TreeNode delete(TreeNode subTreeRoot, Object value);

    protected TreeNode casesDeletion(TreeNode subTreeRoot) {
        // case 1 & 2: when 0 or 1 child(ren)
        if (subTreeRoot.getLeftChild() == null) {
            return subTreeRoot.getRightChild();
        } else if (subTreeRoot.getRightChild() == null) {
            return subTreeRoot.getLeftChild();
        }

        // case 3: 2 children
        subTreeRoot.setValue(subTreeRoot.getLeftChild().max());
        subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), subTreeRoot.getLeftChild().max()));

        return subTreeRoot;
    }

    // get TreeNode with value value
    public TreeNode get(Object value) {
        return root.get(value);
    }

    // get lowest value in tree
    public Object min() {
        return root != null ? root.min() : null;
    }

    // get maximum value in tree
    public Object max() {
        return root != null ? root.max() : null;
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