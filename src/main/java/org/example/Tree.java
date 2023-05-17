package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        private Node(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node: "+value;
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

    public boolean find(int value) {
        if (root == null)
            return false;

        var current = root;

        while (current != null){
            if (value < current.value){
                current = current.leftChild;
            } else if(value > current.value){
                current = current.rightChild;
            } else{
                return true;
            }
        }
        return false;
    }
    public int height(){
        return height(root);
    }
    private int height(Node root) {
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }
    public int min(){
        return min(root);
    }
    private int min(Node root) {
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return root.value;

        return Math.min(min(root.leftChild), min(root.rightChild));
    }
    public void traversePreOrder(){
        //ROOT, LEFT , RIGHT
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder(){
        // LEFT ,ROOT, RIGHT
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);
    }
    public void traversePostOrder(){
        // LEFT , RIGHT, ROOT
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);
    }

    public boolean equals(Tree other){
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinaryTree(){
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinaryTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isBinaryTree(root.leftChild, min, root.value -1)
                && isBinaryTree(root.rightChild, root.value + 1, max);
    }
    public List<Integer> nodesAtKDistance(int k){

        ArrayList<Integer> list = new ArrayList<>();
        nodesAtKDistance(root, k, list);
        return list;
    }
    private void nodesAtKDistance(Node root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (k == 0){
//            System.out.println(root.value);
            list.add(root.value);
            return;
        }
        nodesAtKDistance(root.leftChild, k - 1, list);
        nodesAtKDistance(root.rightChild, k - 1, list);
    }
    public void levelOrderTraversal() {
        if (root == null)
            return;

        for (int i = 0; i <= height(); i++) {
            nodesAtKDistance(i).forEach(System.out::println);
        }
    }

}
