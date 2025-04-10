

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Pong extends JPanel implements ActionListener, KeyListener {
    int jugadorY = 100;
    int iaY = 100;
    int bolaX = 300, bolaY = 200;
    int bolaDX = -5, bolaDY = 3;

    Timer timer = new Timer(20, this);

    public Pong() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Pales
        g.setColor(Color.WHITE);
        g.fillRect(20, jugadorY, 10, 60);
        g.fillRect(getWidth() - 30, iaY, 10, 60);
        // Bola
        g.fillOval(bolaX, bolaY, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bolaX += bolaDX;
        bolaY += bolaDY;

        // Rebote superior/inferior
        if (bolaY <= 0 || bolaY >= getHeight() - 20) bolaDY *= -1;

        // Rebote amb jugador
        if (bolaX <= 30 && bolaY + 20 > jugadorY && bolaY < jugadorY + 60) bolaDX *= -1;

        // Rebote amb IA
        if (bolaX >= getWidth() - 50 && bolaY + 20 > iaY && bolaY < iaY + 60) bolaDX *= -1;

        // Mou la IA (segueix la bola)
        if (bolaY < iaY + 30) iaY -= 3;
        else if (bolaY > iaY + 30) iaY += 3;

        // Reinicia si la bola surt per l'esquerra o dreta
        if (bolaX < 0 || bolaX > getWidth()) {
            bolaX = 300;
            bolaY = 200;
            bolaDX *= -1;
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) jugadorY -= 20;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) jugadorY += 20;
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.add(new Pong());
        frame.setVisible(true);
    }
}
