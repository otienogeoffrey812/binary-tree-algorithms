package org.example;

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);

//        System.out.println(tree.find(1));
//        System.out.println(tree.height());
//        System.out.println(tree.min());
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traversePostOrder();
//        tree.levelOrderTraversal();
//        System.out.println(tree.isBinaryTree());
//        System.out.println(tree.nodesAtKDistance(1));
//        tree.printLeaves();
//        tree.leftSideView();
        tree.rightSideView();

//        Tree other = new Tree();
//        other.insert(7);
//        other.insert(4);
//        other.insert(9);
//        other.insert(1);
//        other.insert(6);
//        other.insert(8);
//        other.insert(10);
//
//        System.out.println(tree.equals(other));
    }
}