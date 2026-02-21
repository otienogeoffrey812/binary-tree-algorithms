package org.example;

public class Main {
    public static void main(String[] args) {

        Tree2 tree = new Tree2();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
//        tree.insert(9);
//        tree.insert(11);
//        tree.insert(12);
//
//        System.out.println(tree.find(13));
//        System.out.println(tree.find2(111));
//        System.out.println("Height: "+tree.height());
//        System.out.println("Min: "+tree.min());
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traversePostOrder();
//        tree.levelOrderTraversal();
//        System.out.println("IS Binary Tree: "+tree.isBinaryTree());
//        System.out.println(tree.nodesAtKDistance(1));
//        System.out.println("Sum Of Nodes: "+tree.sumOfNodes());
//        tree.levelOrderTraversalUsingQueue();
//        tree.levelOrderQueue();
//        tree.printLeaves();
//        tree.levelOrderTraversal();
//        System.out.println("---------------------------");
//        tree.invertBinaryTree();
//        tree.levelOrderTraversal();
//        tree.levelOrderQueue();
//        tree.rightSideView();
//        tree.leftSideView();
//        tree.rightSideView();
//        System.out.println(tree.leftSideView2());
//        System.out.println(tree.rightSideView2());
        tree.leftSideViewQueued();
        tree.rightSideViewQueued();
//        tree.rightSideView();
//
//        Tree2 other = new Tree2();
//        other.insert(7);
//        other.insert(4);
//        other.insert(9);
//        other.insert(1);
//        other.insert(6);
//        other.insert(8);
//
//        System.out.println("Equals: "+tree.equals(other));
    }
}