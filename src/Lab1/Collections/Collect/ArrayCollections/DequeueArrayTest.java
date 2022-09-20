package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeueArrayTest {

    @Test
    void pushQ() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushBack(2).
                pushBack(3).
                pushBack(4);
        assertEquals(deque.toString(), "[ 4 3 2 ]");
    }

    @Test
    void pushS() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushFront(2).pushFront(3).pushFront(4);
        assertEquals(deque.toString(), "[ 2 3 4 ]");
    }

    @Test
    void popTest() throws OversizeException, EmptyException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushFront(2).pushFront(3).pushFront(4);
        assertEquals(2, deque.popBack());
        assertEquals(4, deque.popFront());
        assertEquals(3, deque.popFront());
        assertThrows(EmptyException.class, ()-> {
            double d =deque.popFront();
        });
    }

}