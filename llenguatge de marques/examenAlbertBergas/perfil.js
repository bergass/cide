function mostrarResultados() {
    var perfilForm = document.getElementById('perfilForm');

    // Recuperar los datos almacenados en sessionStorage
    var nombrePerfil = document.getElementById("nombrePerfil")

    // Crear el contenido HTML para mostrar los resultados
    var datosRes =
        nombrePerfil.value = localStorage.getItem('nombre');
    // Crear el contenido HTML para mostrar los resultados

    // Insertar el contenido en el div de resultados
    if (perfilForm) {
        perfilForm.value = datosRes;
    }
}


// Ejecutar la función cuando el DOM esté completamente cargado
document.addEventListener('DOMContentLoaded', mostrarResultados);