package Lab1.Collections.Visual;

import javax.swing.*;

public class LaunchPage {

    private final int BOUNDS = 2000;

    JFrame frame;
    Grid grid;
    Drawable[] figures;
    public LaunchPage(){
        JFrame frame = new JFrame();
        grid = new Grid();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Coordinate grid");
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(grid);

    }
}
