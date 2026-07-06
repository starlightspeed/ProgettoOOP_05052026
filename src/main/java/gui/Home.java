package gui;

import javax.swing.*;
import java.awt.*;

public class Home {
    JFrame frame = new JFrame();
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(cardLayout);

    public Home(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        // Home panel
        JPanel homePanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Comicon Main Menu!");
        JLabel subtitleLabel = new JLabel("Seleziona le opzione");
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(titleLabel);
        centerPanel.add(subtitleLabel);
        titleLabel.setFont(titleLabel.getFont().deriveFont(28f));
        homePanel.add(centerPanel, BorderLayout.CENTER);

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

        // Utente panel (separate file)
        UtentePanel utentePanel = new UtentePanel(() -> cardLayout.show(cardPanel, "home"));

        // Card panel
        cardPanel.add(homePanel, "home");
        cardPanel.add(utentePanel, "utente");
        frame.add(cardPanel, BorderLayout.CENTER);

        // Navigation
        utenteMenu.addActionListener(e -> cardLayout.show(cardPanel, "utente"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
