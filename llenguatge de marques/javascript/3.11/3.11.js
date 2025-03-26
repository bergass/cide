const origen = document.getElementById('origen');
const destino = document.getElementById('destino');
const fechaIni = document.getElementById('fechaIni');
const fechaFi = document.getElementById('fechaFi');
const numAdultos = document.getElementById('numAdultos');
const numNiños = document.getElementById('numNiños');
const descuentos = document.getElementById('descuentos');
const formulario = document.getElementById('formulario');
const btnBuscar = document.getElementById('buscar');

function prufOrigenDestino() {
    var origen = origen.value;
    var destino = destino.value;

    if (origen == destino) {
        alert('Origen y destino NO pueden ser el mismo');
        destino.value = '1';
    }
}

function prufFechas() {
    var hoy = new Date().toISOString().split('T')[0];
    
    fechaIni.setAttribute('min', hoy);

    fechaIni.addEventListener('change', function() {
        fechaFi.setAttribute('min', fechaIni.value);
    });

    fechaFi.addEventListener('change', function() {
        if (fechaFi.value < fechaIni.value) {
            alert('La fecha de fin no puede ser anterior a la fecha de inicio');
            fechaFi.value = '';
        }
    });
}

function prufDescuentos() {
    if (descuentos.value === 'residente') {
        var origen = origen.value;
        var destino = destino.value;

        
        var esValida =
            (origen === 'PMI' && (destino === 'BCN' || destino === 'MAD')) ||
            (destino === 'PMI' && (origen === 'BCN' || origen === 'MAD'));

        if (esValida) {
            alert('El descuento de residente se aplica correctamente.');
        } else {
            alert('Para aplicar el descuento de residente, el origen debe ser Palma y el destino Madrid o Barcelona (o a la inversa).');
            descuentos.value = 'sinDescuento'; 
        }
    }
}

function obtenerInfo(evento) {
    evento.preventDefault(); // Evitar que el formulario se envie
    // guardamos en session, pero podria ser local
    sessionStorage.setItem('origen', origen.value);
    sessionStorage.setItem('destino', destino.value);
    sessionStorage.setItem('fechaIni', fechaIni.value);
    sessionStorage.setItem('fechaFi', fechaFi.value);
    sessionStorage.setItem('numAdultos', numAdultos.value);
    sessionStorage.setItem('numNiños', numNiños.value);
    sessionStorage.setItem('descuentos', descuentos.value);

    window.location.href = 'confirmacion.html';

}

destino.addEventListener('change', prufOrigenDestino);
fechaIni.addEventListener('mouseleave', prufFechas);
descuentos.addEventListener('change', prufDescuentos);
elFormulario.addEventListener('submit', obtenerInfo);