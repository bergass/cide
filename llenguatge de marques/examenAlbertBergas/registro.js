const nombre = document.getElementById("nombre");
const fechaNacimiento = document.getElementById("fechaNacimiento");
const email = document.getElementById("email");
const ciudad = document.getElementById("ciudad");
const codigoPostal = document.getElementById("codigoPostal");
const categoria = document.getElementById("categoria");
const newsletter = document.getElementById("newsletter");
const formulario = document.getElementById("registroForm")

function validarFechas() {
    const hoy = new Date();
    hoy.setHours(0, 0, 0, 0);

    const fechaNacimiento = new Date(fechaNacimiento.value);
    fechaNacimiento.setHours(0, 0, 0, 0);

    if (fechaNacimiento > hoy) {
        alert("La fecha de inicio no puede ser en futuro.");
        return false;
    }

    return true;
}

function validarCodigoPostal() {
    
}

function validarFormulario(evento) {
    if (!validarFechas()) {
        evento.preventDefault();
        return;
    }
    alert("Formulario válido. Redirigiendo...");
}

formulario.addEventListener("submit", validarFormulario);