function afegirElement() { // funcion para añadir un nuevo parrafo al cuerpo
    var ventana = prompt('introdueix el text'); // solicita al usuario que introduzca el texto
    if (ventana) { // si el usuario introduce texto
        var paragraf = document.createElement('p'); // crea un nuevo elemento parrafo
        paragraf.textContent = ventana; // establece el texto del parrafo
        document.body.appendChild(paragraf); // añade el parrafo al cuerpo del documento
        borrar = paragraf; // guarda el parrafo para poder eliminarlo despues
    }
}

function suprimirElement() { // funcion para eliminar el parrafo añadido
    document.body.removeChild(borrar); // elimina el parrafo del cuerpo del documento
}

let contar = 0;
const contadorElement = document.getElementById('mostrar')
const verd = document.getElementById('verd')

verd.addEventListener("click", ()=> {
    contar++;
    contadorElement.textContent = contar;
    if(contar>=10) {
        contadorElement.textContent = 10;
        const vermell = document.getElementById('vermell')

        vermell.classList.toggle('mostrar');
    }
});

vermell.addEventListener("click", ()=> {
    contar=0;
    contadorElement.textContent = contar;
    const vermell = document.getElementById('vermell')

    vermell.classList.remove('mostrar');

});