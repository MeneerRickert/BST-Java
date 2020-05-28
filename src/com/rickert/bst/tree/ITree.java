package com.rickert.bst.tree;

import com.rickert.bst.nodes.TreeNode;

public interface ITree {

    void insert(Object value);
    void delete(Object value);

    TreeNode get(Object value);
    Object minValue();
    TreeNode minNode();
    Object maxValue();
    TreeNode maxNode();
    TreeNode successor(TreeNode node);
    TreeNode predecessor(TreeNode node);

    void preOrderWalk();
    void postOrderWalk();
    void inOrderWalk();

}
