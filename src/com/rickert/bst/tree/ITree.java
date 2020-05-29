package com.rickert.bst.tree;

import com.rickert.bst.nodes.TreeNode;

public interface ITree {

    void insert(Object key);
    void delete(Object key);

    TreeNode get(Object key);
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
