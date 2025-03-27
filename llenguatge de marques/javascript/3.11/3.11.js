const origen = document.getElementById('origen');
const destino = document.getElementById('destino');
const fechaIni = document.getElementById('fechaIni');
const fechaFi = document.getElementById('fechaFi');
const numAdultos = document.getElementById('numAdultos');
const numNiños = document.getElementById('numNiños');
const descuentos = document.getElementById('descuentos');
const formulario = document.getElementById('formulario');

function prufOrigenDestino() {
    if (origen.value === destino.value) {
        alert('Origen y destino NO pueden ser el mismo');
        destino.value = '';
    }
}

function prufFechas() {
    const hoy = new Date().toISOString().split('T')[0];
    fechaIni.setAttribute('min', hoy);

    fechaIni.addEventListener('change', function () {
        fechaFi.setAttribute('min', fechaIni.value);
    });

    fechaFi.addEventListener('change', function () {
        if (fechaFi.value < fechaIni.value) {
            alert('La fecha de fin no puede ser anterior a la fecha de inicio');
            fechaFi.value = '';
        }
    });
}

function prufNumeros() {
    if (numAdultos.value < 0) {
        alert('El número de adultos no puede ser negativo');
        numAdultos.value = '';
    }
    if (numNiños.value < 0) {
        alert('El número de niños no puede ser negativo');
        numNiños.value = '';
    }
}

function prufDescuentos() {
    if (descuentos.value === 'Descuento Residente') {
        const esValida =
            (origen.value === 'Palma' && (destino.value === 'Barcelona' || destino.value === 'Madrid')) ||
            (destino.value === 'Palma' && (origen.value === 'Barcelona' || origen.value === 'Madrid'));

        if (!esValida) {
            alert('Para aplicar el descuento de residente, el origen debe ser Palma y el destino Madrid o Barcelona (o a la inversa).');
            descuentos.value = '';
        }
    }
}

function obtenerInfo(evento) {
    evento.preventDefault(); // Evitar que el formulario se envíe
    sessionStorage.setItem('origen', origen.value);
    sessionStorage.setItem('destino', destino.value);
    sessionStorage.setItem('fechaIni', fechaIni.value);
    sessionStorage.setItem('fechaFi', fechaFi.value);
    sessionStorage.setItem('numAdultos', numAdultos.value);
    sessionStorage.setItem('numNiños', numNiños.value);
    sessionStorage.setItem('descuentos', descuentos.value);

    window.location.href = '3.11.resultados.html';
}

// Eventos
destino.addEventListener('change', prufOrigenDestino);
fechaIni.addEventListener('change', prufFechas);
numAdultos.addEventListener('change', prufNumeros);
numNiños.addEventListener('change', prufNumeros);
descuentos.addEventListener('change', prufDescuentos);
formulario.addEventListener('submit', obtenerInfo);