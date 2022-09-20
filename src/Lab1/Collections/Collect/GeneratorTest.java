package Lab1.Collections.Collect;

import Lab1.Collections.Collect.ArrayCollections.StackArray;
import Lab1.Collections.Collect.ListCollections.QueueList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    void fillDoubleTest() throws OversizeException {
        Stack<Double> stack = new StackArray<>();
        Queue<Double> queue = new QueueList<>();
        final int toGenerate = 10;
        Generator.fillDouble(stack, toGenerate);
        Generator.fillDouble(queue, toGenerate);

        assertEquals(toGenerate, stack.getSize());
        assertEquals(toGenerate, queue.getSize());
    }

}