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

    FileNode insert(FileNode node, String name) {
        if (node == null)
            return new FileNode(name);

        if (name.compareTo(node.fileName) < 0)
            node.left = insert(node.left, name);
        else if (name.compareTo(node.fileName) > 0)
            node.right = insert(node.right, name);
        else
            return node; 

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && name.compareTo(node.left.fileName) < 0)
            return rightRotate(node);

        if (balance < -1 && name.compareTo(node.right.fileName) > 0)
            return leftRotate(node);

        if (balance > 1 && name.compareTo(node.left.fileName) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && name.compareTo(node.right.fileName) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    FileNode minValueNode(FileNode node) {
        FileNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    FileNode delete(FileNode root, String name) {
        if (root == null)
            return root;

        if (name.compareTo(root.fileName) < 0)
            root.left = delete(root.left, name);
        else if (name.compareTo(root.fileName) > 0)
            root.right = delete(root.right, name);
        else {
            if ((root.left == null) || (root.right == null)) {
                FileNode temp = (root.left != null) ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                FileNode temp = minValueNode(root.right);
                root.fileName = temp.fileName;
                root.right = delete(root.right, temp.fileName);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    FileNode search(FileNode root, String name) {
        if (root == null || root.fileName.equals(name))
            return root;

        if (name.compareTo(root.fileName) < 0)
            return search(root.left, name);

        return search(root.right, name);
    }

    void inorder(FileNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.fileName);
            inorder(root.right);
        }
    }
}

public class AVLTreeDemo {
    public static void main(String[] args) {
        
    }
}
