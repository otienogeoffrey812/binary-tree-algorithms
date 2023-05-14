package org.example;

public class Tree {
    private class Node{
        private int value;
        private int rightChild;
        private int leftChild;

        private Node(int value){
            this.value = value;
        }
    }

    private Node root;
}
