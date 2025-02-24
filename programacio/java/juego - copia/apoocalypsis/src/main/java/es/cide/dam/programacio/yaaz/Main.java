package es.cide.dam.programacio.yaaz; /* relaciona totes les classes i el main */
import java.util.Scanner; /* importa un escaner */
import java.util.Random; /* importa un random */

/**************************************/
/* Nom: Albert Bergas Consuegra 				*/
/* DNI/NIE: 45185379Q 			*/
/* Data: 29/11/2024 				*/
/* Exercici: PROU3EX02				*/
/**************************************/

public class Main {
    public static void main(String[] args) { 
        int resultatAtac = 0; /* instancia la variable de l'atac del supervivent */
        int salutZombie = 0; /* instancia la variable de la salut del zombie */
        int salutSupervivent = 0; /* instancia la variable de la slut del supervivent */
        int resultatAtacZombie = 0; /* instancia la variable de l'atac del zombie*/
        int numZombie = 1; /* instancia la variable del numero que surt el zombie */
        Scanner sc = new Scanner(System.in); /* crea un escaner */
        Random random = new Random(); /* crea un random, per poder fer numeros aleatoris */
        
        System.out.println("Dim el nom del Supervivent"); /* imprimeix el missatge */
        supervivent chuckNorris = new supervivent(sc.nextLine()); /* crea un supervivent anomenat chuckNorris, pero es el nom que "veu" la maquina, l'usuari l'hi posara el nom que vulgui */
        
        System.out.println("Dim el nom de la ciutat on es lluitara la batalla"); /* imprimeix el missatge  */
        ciutat palma = new ciutat(sc.nextLine(), random.nextInt(6) + 5); /* crea una ciutat anomenada palma, que es la que "veu" la maquina */
        
        for (int i = 0; i < palma.getTamany(); i++) { /* bucle for per recorre zombies els zombies */
            numZombie++; /* cada vegada es suma a ell mateix */
            zombie zombiePaco = palma.posicioRuta(i); /* asigna un zombie del metode posicio.ruta de la ciutat segons la i del bucle  */
            salutSupervivent = chuckNorris.getSalut(); /* asigna la salut del supervivent al get salut de la clase supervivent */
            salutZombie = zombiePaco.getSalut(); /* asigna la salut del zombie al get salut de la clase zombie */
            
            while (salutZombie > 0 && salutSupervivent > 0) { /* mentre la salut del zombie i la del supervivent siguin major que 0, si un dels dos mor s'atura el while */
                resultatAtac = chuckNorris.ataca() - zombiePaco.defensat(); /* asigna al resultat del atac el resultat de l'ataca del supervivent menos el defensat del zombie */
                if (resultatAtac < 0) { /* si el resultat de l'atac es menor que 0 */
                    resultatAtac = 0; /* el resultat de l'atac es igual a 0 */
                }
                
                salutZombie = salutZombie - resultatAtac; /* asigna la salut del zombie al resultat de la salut del zombie menos el resultat de l'atac */
                System.out.println("El ataque ha quitado " + resultatAtac + " de vida"); /* imprimeix el missatge relacionat amb el resultat de l'atac */
                System.out.println("El zombie " + numZombie + " te " + salutZombie + " de vida"); /* imprimeix el missatge relacionat amb el nombre el zombie i la seva salut */
                
                if (salutZombie > 0) { /* si la salut del zombie es major que 0 */
                    resultatAtacZombie = zombiePaco.ataca() - chuckNorris.defensat(); /* asigna al resultat de l'atac del zombie el resultat de l'atac del zombie menos la defensa del supervivent */
                    
                    if (resultatAtacZombie < 0) { /* si resultat de l'atac del zombie es menor que 0 */
                        resultatAtacZombie = 0; /* resultat de l'atac del zombie es igual a 0 */
                    }
                    salutSupervivent = salutSupervivent - resultatAtacZombie; /* asigna al resultat de la salut del supervivent el resultat de salut del supervivent menos el resultat de l'atac del zombie */
                    System.out.println("El ataque ha quitado " + resultatAtacZombie + " de vida"); /* imprimeix el missatge relacionat amb l'atac del zombie */
                    System.out.println(chuckNorris.getNom() + " te " + salutSupervivent + " de vida"); /* imprimeix el missatge relacionat amb la salut del supervivent */
                }
            }
            
            if (salutZombie <= 0) { /* si la salut del zombie es menor o igual a 0 */
                System.out.println("El zombie " + numZombie + " ha mort"); /* imprimeix el missatge de mort del zombie */
            }

            
            if (i != (palma.getTamany() - 1)) { /* quan i sigui el numero abans del tamany de la ciutat no fara l'if quan aparegui el darrer zombie de l'array  */
                System.out.println("Surt al pas el zombie " + (numZombie + 1)); /* imprimeix el missatge relacionat amb el zombie següent */
            }
        }
        
        if (salutSupervivent <= 0) { /* si la salut del supervivent es menor o igual a 0 */
            System.out.println(chuckNorris.getNom() + " ha mort"); /* imprimeix que el supervivent ha mort */
        }
        
        if (salutSupervivent > 0) { /* si la salut del supervivent es major a 0 */
            System.out.println(chuckNorris.getNom() + " Ha sobreviscut"); /* imprimeix que el supervivent ha sobreviscut */
        }
        sc.close(); /* tanca l'escaner */
    }
}