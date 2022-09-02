package Lab1.Collections;

import java.util.Random;

public class Generator {
    static Random random= new Random();
    public static int getInt() {
        return random.nextInt(256);
    }
    public  static  int getInt(int from, int to) {
        return random.nextInt(from, to);
    }
}
