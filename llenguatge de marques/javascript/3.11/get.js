document.addEventListener('DOMContentLoaded', function () {
    const params = new URLSearchParams(window.location.search);

    // Recoger los datos del GET
    const origen = params.get("origen");
    const destino = params.get("destino");
    const fechaIni = params.get("fechaIni");
    const fechaFi = params.get("fechaFi");
    const adultos = params.get("adultos");
    const niños = params.get("niños");
    const descuentos = params.get("descuentos");

    // Crear el contenido HTML para mostrar los resultados
    const resultadosDiv = document.getElementById("resultados");
    if (resultadosDiv) {
        resultadosDiv.innerHTML = `
            <p><strong>Origen:</strong> ${origen}</p>
            <p><strong>Destino:</strong> ${destino}</p>
            <p><strong>Fecha de ida:</strong> ${fechaIni}</p>
            <p><strong>Fecha de vuelta:</strong> ${fechaFi || "No especificada"}</p>
            <p><strong>Adultos:</strong> ${adultos}</p>
            <p><strong>Niños:</strong> ${niños}</p>
            <p><strong>Descuento aplicado:</strong> ${descuentos}</p>
        `;
    }
});