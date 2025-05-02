package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Editor de fitxers de text");
        finestra.setSize(500, 500);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout()); // Establim BorderLayout per al JFrame

        // Panell superior
        JPanel panellSuperior = new JPanel();
        panellSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // Organitza els elements en línia
        panellSuperior.add(new JLabel("  Nom del fitxer: "));
        panellSuperior.add(new JTextField(33));

        // Panell fitxer (centre)
        JPanel panellFitxer = new JPanel();
        panellFitxer.setLayout(new BorderLayout()); // Ocupa tot l'espai disponible
        panellFitxer.add(new JTextField()); // TextField gran al centre

        // Panell botons
        JPanel panellBotons = new JPanel();
        panellBotons.setLayout(new FlowLayout()); // Organitza els elements en línia
        JButton llegir = new JButton("Llegir");
        JButton escriure = new JButton("Escriure");
        JCheckBox afegir = new JCheckBox("Afegir");
        panellBotons.add(llegir);
        panellBotons.add(escriure);
        panellBotons.add(afegir);

        // Panell inferior amb separador i botons
        JPanel panellInferior = new JPanel();
        panellInferior.setLayout(new BorderLayout());
        panellInferior.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.NORTH); // Separador horitzontal
        panellInferior.add(panellBotons, BorderLayout.CENTER); // Panell de botons

        // Afegim els components al JFrame
        finestra.add(panellSuperior, BorderLayout.NORTH); // Panell superior a dalt
        finestra.add(panellFitxer, BorderLayout.CENTER); // Panell fitxer al centre
        finestra.add(panellInferior, BorderLayout.SOUTH); // Panell inferior amb separador i botons

        // Fem visible la finestra
        finestra.setVisible(true);
    }
}