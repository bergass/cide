package com.example;

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*; // importa todas las clases del paquete awt
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.KeyListener; // importa la interfaz KeyListener para manejar eventos de teclado
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent; // importa la classe ActionEvent per manejar esdeveniments d'acció
import java.awt.event.ActionListener;

// Albert Bergas Consuegra 45185379Q

public class Main {
    public static boolean validarDNI(String dni) {
        // Verifica que el format sigui correcte (8 dígits + 1 lletra)
        return dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
        // Calcula la lletra esperada i la compara amb la lletra proporcionada
                "TRWAGMYFPDXBNJZSQVHLCKE"
                        .charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character.toUpperCase(dni.charAt(8));
    }

    public static boolean esDataValida(String dataString) {
        try {
            // Defineix el format esperat de la data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Converteix la cadena de text en un objecte LocalDate
            LocalDate dataEntrada = LocalDate.parse(dataString, formatter);

            // Comprova si la data no és anterior a la data actual
            return !dataEntrada.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            // Captura l'excepció si la cadena no té el format correcte i retorna false
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reserves Hotel"); // crea una ventana con el titulo gestor de biblioteca
        frame.setSize(600, 500); // establece el tamano de la ventana a 600x500 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout

        JPanel panell = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 0, 2, 30);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; //
        gbc.gridy = 0;// establece la coordenada y del componente
        JLabel nomLabel = new JLabel("Nom:");
        panell.add(nomLabel);

        gbc.gridx = 1;
        gbc.gridy = 0;// establece la coordenada y del componente
        JTextField nom = new JTextField(10);
        panell.add(nom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;// establece la coordenada y del componente
        JLabel dniLabel = new JLabel("DNI:");
        panell.add(dniLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;// establece la coordenada y del componente
        JTextField dni = new JTextField(10);
        panell.add(dni, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;// establece la coordenada y del componente
        JLabel validarDni = new JLabel("");
        dni.addKeyListener(new KeyListener() { // anade un listener al campo de texto para manejar eventos de teclado
            public void keyTyped(KeyEvent e) { // metodo que se ejecuta cuando se escribe una tecla
                validarDNI(dni.getText());
                if (validarDNI(dni.getText()) == true) { // si es true da ok sino ko
                    validarDni.setText("OK");
                } else {
                    validarDni.setText("KO");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) { // metodo que se ejecuta cuando se presiona una tecla
                // no hace nada se tiene que poner
            }

            @Override
            public void keyReleased(KeyEvent e) { // metodo que se ejecuta cuando se suelta una tecla
                // no hace nada se tiene que poner
            }
        });
        panell.add(validarDni, gbc);

        gbc.gridx = 0;// establece la coordenada x del componente
        gbc.gridy = 3;// establece la coordenada y del componente
        JLabel dCheckIn = new JLabel("Data check-in: (dd/MM/yyyy)");
        panell.add(dCheckIn, gbc);

        gbc.gridx = 1;// establece la coordenada x del componente
        gbc.gridy = 3;// establece la coordenada y del componente
        JTextField data = new JTextField(10);
        if (esDataValida(data.getText()) == true) {

        }
        panell.add(data, gbc);

        gbc.gridx = 0;// establece la coordenada x del componente
        gbc.gridy = 4;// establece la coordenada y del componente
        JLabel nomHotel = new JLabel("Hotel:");
        panell.add(nomHotel, gbc);

        gbc.gridx = 1;// establece la coordenada x del componente
        gbc.gridy = 4;// establece la coordenada y del componente
        String[] hotels = { "Hotel Mar", "Hotel Illa", "Hotel Muntanya" }; // define un array de strings con los generos
        JComboBox<String> comboBox = new JComboBox<>(hotels); // crea un combobox con los generos
        panell.add(comboBox, gbc);

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 5; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // centra el componente
        JSlider numNits = new JSlider(JSlider.HORIZONTAL, 0, 30, 4); // crea un slider horizontal con valores entre 1 y
                                                                     // el del hotel
        numNits.setMajorTickSpacing(10); // establece intervalos grandes de 25 unidades
        numNits.setMinorTickSpacing(5); // establece intervalos pequeños de 5 unidades
        numNits.setPaintTicks(true); // muestra las marcas de los intervalos
        numNits.setPaintLabels(true); // muestra las etiquetas numericas de los intervalos
        JLabel valorS = new JLabel("Valor de slider:" + numNits.getValue()); // crea una etiqueta con el valor inicial
                                                                             // del slider
        numNits.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
            @Override
            public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                valorS.setText("Valor de slider:" + numNits.getValue()); // actualiza el texto de la etiqueta con el
                                                                         // nuevo valor del slider
            }
        });
        if (comboBox.getSelectedItem() == "Hotel Mar") {
            numNits.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
                @Override
                public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                    numNits.setMaximum(7);
                }
            });
        } else if (comboBox.getSelectedItem() == "Hotel Illa") {
            numNits.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
                @Override
                public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                    numNits.setMaximum(15);
                }
            });
        } else if (comboBox.getSelectedItem() == "Hotel Muntanya") {
            numNits.addChangeListener(new ChangeListener() { // añade un listener para cambios en el slider
                @Override
                public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando cambia el valor del slider
                    numNits.setMaximum(30);
                }
            });
        }
        panell.add(numNits, gbc); // añade el slider al panel gestionLlibres

        gbc.gridx = 0;// establece la coordenada x del componente
        gbc.gridy = 6;// establece la coordenada y del componente
        JLabel reserva = new JLabel("");
        JButton guardarRes = new JButton("Guardar Reserva"); // crea un botó amb el text "resta"
        guardarRes.addActionListener(new ActionListener() { // afegeix un listener al botó perquè quan es faci clic,
                                                            // es cridi al mètode resta amb els camps de text i
                                                            // l'etiqueta de resultat
            @Override
            public void actionPerformed(ActionEvent e) {
                reserva.setText("Reserva:" + nom.getText() + ", " + dni.getText() + ", "
                        + data.getText() + ", " + comboBox.getSelectedItem() + ", " + numNits.getValue()); // quan
                                                                                                           // pulsis el
                                                                                                           // boto surti
                                                                                                           // el resum
                                                                                                           // de la
                                                                                                           // reserva
            }
        });
        panell.add(guardarRes, gbc); // afegeix el botó al panell

        gbc.gridx = 0;// establece la coordenada x del componente
        gbc.gridy = 7;// establece la coordenada y del componente
        panell.add(reserva, gbc);

        gbc.gridx = 0;// establece la coordenada x del componente
        gbc.gridy = 7;// establece la coordenada y del componente
        panell.add(valorS, gbc);

        frame.add(panell); // añade el panel de pestañas al frame
        frame.setVisible(true); // hace visible la ventana
    }
}
// La intencion es lo que cuenta