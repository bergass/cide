const body = document.body; // selecciona el cuerpo del documento
let createdElements = []; // array para almacenar los elementos creados

function augmentar() { // funcion para aumentar el tamaño de la fuente del cuerpo
    const currentSize = parseFloat(window.getComputedStyle(body).fontSize); // obtiene el tamaño actual de la fuente
    body.style.fontSize = (currentSize + 2) + 'px'; // incrementa el tamaño de la fuente en 2px
}

function disminuir() { // funcion para disminuir el tamaño de la fuente del cuerpo
    const currentSize = parseFloat(window.getComputedStyle(body).fontSize); // obtiene el tamaño actual de la fuente
    body.style.fontSize = (currentSize - 2) + 'px'; // disminuye el tamaño de la fuente en 2px
}

function canviarColor() { // funcion para cambiar el color del texto del cuerpo
    const currentColor = window.getComputedStyle(body).color; // obtiene el color actual del texto
    if (currentColor === 'rgb(0, 0, 0)') { // si el color es negro
        body.style.color = 'red'; // cambia el color a rojo
    } else {
        body.style.color = 'black'; // cambia el color a negro
    }
}

function afegirElement() { // funcion para añadir un nuevo parrafo al cuerpo
    const text = prompt('Introdueix el text per al nou paràgraf:'); // solicita al usuario que introduzca el texto
    if (text) { // si el usuario introduce texto
        const paragraf = document.createElement('p'); // crea un nuevo elemento parrafo
        paragraf.innerText = text; // establece el texto del parrafo
        document.body.appendChild(paragraf); // añade el parrafo al cuerpo del documento
        createdElements.push(paragraf); // guarda el parrafo en el array de elementos creados
    }
}

function suprimirElement() { // funcion para eliminar los parrafos añadidos
    if (createdElements.length > 0) { // si hay elementos creados
        createdElements.forEach(element => { // recorre el array de elementos creados
            document.body.removeChild(element); // elimina cada elemento del cuerpo del documento
        });
        createdElements = []; // vacia el array de elementos creados
    } else {
        alert('No hi ha cap paràgraf per eliminar.'); // muestra un mensaje si no hay elementos para eliminar
    }
}