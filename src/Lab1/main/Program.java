package Lab1.main;
import Lab1.Collections.IntCollections.StackList;

public class Program {


    public static void main(String[] args) {
        StackList<Integer> ints = new StackList<>();
        ints.push(1);
        ints.push(2);
        ints.push(3);
        int a =ints.pop();
        for (int i = 0; i < a; i++)
            System.out.println(ints.toString());
    }
}
