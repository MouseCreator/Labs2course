package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeueArrayTest {

    @Test
    void pushQ() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.PushBack(2).
                PushBack(3).
                PushBack(4);
        assertEquals(deque.toString(), "[ 4 3 2 ]");
    }

    @Test
    void pushS() throws OversizeException {
        DequeueArray<Integer> deque = new DequeueArray<>(2);
        deque.pushFront(2).pushFront(3).pushFront(4);
        assertEquals(deque.toString(), "[ 2 3 4 ]");
    }

}