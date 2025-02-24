package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame finestra = new JFrame("Exemple Swing");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JTextField campText = new JTextField(15);
        panel.add(campText);

        JLabel etiqueta = new JLabel("Texxto de l'etiqueta");
        panel.add(etiqueta);

        JButton boto = new JButton("Prem-me");
        panel.add(boto);

        boto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText(campText.getText());
            }
        });

        finestra.add(panel);
        finestra.setVisible(true);
    }
}