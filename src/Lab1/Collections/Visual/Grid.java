package Lab1.Collections.Visual;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel{
    private int BOUNDS = 5000;

    public Grid() {
        super();
        this.setBackground(Color.white);
        this.setBounds(-BOUNDS/2, -BOUNDS/2, BOUNDS, BOUNDS);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, BOUNDS, 0, -BOUNDS);
    }
}
