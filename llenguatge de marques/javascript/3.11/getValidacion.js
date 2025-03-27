const origen = document.getElementById("origen");
const destino = document.getElementById("destino");
const fechaIni = document.getElementById("fechaIni");
const fechaFi = document.getElementById("fechaFi");
const adultos = document.getElementById("adultos");
const niños = document.getElementById("niños");
const descuentos = document.getElementById("descuentos");
const formulario = document.getElementById("formulario");

function validarOriDes() {
    const valoresValidos = ["Palma", "Madrid", "Barcelona", "Londres", "Paris", "Roma"];
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
        return false; /*Se utiliza para indicar que la validación ha fallado.
        Por ejemplo, si el origen y el destino son iguales, la función 
        validarOriDes devuelve false, lo que significa que el formulario
         no debe proceder.*/
    }

    return true;/*Se utiliza para indicar que la validación fue exitosa.
    Si no hay problemas con los valores validados, la función devuelve 
    true, lo que permite continuar con el flujo normal del programa.*/
}

function validarFechas() {
    const hoy = new Date(); // Fecha actual
    const fechaInicio = new Date(fechaIni.value); // Convertir fecha de inicio a objeto Date

    if (fechaInicio.value < hoy) {
        alert("La fecha de inicio no puede ser en el pasado");
        return false;
    }

    if (fechaFi.value < hoy) {
        alert("La fecha de fin debe ser mayor a la de inicio");
        return false;
    }

    if (fechaFi.value <= fechaInicio.value) {
        alert("La fecha de fin debe ser mayor a la fecha de inicio");
    }
    return true;
}

function validarNumeros() {
    if (adultos.value < 1) {
        alert("El numero de adultos debe ser como minimo 1");
        return false;
    }

    if (niños.value < 0) {
        alert("El numero de niños no puede ser negativo");
        return false;
    }

    return true
}

function validarDescuentos() {
    if (descuentos.value === "Descuentos Residente") {
        const esValida =
        (origen.value === "Palma" && (destino.value === "Madrid") && (destino.value === "Barcelona"));
        (destino.value === "Palma" && (origen.value === "Madrid") && (origen.value === "Barcelona"));

        if (!esValida) {
            alert ("Para el descuento residente palma tiene que ser el origen o el destino ");
            descuentos.value = "";
            return false;
        }
        return true;
    }
}

function validarFormulario(evento) {

    if(validarOriDes() && validarFechas() && validarDescuentos() && validarNumeros()) {
        evento.preventDefault();
        return;
    }
    alert("Formulario válido. Redirigiendo...");

}
// Asociar la validación al evento submit del formulario

formulario.addEventListener("submit", validarFormulario);