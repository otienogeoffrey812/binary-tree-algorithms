package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    private int height(Node node) {
        if(node == null) return -1;
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }
    public int min(){
        return min(root);
    }
    private int min(Node node) {
        if (node == null) return Integer.MAX_VALUE;

        if (node.leftChild == null && node.rightChild == null)
            return node.value;

        return Math.min(Math.min(min(node.leftChild)
                , min(node.rightChild)), node.value);
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
    private void traversePostOrder(Node node) {
        if (node == null)
            return;

        traversePostOrder(node.leftChild);
        traversePostOrder(node.rightChild);
        System.out.println(node);
    }

    public boolean equals(Tree other){
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;

        return first.value == second.value
                && equals(first.leftChild, second.leftChild)
                && equals(first.rightChild, second.rightChild);
    }

    public boolean isBinaryTree(){
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinaryTree(Node node, int min, int max) {
        if (node == null) return true;

        if (node.value < min || node.value > max) return false;

        return isBinaryTree(node.leftChild, min, node.value -1)
                && isBinaryTree(node.rightChild, node.value + 1, max);
    }
    public List<Integer> nodesAtKDistance(int k){

        ArrayList<Integer> list = new ArrayList<>();
        nodesAtKDistance(root, k, list);
        return list;
    }
    private void nodesAtKDistance(Node node, int k, ArrayList<Integer> list) {
        if (node == null)
            return;
        if (k == 0){
//            System.out.println(root.value);
            list.add(node.value);
            return;
        }
        nodesAtKDistance(node.leftChild, k - 1, list);
        nodesAtKDistance(node.rightChild, k - 1, list);
    }
    public void levelOrderTraversal() {
        if (root == null) return;

        for (int i = 0; i <= height(); i++) {
            nodesAtKDistance(i).forEach(System.out::println);
        }
    }
    public void levelOrderTraversalUsingQueue(){
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            var current  = queue.poll();
            System.out.println(current);

            if (current.leftChild != null ){
                queue.add(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
    }
    public void printLeaves(){
        printLeaves(root);
    }
    private void printLeaves(Node node) {
        if(node == null) return;

        if (node.leftChild == null && node.rightChild == null){
            System.out.println(node.value);
        }
        printLeaves(node.leftChild);
        printLeaves(node.rightChild);
    }

    public int sumOfNodes(){
        return sumOfNodes(root);
    }

    private int sumOfNodes(Node node) {
        if(node == null)return 0;

        return node.value + sumOfNodes(node.leftChild) + sumOfNodes(node.rightChild);
    }
    private void invertBinaryTree(Node node) {
        if (node == null) return;

        var temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;

        invertBinaryTree(node.leftChild);
        invertBinaryTree(node.rightChild);
    }

    public void leftSideView(){
        if (root == null) return;

        for (int i = 0; i <= height(); i++) {
            List<Integer> nodesAtLevel = nodesAtKDistance(i);
            System.out.println(nodesAtLevel.get(0));
        }
    }

}
