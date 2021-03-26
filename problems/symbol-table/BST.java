public class BST <Key extends Comparable<Key> , Value> {
    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node temp = floor(node.right, key);
        if (temp != null) {
            return temp;
        } else {
            return node;
        }
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.count;
    }

    public Value get(Key key) {
        Node ptr = root;
        while (ptr != null) {
            int cmp = key.compareTo(ptr.key);
            if (cmp < 0) {
                ptr = ptr.left;
            } else if (cmp > 0) {
                ptr = ptr.right;
            } else {
                return ptr.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void deleteMin() {
        if (root == null) {
            return;
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Key largest(Node node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }

    public Key largest() {
        return largest(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(4, "abcd");
        System.out.println(tree.get(4));
        System.out.println(tree.size());
    }

}
