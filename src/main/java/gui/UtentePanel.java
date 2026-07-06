package gui;

import javax.swing.*;
import java.awt.*;

public class UtentePanel extends JPanel {
    // its a panel. calls home when u press back. neat.
    public UtentePanel(Runnable onBack) {
        setLayout(new BorderLayout());

        // login form. label left, text right. classic.
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

        // bottom row. two buttons. one goes forward one goes back.
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // login button. opens account panel. exciting.
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(150, 60));
        JPanel loginWrapper = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        loginWrapper.add(loginButton);
        bottomPanel.add(loginWrapper, BorderLayout.WEST);
        loginButton.addActionListener(e -> new AccountPanel("Account", 500, 400));

        // go back home. where the heart is hehe
        JButton backButton = new JButton("Back to Home");
        backButton.setPreferredSize(new Dimension(280, 60));
        JPanel backWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backWrapper.add(backButton);
        bottomPanel.add(backWrapper, BorderLayout.CENTER);
        backButton.addActionListener(e -> onBack.run());

        add(bottomPanel, BorderLayout.SOUTH);
    }
}
