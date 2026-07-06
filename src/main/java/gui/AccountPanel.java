package gui;

import javax.swing.*;
import java.awt.*;

public class AccountPanel {
    // account stuff. empty for now hehe
    JFrame frame = new JFrame();

    public AccountPanel(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        // placeholder. looks cool tho
        JLabel label = new JLabel("Account Panel");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(28f));
        frame.add(label, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
