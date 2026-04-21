package Practical;

import AVLTree;

public class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int k) {
            key = k;
            height = 1;
        }
    }

    Node root;

    int h(Node n) {
        return n == null ? 0 : n.height;
    }

    int balance(Node n) {
        return n == null ? 0 : h(n.left) - h(n.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;

        y.height = Math.max(h(y.left), h(y.right)) + 1;
        x.height = Math.max(h(x.left), h(x.right)) + 1;

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;

        x.height = Math.max(h(x.left), h(x.right)) + 1;
        y.height = Math.max(h(y.left), h(y.right)) + 1;

        return y;
    }

    Node insert(Node n, int key) {
        if (n == null) return new Node(key);

        if (key < n.key) n.left = insert(n.left, key);
        else if (key > n.key) n.right = insert(n.right, key);
        else return n;

        n.height = 1 + Math.max(h(n.left), h(n.right));

        int b = balance(n);

        if (b > 1 && key < n.left.key) return rotateRight(n);
        if (b < -1 && key > n.right.key) return rotateLeft(n);
        if (b > 1 && key > n.left.key) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (b < -1 && key < n.right.key) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

        return n;
    }

    Node min(Node n) {
        while (n.left != null) n = n.left;
        return n;
    }

    Node delete(Node n, int key) {
        if (n == null) return null;

        if (key < n.key) n.left = delete(n.left, key);
        else if (key > n.key) n.right = delete(n.right, key);
        else {
            if (n.left == null || n.right == null)
                n = (n.left != null) ? n.left : n.right;
            else {
                Node temp = min(n.right);
                n.key = temp.key;
                n.right = delete(n.right, temp.key);
            }
        }

        if (n == null) return null;

        n.height = 1 + Math.max(h(n.left), h(n.right));

        int b = balance(n);

        if (b > 1 && balance(n.left) >= 0) return rotateRight(n);
        if (b > 1 && balance(n.left) < 0) {
            n.left = rotateLeft(n.left);
            return rotateRight(n);
        }
        if (b < -1 && balance(n.right) <= 0) return rotateLeft(n);
        if (b < -1 && balance(n.right) > 0) {
            n.right = rotateRight(n.right);
            return rotateLeft(n);
        }

        return n;
    }

    void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.key + " ");
            inorder(n.right);
        }
    }

    public static void main(String[] args) {
        AVLTree t = new AVLTree();

        int[] arr = {10, 20, 30, 40, 50, 25};
        for (int x : arr) t.root = t.insert(t.root, x);

        System.out.print("Inorder: ");
        t.inorder(t.root);

        t.root = t.delete(t.root, 40);

        System.out.print("\nAfter delete: ");
        t.inorder(t.root);
    }
}