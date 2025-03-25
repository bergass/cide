package com.example; // define el paquete de la clase

import java.awt.Color; // importa la clase color para definir colores
import java.awt.Font; // importa la clase font para definir fuentes
import java.awt.Graphics; // importa la clase graphics para dibujar
import java.awt.Graphics2D; // importa la clase graphics2d para mejorar el dibujo
import java.awt.event.ActionEvent; // importa la clase actionevent para manejar eventos
import java.awt.event.ActionListener; // importa la clase actionlistener para manejar eventos
import java.awt.event.KeyEvent; // importa la clase keyevent para manejar eventos de teclado
import javax.swing.JPanel; // importa la clase jpanel para crear paneles
import javax.swing.Timer; // importa la clase timer para manejar temporizadores

public class juego extends JPanel implements ActionListener { // define la clase juego que extiende jpanel e implementa actionlistener
    pelota pelota; // declara una variable de tipo pelota
    pala palaI; // declara una variable de tipo pala para la pala izquierda
    pala palaD; // declara una variable de tipo pala para la pala derecha
    private int c1; // declara una variable privada para el contador 1
    private int c2; // declara una variable privada para el contador 2
    private final Timer TIMER; // declara una variable final para el temporizador
    String N1; // declara una variable para el nombre del jugador 1
    String N2; // declara una variable para el nombre del jugador 2

    public juego(String N1, String N2) { // constructor de la clase juego
        this.N1 = N1; // asigna el nombre del jugador 1
        this.N2 = N2; // asigna el nombre del jugador 2
        setBackground(Color.WHITE); // establece el color de fondo del panel
        pelota = new pelota(); // crea una nueva pelota
        palaI = new pala(); // crea una nueva pala izquierda
        palaD = new pala(); // crea una nueva pala derecha
        palaI.addKeyListenerToComponent(this, KeyEvent.VK_W, KeyEvent.VK_S); // añade un keylistener a la pala izquierda
        palaD.addKeyListenerToComponent(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN); // añade un keylistener a la pala derecha
        setFocusable(true); // establece el panel como enfocable
        TIMER = new Timer(pelota.getRetraso(), this); // crea un nuevo temporizador con el retraso de la pelota
        TIMER.start(); // inicia el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) { // metodo para pintar el componente
        super.paintComponent(g); // llama al metodo paintcomponent de la clase padre
        Graphics2D g2d = (Graphics2D) g; // convierte el graphics a graphics2d
        g2d.setColor(Color.RED); // establece el color rojo
        g2d.fillOval(pelota.getX(), pelota.getY(), pelota.getRadio() * 2, pelota.getRadio() * 2); // dibuja la pelota
        g2d.setColor(Color.RED); // establece el color rojo
        g2d.fillRect(palaI.getX(), palaI.getY(), palaI.getAncho(), palaI.getAlto()); // dibuja la pala izquierda
        g2d.setColor(Color.RED); // establece el color rojo
        palaD.setX(746); // establece la posicion x de la pala derecha
        g2d.fillRect(palaD.getX(), palaD.getY(), palaD.getAncho(), palaD.getAlto()); // dibuja la pala derecha
        c1 = pelota.getContador2(); // obtiene el contador 2 de la pelota
        c2 = pelota.getContador1(); // obtiene el contador 1 de la pelota

        Font font = new Font("Arial", Font.BOLD, 30); // define una nueva fuente
        g2d.setFont(font); // establece la nueva fuente
        g2d.setColor(Color.BLACK); // establece el color negro

        g2d.drawString(N1+" "+ String.valueOf(c1), (getWidth()-650), 50); // dibuja el nombre y contador del jugador 1
        g2d.drawString(N2+" "+String.valueOf(c2), (getWidth()-300), 50); // dibuja el nombre y contador del jugador 2

        g2d.drawString("|", (getWidth()/2), (getHeight()-20)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-60)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-100)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-140)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-180)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-220)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-260)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-300)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-340)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-380)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-420)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-460)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth()/2), (getHeight()-500)); // dibuja una linea vertical
    }

    @Override
    public void actionPerformed(ActionEvent e) { // metodo para manejar eventos de accion
        pelota.moverPelota(this); // mueve la pelota
        pelota.moverPelota2(palaI); // mueve la pelota considerando la pala izquierda
        pelota.moverPelota2(palaD); // mueve la pelota considerando la pala derecha
        repaint(); // repinta el panel
    }
}