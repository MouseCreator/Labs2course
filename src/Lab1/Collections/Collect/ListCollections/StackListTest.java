package Lab1.Collections.Collect.ListCollections;
import Lab1.Collections.Collect.ListCollections.StackList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StackListTest {

    @Test
    void pushS() {
        StackList<Integer> stack = new StackList<>();
        stack.pushS(5);
        stack.pushS(4);
        stack.pushS(3);
        stack.pushS(2);
        stack.pushS(1);
        stack.pushS(0);
        assertEquals("[ 0 1 2 3 4 5 ]", stack.toString());
    }

    @Test
    void popS() {
        double[] source = {0.12, 0.44};
        StackList<Double> stack = StackList.fromDouble(source);

        double temp = stack.popS();
        assertEquals(source[0], temp, 0.0001);

        temp = stack.popS();
        assertEquals(source[1], temp, 0.0001);

        boolean hadException = false;

        try {
            stack.popS();
        }
        catch (NullPointerException e) {
            hadException = true;
        }
        assertEquals(true, hadException);
    }

}