import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutsExample extends JFrame { // clase LayoutsExample que extiende JFrame
    private JPanel mainPanel; // panel principal
    private CardLayout cardLayout; // layout de tarjetas
    
    public LayoutsExample() { // constructor de LayoutsExample
        setTitle("Ejemplo de Layouts"); // establece el titulo de la ventana
        setSize(600, 400); // establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // establece la operacion de cierre
        setLocationRelativeTo(null); // centra la ventana

        // Layout principal con CardLayout
        cardLayout = new CardLayout(); // inicializa cardLayout
        mainPanel = new JPanel(cardLayout); // inicializa mainPanel con cardLayout

        // Crear los diferentes paneles
        mainPanel.add(createFlowLayoutPanel(), "FlowLayout"); // añade panel de FlowLayout
        mainPanel.add(createBorderLayoutPanel(), "BorderLayout"); // añade panel de BorderLayout
        mainPanel.add(createGridLayoutPanel(), "GridLayout"); // añade panel de GridLayout
        mainPanel.add(createGridBagLayoutPanel(), "GridBagLayout"); // añade panel de GridBagLayout
        mainPanel.add(createBoxLayoutPanel(), "BoxLayout"); // añade panel de BoxLayout

        // Selector de layout
        String[] layouts = {"FlowLayout", "BorderLayout", "GridLayout", "GridBagLayout", "BoxLayout"}; // array de nombres de layouts
        JComboBox<String> layoutSelector = new JComboBox<>(layouts); // combo box para seleccionar layout
        layoutSelector.addActionListener(new ActionListener() { // añade listener al combo box
            @Override
            public void actionPerformed(ActionEvent e) { // metodo que se ejecuta al seleccionar un layout
                String selectedLayout = (String) layoutSelector.getSelectedItem(); // obtiene el layout seleccionado
                cardLayout.show(mainPanel, selectedLayout); // muestra el panel correspondiente al layout seleccionado
            }
        });

        // Panel superior con el selector
        JPanel topPanel = new JPanel(new FlowLayout()); // panel superior con FlowLayout
        topPanel.add(new JLabel("Selecciona un Layout: ")); // añade etiqueta al panel superior
        topPanel.add(layoutSelector); // añade combo box al panel superior

        // Agregar todo al JFrame
        getContentPane().setLayout(new BorderLayout()); // establece el layout del contenido del JFrame
        getContentPane().add(topPanel, BorderLayout.NORTH); // añade el panel superior al norte del JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER); // añade el panel principal al centro del JFrame
    }

    // FlowLayout: Componentes alineados de izquierda a derecha
    private JPanel createFlowLayoutPanel() { // metodo para crear panel con FlowLayout
        JPanel panel = new JPanel(new FlowLayout()); // inicializa panel con FlowLayout
        panel.add(new JButton("Botón 1")); // añade boton 1 al panel
        panel.add(new JButton("Botón 2")); // añade boton 2 al panel
        panel.add(new JButton("Botón 3")); // añade boton 3 al panel
        return panel; // retorna el panel
    }

    // BorderLayout: Divide en 5 regiones (Norte, Sur, Este, Oeste, Centro)
    private JPanel createBorderLayoutPanel() { // metodo para crear panel con BorderLayout
        JPanel panel = new JPanel(new BorderLayout()); // inicializa panel con BorderLayout
        panel.add(new JButton("Norte"), BorderLayout.NORTH); // añade boton al norte del panel
        panel.add(new JButton("Sur"), BorderLayout.SOUTH); // añade boton al sur del panel
        panel.add(new JButton("Este"), BorderLayout.EAST); // añade boton al este del panel
        panel.add(new JButton("Oeste"), BorderLayout.WEST); // añade boton al oeste del panel
        panel.add(new JButton("Centro"), BorderLayout.CENTER); // añade boton al centro del panel
        return panel; // retorna el panel
    }

    // GridLayout: Componentes en filas y columnas
    private JPanel createGridLayoutPanel() { // metodo para crear panel con GridLayout
        JPanel panel = new JPanel(new GridLayout(2, 3)); // inicializa panel con GridLayout de 2 filas y 3 columnas
        for (int i = 1; i <= 6; i++) { // bucle para añadir botones
            panel.add(new JButton("Botón " + i)); // añade boton al panel
        }
        return panel; // retorna el panel
    }

    // GridBagLayout: Distribución más flexible
    private JPanel createGridBagLayoutPanel() { // metodo para crear panel con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout()); // inicializa panel con GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // inicializa restricciones de GridBag
        
        gbc.fill = GridBagConstraints.BOTH; // establece que los componentes llenen el espacio disponible
        gbc.insets = new Insets(5, 5, 5, 5); // establece margenes

        // Botón 1 ocupa 2 columnas
        gbc.gridx = 0; // establece la columna del boton
        gbc.gridy = 0; // establece la fila del boton
        gbc.gridwidth = 2; // establece que el boton ocupa 2 columnas
        panel.add(new JButton("Botón 1"), gbc); // añade boton al panel

        // Botón 2 y 3 en la misma fila pero diferentes columnas
        gbc.gridx = 0; // establece la columna del boton
        gbc.gridy = 1; // establece la fila del boton
        gbc.gridwidth = 1; // establece que el boton ocupa 1 columna
        panel.add(new JButton("Botón 2"), gbc); // añade boton al panel

        gbc.gridx = 1; // establece la columna del boton
        panel.add(new JButton("Botón 3"), gbc); // añade boton al panel

        // Botón 4 ocupa dos filas
        gbc.gridx = 2; // establece la columna del boton
        gbc.gridy = 0; // establece la fila del boton
        gbc.gridheight = 2; // establece que el boton ocupa 2 filas
        panel.add(new JButton("Botón 4"), gbc); // añade boton al panel

        return panel; // retorna el panel
    }

    // BoxLayout: Componentes en fila o columna ajustándose automáticamente
    private JPanel createBoxLayoutPanel() { // metodo para crear panel con BoxLayout
        JPanel panel = new JPanel(); // inicializa panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // establece BoxLayout vertical
        panel.add(new JButton("Botón 1")); // añade boton 1 al panel
        panel.add(new JButton("Botón 2")); // añade boton 2 al panel
        panel.add(new JButton("Botón 3")); // añade boton 3 al panel
        return panel; // retorna el panel
    }

    public static void main(String[] args) { // metodo principal
        SwingUtilities.invokeLater(() -> { // ejecuta el codigo en el hilo de despacho de eventos
            new LayoutsExample().setVisible(true); // crea una instancia de LayoutsExample y la hace visible
        });
    }
}
