package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Home {
    // Login form stuff hehe
    private JLabel welcome;
    private JTextField usernameField;
    private JLabel username;
    private JPasswordField passwordField;
    private JButton login;
    private JLabel password;
    private Controller controller;

    // The main window. just one. pls.
    JFrame frame = new JFrame();

    /**
     * Constructs the main Home window with a login form on top
     * and menu navigation buttons below.
     *
     * @param title  window title
     * @param width  window width
     * @param height window height
     */
    public Home(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        controller = new Controller();

        // LOGIN FORM PANEL
        // everything stacked real nice vertically hehe
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // gotta welcome em you know
        welcome = new JLabel("Welcome to COMICON!");
        welcome.setFont(welcome.getFont().deriveFont(Font.BOLD, 28f));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(welcome);
        formPanel.add(Box.createVerticalStrut(25));

        // put ur username here
        JPanel usernameRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        username = new JLabel("Username:");
        usernameField = new JTextField(15);
        usernameRow.add(username);
        usernameRow.add(usernameField);
        formPanel.add(usernameRow);

        // secret password time. no peeking hehehe
        JPanel passwordRow = new JPanel(new FlowLayout(FlowLayout.CENTER));
        password = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        passwordRow.add(password);
        passwordRow.add(passwordField);
        formPanel.add(passwordRow);

        // login and sign up. dynamic duo.
        JPanel loginRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        login = new JButton("Login");
        login.setPreferredSize(new Dimension(150, 40));
        loginRow.add(login);

        JButton signUp = new JButton("Sign Up");
        signUp.addActionListener(e -> new SignupPanel("Sign Up", 500, 400));
        loginRow.add(signUp);
        formPanel.add(loginRow);
        formPanel.add(Box.createVerticalStrut(15));

        // just a line. separating stuff. very important.
        formPanel.add(new JSeparator());
        formPanel.add(Box.createVerticalStrut(15));

        // MENU NAVIGATION BUTTONS
        // two buttons. two adventures. choose wisely.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        // evento stuff. for events n things.
        JButton eventoMenu = new JButton("Evento Menu");
        eventoMenu.setPreferredSize(new Dimension(150, 60));
        eventoMenu.addActionListener(e -> new EventoPanel("Eventi", 500, 400));

        // admin stuff. not ready yet hehe
        JButton adminMenu = new JButton("Admin Menu");
        adminMenu.setPreferredSize(new Dimension(150, 60));

        buttonPanel.add(eventoMenu);
        buttonPanel.add(adminMenu);
        formPanel.add(buttonPanel);

        // ok put it all together now
        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.add(formPanel, BorderLayout.CENTER);

        frame.add(rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
