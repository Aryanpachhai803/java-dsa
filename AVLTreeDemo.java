import java.util.Scanner;

class FileNode {
    String fileName;
    int height;
    FileNode left, right;

    FileNode(String fileName) {
        this.fileName = fileName;
        this.height = 1;
    }
}

class AVLTree {

    int height(FileNode node) {
        return (node == null) ? 0 : node.height;
    }

    int getBalance(FileNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    FileNode rightRotate(FileNode y) {
        FileNode x = y.left;
        FileNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    FileNode leftRotate(FileNode x) {
        FileNode y = x.right;
        FileNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

}

public class AVLTreeDemo {
    public static void main(String[] args) {
        
    }
}
