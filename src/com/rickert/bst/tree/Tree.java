package com.rickert.bst.tree;

import com.rickert.bst.exceptions.WrongInputException;
import com.rickert.bst.nodes.TreeNode;
import com.rickert.bst.util.Checker;

public class Tree implements ITree {

    private TreeNode root;

    @Override
    // insert node with key key
    public void insert(Object key) {
        if (Checker.isConvertible(key)) {
            try {
                if (root != null) {
                    // inserting a new node
                    root.insert(key);
                } else {
                    // If root doesn't exist, create it
                    root = new TreeNode(null, key);
                }
            } catch (WrongInputException ex) {
                System.out.println("Input is not compatible");
            }
        } else {
            System.out.println("Input is not compatible");
        }
    }

    @Override
    // delete node with key key
    public void delete(Object key) {
        root = delete(this.root, key);
    }

    // delete node with key key
    private TreeNode delete(TreeNode subTreeRoot, Object key) {
        // Catching null
        if (!Checker.isConvertible(key)) {
            return null;
        }

        // searching for the key
        if (Checker.getFloat(key) < Checker.getFloat(subTreeRoot.getKey())) {
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), key));
            subTreeRoot.getLeftChild().setParent(subTreeRoot);
        } else if (Checker.getFloat(key) > Checker.getFloat(subTreeRoot.getKey())) {
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), key));
            subTreeRoot.getRightChild().setParent(subTreeRoot);
        } else {
            // case 1 & 2: when 0 or 1 child(ren)
            if (subTreeRoot.getLeftChild() == null) {
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            // case 3: 2 children
            subTreeRoot.setKey(subTreeRoot.getLeftChild().maxValue());
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), subTreeRoot.getLeftChild().maxValue()));
            subTreeRoot.getLeftChild().setParent(subTreeRoot);
        }

        return subTreeRoot;
    }

    @Override
    // get TreeNode with key key
    public TreeNode get(Object key) {
        try {
            return root.get(key);
        } catch (WrongInputException ex) {
            System.out.println("Input is not compatible");
            return null;
        }
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
    public TreeNode successor(TreeNode node) {
        if (inTree(node)) {
            return node.successor();
        } else {
            System.out.println("The node is not within the tree");
            return null;
        }
    }

    @Override
    // get the predecessor of node
    public TreeNode predecessor(TreeNode node)  {
        if (inTree(node)) {
            return node.predecessor();
        } else {
            System.out.println("The node is not within the tree");
            return null;
        }
    }

    private boolean inTree(TreeNode node) {
        return (this.get(node.getKey()) != null);
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