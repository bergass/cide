const elFormulario = document.getElementById('elFormulario');
const laConfirmacion = document.getElementById('laConfirmacion');
const btnBuscar = document.getElementById('btnBuscar');

function mostrarConfirmacion() {
    var paisOrigen = sessionStorage.getItem('paisOrigen');
    var paisDestino = sessionStorage.getItem('paisDestino');
    var fechaInicio = sessionStorage.getItem('fechaInicio');
    var fechaFinal = sessionStorage.getItem('fechaVuelta');
    var adultos = sessionStorage.getItem('adultos');
    var ninyos = sessionStorage.getItem('ninyos');
    var descuentos = sessionStorage.getItem('descuentos');

    var datosConfirmados = `<h2>Confirmación de tu vuelo</h2>
        <p><strong>Origen:</strong> ${paisOrigen}</p>
        <p><strong>Destino:</strong> ${paisDestino}</p>
        <p><strong>Fecha de ida:</strong> ${fechaInicio}</p>
        <p><strong>Fecha de vuelta:</strong> ${fechaFinal}</p>
        <p><strong>Adultos:</strong> ${adultos}</p>
        <p><strong>Niños:</strong> ${ninyos}</p>
        <p><strong>Descuento aplicado:</strong> ${descuentos}</p>`;

    laConfirmacion.innerHTML = datosConfirmados;
}

document.addEventListener('DOMContentLoaded', mostrarConfirmacion);
