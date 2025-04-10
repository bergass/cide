package com.example; // Declarar el paquete donde se encuentra la clase

import java.awt.Color; // Importar la clase Color para manejar colores
import java.awt.Graphics; // Importar la clase Graphics para dibujar en el panel
import java.awt.Graphics2D; // Importar Graphics2D para funcionalidades avanzadas de dibujo
import java.awt.event.ActionEvent; // Importar ActionEvent para manejar eventos de acción
import java.awt.event.ActionListener; // Importar ActionListener para escuchar eventos de acción
import java.awt.event.KeyEvent; // Importar KeyEvent para manejar eventos de teclado
import java.awt.event.KeyListener; // Importar KeyListener para escuchar eventos de teclado
import java.util.ArrayList; // Importar ArrayList para manejar listas dinámicas
import java.util.Random; // Importar Random para generar números aleatorios

import javax.swing.JOptionPane; // Importar JOptionPane para mostrar cuadros de diálogo
import javax.swing.JPanel; // Importar JPanel para crear el panel del juego
import javax.swing.Timer; // Importar Timer para manejar la lógica del juego en intervalos

public class GameEngine extends JPanel implements ActionListener, KeyListener { // Clase principal del motor del juego
    private Timer timer; // Temporizador para controlar la lógica del juego
    private Jugador jugador; // Objeto que representa al jugador
    private ArrayList<Obstaculo> obstaculos; // Lista de obstáculos en el juego
    private int score; // Puntaje del jugador

    public GameEngine() { // Constructor de la clase
        // Inicializar el juego
        this.jugador = new Jugador(375, 500); // Crear al jugador en la posición inicial (x=375, y=500)
        this.obstaculos = new ArrayList<>(); // Inicializar la lista de obstáculos
        this.score = 0; // Inicializar el puntaje en 0

        // Configurar el temporizador
        timer = new Timer(30, this); // Crear un temporizador que ejecuta actionPerformed cada 30 ms
        timer.start(); // Iniciar el temporizador

        // Agregar eventos de teclado
        setFocusable(true); // Hacer que el panel sea enfocable para recibir eventos de teclado
        addKeyListener(this); // Registrar la clase actual como receptor de eventos de teclado
    }

    @Override
    protected void paintComponent(Graphics g) { // Método para dibujar en el panel
        super.paintComponent(g); // Llamar al método de la superclase para limpiar la pantalla
        Graphics2D g2d = (Graphics2D) g; // Convertir Graphics a Graphics2D para más funcionalidades

        // Dibujar el fondo
        g2d.setColor(Color.WHITE); // Establecer el color de fondo a blanco
        g2d.fillRect(0, 0, getWidth(), getHeight()); // Dibujar un rectángulo que cubre toda la pantalla
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mover los obstáculos
        for (int i = 0; i < obstaculos.size(); i++) {
            Obstaculo obstaculo = obstaculos.get(i);
            obstaculo.move();

            // Verificar colisiones
            if (obstaculo.getBounds().intersects(jugador.getBounds())) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over! Puntaje: " + score);
                System.exit(0);
            }

            // Eliminar obstáculos que salieron de la pantalla
            if (obstaculo.isOutOfBounds(getHeight())) {
                obstaculos.remove(i);
                i--;
                score++;
            }
        }

        // Generar nuevos obstáculos
        if (new Random().nextInt(20) == 0) {
            int x = new Random().nextInt(getWidth() - 50);
            obstaculos.add(new Obstaculo(x, 0, 5));
        }

        repaint(); // Redibujar la pantalla
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Mover al jugador con las teclas izquierda y derecha
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jugador.move(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jugador.move(10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No se necesita implementar
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se necesita implementar
    }
}
