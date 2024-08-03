package com.onejava.tree;

class Node {
    Integer value;
    Node left, right;

    public Node(int value)
    {
        this.value = value;
        left = right = null;
    }

}

class BinaryTree{
    Node root;
    static void preorder(Node rt) {
        if (rt == null) return; // Empty subtree - do nothing
        visit(rt);             // Process root node
        preorder(rt.left);    // Process all nodes in left
        preorder(rt.right);   // Process all nodes in right
    }

    static void postorder(Node rt) {
        if (rt == null) return; // Empty subtree - do nothing
        postorder(rt.left);    // Process all nodes in left
        postorder(rt.right);   // Process all nodes in right
        visit(rt);             // Process root node
    }

    static void inorder(Node rt) {
        if (rt == null) return; // Empty subtree - do nothing
        inorder(rt.left);    // Process all nodes in left
        visit(rt);             // Process root node
        inorder(rt.right);   // Process all nodes in right
    }

    private static void visit(Node rt) {
        System.out.print(rt.value + " ");
    }
}

public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("\nPreorder traversal of binary tree is ");
        BinaryTree.preorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        BinaryTree.postorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        BinaryTree.inorder(tree.root);

    }

}