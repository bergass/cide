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
import java.awt.event.KeyListener; // importa la clase keylistener para manejar eventos de teclado

// Albert Bergas Consuegra

public class juego extends JPanel implements ActionListener, KeyListener { // define la clase juego que extiende jpanele
                                                                           // implementa actionlistener y keylistener

    pelota pelota; // declara una variable de tipo pelota
    pala palaI; // declara una variable de tipo pala para la pala izquierda
    pala palaD; // declara una variable de tipo pala para la pala derecha
    private int c1; // declara una variable privada para el contador 1
    private int c2; // declara una variable privada para el contador 2
    private final Timer TIMER; // declara una variable final para el temporizador
    String N1; // declara una variable para el nombre del jugador 1
    String N2; // declara una variable para el nombre del jugador 2
    private boolean wPulsado, sPulsado, upPulsado, downPulsado = false; // declara variables booleanas paralas teclas
                                                                        // presionadas

    public juego(String N1, String N2) { // constructor de la clase juego

        this.N1 = N1; // asigna el nombre del jugador 1
        this.N2 = N2; // asigna el nombre del jugador 2
        setBackground(Color.WHITE); // establece el color de fondo del panel
        pelota = new pelota(); // crea una nueva pelota
        palaI = new pala(); // crea una nueva pala izquierda
        palaD = new pala(); // crea una nueva pala derecha
        setFocusable(true); // establece el panel como enfocable
        requestFocusInWindow(); // no se porque se pone pero se tiene que poner
        addKeyListener(this); // añade el metodo KeyListener para que el juego pueda interpretar entradas
                              // deteclado
        TIMER = new Timer(pelota.getRetraso(), this); // crea un nuevo temporizador con el retraso de la pelota
        TIMER.start(); // inicia el temporizador
    }

    @Override
    public void keyPressed(KeyEvent e) { // metodo para manejar eventos de teclado
        int tecla = e.getKeyCode(); // obtiene el codigo de la tecla presionada
        // Actualizar el estado de las teclas
        if (tecla == KeyEvent.VK_W) { // si se presiona la tecla W
            wPulsado = true; // establece la variable wPressed como verdadera
        } else if (tecla == KeyEvent.VK_S) { // si se presiona la tecla S
            sPulsado = true; // establece la variable sPressed como verdadera
        } else if (tecla == KeyEvent.VK_UP) { // si se presiona la tecla de flecha arriba
            upPulsado = true; // establece la variable upPressed como verdadera
        } else if (tecla == KeyEvent.VK_DOWN) { // si se presiona la tecla de flecha abajo
            downPulsado = true; // establece la variable downPressed como verdadera
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { // metodo para manejar eventos de teclado
        int tecla = e.getKeyCode(); // obtiene el codigo de la tecla liberada
        if (tecla == KeyEvent.VK_W) { // si se suelta la tecla W
            wPulsado = false; // establece la variable wPressed como falsa
        } else if (tecla == KeyEvent.VK_S) { // si se suelta la tecla S
            sPulsado = false; // establece la variable sPressed como falsa
        } else if (tecla == KeyEvent.VK_UP) { // si se suelta la tecla de flecha arriba
            upPulsado = false; // establece la variable upPressed como falsa
        } else if (tecla == KeyEvent.VK_DOWN) { // si se suelta la tecla de flecha abajo
            downPulsado = false; // establece la variable downPressed como falsa
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { // metodo para manejar eventos de teclado
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
        palaD.setX(getWidth() - 40); // establece la posicion x de la pala derecha
        palaI.setX(getWidth() - 760); // establece la posicion x de la pala izquierda
        g2d.fillRect(palaD.getX(), palaD.getY(), palaD.getAncho(), palaD.getAlto()); // dibuja la pala derecha
        c1 = pelota.getContador2(); // obtiene el contador 2 de la pelota
        c2 = pelota.getContador1(); // obtiene el contador 1 de la pelota

        Font font = new Font("Arial", Font.BOLD, 30); // define una nueva fuente
        g2d.setFont(font); // establece la nueva fuente
        g2d.setColor(Color.BLACK); // establece el color negro
        g2d.drawString(N1 + " " + String.valueOf(c1), (getWidth() - 650), getHeight() - 400); // dibuja el nombre y contador del jugador 1
        g2d.drawString(N2 + " " + String.valueOf(c2), (getWidth() - 300), getHeight() - 400); // dibuja el nombre y contador del jugador 2
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 20)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 60)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 100)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 140)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 180)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 220)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 260)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 300)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 340)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 380)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 420)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 460)); // dibuja una linea vertical
        g2d.drawString("|", (getWidth() / 2), (getHeight() - 500)); // dibuja una linea vertical
    }

    @Override
    public void actionPerformed(ActionEvent e) { // metodo para manejar eventos de accion
        if (wPulsado) { // mover la pala izquierda
            palaI.moverPala(-15, getHeight()); // mueve la pala izquierda hacia arriba
        }
        if (sPulsado) { // mover la pala izquierda
            palaI.moverPala(15, getHeight()); // mueve la pala izquierda hacia abajo
        }
        if (upPulsado) { // mover la pala derecha
            palaD.moverPala(-15, getHeight()); // mueve la pala derecha hacia arriba
        }
        if (downPulsado) { // mover la pala derecha
            palaD.moverPala(15, getHeight()); // mueve la pala derecha hacia abajo
        }
        pelota.moverPelota(this); // mueve la pelota
        pelota.moverPelota2(palaI); // mueve la pelota considerando la pala izquierda
        pelota.moverPelota2(palaD); // mueve la pelota considerando la pala derecha
        repaint(); // repinta el panel
    }
}