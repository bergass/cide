const inOrigen = document.getElementById('inOrigen');
const inDestino = document.getElementById('inDestino');
const fechaInicio = document.getElementById('fechaInicio');
const fechaFinal = document.getElementById('fechaFinal');
const inAdultos = document.getElementById('inAdultos');
const inNinyos = document.getElementById('inNinyos');
const inDescuentos = document.getElementById('inDescuentos');
const elFormulario = document.getElementById('elFormulario');
const btnBuscar = document.getElementById('btnBuscar');

function prufOrigenDestino() {
    var elOrigen = inOrigen.value;
    var elDestino = inDestino.value;

    if (elOrigen == elDestino) {
        alert('Origen y destino NO pueden ser el mismo');
        inDestino.value = '1';
    }
}

function prufFechas() {
    var hoy = new Date().toISOString().split('T')[0];
    
    fechaInicio.setAttribute('min', hoy);

    fechaInicio.addEventListener('change', function() {
        fechaFinal.setAttribute('min', fechaInicio.value);
    });

    fechaFinal.addEventListener('change', function() {
        if (fechaFinal.value < fechaInicio.value) {
            alert('La fecha de fin no puede ser anterior a la fecha de inicio');
            fechaFinal.value = '';
        }
    });
}

function prufDescuentos() {
    if (inDescuentos.value === 'residente') {
        var origen = inOrigen.value;
        var destino = inDestino.value;

        
        var esValida =
            (origen === 'PMI' && (destino === 'BCN' || destino === 'MAD')) ||
            (destino === 'PMI' && (origen === 'BCN' || origen === 'MAD'));

        if (esValida) {
            alert('El descuento de residente se aplica correctamente.');
        } else {
            alert('Para aplicar el descuento de residente, el origen debe ser Palma y el destino Madrid o Barcelona (o a la inversa).');
            inDescuentos.value = 'sinDescuento'; 
        }
    }
}

function obtenerInfo(evento) {
    evento.preventDefault(); // Evitar que el formulario se envie
    // guardamos en session, pero podria ser local
    sessionStorage.setItem('paisOrigen', inOrigen.value);
    sessionStorage.setItem('paisDestino', inDestino.value);
    sessionStorage.setItem('fechaInicio', fechaInicio.value);
    sessionStorage.setItem('fechaVuelta', fechaFinal.value);
    sessionStorage.setItem('adultos', inAdultos.value);
    sessionStorage.setItem('ninyos', inNinyos.value);
    sessionStorage.setItem('descuentos', inDescuentos.value);

    window.location.href = 'confirmacion.html';

}

inDestino.addEventListener('change', prufOrigenDestino);
fechaInicio.addEventListener('mouseleave', prufFechas);
inDescuentos.addEventListener('change', prufDescuentos);
elFormulario.addEventListener('submit', obtenerInfo);