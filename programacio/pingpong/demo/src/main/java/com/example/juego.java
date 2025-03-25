package com.example;

import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class juego extends JPanel implements ActionListener {
    pelota pelota;
    pala palaI;
    pala palaD;
    private int c1;
    private int c2;
    private final Timer TIMER;

    public juego() {
        setBackground(Color.WHITE);
        pelota = new pelota();
        palaI = new pala();
        palaD = new pala();
        palaI.addKeyListenerToComponent(this, KeyEvent.VK_W, KeyEvent.VK_S);
        palaD.addKeyListenerToComponent(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        setFocusable(true);
        TIMER = new Timer(pelota.getRetraso(), this);
        TIMER.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método paintComponent de la clase padre, para que se encargue de la
                                 // parte pesada de la pintura
        Graphics2D g2d = (Graphics2D) g; // Conversión a Graphics2D para mejorar el dibujo
        g2d.setColor(Color.RED); // Define el color del círculo
        g2d.fillOval(pelota.getX(), pelota.getY(), pelota.getRadio() * 2, pelota.getRadio() * 2); // Dibuja el círculo
                                                                                                  // en las coordenadas
                                                                                                  // x, y con el radio
        g2d.setColor(Color.RED); // Define el color del círculo
        g2d.fillRect(palaI.getX(), palaI.getY(), palaI.getAncho(), palaI.getAlto()); // Dibuja la pala derecha
        g2d.setColor(Color.RED); // Define el color del círculo
        palaD.setX(746);
        g2d.fillRect(palaD.getX(), palaD.getY(), palaD.getAncho(), palaD.getAlto()); // Dibuja la pala derecha
        c1 = pelota.getContador2();
        c2 = pelota.getContador1();

        Font font = new Font("Arial", Font.BOLD, 30); // Define una nueva fuente
        g2d.setFont(font); // Establece la nueva fuente
        g2d.setColor(Color.BLACK); // Define el color del círculo

        g2d.drawString("Jugador 1: "+String.valueOf(c1), (getWidth()-650), 50);
        g2d.drawString("Jugador 2: "+String.valueOf(c2), (getWidth()-300), 50);

        g2d.drawString("|", (getWidth()/2), (getHeight()-20));
        g2d.drawString("|", (getWidth()/2), (getHeight()-60));
        g2d.drawString("|", (getWidth()/2), (getHeight()-100));
        g2d.drawString("|", (getWidth()/2), (getHeight()-140));
        g2d.drawString("|", (getWidth()/2), (getHeight()-180));
        g2d.drawString("|", (getWidth()/2), (getHeight()-220));
        g2d.drawString("|", (getWidth()/2), (getHeight()-260));
        g2d.drawString("|", (getWidth()/2), (getHeight()-300));
        g2d.drawString("|", (getWidth()/2), (getHeight()-340));
        g2d.drawString("|", (getWidth()/2), (getHeight()-380));
        g2d.drawString("|", (getWidth()/2), (getHeight()-420));
        g2d.drawString("|", (getWidth()/2), (getHeight()-460));
        g2d.drawString("|", (getWidth()/2), (getHeight()-500));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        pelota.moverPelota(this);
        pelota.moverPelota2(palaI);
        pelota.moverPelota2(palaD);
        repaint();
    }
}
