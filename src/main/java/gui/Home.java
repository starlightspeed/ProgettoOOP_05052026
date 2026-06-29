package gui;

import javax.swing.*;

public class Home {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    public Home (String title, int width, int height) {
            frame.setTitle(title);
            frame.setSize(width, height);



            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }

    /*
    public Home() {
        controller = new Controller();
        // Add action listeners or other initialization code here

    }
    */
