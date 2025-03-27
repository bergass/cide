const origen = document.getElementById("origen");
const destino = document.getElementById("destino");
const fechaIni = document.getElementById("fechaIni");
const fechaFi = document.getElementById("fechaFi");
const adultos = document.getElementById("adultos");
const niños = document.getElementById("niños");
const descuentos = document.getElementById("descuentos");
const formulario = document.getElementById("formulario");

function validarOriDes() {
    const valoresValidos = ["Palma", "Madrid", "Barcelona", "Londres", "Paris"];
    if (!valoresValidos.includes(origen.value)) {
        alert("El campo de origen tiene un valor no válido.");
        return false;
    }
    if (!valoresValidos.includes(destino.value)) {
        alert("El campo de destino tiene un valor no válido.");
        return false;
    }
    if (origen.value === destino.value) {
        alert("El origen y el destino no pueden ser el mismo");
        return false;
    }
    return true;
}

function validarFechas() {
    const hoy = new Date();
    hoy.setHours(0, 0, 0, 0);

    const fechaInicio = new Date(fechaIni.value);
    fechaInicio.setHours(0, 0, 0, 0);

    if (fechaInicio < hoy) {
        alert("La fecha de inicio no puede ser en el pasado.");
        return false;
    }

    if (fechaFi.value) {
        const fechaFin = new Date(fechaFi.value);
        fechaFin.setHours(0, 0, 0, 0);

        if (fechaFin < hoy) {
            alert("La fecha de fin no puede ser en el pasado.");
            return false;
        }

        if (fechaFin <= fechaInicio) {
            alert("La fecha de fin debe ser mayor a la fecha de inicio.");
            return false;
        }
    }

    return true;
}

function validarNumeros() {
    if (adultos.value < 1) {
        alert("El número de adultos debe ser como mínimo 1.");
        return false;
    }

    if (niños.value < 0) {
        alert("El número de niños no puede ser negativo.");
        return false;
    }

    return true;
}

function validarDescuentos() {
    if (descuentos.value === "Descuentos Residente") {
        const esValida =
            (origen.value === "Palma" && (destino.value === "Madrid" || destino.value === "Barcelona")) ||
            (destino.value === "Palma" && (origen.value === "Madrid" || origen.value === "Barcelona"));

        if (!esValida) {
            alert("Para el descuento residente, Palma debe ser el origen o el destino.");
            descuentos.value = "";
            return false;
        }
    }
    return true;
}

function validarFormulario(evento) {
    if (!validarOriDes() || !validarFechas() || !validarDescuentos() || !validarNumeros()) {
        evento.preventDefault();
        return;
    }
    alert("Formulario válido. Redirigiendo...");
}

formulario.addEventListener("submit", validarFormulario);