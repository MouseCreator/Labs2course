package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.Generator;
import Lab1.Collections.Collect.OversizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        int length = ints.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = ints[length-1-i];
        }
        ints = copy;
    }
    @Test
    void pushFrontTest() {
        pushInts();

        reverseInputArray();
        assertEquals(Arrays.toString(ints), stack.toString());

        assertThrows(OversizeException.class, ()-> {
            while (stack.getLimit() <= stack.ABSOLUTE_ELEMENT_LIMIT) {
                Generator.fillInt(stack, 100);
            }
        });
    }
    @Test
    void popFrontTest() {
        pushInts();
        reverseInputArray();
        for (int anInt : ints) {
            assertEquals(anInt, stack.popFront());
        }
        assertThrows(EmptyException.class, ()-> stack.popFront());

    }
}