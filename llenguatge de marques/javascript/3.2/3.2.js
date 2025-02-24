const augmentarButton = document.getElementById('augmentar');
const disminuirButton = document.getElementById('disminuir');
const cambiarColorButton = document.getElementById('cambiarColor');
const body = document.body;

function augmentar() {
    const currentSize = parseFloat(window.getComputedStyle(body).fontSize);
    body.style.fontSize = (currentSize + 2) + 'px';
};

function disminuir() {
    const currentSize = parseFloat(window.getComputedStyle(body).fontSize);
    body.style.fontSize = (currentSize - 2) + 'px';
};

function canviarColor() {
    const currentColor = window.getComputedStyle(body).color;
    if (currentColor === 'rgb(0, 0, 0)') { // black
        body.style.color = 'red';
    } else {
        body.style.color = 'black';
    }
};

function afegirElement() {
    var ventana = prompt('introdueix el text');
    var paragraf = document.createElement('p');
    paragraf.innerHTML = ventana;
    document.body.appendChild(paragraf);
    borrar = paragraf;
};

function suprimirElement() {
    document.body.removeChild(borrar);
}

