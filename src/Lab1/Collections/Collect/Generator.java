package Lab1.Collections.Collect;

import Lab1.Collections.Geometry.Circle;
import Lab1.Collections.Geometry.GenLine;

import java.util.Random;
import java.util.Vector;

public class Generator {
    public static Random random = new Random();
    public static int getInt() {
        return random.nextInt(256);
    }
    public static double getDouble() {
        return random.nextDouble(256.0);
    }
    public static GenLine getLine() {
        return new GenLine(getDouble(), getDouble(), getDouble());
    }
    public static Circle getCircle() {
        return new Circle(getDouble(),getDouble(), getDouble());
    }
    public static String getString() {
        String str = "";
        str += random.nextInt();
        return str;
    }
    public static Vector<Integer> getVector() {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(Generator.getInt());
        }
        return vector;
    }
    public static void fillInt(Stack<Integer> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getInt());
        }
    }
    public static void fillInt(Queue<Integer> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getInt());
        }
    }
    public static void fillDouble(Stack<Double> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getDouble());
        }
    }
    public static void fillDouble(Queue<Double> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getDouble());
        }
    }
    public static void fillString(Stack<String> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getString());
        }
    }
    public static void fillString(Queue<String> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getString());
        }
    }
    public static void fillVector(Stack<Vector<Integer>> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getVector());
        }
    }
    public static void fillVector(Queue<Vector<Integer>> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getVector());
        }
    }
    public static void fillLine(Stack<GenLine> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getLine());
        }
    }
    public static void fillLine(Queue<GenLine> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getLine());
        }
    }
    public static void fillCircle(Stack<Circle> stack, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            stack.pushFront(getCircle());
        }
    }
    public static void fillCircle(Queue<Circle> queue, final int elements) throws OversizeException {
        for (int i = 0; i < elements; i++) {
            queue.pushBack(getCircle());
        }
    }
}
