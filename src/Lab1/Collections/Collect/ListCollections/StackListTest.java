package Lab1.Collections.Collect.ListCollections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StackListTest {

    @Test
    void pushFront() {
        StackList<Integer> stack = new StackList<>();
        stack.pushFront(6);
        stack.pushFront(5);
        stack.pushFront(4);
        stack.pushFront(3);
        stack.pushFront(2);
        stack.pushFront(1);
        stack.pushFront(0);
        assertEquals("[ 0 1 2 3 4 5 6 ]", stack.toString());
    }

    @Test
    void popFront() {
        double[] source = {0.12, 0.44};
        StackList<Double> stack = StackList.fromDouble(source);

        double temp = stack.popFront();
        assertEquals(source[0], temp, 0.0001);

        temp = stack.popFront();
        assertEquals(source[1], temp, 0.0001);


        assertThrows(NullPointerException.class, ()-> {
            double d =stack.popFront();
        });
    }

}