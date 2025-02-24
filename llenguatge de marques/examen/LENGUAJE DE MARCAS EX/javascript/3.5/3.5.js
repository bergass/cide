// funcion que se ejecuta cuando se hace clic en el boton del menu hamburguesa
function menuHamburguesa() {
    // obtener el elemento del menu de navegacion por su id
    const menu = document.getElementById('menuNav');
    // alternar la clase 'mostrar' en el menu
    menu.classList.toggle('mostrar');
}

// obtener todos los enlaces dentro del menu
const enlacesMenu = document.querySelectorAll('.menu a');

// añadir un evento de clic a cada enlace del menu
enlacesMenu.forEach(enlace => {
    enlace.addEventListener('click', () => {
        // obtener el elemento del menu de navegacion por su id
        const menu = document.getElementById('menuNav');
        // quitar la clase 'mostrar' del menu para ocultarlo
        menu.classList.remove('mostrar');
    });
});