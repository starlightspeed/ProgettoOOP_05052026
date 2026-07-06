package gui;

import javax.swing.*;
import java.awt.*;

public class UtentePanel extends JPanel {
    public UtentePanel(Runnable onBack) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Utente Menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(28f));
        add(title, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Home");
        backButton.setPreferredSize(new Dimension(150, 60));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> onBack.run());
    }
}
