function mostrarResultados() {
    var resultados = document.getElementById('resultados');

    // Recuperar los datos almacenados en sessionStorage
    var origen = sessionStorage.getItem('origen');
    var destino = sessionStorage.getItem('destino');
    var fechaIni = sessionStorage.getItem('fechaIni');
    var fechaFi = sessionStorage.getItem('fechaFi');
    var adultos = sessionStorage.getItem('adultos');
    var niños = sessionStorage.getItem('niños');
    var descuentos = sessionStorage.getItem('descuentos');

    // Crear el contenido HTML para mostrar los resultados
    var datosRes = `
        <p><strong>Origen:</strong> ${origen}</p>
        <p><strong>Destino:</strong> ${destino}</p>
        <p><strong>Fecha de ida:</strong> ${fechaIni}</p>
        <p><strong>Fecha de vuelta:</strong> ${fechaFi}</p>
        <p><strong>Adultos:</strong> ${adultos}</p>
        <p><strong>Niños:</strong> ${niños}</p>
        <p><strong>Descuento aplicado:</strong> ${descuentos}</p>
    `;

    // Insertar el contenido en el div de resultados
    if (resultados) {
        resultados.innerHTML = datosRes;
    }
}

// Ejecutar la función cuando el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', mostrarResultados);