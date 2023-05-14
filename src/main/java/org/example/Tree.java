package org.example;

public class Tree {
    private class Node{
        private int value;
        private Node rightChild;
        private Node leftChild;
        private Node(int value){
            this.value = value;
        }
    }

    private Node root;
    public void insert(int value){
        var node = new Node(value);
        if (root == null){
            root = node;
            return;
        }
        var current = root;

        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    return;
                }
                current = current.leftChild;
            } else{
                if (current.rightChild == null){
                    current.rightChild = node;
                    return;
                }
                current = current.rightChild;
            }
        }

    }
}
