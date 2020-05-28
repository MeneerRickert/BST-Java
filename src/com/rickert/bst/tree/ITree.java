package com.rickert.bst.tree;

import com.rickert.bst.exceptions.NodeNotInTreeException;
import com.rickert.bst.exceptions.WrongInputException;
import com.rickert.bst.nodes.TreeNode;

public interface ITree {

    void insert(Object value) throws WrongInputException;
    void delete(Object value);

    TreeNode get(Object value) throws WrongInputException;
    Object minValue();
    TreeNode minNode();
    Object maxValue();
    TreeNode maxNode();
    TreeNode successor(TreeNode node) throws WrongInputException, NodeNotInTreeException;
    TreeNode predecessor(TreeNode node) throws NodeNotInTreeException, WrongInputException;

    void preOrderWalk();
    void postOrderWalk();
    void inOrderWalk();

}
