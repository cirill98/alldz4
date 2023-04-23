//Реализовать поиск максимального элемента в дереве. Метод назвать findLast
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class Main {


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(17);
        tree.add(3);
        tree.add(9);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(15);

        System.out.println("Минимальное значение значение");
        System.out.println(tree.findFirst());
        System.out.println("Максимальное значение");
        System.out.println(tree.findLast());

        tree.getChildrenCount();


        int leafNodes = tree.getChildrenCount(tree.root);
        System.out.println("Количество листьев = " + leafNodes);

    }

}