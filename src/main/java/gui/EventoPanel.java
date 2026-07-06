package gui;

import javax.swing.*;
import java.awt.*;

/**
 * evento window. placeholder vibes hehe
 */
public class EventoPanel {
    JFrame frame = new JFrame();

    public EventoPanel(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        // big texto say evento. very creative i know
        JLabel label = new JLabel("Evento Panel");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(28f));
        frame.add(label, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
