package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeueArrayTest {

    @Test
    void pushQ() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushQ(2).
                pushQ(3).
                pushQ(4);
        assertEquals(deque.toString(), "[ 4 3 2 ]");
    }

    @Test
    void pushS() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushS(2).pushS(3).pushS(4);
        assertEquals(deque.toString(), "[ 2 3 4 ]");
    }

}