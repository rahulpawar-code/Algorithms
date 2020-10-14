/*
 * https://www.techiedelight.com/deletion-from-bst/
 */

import java.util.Random;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int k) {
        key = k;
        left = null;
        right = null;
    }
}

class BST {
    private Node head;

    public BST() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private int heightRec(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    public int height() {
        return heightRec(head);
    }

    private Node insertRec(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    public void insert(int key) {
        head = insertRec(head, key);
    }

    public void insertIterative(int key) {
        if (head == null) {
            head = new Node(key);
            return;
        }

        Node parent = null;
        Node current = head;

        while (current != null) {
            parent = current;

            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public void inorder() {
        inorder(head);
        if (head != null) {
            System.out.println("");
        }
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.key < min || max < node.key) {
            return false;
        }

        return isBST(node.left, min, node.key) &&
                isBST(node.right, node.key, max);
    }

    public boolean isBST() {
        return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Node minimumKey(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

   private void deleteIterative(Node node, int key) {
        if (head == null) {
            return;
        }

        Node parent = null;
        Node current = head;

        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return;
        }

        // No child
        if (current.left == null && current.right == null) {
            if (current != head) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                head = null;
            }
        } else if (current.left != null && current.right != null) {
            // 2 child
            Node successor = minimumKey(current.right);

            int val = successor.key;
            deleteIterative(current, val);
            current.key = val;
        } else {
            // 1 child
            Node temp = (current.left != null) ? current.left : current.right;

            if (current != head) {
                if (parent.left == current) {
                    parent.left = temp;
                } else {
                    parent.right = temp;
                }
            } else {
                head = temp;
            }
        }
    }

    public void deleteIterative(int key) {
        deleteIterative(head, key);
    }

    private Node deleteRecursive(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left != null && node.right != null) {
                Node successor = minimumKey(node.right);
                node.key = successor.key;
                node.right = deleteRecursive(node.right, successor.key);
            } else {
                Node child = node.left != null ? node.left : node.right;
                node = child;
            }
        }
        return node;
    }

    public void deleteRecursive(int key) {
        head = deleteRecursive(head, key);
    }
}


class Driver {
    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static int[] generateArray(int max, int num) {
        int[] array = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; ++i) {
            array[i] = random.nextInt(max) + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int max = 100;
        int num = 15;
        int[] array = generateArray(max, num);
        Driver.printArray(array);
        System.out.println("");
        BST tree1 = new BST();
        for (int a : array) {
            tree1.insert(a);
        }
        System.out.println("height : " + tree1.height());
        tree1.inorder();
        System.out.println("Deleting : " + array[array.length - 2]);
        tree1.deleteIterative(array[array.length - 2]);
        tree1.inorder();
        System.out.println("is BST : " + tree1.isBST());


        System.out.println("==============================================");
        int[] array2 = generateArray(2 * max, num + 10);
        Driver.printArray(array2);

        System.out.println("");
        BST tree2 = new BST();
        for (int a : array2) {
            tree2.insertIterative(a);
        }
        System.out.println("height : " + tree2.height());
        tree2.inorder();
        System.out.println("Deleting : " + array2[array2.length - 2]);
        tree2.deleteIterative(array2[array2.length - 2]);
        tree2.inorder();
        System.out.println("is BST : " + tree2.isBST());
    }
}
