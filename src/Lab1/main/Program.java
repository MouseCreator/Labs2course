package Lab1.main;
import Lab1.Collections.IntCollections.DequeueList;
import Lab1.Collections.IntCollections.StackList;

public class Program {


    public static void main(String[] args) {
        DequeueList<Integer> ints = new DequeueList<>();
        ints.pushS(1);
        ints.pushQ(0);
        ints.pushS(2);
        System.out.println(ints.peekQ());
        System.out.println(ints.peekS());
    }
}
