package es.cide.dam.programacio.yaaz; /* relaciona totes les classes i el main */

import java.util.Random; /*importam un random */

/**************************************/
/* Nom: Albert Bergas Consuegra 				*/
/* DNI/NIE: 45185379Q 			*/
/* Data: 15/11/2024 				*/
/* Exercici: PROU3EX01				*/
/**************************************/

public class zombie { /* comença a definir la classe zombie */
    private Random random = new Random(); /* instancia per generar numeros aleatoris */
    private int salut; /* atribut de salut */
    private int ataque; /* atribut d'atac */
    private int defensa; /* atribut de defensa */
    private int golpe; /* atribut d'atac */
    private int recibirGolpe; /* atribut de defensat  */

    public zombie() { /* constructor de la classe zombie */
        this.salut = 20; /* inicialitza la salut del zombie amb un valor de 20 */
        this.ataque = 5; /* inicialitza l'ataque del zombie amb un valor de 5 */
        this.defensa = 5; /* inicialitza la defensa del zombie amb un valor de 5 */
        System.out.println("he creat un zombie"); /* imprimeix un missatge */
    }

    public void setSalut(int salut1) { /* metode public per assignar un valor a la salut */
        this.salut = salut1; /* assigna el valor de salut1 a l'atribut salut */
        System.out.println("he canviat la salut de zombie"); /* imprimeix un missatge */
    }

    public int getSalut() { /* metode public per obtenir el valor de salut */
        return salut; /* retorna el valor actual de salut */
    }

    public void setAtaque(int ataque1) { /* metode public per assignar un valor a l'atac */
        this.ataque = ataque1; /* assigna el valor de ataque1 a l'atribut atac */
        System.out.println("he canviat l'ataca de zombie"); /* imprimeix un missatge */
    }

    public int getAtaque() { /* metode public per obtenir el valor de l'atac */
        return ataque; /* retorna el valor actual de l'atac */
    }

    public void setDefensa(int defensa1) { /* metode public per assignar un valor a la defensa */
        this.defensa = defensa1; /* assigna el valor de defensa1 a l'atribut defensa */
        System.out.println("he canviat la defensa de zombie"); /* imprimeix un missatge */
    }

    public int getDefensa() { /* metode public per obtenir el valor de la defensa */
        return defensa; /* retorna el valor actual de la defensa */
    }

    public int ataca() { /* metode public per calcular i retornar un valor d'atac */
        golpe = random.nextInt(ataque); /* genera un numero aleatori entre 0 i ataque */
        System.out.println("zombie ha atacat " + golpe); /* imprimeix el valor de l'atac */
        return golpe; /* retorna el valor de l'atac */
    }

    public int defensat() { /* metode public per calcular i retornar un valor de defensa */
        recibirGolpe = random.nextInt(defensa); /* genera un numero aleatori entre 0 i defensa */
        System.out.println("zombie ha defensat " + recibirGolpe); /* imprimeix el valor de la defensa */
        return recibirGolpe; /* retorna el valor de la defensa */
    }
}
