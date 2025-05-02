package com.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class io {
    public static void main(String[] args) {
        try {
            escriureArxiu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escriureArxiu() throws IOException {
        FileOutputStream file = null;
        char caracter;
        String text = "En una galaxia muy muy lejana...";

        try {
            file = new FileOutputStream("datos.txt");
            for (int i = 0; i < text.length(); i++) {
                caracter = text.charAt(i);
                file.write((byte) caracter); // Escribimos el carácter como byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close(); // Cerramos el archivo en el bloque finally
            }
        }
    }
}
