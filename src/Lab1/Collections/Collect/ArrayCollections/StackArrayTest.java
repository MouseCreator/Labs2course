package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.Generator;
import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {
    private StackArray<Integer> stack;

    private int[] ints;
    @BeforeEach
    void init() {
        stack = new StackArray<>();
        ints = new int[3];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
    }
    void pushInts() {
        for (int i : ints) {
            stack.pushFront(i);
        }
    }
    void reverseInputArray() {
        Collections.reverse(Arrays.asList(ints));
    }
    @Test
    void pushFrontTest() {
        pushInts();
        reverseInputArray();
        assertEquals(Arrays.toString(ints), stack.toString());

        assertThrows(OversizeException.class, ()-> {
            while (true) {
                Generator.fillInt(stack, 100);
            }
        });
    }
    @Test
    void popFrontTest() {
        pushInts();
        reverseInputArray();
        assertThrows(EmptyException.class, ()-> {
            int i = 0;
            while (stack.getLimit() < stack.ABSOLUTE_ELEMENT_LIMIT) {
                assertEquals(ints[i], stack.popFront());
                i++;
            }
        });

    }
}