function augmentar() { // funcion para aumentar el tamaño de la fuente del cuerpo
    var body = document.body; // selecciona el cuerpo del documento
    var currentSize = parseFloat(window.getComputedStyle(body).fontSize); // obtiene el tamaño actual de la fuente
    body.style.fontSize = (currentSize + 2) + 'px'; // incrementa el tamaño de la fuente en 2px
}

function disminuir() { // funcion para disminuir el tamaño de la fuente del cuerpo
    var body = document.body; // selecciona el cuerpo del documento
    var currentSize = parseFloat(window.getComputedStyle(body).fontSize); // obtiene el tamaño actual de la fuente
    body.style.fontSize = (currentSize - 2) + 'px'; // disminuye el tamaño de la fuente en 2px
}

function canviarColor() { // funcion para cambiar el color del texto del cuerpo
    var body = document.body; // selecciona el cuerpo del documento
    var currentColor = window.getComputedStyle(body).color; // obtiene el color actual del texto
    if (currentColor === 'rgb(0, 0, 0)') { // si el color es negro
        body.style.color = 'green'; // cambia el color a verde
    } else {
        body.style.color = 'black'; // cambia el color a negro
    }
}

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

function afegirClasse() { // funcion para añadir una clase al titulo
    var texto = document.getElementById('title'); // selecciona el titulo por su id
    texto.classList.add('classe44'); // añade la clase 'classe44' al titulo
}

function suprimirClasse() { // funcion para eliminar una clase del titulo
    var texto = document.getElementById('title'); // selecciona el titulo por su id
    texto.classList.remove('classe44'); // elimina la clase 'classe44' del titulo
}

function afegirNovaClasse() { // funcion para añadir una nueva clase al titulo
    var element = document.getElementById('title'); // selecciona el titulo por su id
    element.classList.add('novaClasse'); // añade la clase 'novaClasse' al titulo
}

function suprimirNovaClasse() { // funcion para eliminar una nueva clase del titulo
    var element = document.getElementById('title'); // selecciona el titulo por su id
    element.classList.remove('novaClasse'); // elimina la clase 'novaClasse' del titulo
}