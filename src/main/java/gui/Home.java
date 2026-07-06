package gui;

import javax.swing.*;
import java.awt.*;

public class Home {
    // Main application window
    JFrame frame = new JFrame();
    // CardLayout switches between panels (home, utente, etc.)
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);

    public Home(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        // Building the home screen with title, subtitle, and three menu buttons
        // nested the Layout Manager with BorderLayout as the main then BoxLayout as the Center then FlowLayout in the South
        // its wierd just check the java documentation, it's hard to explain
        JPanel homePanel = new JPanel(new BorderLayout());

        // Center BoxLayout
        JLabel titleLabel = new JLabel("Comicon Main Menu!");
        JLabel subtitleLabel = new JLabel("Seleziona le opzione");
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(titleLabel);
        centerPanel.add(subtitleLabel);
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 40f));
        subtitleLabel.setFont(subtitleLabel.getFont().deriveFont(Font.BOLD, 15f));
        homePanel.add(centerPanel, BorderLayout.CENTER);

        // South FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton utenteMenu = new JButton("Utente Menu");
        JButton eventoMenu = new JButton("Evento Menu");
        JButton adminMenu = new JButton("Admin Menu");
        utenteMenu.setPreferredSize(new Dimension(150, 60));
        eventoMenu.setPreferredSize(new Dimension(150, 60));
        adminMenu.setPreferredSize(new Dimension(150, 60));
        buttonPanel.add(utenteMenu);
        buttonPanel.add(eventoMenu);
        buttonPanel.add(adminMenu);
        homePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Utente panel, callback restores the window title when navigating back
        UtentePanel utentePanel = new UtentePanel(() -> {
            frame.setTitle(title);
            cardLayout.show(cardPanel, "home");
        });

        // Register panels with the card layout so they can be swapped by name
        cardPanel.add(homePanel, "home");
        cardPanel.add(utentePanel, "utente");
        frame.add(cardPanel, BorderLayout.CENTER);

        // Clicking "Utente Menu" updates the window title and switches to the utente panel
        utenteMenu.addActionListener(e -> {
            frame.setTitle("Utente Menu");
            cardLayout.show(cardPanel, "utente");
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
