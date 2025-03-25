        package com.example; // define el paquete de la clase

import javax.swing.*; // importa la libreria swing para crear interfaces graficas
import javax.swing.event.ChangeEvent; // importa la clase ChangeEvent para manejar eventos de cambio
import javax.swing.event.ChangeListener; // importa la interfaz ChangeListener para manejar eventos de cambio
import java.awt.event.ActionListener; // importa la interfaz ActionListener para manejar eventos de accion
import java.io.BufferedReader; // importa la clase BufferedReader para leer archivos
import java.io.FileReader; // importa la clase FileReader para leer archivos
import java.io.FileWriter; // importa la clase FileWriter para escribir archivos
import java.io.IOException; // importa la clase IOException para manejar excepciones de entrada/salida
import java.io.PrintWriter; // importa la clase PrintWriter para escribir archivos
import java.awt.event.ActionEvent; // importa la clase ActionEvent para manejar eventos de accion

import java.awt.*; // importa todas las clases del paquete awt

public class Main { // define la clase principal
    public static void main(String[] args) { // define el metodo main
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // establece el look and feel de la aplicacion para que se vea como una aplicacion de windows
        } catch (Exception e) {
            e.printStackTrace(); // imprime el error si ocurre una excepcion
        }
        JFrame frame = new JFrame("Gestor de Biblioteca"); // crea una ventana con el titulo gestor de biblioteca
        frame.setSize(600, 500); // establece el tamano de la ventana a 600x500 pixeles
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cierra la aplicacion al cerrar la ventana
        frame.setLayout(new FlowLayout()); // establece el layout de la ventana como flowlayout
        
        JTabbedPane tabbedPane = new JTabbedPane(); // crea un panel de pestañas
        
        JPanel gestionLlibres = new JPanel(new GridBagLayout()); // crea un panel con layout gridbaglayout
        GridBagConstraints gbc = new GridBagConstraints(); // crea un objeto gridbagconstraints para manejar las restricciones del layout
        gbc.insets = new Insets(2, 0, 2, 30); // establece los margenes internos del layout
        gbc.anchor = GridBagConstraints.WEST; // establece el anclaje de los componentes al oeste

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 0; // establece la coordenada y del componente
        JTextField titulo = new JTextField(10); // crea un campo de texto con 10 columnas
        gestionLlibres.add(titulo, gbc); // añade el campo de texto al panel gestionLlibres

        String[] genere = {"Aventura","Fantasi","Misteri","Terror","Ciencia Ficcio"}; // define un array de strings con los generos
        JComboBox<String> comboBox = new JComboBox<>(genere); // crea un combobox con los generos
        gbc.gridx = 1; // establece la coordenada x del componente
        gbc.gridy = 0; // establece la coordenada y del componente
        gestionLlibres.add(comboBox, gbc); // añade el combobox al panel gestionLlibres

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 2; // establece la coordenada y del componente
        JLabel anyPublicacioLabel = new JLabel("Any de publicacio"); // crea una etiqueta con el texto any de publicacio
        gestionLlibres.add(anyPublicacioLabel, gbc); // añade la etiqueta al panel gestionLlibres

        gbc.gridx = 1; // establece la coordenada x del componente
        gbc.gridy = 2; // establece la coordenada y del componente
        JSlider anyPublicacio = new JSlider(JSlider.HORIZONTAL, 1900, 2025, 1963); // crea un slider horizontal con valores entre 1900 y 2025 y valor inicial 1963
        anyPublicacio.setMajorTickSpacing(25); // establece intervalos grandes de 25 unidades
        anyPublicacio.setMinorTickSpacing(5); // establece intervalos pequeños de 5 unidades
        anyPublicacio.setPaintTicks(true); // muestra las marcas de los intervalos
        anyPublicacio.setPaintLabels(true); // muestra las etiquetas numericas de los intervalos
        gestionLlibres.add(anyPublicacio, gbc); // añade el slider al panel gestionLlibres

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 3; // establece la coordenada y del componente
        gestionLlibres.add(new JLabel("Any seleccionat"), gbc); // añade una etiqueta con el texto any seleccionat al panel gestionLlibres

        gbc.gridx = 1; // establece la coordenada x del componente
        gbc.gridy = 3; // establece la coordenada y del componente
        JLabel value = new JLabel(""+anyPublicacio.getValue()); // crea una etiqueta con el valor inicial del slider
        anyPublicacio.addChangeListener(new ChangeListener() { // añade un listener al slider para manejar eventos de cambio
            @Override
            public void stateChanged(ChangeEvent e) { // metodo que se ejecuta cuando ocurre un evento de cambio
                value.setText(""+anyPublicacio.getValue()); // actualiza el texto de la etiqueta con el valor del slider
            }
        });
        gestionLlibres.add(value, gbc); // añade la etiqueta al panel gestionLlibres

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 4; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // centra el componente
        JCheckBox checkBox = new JCheckBox("Best Seller"); // crea un checkbox con el texto best seller
        checkBox.setSelected(false); // establece el checkbox como no seleccionado por defecto
        gestionLlibres.add(checkBox, gbc); // añade el checkbox al panel gestionLlibres

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 5; // establece la coordenada y del componente
        gbc.gridwidth = 1; // restablece el gridwidth a 1
        gbc.anchor = GridBagConstraints.WEST; // restablece el anchor a west
        JButton botoAf = new JButton("Afegir a la llista"); // crea un boton con el texto afegir a la llista
        gestionLlibres.add(botoAf, gbc); // añade el boton al panel gestionLlibres

        gbc.gridx = 1; // establece la coordenada x del componente
        gbc.gridy = 5; // establece la coordenada y del componente
        JButton botoSupr = new JButton("Suprimir de la llista"); // crea un boton con el texto suprimir de la llista
        gestionLlibres.add(botoSupr, gbc); // añade el boton al panel gestionLlibres

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 6; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        gbc.fill = GridBagConstraints.BOTH; // hace que el componente ocupe todo el espacio disponible
        gbc.weightx = 1.0; // establece el peso en el eje x
        gbc.weighty = 1.0; // establece el peso en el eje y
        DefaultListModel<String> listModel = new DefaultListModel<>(); // crea un modelo de lista por defecto
        JList<String> bookList = new JList<>(listModel); // crea una lista con el modelo de lista
        JScrollPane scrollPane = new JScrollPane(bookList); // crea un panel de desplazamiento con la lista
        gestionLlibres.add(scrollPane, gbc); // añade el panel de desplazamiento al panel gestionLlibres

        botoAf.addActionListener(new ActionListener() { // añade un listener al boton para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                String title = titulo.getText(); // obtiene el texto del campo de texto
                String genre = (String) comboBox.getSelectedItem(); // obtiene el item seleccionado del combobox
                int year = anyPublicacio.getValue(); // obtiene el valor del slider
                boolean isBestSeller = checkBox.isSelected(); // obtiene el estado del checkbox
                String book = String.format("%s - %s - %d - Best-Seller: %s", title, genre, year, isBestSeller ? "Sí" : "No"); // crea una cadena con los datos del libro
                listModel.addElement(book); // añade el libro al modelo de lista
            }
        });

        botoSupr.addActionListener(new ActionListener() { // añade un listener al boton para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                int selectedIndex = bookList.getSelectedIndex(); // obtiene el indice del item seleccionado en la lista
                if (selectedIndex != -1) { // si hay un item seleccionado
                    listModel.remove(selectedIndex); // elimina el item del modelo de lista
                }
            }
        });

        tabbedPane.addTab("Gestion de llibres", gestionLlibres); // añade la pestaña con el panel gestionLlibres

        // Panel de Análisis de Datos
        JPanel analisisDades = new JPanel(new GridBagLayout()); // crea un panel con layout gridbaglayout
        gbc = new GridBagConstraints(); // crea un objeto gridbagconstraints para manejar las restricciones del layout
        gbc.insets = new Insets(2, 0, 2, 30); // establece los margenes internos del layout
        gbc.anchor = GridBagConstraints.WEST; // establece el anclaje de los componentes al oeste

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 0; // establece la coordenada y del componente
        JLabel filterLabel = new JLabel("Filtrar por género:"); // crea una etiqueta con el texto filtrar por genero
        analisisDades.add(filterLabel, gbc); // añade la etiqueta al panel analisisDades

        gbc.gridx = 1; // establece la coordenada x del componente
        gbc.gridy = 0; // establece la coordenada y del componente
        JComboBox<String> filterComboBox = new JComboBox<>(genere); // crea un combobox con los generos
        analisisDades.add(filterComboBox, gbc); // añade el combobox al panel analisisDades

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 1; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        JButton statsButton = new JButton("Calcular Estadísticas"); // crea un boton con el texto calcular estadisticas
        analisisDades.add(statsButton, gbc); // añade el boton al panel analisisDades

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 2; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        JLabel statsLabel = new JLabel("Resultados:"); // crea una etiqueta con el texto resultados
        analisisDades.add(statsLabel, gbc); // añade la etiqueta al panel analisisDades

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 3; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        JTextArea statsArea = new JTextArea(10, 40); // crea un area de texto con 10 filas y 40 columnas
        statsArea.setEditable(false); // establece el area de texto como no editable
        JScrollPane statsScrollPane = new JScrollPane(statsArea); // crea un panel de desplazamiento con el area de texto
        analisisDades.add(statsScrollPane, gbc); // añade el panel de desplazamiento al panel analisisDades

        statsButton.addActionListener(new ActionListener() { // añade un listener al boton para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                String selectedGenre = (String) filterComboBox.getSelectedItem(); // obtiene el item seleccionado del combobox
                int totalBooks = listModel.getSize(); // obtiene el tamaño del modelo de lista
                int genreCount = 0; // inicializa el contador de libros por genero
                int yearSum = 0; // inicializa la suma de los años de publicacion

                for (int i = 0; i < listModel.getSize(); i++) { // recorre todos los elementos del modelo de lista
                    String book = listModel.getElementAt(i); // obtiene el elemento en la posicion i
                    if (book.contains(selectedGenre)) { // si el libro contiene el genero seleccionado
                        genreCount++; // incrementa el contador de libros por genero
                    }
                    String[] parts = book.split(" - "); // divide el libro en partes usando el separador " - "
                    int year = Integer.parseInt(parts[2]); // convierte la tercera parte a entero (año de publicacion)
                    yearSum += year; // suma el año de publicacion a la suma total
                }

                double averageYear = totalBooks > 0 ? (double) yearSum / totalBooks : 0; // calcula el año promedio de publicacion

                statsArea.setText(String.format("Total de libros: %d\nCantidad por género (%s): %d\nAño promedio de publicación: %.2f",
                        totalBooks, selectedGenre, genreCount, averageYear)); // muestra los resultados en el area de texto
            }
        });

        tabbedPane.addTab("Analisis de dades", analisisDades); // añade la pestaña con el panel analisisDades

        // Panel de Exportar Datos
        JPanel exportarDades = new JPanel(new GridBagLayout()); // crea un panel con layout gridbaglayout
        gbc = new GridBagConstraints(); // crea un objeto gridbagconstraints para manejar las restricciones del layout
        gbc.insets = new Insets(2, 0, 2, 30); // establece los margenes internos del layout
        gbc.anchor = GridBagConstraints.WEST; // establece el anclaje de los componentes al oeste

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 0; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        JButton exportButton = new JButton("Guardar en archivo .txt"); // crea un boton con el texto guardar en archivo .txt
        exportarDades.add(exportButton, gbc); // añade el boton al panel exportarDades

        gbc.gridx = 0; // establece la coordenada x del componente
        gbc.gridy = 1; // establece la coordenada y del componente
        gbc.gridwidth = 2; // hace que el componente ocupe dos columnas
        JButton importButton = new JButton("Cargar desde archivo .txt"); // crea un boton con el texto cargar desde archivo .txt
        exportarDades.add(importButton, gbc); // añade el boton al panel exportarDades

        exportButton.addActionListener(new ActionListener() { // añade un listener al boton para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                try (PrintWriter writer = new PrintWriter(new FileWriter("libros.txt"))) { // crea un escritor de archivos con el archivo libros.txt
                    for (int i = 0; i < listModel.getSize(); i++) { // recorre todos los elementos del modelo de lista
                        writer.println(listModel.getElementAt(i)); // escribe el elemento en el archivo
                    }
                    JOptionPane.showMessageDialog(frame, "Datos guardados en libros.txt"); // muestra un mensaje de dialogo indicando que los datos se han guardado
                } catch (IOException ex) {
                    ex.printStackTrace(); // imprime el error si ocurre una excepcion
                }
            }
        });

        importButton.addActionListener(new ActionListener() { // añade un listener al boton para manejar eventos de accion
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta cuando ocurre un evento de accion
                try (BufferedReader reader = new BufferedReader(new FileReader("libros.txt"))) { // crea un lector de archivos con el archivo libros.txt
                    listModel.clear(); // limpia el modelo de lista
                    String line; // declara una variable para almacenar cada linea del archivo
                    while ((line = reader.readLine()) != null) { // lee cada linea del archivo
                        listModel.addElement(line); // añade la linea al modelo de lista
                    }
                    JOptionPane.showMessageDialog(frame, "Datos cargados desde libros.txt"); // muestra un mensaje de dialogo indicando que los datos se han cargado
                } catch (IOException ex) {
                    ex.printStackTrace(); // imprime el error si ocurre una excepcion
                }
            }
        });

        tabbedPane.addTab("Exportar dades", exportarDades); // añade la pestaña con el panel exportarDades

        frame.add(tabbedPane); // añade el panel de pestañas al frame
        frame.setVisible(true); // hace visible la ventana
    }   
}