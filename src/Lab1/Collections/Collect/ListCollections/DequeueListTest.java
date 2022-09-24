package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.EmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DequeueListTest {
    private DequeueList<String> dequeue;
    private String[] strings = new String[4];
    @BeforeEach
    void initDequeue() {
        dequeue = new DequeueList<>();
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "String" + i;
        }
    }
    void pushStrings() {
        dequeue.pushFront(strings[1]);
        dequeue.pushFront(strings[0]);
        dequeue.pushBack(strings[2]);
        dequeue.pushBack(strings[3]);
    }
    @Test
    void push() {
        pushStrings();
        assertEquals(strings[1], dequeue.peekFront());
        assertEquals(strings[3], dequeue.peekBack());
        assertEquals(Arrays.toString(strings), dequeue.toString());
    }

    void popBack() {
        dequeue.popBack();
        strings = Arrays.copyOf(strings, strings.length-1);
        assertEquals(Arrays.toString(strings), dequeue.toString());
    }
    void popFront() {
        dequeue.popFront();
        strings = Arrays.copyOfRange(strings,1, strings.length);
        assertEquals(Arrays.toString(strings), dequeue.toString());
    }

    @Test
    void pop() {
        pushStrings();

        popFront();
        popBack();
        popBack();
        popFront();

        assertTrue(dequeue.isEmpty());

        assertThrows(EmptyException.class, dequeue::popBack);
        assertThrows(EmptyException.class, dequeue::popFront);
    }

}