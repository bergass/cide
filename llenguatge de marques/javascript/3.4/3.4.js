function augmentar() {
    var body = document.body;
    var currentSize = parseFloat(window.getComputedStyle(body).fontSize);
    body.style.fontSize = (currentSize + 2) + 'px';
};

function disminuir() {
    var body = document.body;
    var currentSize = parseFloat(window.getComputedStyle(body).fontSize);
    body.style.fontSize = (currentSize - 2) + 'px';
};

function canviarColor() {
    var body = document.body;
    var currentColor = window.getComputedStyle(body).color;
    if (currentColor === 'rgb(0, 0, 0)') { // black
        body.style.color = 'green';
    } else {
        body.style.color = 'black';
    }
};

function afegirElement() {
    var ventana = prompt('introdueix el text');
    if (ventana) {
        var paragraf = document.createElement('p');
        paragraf.textContent = ventana;
        document.body.appendChild(paragraf);
        borrar = paragraf;
    }
};

function suprimirElement() {
    document.body.removeChild(borrar);
}

function afegirClasse() {
    var texto = document.getElementById('title');
    texto.classList.add('classe44')
}
function suprimirClasse() {
    var texto = document.getElementById('title');
    texto.classList.remove('classe44')
}

function traduccionLetra() {
    var texto = document.getElementById("title"); 
    if (texto.innerHTML === "Hola buenos dias") {
        texto.innerHTML = "Hello good morning";
    } else {
        texto.innerHTML = "Hola buenos dias";
    }
}

function pasoEncima() {
    var traducirBoton = document.getElementById('traducirBoton'); 
    traducirBoton.classList.add("claseBoton"); 
}

    document.getElementById('botonTraducir').addEventListener('click', traduccionLetra);
    document.getElementById('pasoEncima').addEventListener('mouseover', pasoEncima);
