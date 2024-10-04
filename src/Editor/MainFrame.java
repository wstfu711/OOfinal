package Editor;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static int WIDTH = 1500;
    private static int HEIGHT = 1000;

    public MainFrame(){
        setTitle("UML Editor");
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        //set other need on the window
        add(new MenuBar(), BorderLayout.NORTH);
        add(new ToolBar(), BorderLayout.WEST);
        add(Canva.getInstance());
    }
}
