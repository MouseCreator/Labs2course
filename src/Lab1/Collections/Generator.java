package Lab1.Collections;

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
}
