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

            JPanel titlePanel = new JPanel();

            // big title so u know what ur signing up for
            JLabel titleLabel = new JLabel("Create Account");
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            titleLabel.setFont(titleLabel.getFont().deriveFont(28f));
            titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            frame.add(titleLabel, BorderLayout.NORTH);
            titlePanel.add(Box.createVerticalStrut(25));


            JPanel formPanel = new JPanel();
            formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
            Dimension labelSize = new Dimension(80, 25);


            // the form. fill it out. or else hehe
            JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0));
            JLabel email = new JLabel("Email: ");
            email.setPreferredSize(labelSize);
            email.setHorizontalAlignment(SwingConstants.RIGHT);
            JTextField emailField = new JTextField(15);
            emailPanel.add(email);
            emailPanel.add(emailField);
            formPanel.add(emailPanel);
            formPanel.add(Box.createVerticalStrut(10));

            JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0));
            JLabel password = new JLabel("Password: ");
            password.setPreferredSize(labelSize);
            password.setHorizontalAlignment(SwingConstants.RIGHT);
            JPasswordField passwordField = new JPasswordField(15);
            passwordPanel.add(password);
            passwordPanel.add(passwordField);
            formPanel.add(passwordPanel);
            formPanel.add(Box.createVerticalStrut(10));

            JPanel tipoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0));
            JLabel tipo = new JLabel("Tipo: ");
            tipo.setPreferredSize(labelSize);
            tipo.setHorizontalAlignment(SwingConstants.RIGHT);
            JComboBox<String> tipoCombo = new JComboBox<>(new String[]{"Lavoratore", "Ospite", "Visitatore"});
            tipoCombo.setPreferredSize(new Dimension(168, 25));
            tipoPanel.add(tipo);
            tipoPanel.add(tipoCombo);
            formPanel.add(tipoPanel);
            formPanel.add(Box.createVerticalStrut(10));

            JPanel subComboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0));
            JLabel subLabel = new JLabel("Mansione: ");
            subLabel.setPreferredSize(labelSize);
            subLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            JComboBox<String> subCombo = new JComboBox<>();
            subCombo.setPreferredSize(new Dimension(168, 25));

            // start with lavoratore. most ppl r workers amirite
            for (Mansione m : Mansione.values()) subCombo.addItem(m.name());

            subComboPanel.add(subLabel);
            subComboPanel.add(subCombo);
            formPanel.add(subComboPanel);

            // tipo changed? gotta update the sub thingy too
            tipoCombo.addItemListener(e -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selected = (String) e.getItem();
                    subCombo.removeAllItems();
                    switch (selected) {
                        case "Lavoratore":
                            subLabel.setText("Mansione: ");
                            for (Mansione m : Mansione.values()) subCombo.addItem(m.name());
                            break;
                        case "Ospite":
                            subLabel.setText("Ruolo: ");
                            for (Ruolo r : Ruolo.values()) subCombo.addItem(r.name());
                            break;
                        case "Visitatore":
                            subLabel.setText("Biglietto: ");
                            for (Biglietto b : Biglietto.values()) subCombo.addItem(b.name());
                            break;
                    }
                }
            });

            formPanel.add(Box.createVerticalStrut(20));

            // the big button. not red but still important
            JButton registerButton = new JButton("Register");
            registerButton.setPreferredSize(new Dimension(150, 40));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(registerButton);

            formPanel.add(buttonPanel);

            registerButton.addActionListener(e -> {
                String email2 = emailField.getText().trim();
                String password2 = new String(passwordField.getPassword()).trim();
                String tipo2 = (String) tipoCombo.getSelectedItem();
                String sottoTipo = (String) subCombo.getSelectedItem();

                // TODO: actually register the user lol
            });

            JPanel centerWrapper = new JPanel(new GridBagLayout());
            centerWrapper.add(formPanel);
            frame.add(centerWrapper, BorderLayout.CENTER);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        // TODO: still gotta do the registration thing
    }
