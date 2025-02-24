package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class f {
    public static void main(String[] args) {
        // creem el JFrame principal
        JFrame finestra = new JFrame("Exemple de JDialog");
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());
        // boto per obrir el dialog
        JButton botoObrir = new JButton("Obrir dialeg");
        finestra.add(botoObrir);
        // afegim un listener per obrir el JDialog quan es premi
        botoObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        // fem visible la finestra principal
      
        //metode per crear i mostrar un JDialog
            
        finestra.setVisible(true);
    }

}