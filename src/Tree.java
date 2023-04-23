import java.util.*;
import java.util.function.Consumer;

//import static sun.net.www.http.KeepAliveCache.result;

public class Tree {
    public void getChildrenCount() {
        return;
    }

    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;// первое значение 7

    public void add(int value) {
        // затем вставляем value = 3
        root = appendNode(root, value);

    }

    private Node appendNode(Node current, int value) {
        if (current == null) {
            return new Node(value);// вставится здесь 3
        }
        if (current.value > value) {
            current.left = appendNode(current.left, value);
        } else if (current.value < value) {
            current.right = appendNode(current.right, value);
        }
        return current;
    }

    public boolean contains(int value) {
        return findNode(root, value) != null;
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value > value) {
            return findNode(current.left, value);
        } else if (current.value < value) {
            return findNode(current.right, value);

        }
        return current;
    }

    public void remove(int value) {
        root = removeNode(root, value);

    }

    private Node removeNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (current.value > value) {
            current.left = removeNode(current.left, value);
            return current;
        } else if (current.value < value) {
            current.right = removeNode(current.right, value);
            return current;
        }
        //если совпало с текущим узлом надо удалить текущий узел
        //3 случая
        // 1 Нет дочерних узлов
        if (current.left == null && current.right == null) {
            return null;
        }
        // 2 Есть только 1 дочерний узел
        if (current.left == null) {//&& current.right!=null
            return current.right;
        }
        if (current.left != null) {//&& current.right==null
            return current.left;
        }
        //3 естьоба дочерних узла
        //Нужно найти минимальный элемент в правом поддереве
        Node smallestNodeOnTheRight = findFirst((current.right));
        int smallestValueOnTheRight = smallestNodeOnTheRight.value;
        //Вставить его значение в текущий узел
        current.value = smallestValueOnTheRight;
        // И удалить этот найденный минимальный узел
        current.right = removeNode(current.right, smallestValueOnTheRight);
        return current;
    }

    public int findFirst() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findFirst(root).value;
    }

    private Node findFirst(Node current) {
        if (current.left != null) {
            return findFirst(current.left);
        }
        return current;
    }

    public static int getChildrenCount(Node node) {
        if (node == null) {
            return 0;
        }
        // if left and right of the node is null
        // it is leaf node
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getChildrenCount(node.left) + getChildrenCount(node.right);
        }
    }


    public int findLast() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return findLast(root).value;
    }

    private Node findLast(Node current) {
        if (current.right != null) {
            return findLast(current.right);
        }
        return current;
    }
}
