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

// funcion para filtrar productos segun el texto del buscador
function filtrarProductes() {
    // obtener el texto del buscador y convertirlo a minusculas
    const text = document.getElementById('cercador').value.toLowerCase();
    // obtener todos los productos
    const productes = document.querySelectorAll('.producte');

    // recorrer todos los productos
    productes.forEach(producte => {
        // obtener el texto alternativo de la imagen del producto y convertirlo a minusculas
        const altText = producte.querySelector('img').alt.toLowerCase();
        // comprobar si el texto del buscador esta incluido en el texto alternativo
        if (altText.includes(text)) {
            // mostrar el producto
            producte.style.display = 'block';
        } else {
            // ocultar el producto
            producte.style.display = 'none';
        }
    });
}

// añadir un evento de entrada al campo de texto del buscador
document.getElementById('cercador').addEventListener('input', filtrarProductes);