package Lab1.Collections.Collect;

import Lab1.Collections.Collect.ArrayCollections.QueueArray;
import Lab1.Collections.Collect.ArrayCollections.StackArray;
import Lab1.Collections.Collect.LibraryCollections.LibraryQueue;
import Lab1.Collections.Collect.LibraryCollections.LibraryStack;
import Lab1.Collections.Collect.ListCollections.QueueList;
import Lab1.Collections.Collect.ListCollections.StackList;
import Lab1.Collections.Geometry.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    void fillDoubleTest() {
        Stack<Double> stack = new StackArray<>();
        Queue<Double> queue = new QueueArray<>();
        final int toGenerate = 10;
        Generator.fillDouble(stack, toGenerate);
        Generator.fillDouble(queue, toGenerate);

        assertEquals(toGenerate, stack.getSize());
        assertEquals(toGenerate, queue.getSize());
    }
    @Test
    void fillCircleTest() {
        Stack<Circle> stack = new StackList<>();
        Queue<Circle> queue = new QueueList<>();
        final int toGenerate = 40;
        Generator.fillCircle(stack, toGenerate);
        Generator.fillCircle(queue, toGenerate);

        assertEquals(toGenerate, stack.getSize());
        assertEquals(toGenerate, queue.getSize());
    }
    @Test
    void fillStringTest()  {
        Stack<Circle> stack = new LibraryStack<>();
        Queue<Circle> queue = new LibraryQueue<>(150);
        final int toGenerate = 150;
        Generator.fillCircle(stack, toGenerate);
        Generator.fillCircle(queue, toGenerate);

        assertEquals(toGenerate, stack.getSize());
        assertEquals(toGenerate, queue.getSize());

        assertThrows(OversizeException.class, ()-> Generator.fillCircle(queue, 1));
    }

}