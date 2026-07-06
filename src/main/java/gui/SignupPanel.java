package gui;

import model.Biglietto;
import model.Mansione;
import model.Ruolo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class SignupPanel {
    JFrame frame = new JFrame();

    public SignupPanel(String title, int width, int height) {
        frame.setTitle(title);
        frame.setSize(width, height);

        // big title so u know what ur signing up for
        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(28f));
        frame.add(titleLabel, BorderLayout.NORTH);

        // the form. fill it out. or else hehe
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 5));

        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> tipoCombo = new JComboBox<>(new String[]{"Lavoratore", "Ospite", "Visitatore"});
        JLabel subLabel = new JLabel("Mansione:");
        JComboBox<String> subCombo = new JComboBox<>();

        // start with lavoratore. most ppl r workers amirite
        for (Mansione m : Mansione.values()) subCombo.addItem(m.name());

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(tipoCombo);
        formPanel.add(subLabel);
        formPanel.add(subCombo);

        frame.add(formPanel, BorderLayout.CENTER);

        // tipo changed? gotta update the sub thingy too
        tipoCombo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selected = (String) e.getItem();
                subCombo.removeAllItems();
                switch (selected) {
                    case "Lavoratore":
                        subLabel.setText("Mansione:");
                        for (Mansione m : Mansione.values()) subCombo.addItem(m.name());
                        break;
                    case "Ospite":
                        subLabel.setText("Ruolo:");
                        for (Ruolo r : Ruolo.values()) subCombo.addItem(r.name());
                        break;
                    case "Visitatore":
                        subLabel.setText("Biglietto:");
                        for (Biglietto b : Biglietto.values()) subCombo.addItem(b.name());
                        break;
                }
            }
        });

        // the big button. not red but still important
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(150, 60));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String tipo = (String) tipoCombo.getSelectedItem();
            String sottoTipo = (String) subCombo.getSelectedItem();

            // TODO: actually register the user lol
        });

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // TODO: still gotta do the registration thing
}
