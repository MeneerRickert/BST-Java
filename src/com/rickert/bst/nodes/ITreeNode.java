package com.rickert.bst.nodes;

import com.rickert.bst.exceptions.WrongInputException;

public interface ITreeNode {

    void insert(Object value) throws WrongInputException;

    TreeNode get(Object value) throws WrongInputException;
    Object minValue();
    TreeNode minNode();
    Object maxValue();
    TreeNode maxNode();
    TreeNode successor();
    TreeNode predecessor();

    void preOrderWalk();
    void postOrderWalk();
    void inOrderWalk();

    Object getKey();
    Object getValue();
    TreeNode getParent();
    TreeNode getLeftChild();
    TreeNode getRightChild();
    void setKey(Object key);
    void setValue(Object value);
    void setParent(TreeNode parent);
    void setLeftChild(TreeNode leftChild);
    void setRightChild(TreeNode rightChild);

}
