package com.rickert.bst.exceptions;

public class NodeNotInTreeException extends Exception {

    public NodeNotInTreeException() {
        super("The node is not in the tree");
    }
}
