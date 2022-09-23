package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.Generator;
import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueArrayTest {

    @Test
    void pushBackTest() throws OversizeException {
        QueueArray<Integer> queue = new QueueArray<>(2);
        queue.pushBack(2);
        queue.toString();
        queue.pushBack(3);
        queue.toString();
        queue.pushBack(4);
        assertEquals(queue.toString(), "[ 2 3 4 ]");
        assertThrows(OversizeException.class, ()-> {
            while (true) {
                queue.pushBack(Generator.getInt());
            }
        });
    }

    @Test
    void popBackTest() throws OversizeException, EmptyException {
        QueueArray<Integer> queue = new QueueArray<>(3);
        queue.pushBack(2).pushBack(3).pushBack(4);
        assertEquals(2, queue.popBack());
        assertEquals(3, queue.popBack());
        assertEquals(4, queue.popBack());
        assertThrows(EmptyException.class, ()-> {
            double d = queue.popBack();
        });
    }
}