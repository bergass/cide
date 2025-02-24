package es.cide.dam.programacio.yaaz; /* relaciona totes les classes i el main */

import java.util.Random; /*importam un random */

/**************************************/
/* Nom: Albert Bergas Consuegra 				*/
/* DNI/NIE: 45185379Q 			*/
/* Data: 15/11/2024 				*/
/* Exercici: PROU3EX01				*/
/**************************************/

public class supervivent { /* comença a definir la classe supervivent */
    private Random random = new Random(); /* instancia per generar numeros aleatoris */
    private String nom; /* atribut de nom */
    private int salut; /* atribut de salut */
    private int ataque; /* atribut de ataque */
    private int defensa; /* atribut de defensa */
    private int golpe; /* atribut d'atac */
    private int recibirGolpe; /* atribut de defensat */

    public supervivent(String nomSupervivent) { /* constructor de supervivent */
        this.nom = nomSupervivent; /* asigna el nom escrit al atribut nom */
        this.salut = 100; /* inicialitza la variable salut amb un valor de 100 */
        this.ataque = 10; /* inicialitza la variable ataque amb un valor de 10 */
        this.defensa = 10; /* inicialitza la variable defensa amb un valor de 10 */
        System.out.println("He creat un supervivent"); /* imprimeix */
    }

    public void setNom(String nom1) { /* el metode setNom es public no volem que mos torni ninguna variable perque noltros li posam el valor del nom */
        this.nom = nom1; /* asigna el nom escrit al nom del supervivent */
        System.out.println("He canviat el nom de supervivent"); /* imprimeix */
    }

    public String getNom() { /* el metode getNom es public volem que mos torni un String que sera l'atribut nom que tengui en aquell moment */
        return nom; /* retorna el nom */
    }

    public void setSalut(int salut1) { /* el metode setNom es public no volem que mos torni ninguna variable perque noltros li posam el valor del salut */
        this.salut = salut1; /* asigna la salut escrita a la salut del supervivent */
        System.out.println("He canviat la salut de supervivent"); /* imprimeix */
    }

    public int getSalut() { /* el metode getSalut es public volem que mos torni un int que sera l'atribut salut que tengui en aquell moment */
        return salut; /* retorna la salut */
    }

    public void setAtaque(int ataque1) { /* el metode setNom es public no volem que mos torni ninguna variable perque noltros li posam el valor del ataque */
        this.ataque = ataque1; /* asigna l'ataque escrita a l'ataque del supervivent */
        System.out.println("He canviat l'ataca de supervivent"); /* imprimeix */
    }

    public int getAtaque() { /* el metode getAtaque es public volem que mos torni un int que sera l'atribut ataque que tengui en aquell moment */
        return ataque; /* retorna l'ataque */
    }

    public void setDefensa(int defensa1) { /* el metode setNom es public no volem que mos torni ninguna variable perque noltros li posam el valor del defensa */
        this.defensa = defensa1;
        System.out.println("He canviat la defensa de supervivent"); /* imprimeix */
    }

    public int getDefensa() { /* el metode getDefensa es public volem que mos torni un int que sera l'atribut defensa que tengui en aquell moment */
        return defensa; /* retorna la defensa */
    }

    public int ataca() { /* el metode ataca es public volem que mos torni un int */
        golpe = random.nextInt(ataque); /* iguala la variable golpe a un numero aleatori que estigui entre el maxim(ataque) i 0, i li sumam un perque no sigui atac 0 */
        System.out.println(this.nom+" ha atacat " + golpe); /* imprimeix l'atac que fa */
        return golpe; /* retorna la variable que mos dona golpe */
    }

    public int defensat() { /* el metode defensat es public volem que mos torni un int */
        recibirGolpe = random.nextInt(defensa); /* iguala la variable recibirGolpe a un numero aleatori que estigui entre el maxim(defensa) i 0, i li sumam un perque no sigui 0 */
        System.out.println(this.nom+" s'ha defensat " + recibirGolpe); /* imprimeix la defensa que fa */
        return recibirGolpe; /* retorna la variable que mos dona recibirGolpe */
    }
}
