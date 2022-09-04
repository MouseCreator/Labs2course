package Lab1.main;
import Lab1.Collections.ArrayCollections.QueueArray;
import Lab1.Collections.ArrayCollections.StackArray;
import Lab1.Collections.ListCollections.DequeueList;

public class Program {


    public static void main(String[] args) {
        QueueArray<Integer> ints = new QueueArray<>(3);

        ints.pushQ(0);
        System.out.println(ints.getSize());
        ints.pushQ(1);
        System.out.println(ints.getSize());
        ints.pushQ(2);
        System.out.println(ints.getSize());


        ints.popQ();
        System.out.println(ints.getSize());

        ints.pushQ(3);
        ints.popQ();
        System.out.println(ints.getSize());

        System.out.println(ints.toString());

    }
}
