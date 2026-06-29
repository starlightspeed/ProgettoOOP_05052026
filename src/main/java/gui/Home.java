package gui;

import model.Mansione;
import model.Ruolo;

import javax.swing.*;
import java.awt.*;

public class Home {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Welcome to the Comicon!");
    JPanel panel = new JPanel();
    JButton button = new JButton("Add");
    JComboBox<Ruolo> comboBox = new JComboBox<Ruolo>(Ruolo.values());
    JComboBox<Mansione> comboBox2 = new JComboBox<Mansione>(Mansione.values());
    JComboBox<Ruolo> comboBox3 = new JComboBox<Ruolo>(Ruolo.values());


    public Home (String title, int width, int height) {
            frame.setTitle(title);
            frame.setSize(width, height);

            // Sets the Layout Manager (chosen layout: FlowLayout)
            frame.setLayout(new FlowLayout(FlowLayout.CENTER));
            label.setHorizontalAlignment(SwingConstants.CENTER);

            // Puts the JLabel title
            frame.add(label, BorderLayout.NORTH);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            label.setFont(label.getFont().deriveFont(28f));

            // Puts the something Button
            button.setPreferredSize(new Dimension(150, 60));
            panel.add(button);

            //shows the enum Biglietto
            comboBox.setPreferredSize(new Dimension(120, 30));
            panel.add(comboBox);

            //shows the enum Mansione
            comboBox2.setPreferredSize(new Dimension(120, 30));
            panel.add(comboBox2);

            //shows the enum Ruolo
            comboBox3.setPreferredSize(new Dimension(120, 30));
            panel.add(comboBox3);

            frame.add(panel, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
