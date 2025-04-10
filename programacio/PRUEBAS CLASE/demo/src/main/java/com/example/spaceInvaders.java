package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Classe que representa el jugador (la nau espacial)
class Jugador {
    int x, y;       // Posició del jugador
    int ample = 40; // Amplada de la nau
    int alt = 20;   // Alçada de la nau

    public Jugador(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Dibuixa la nau
    public void dibuixa(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, ample, alt);
    }

    // Mou la nau cap a esquerra o dreta
    public void moure(int direccio, int amplePantalla) {
        x += direccio * 10; // Moure 10 píxels
        if (x < 0) x = 0;
        if (x > amplePantalla - ample) x = amplePantalla - ample;
    }
}

// Classe que representa un dispar (bala)
class Disparo {
    int x, y;
    int radi = 5;

    public Disparo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Dibuixa el dispar com un cercle vermell
    public void dibuixa(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, radi * 2, radi * 2);
    }

    // Mou el dispar cap amunt
    public void moure() {
        y -= 10;
    }

    // Comprova si ha sortit de la pantalla
    public boolean foraPantalla() {
        return y < 0;
    }
}

// Classe que representa un enemic
class Enemic {
    int x, y;
    int mida = 30;

    public Enemic(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Dibuixa l'enemic com un quadrat blau
    public void dibuixa(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, mida, mida);
    }

    // Comprova si hi ha col·lisió amb un dispar
    public boolean colisiona(Disparo d) {
        Rectangle enemicRect = new Rectangle(x, y, mida, mida);
        Rectangle disparRect = new Rectangle(d.x, d.y, d.radi * 2, d.radi * 2);
        return enemicRect.intersects(disparRect);
    }
}

// Panell principal del joc
class PanellJoc extends JPanel implements ActionListener, KeyListener {
    Jugador jugador;
    ArrayList<Disparo> dispars = new ArrayList<>();
    ArrayList<Enemic> enemics = new ArrayList<>();
    Timer timer;

    boolean esquerra = false;
    boolean dreta = false;
    boolean disparant = false;

    public PanellJoc() {
        setBackground(Color.BLACK);
        jugador = new Jugador(280, 350); // Posició inicial
        crearEnemics();

        timer = new Timer(30, this); // Actualitza cada 30ms
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }

    // Crea enemics en línia a la part superior
    public void crearEnemics() {
        for (int i = 0; i < 6; i++) {
            enemics.add(new Enemic(50 + i * 60, 50));
        }
    }

    // Dibuixa tot el joc
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jugador.dibuixa(g);

        for (Disparo d : dispars) {
            d.dibuixa(g);
        }

        for (Enemic e : enemics) {
            e.dibuixa(g);
        }

        // Missatge si guanyes
        if (enemics.isEmpty()) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Has guanyat!", 220, 200);
        }
    }

    // S'executa cada tick del Timer
    @Override
    public void actionPerformed(ActionEvent e) {
        if (esquerra) jugador.moure(-1, getWidth());
        if (dreta) jugador.moure(1, getWidth());

        // Actualitza dispars
        ArrayList<Disparo> disparsFora = new ArrayList<>();
        ArrayList<Enemic> enemicsEliminats = new ArrayList<>();

        for (Disparo d : dispars) {
            d.moure();
            if (d.foraPantalla()) {
                disparsFora.add(d);
            } else {
                for (Enemic en : enemics) {
                    if (en.colisiona(d)) {
                        disparsFora.add(d);
                        enemicsEliminats.add(en);
                    }
                }
            }
        }

        // Elimina dispars i enemics col·lisionats
        dispars.removeAll(disparsFora);
        enemics.removeAll(enemicsEliminats);

        repaint();
    }

    // Controls del teclat
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) esquerra = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) dreta = true;
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !disparant) {
            // Crear dispar al centre superior de la nau
            dispars.add(new Disparo(jugador.x + jugador.ample / 2, jugador.y));
            disparant = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) esquerra = false;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) dreta = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) disparant = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}

// Classe principal del joc
public class spaceInvaders {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Space Invaders!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.add(new PanellJoc());
            frame.setVisible(true);
        });
    }
}
