package com.example;

//Albert Bergas Consuegra
//DNI: 45185379Q

interface graella { //crea la interficie grealla

    public void posarCarnAGraella(); //crea el metode per a les classes que implementin la interficie

    public void llevarCarnDeGraella(); //crea el metode per a les classes que implementin la interficie

    public boolean estaFet(); //crea el metode per a les classes que implementin la interficie
}

interface menjar {

    public void assabori(); //crea el metode per a les classes que implementin la interficie

    public boolean crema(); //crea el metode per a les classes que implementin la interficie

}

public class Main {
    public static void main(String[] args) {
        torrada miTorrada = new torrada(); //crea una torrada
        botifarro miBotifarro = new botifarro();  //crea un botifarro
        sobrassada miSobrassada = new sobrassada(); //crea una sobrassada
        miBotifarro.posarCarnAGraella();  //fe el metode de mibotifarro
        miSobrassada.posarCarnAGraella(); //fe el metode de misobrassada

        boolean botifarroFet;
        boolean sobrassadaFeta;

        do {  //fes aixo
            botifarroFet = miBotifarro.estaFet();//fe el metode de mibotifarro
            sobrassadaFeta = miSobrassada.estaFet();//fe el metode de misobrassada
            if (botifarroFet == true && sobrassadaFeta == false) {//si un esta fet i s'altre no
                System.out.println("El botifarro esta fet i la sobrassada esta crua. He d'esperar");//imprimeix
            } else if (botifarroFet == false && sobrassadaFeta == true) {//si un no esta fet i s'altre si
                System.out.println("El botifarro esta cru i la sobrassada esta feta. He d'esperar");//imprimeix
            } else if (botifarroFet == true && sobrassadaFeta == true) {//si els dos estan fets
                System.out.println("El botifarro esta fet i la sobrassada esta feta. Ja puc anar a sopar");//imprimeix
                botifarroFet = true;
                sobrassadaFeta = true;
                miBotifarro.assabori();
                miSobrassada.assabori();
            } else if (botifarroFet == false && sobrassadaFeta == false) {// si els dos no estan fets
                System.out.println("El botifarro esta cru i la sobrassada esta cru. He d'esperar");//imprimeix
            }
        }while (botifarroFet == false || sobrassadaFeta == false);//mentre un dels dos sigui false(no estigui fet)
    }
}
