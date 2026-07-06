package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UtentePanel extends JPanel {
    // Separately compiled panel, takes a callback so Home controls navigation
    public UtentePanel(Runnable onBack) {
        setLayout(new BorderLayout());

        // Login form — each row wraps a label (left) and a text field (stretches)
        JPanel formPanel = new JPanel(new GridLayout(2, 1));

        JPanel loginRow = new JPanel(new BorderLayout());
        loginRow.add(new JLabel("Login: "), BorderLayout.WEST);
        loginRow.add(new JTextField(), BorderLayout.CENTER);
        formPanel.add(loginRow);

        JPanel passwordRow = new JPanel(new BorderLayout());
        passwordRow.add(new JLabel("Password: "), BorderLayout.WEST);
        passwordRow.add(new JPasswordField(), BorderLayout.CENTER);
        formPanel.add(passwordRow);

        add(formPanel, BorderLayout.CENTER);

        // Bottom row: login (left) / back button (centered) / sign up (right)
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Login button on the left
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(150, 60));
        JPanel loginWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginWrapper.add(loginButton);
        bottomPanel.add(loginWrapper, BorderLayout.WEST);
        loginButton.addActionListener(e -> new AccountPanel("Account", 500, 400));

        // Centered back button
        JButton backButton = new JButton("Back to Home");
        backButton.setPreferredSize(new Dimension(280, 60));
        JPanel backWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backWrapper.add(backButton);
        bottomPanel.add(backWrapper, BorderLayout.CENTER);
        backButton.addActionListener(e -> onBack.run());

        // Clickable sign up button, opens the registration window
        JLabel signUp = new JLabel("Sign Up");
        signUp.setForeground(Color.BLUE.darker());
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new SignupPanel("Sign Up", 500, 400);
            }
        });
        JPanel signUpWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        signUpWrapper.add(signUp);
        bottomPanel.add(signUpWrapper, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
