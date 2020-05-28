package com.rickert.bst.nodes;

import com.rickert.bst.exceptions.WrongInputException;

public interface ITreeNode {

    void insert(Object value) throws WrongInputException;

    TreeNode get(Object value) throws WrongInputException;
    Object minValue();
    TreeNode minNode();
    Object maxValue();
    TreeNode maxNode();

    void preOrderWalk();
    void postOrderWalk();
    void inOrderWalk();

    Object getValue();
    TreeNode getParent();
    TreeNode getLeftChild();
    TreeNode getRightChild();
    void setValue(Object value);
    void setParent(TreeNode parent);
    void setLeftChild(TreeNode leftChild);
    void setRightChild(TreeNode rightChild);

}
