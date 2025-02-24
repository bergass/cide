package com.example;

import javax.swing.*;

import java.awt.*;

import javax.swing.*;

public class ExempleLayout {
    public static void main(String[] args) {
        // Creem la finestra principal (JFrame)
        JFrame finestra = new JFrame("Exemple de LayoutManager");
        finestra.setSize(500, 500);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout()); // Establim BorderLayout per al JFrame

        // Creem un panell superior amb FlowLayout
        JPanel panellSuperior = new JPanel();
        panellSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // Organitza els elements en línia
        panellSuperior.add(new JLabel("File"));
        panellSuperior.add(new JLabel("Options"));
        panellSuperior.add(new JLabel("Help"));

        JPanel panellSuperior1 = new JPanel();
        panellSuperior1.setLayout(new FlowLayout(FlowLayout.LEFT)); // Organitza els elements en línia
        panellSuperior1.add(new JLabel("Proxy"));
        panellSuperior1.add(new JLabel("Cookies"));
        panellSuperior1.add(new JLabel("Accounts"));

        JPanel panellUser = new JPanel();
        panellUser.setLayout(new GridBagLayout()); // Usa GridBagLayout per a més control sobre el disseny
        panellUser.setBorder(BorderFactory.createTitledBorder("New User"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 1); // Espai entre els components
        gbc.anchor = GridBagConstraints.WEST; // Centra els components

        gbc.gridx = 0;
        gbc.gridy = 0;
        panellUser.add(new JLabel("Account name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panellUser.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panellUser.add(new JLabel("Full name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panellUser.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panellUser.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panellUser.add(new JTextField(10), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panellUser.add(new JLabel("Repeat Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panellUser.add(new JTextField(10), gbc);

        JPanel panellContenidor = new JPanel();
        panellContenidor.setLayout(new BoxLayout(panellContenidor, BoxLayout.Y_AXIS));
        panellContenidor.add(panellSuperior);
        panellContenidor.add(new JSeparator(SwingConstants.HORIZONTAL));
        panellContenidor.add(panellSuperior1);
        panellContenidor.add(panellUser);

        // Afegim els panells a la finestra
        finestra.add(panellContenidor, BorderLayout.NORTH);

        
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
       
        // Fem visible la finestra
        finestra.setVisible(true);
    }
}
