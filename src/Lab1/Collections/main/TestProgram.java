package Lab1.Collections.main;

import Lab1.Collections.Collect.ListCollections.StackList;

public class TestProgram {
    public static void main(String[] args) {
        StackList<Integer> list = new StackList();
        list.pushFront(0);
        list.toString();
    }

}
