function buscar() {
    var origen = document.getElementById("origen").value;
    var destino = document.getElementById("destino").value;
    var fechaInici = document.getElementById("fechaIni").value;
    var fechaFi = document.getElementById("fechaFi").value;
    var numAdultos = document.getElementById("numAdultos").value;
    var numNiños = document.getElementById("numNiños").value;
    var descuentos = document.getElementById("descuentos").value;
    const today = new Date().toISOString().split('T')[0];

    if (origen === destino) {
        alert('El origen y el destino no pueden ser iguales.');
        return false;
    }

    if (fechaInici < today) {
        alert('La fecha de inicio no puede ser en el pasado.');
        return false;
    }

    if (fechaFi < today) {
        alert('La fecha de fin no puede ser en el pasado.');
        return false;
    }

    if (fechaFi < fechaInici) {
        alert('La fecha de fin no puede ser anterior a la fecha de inicio.');
        return false;
    }

    document.getElementById("origenRes").textContent = origen;
    document.getElementById("destinoRes").textContent = destino;
    document.getElementById("fechaIniciRes").textContent = fechaInici;
    document.getElementById("fechaFiRes").textContent = fechaFi;

    // Redirigir a 3.11.resultados.html
    window.location.href = '3.11.resultados.html';
    return true;
} 