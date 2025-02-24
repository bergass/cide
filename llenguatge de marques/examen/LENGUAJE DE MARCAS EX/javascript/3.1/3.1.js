const body = document.body; // selecciona el cuerpo del documento

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