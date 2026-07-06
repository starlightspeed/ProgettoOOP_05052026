package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Home {
    private JPanel mainPanel;
    private JLabel welcome;
    private JTextField usernameField;
    private JLabel username;
    private JPasswordField passwordField;
    private JButton login;
    private JLabel password;
    private JButton SignUp;
    private static JFrame frameHome;
    private Controller controller;

    public static void main(String[] args) {
        frameHome = new JFrame("Home");
        frameHome.setContentPane(new Home().mainPanel);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.pack();
        frameHome.setVisible(true);




    }

    public Home() {
        controller = new Controller();
        // Add action listeners or other initialization code here

    }


    /*private void createUIComponents() {
        // TODO: place custom component creation code here
        welcome.setFont(welcome.getFont().deriveFont(Font.BOLD, 28f));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
    }*/
}
