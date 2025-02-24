// Seleccionamos los elementos del DOM
const nuevaTareaInput = document.getElementById('nuevaTarea');
const botonAgregar = document.getElementById('botonAgregar');
const listaTareas = document.getElementById('listaTareas');
const filtroTodas = document.getElementById('filtroTodas');
const filtroActivas = document.getElementById('filtroActivas');
const filtroCompletadas = document.getElementById('filtroCompletadas');
const botonEliminarCompletadas = document.getElementById('eliminarCompletadas');

// Función para agregar una nueva tarea
function agregarTarea() {
    const textoTarea = nuevaTareaInput.value.trim(); // Obtenemos el texto de la nueva tarea
    if (textoTarea !== '') { // Verificamos que no esté vacío
        const nuevaTarea = document.createElement('li'); // Creamos un nuevo elemento <li>
        const checkbox = document.createElement('input'); // Creamos un nuevo elemento <input> tipo checkbox
        checkbox.type = 'checkbox'; // Establecemos el tipo del input como checkbox
        checkbox.addEventListener('change', marcarCompletada); // Agregamos un evento para marcar como completada
        const texto = document.createElement('span'); // Creamos un nuevo elemento <span>
        texto.textContent = textoTarea; // Establecemos el texto de la tarea
        const botonEliminar = document.createElement('button'); // Creamos un nuevo botón para eliminar la tarea
        botonEliminar.textContent = 'Eliminar'; // Establecemos el texto del botón
        botonEliminar.addEventListener('click', eliminarTarea); // Agregamos un evento para eliminar la tarea
        nuevaTarea.appendChild(checkbox); // Añadimos el checkbox al <li>
        nuevaTarea.appendChild(texto); // Añadimos el texto al <li>
        nuevaTarea.appendChild(botonEliminar); // Añadimos el botón al <li>
        listaTareas.appendChild(nuevaTarea); // Añadimos el <li> a la lista de tareas
        nuevaTareaInput.value = ''; // Limpiamos el campo de texto
    }
}

// Función para marcar una tarea como completada
function marcarCompletada(event) {
    const tarea = event.target.parentElement; // Obtenemos el <li> que contiene el checkbox
    if (event.target.checked) { // Si el checkbox está marcado
        tarea.classList.add('completada'); // Añadimos la clase 'completada'
    } else { // Si el checkbox no está marcado
        tarea.classList.remove('completada'); // Quitamos la clase 'completada'
    }
}

// Función para eliminar una tarea
function eliminarTarea(event) {
    const tarea = event.target.parentElement; // Obtenemos el <li> que contiene el botón
    listaTareas.removeChild(tarea); // Eliminamos el <li> de la lista de tareas
}

// Función para eliminar todas las tareas completadas
function eliminarCompletadas() {
    const tareasCompletadas = document.querySelectorAll('.completada'); // Seleccionamos todas las tareas completadas
    tareasCompletadas.forEach(tarea => listaTareas.removeChild(tarea)); // Eliminamos cada tarea completada
    alert('Se han eliminado todas las tareas completadas'); // Mensaje en la consola
}

// Función para filtrar las tareas
function filtrarTareas(event) {
    const filtro = event.target.id; // Obtenemos el id del botón de filtro
    const tareas = listaTareas.children; // Obtenemos todas las tareas
    for (let tarea of tareas) { // Iteramos sobre cada tarea
        switch (filtro) {
            case 'filtroTodas':
                tarea.style.display = 'flex'; // Mostramos todas las tareas
                break;
            case 'filtroActivas':
                if (tarea.classList.contains('completada')) {
                    tarea.style.display = 'none'; // Ocultamos las tareas completadas
                } else {
                    tarea.style.display = 'flex'; // Mostramos las tareas activas
                }
                break;
            case 'filtroCompletadas':
                if (tarea.classList.contains('completada')) {
                    tarea.style.display = 'flex'; // Mostramos las tareas completadas
                } else {
                    tarea.style.display = 'none'; // Ocultamos las tareas activas
                }
                break;
        }
    }
}

// Agregamos eventos a los botones y al campo de texto
botonAgregar.addEventListener('click', agregarTarea);
filtroTodas.addEventListener('click', filtrarTareas);
filtroActivas.addEventListener('click', filtrarTareas);
filtroCompletadas.addEventListener('click', filtrarTareas);
botonEliminarCompletadas.addEventListener('click', eliminarCompletadas);