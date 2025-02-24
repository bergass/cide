package com.example; // defineix el paquet on es troba la classe

import javax.swing.*; // importa la llibreria swing per crear interfícies gràfiques
import java.awt.*; // importa la llibreria awt per manejar components gràfics
import java.awt.event.ActionEvent; // importa la classe ActionEvent per manejar esdeveniments d'acció
import java.awt.event.ActionListener; // importa la interfície ActionListener per escoltar esdeveniments d'acció

/**************************************/
/* nom: albert bergas consuegra */
/* dni/nie: 45185379q */
/* data: 14/02/2025 */
/* exercici: prou6ex01 */
/**************************************/

public class Main { // defineix la classe principal
    public static void main(String[] args) { // mètode principal que s'executa en iniciar el programa
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // estableix el look and feel de l'aplicació perquè es vegi com una aplicació de windows
        } catch (Exception e) {
            e.printStackTrace(); // imprimeix l'error si ocorre una excepció
        }
        JFrame calculadora = new JFrame("Calculadora"); // crea una finestra amb el títol "calculadora"
        calculadora.setSize(400, 300); // estableix la mida de la finestra a 400x300 píxels
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // estableix que l'aplicació es tanqui quan es tanca la finestra
        calculadora.setLayout(new BorderLayout()); // estableix el layout de la finestra com borderlayout

        JPanel panel = new JPanel(); // crea un panell per contenir els components
        panel.setLayout(new GridLayout(4,2,10,10)); // estableix el layout del panell com una quadrícula de 4 files i 2 columnes amb 10 píxels d'espai entre components

        JTextField num1 = new JTextField(3); // crea un camp de text per al primer número amb una amplada de 3 columnes
        panel.add(num1); // afegeix el camp de text al panell

        JTextField num2 = new JTextField(3); // crea un camp de text per al segon número amb una amplada de 3 columnes
        panel.add(num2); // afegeix el camp de text al panell

        JLabel resultat = new JLabel("Resultat",SwingConstants.CENTER); // crea una etiqueta per mostrar el resultat, centrada horitzontalment
        resultat.setFont(new Font("Arial", Font.BOLD, 16)); // estableix la font de l'etiqueta a arial, negreta, mida 16        

        JButton boto1 = new JButton("Suma"); // crea un botó amb el text "suma"
        boto1.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic, es cridi al mètode suma amb els camps de text i l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                suma(num1, num2, resultat); // crida al mètode suma amb els camps de text i l'etiqueta de resultat
            }
        });
        panel.add(boto1); // afegeix el botó al panell

        JButton boto2 = new JButton("Resta"); // crea un botó amb el text "resta"
        boto2.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic, es cridi al mètode resta amb els camps de text i l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                resta(num1, num2, resultat); // crida al mètode resta amb els camps de text i l'etiqueta de resultat
            }
        });
        panel.add(boto2); // afegeix el botó al panell

        JButton boto3 = new JButton("Multiplicacio"); // crea un botó amb el text "multiplicacio"
        boto3.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic, es cridi al mètode multiplicacio amb els camps de text i l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplicacio(num1, num2, resultat); // crida al mètode multiplicacio amb els camps de text i l'etiqueta de resultat
            }
        });
        panel.add(boto3); // afegeix el botó al panell

        JButton boto4 = new JButton("Divisio"); // crea un botó amb el text "divisio"
        boto4.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic, es cridi al mètode divisio amb els camps de text i l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                divisio(num1, num2, resultat); // crida al mètode divisio amb els camps de text i l'etiqueta de resultat
            }
        });
        panel.add(boto4); // afegeix el botó al panell

        panel.add(resultat); // afegeix l'etiqueta de resultat al panell

        calculadora.add(panel, BorderLayout.CENTER); // afegeix el panell a la finestra al centre del borderlayout
        calculadora.setVisible(true); // fa visible la finestra
    }

    public static void suma(JTextField num1, JTextField num2, JLabel resultat) { // mètode per sumar els números dels camps de text i mostrar el resultat a l'etiqueta
        try {
            double numero1 = Double.parseDouble(num1.getText().trim()); // converteix el text del primer camp de text a un enter
            double numero2 = Double.parseDouble(num2.getText().trim()); // converteix el text del segon camp de text a un enter
            double suma = numero1 + numero2; // suma els dos números
            resultat.setText(String.valueOf(suma)); // mostra el resultat de la suma a l'etiqueta
        } catch (NumberFormatException e) {
            resultat.setText("Error:("); // si hi ha un error de format, mostra "error:(" a l'etiqueta
        }
    }

    public static void resta(JTextField num1, JTextField num2, JLabel resultat) { // mètode per restar els números dels camps de text i mostrar el resultat a l'etiqueta
        try {
            double numero1 = Double.parseDouble(num1.getText().trim()); // converteix el text del primer camp de text a un enter
            double numero2 = Double.parseDouble(num2.getText().trim()); // converteix el text del segon camp de text a un enter
            double resta = numero1 - numero2; // resta els dos números
            resultat.setText(String.valueOf(resta)); // mostra el resultat de la resta a l'etiqueta
        } catch (NumberFormatException e) {
            resultat.setText("Error:("); // si hi ha un error de format, mostra "error:(" a l'etiqueta
        }
    }

    public static void multiplicacio(JTextField num1, JTextField num2, JLabel resultat) { // mètode per multiplicar els números dels camps de text i mostrar el resultat a l'etiqueta
        try {
            double numero1 = Double.parseDouble(num1.getText().trim()); // converteix el text del primer camp de text a un enter
            double numero2 = Double.parseDouble(num2.getText().trim()); // converteix el text del segon camp de text a un enter
            double multiplicacio = numero1 * numero2; // multiplica els dos números
            resultat.setText(String.valueOf(multiplicacio)); // mostra el resultat de la multiplicació a l'etiqueta
        } catch (NumberFormatException e) {
            resultat.setText("Error:("); // si hi ha un error de format, mostra "error:(" a l'etiqueta
        }
    }

    public static void divisio(JTextField num1, JTextField num2, JLabel resultat) { // mètode per dividir els números dels camps de text i mostrar el resultat a l'etiqueta
        try {
            double numero1 = Double.parseDouble(num1.getText().trim()); // converteix el text del primer camp de text a un enter
            double numero2 = Double.parseDouble(num2.getText().trim()); // converteix el text del segon camp de text a un enter
            double divisio = numero1 / numero2; // divideix els dos números
            resultat.setText(String.valueOf(divisio)); // mostra el resultat de la divisió a l'etiqueta
        } catch (ArithmeticException e) {
            resultat.setText("Error:("); // si hi ha un error aritmètic, mostra "error:(" a l'etiqueta
        } catch (NumberFormatException e) {
            resultat.setText("Error:("); // si hi ha un error de format, mostra "error:(" a l'etiqueta
        }
    }
}