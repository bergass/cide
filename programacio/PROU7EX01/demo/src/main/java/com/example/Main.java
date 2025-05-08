package com.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;

//Albert Bergas Consuegra

public class Main {
    public static void main(String[] args) {
        // crea la finestra principal amb títol i mida inicial
        JFrame finestra = new JFrame("Editor de fitxers de text");
        finestra.setSize(500, 500);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // tanca l'aplicació en sortir
        finestra.setLayout(new BorderLayout()); // estableix el disseny de la finestra com BorderLayout

        // panell superior per introduir el nom del fitxer
        JPanel panellSuperior = new JPanel();
        panellSuperior.setLayout(new FlowLayout(FlowLayout.LEFT)); // organitza els components en línia
        panellSuperior.add(new JLabel("  Nom del fitxer: ")); // etiqueta per indicar el camp de text
        JTextField campNomFitxer = new JTextField(33); // camp de text per escriure el nom del fitxer
        panellSuperior.add(campNomFitxer); // afegeix el camp de text al panell superior

        // panell central per mostrar el contingut del fitxer
        JPanel panellFitxer = new JPanel();
        panellFitxer.setLayout(new BorderLayout()); // ocupa tot l'espai disponible
        JTextArea campContingut = new JTextArea(); // àrea de text gran per mostrar o editar contingut
        campContingut.setLineWrap(true); // activa el salt de línia automàtic
        campContingut.setWrapStyleWord(true); // ajusta el salt de línia per paraules completes
        JScrollPane scrollPane = new JScrollPane(campContingut); // afegeix un scroll per l'àrea de text
        panellFitxer.add(scrollPane); // afegeix l'àrea de text amb scroll al panell central

        // panell inferior amb botons i una casella de selecció
        JPanel panellBotons = new JPanel();
        panellBotons.setLayout(new FlowLayout()); // organitza els botons en línia
        JButton llegir = new JButton("Llegir"); // botó per llegir el contingut del fitxer
        JButton escriure = new JButton("Escriure"); // botó per escriure al fitxer
        JCheckBox afegir = new JCheckBox("Afegir"); // casella per indicar si s'ha d'afegir al final del fitxer
        panellBotons.add(llegir); // afegeix el botó llegir
        panellBotons.add(escriure); // afegeix el botó escriure
        panellBotons.add(afegir); // afegeix la casella de selecció

        // panell inferior amb separador i panell de botons
        JPanel panellInferior = new JPanel();
        panellInferior.setLayout(new BorderLayout()); // disseny per organitzar components
        panellInferior.add(new JSeparator(SwingConstants.HORIZONTAL), BorderLayout.NORTH); // separador horitzontal
        panellInferior.add(panellBotons, BorderLayout.CENTER); // afegeix el panell de botons al centre

        // afegeix els panells a la finestra principal
        finestra.add(panellSuperior, BorderLayout.NORTH); // panell superior a la part superior
        finestra.add(panellFitxer, BorderLayout.CENTER); // panell central al centre
        finestra.add(panellInferior, BorderLayout.SOUTH); // panell inferior a la part inferior

        // funcionalitat del botó llegir
        llegir.addActionListener(e -> {
            String nomFitxer = campNomFitxer.getText(); // obté el nom del fitxer del camp de text
            File fitxer = new File(nomFitxer); // crea un objecte fitxer amb el nom indicat

            if (!fitxer.exists()) { // comprova si el fitxer no existeix
                JOptionPane.showMessageDialog(finestra, "El fitxer no existeix: " + nomFitxer,
                        "Error", JOptionPane.ERROR_MESSAGE); // mostra un missatge d'error
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(fitxer))) { // obre el fitxer per llegir
                    StringBuilder contingut = new StringBuilder(); // acumula el contingut del fitxer
                    String linia;
                    while ((linia = reader.readLine()) != null) { // llegeix línia per línia
                        contingut.append(linia).append(System.lineSeparator()); // afegeix cada línia al contingut
                    }
                    campContingut.setText(contingut.toString()); // mostra el contingut al JTextArea
                } catch (IOException ex) { // captura errors de lectura
                    JOptionPane.showMessageDialog(finestra, "Error al llegir el fitxer: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE); // mostra un missatge d'error
                }
            }
        });

        // funcionalitat del botó escriure
        escriure.addActionListener(e -> {
            String nomFitxer = campNomFitxer.getText(); // obté el nom del fitxer del camp de text
            String text = campContingut.getText(); // obté el text de l'àrea de text
            boolean afegirAlFinal = afegir.isSelected(); // comprova si la casella està marcada

            File fitxer = new File(nomFitxer); // crea un objecte fitxer amb el nom indicat

            try (FileWriter writer = new FileWriter(fitxer, afegirAlFinal)) { // obre el fitxer per escriure
                writer.write(text); // escriu el text al fitxer
                JOptionPane.showMessageDialog(finestra, "Text escrit correctament al fitxer: " + nomFitxer,
                        "Èxit", JOptionPane.INFORMATION_MESSAGE); // mostra un missatge d'èxit
            } catch (IOException ex) { // captura errors d'escriptura
                JOptionPane.showMessageDialog(finestra, "Error al escriure al fitxer: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE); // mostra un missatge d'error
            }
        });

        // fa visible la finestra principal
        finestra.setVisible(true);
    }
}