var cuenta = 0;

function contar() {
    var paragraf = document.getElementById("mostrarClicks");
    var btnContar = document.getElementById("contar");
    var btnReiniciar = document.getElementById("reiniciar");

        cuenta++;
        paragraf.textContent = cuenta;
    
    if (cuenta == 10) {
        btnContar.style.display = "none";
        btnReiniciar.style.display = "flex";
    }

}
function reiniciar() {
    var paragraf = document.getElementById("mostrarClicks");
    var btnContar = document.getElementById("contar");
    var btnReiniciar = document.getElementById("reiniciar");

    cuenta = 0;
    paragraf.textContent = cuenta;
    btnReiniciar.style.display = "none";
    btnContar.style.display = "flex";
}

function afegir() {
    var comentaris = document.getElementById("comentaris"); // Campo de texto
    var divComentaris = document.getElementById("comentarisAfegits"); // Contenedor de comentarios

    // Obtener el texto del campo y convertirlo a minúsculas
    var textComentari = comentaris.value.trim().toLowerCase();

    // Validar que no esté vacío
    if (textComentari !== "") {
        // Crear un nuevo párrafo para el comentario
        var nouParagraf = document.createElement("p");
        nouParagraf.textContent = textComentari;

        // Añadir el nuevo comentario al contenedor
        divComentaris.appendChild(nouParagraf);

        // Limpiar el campo de texto
        comentaris.value = "";
    } else {
        alert("El camp de comentaris no pot estar buit."); // Mensaje de alerta
    }
}
function borrar() {
    var divComentaris = document.getElementById("comentarisAfegits"); // Contenedor de comentarios

    // Verificar si hay comentarios para eliminar
    if (divComentaris.lastChild) {
        divComentaris.removeChild(divComentaris.lastChild); // Eliminar el último comentario
    } else {
        alert("No hi ha més comentaris per eliminar."); // Mensaje si no hay comentarios
    }
}