// querySelector() selecciona el primer elemento que coincida con el parametro
const hamburguesa = document.querySelector('.hamburguesa');

// El eventListener escucha el evento 'click' en el elemento 'hamburguesa'
hamburguesa.addEventListener('click', function () {
    // Creamos una función anónima que se ejecuta al hacer click 
    const menu = document.querySelector('.menu');
    // Guardamos en la variable 'menu' el elemento con la clase 'menu'

    // Alterna la clase 'menu-visible' en el elemento 'menu'
    menu.classList.toggle('menu-visible');
});

/* ACTIVIDAD 3.7 */

// Primero capturamos el evento 'input' en el campo de busqueda
const busquedaInput = document.querySelector('.barraBusqueda input');
// Luego creamos una función que se ejecuta al escribir en el campo de busqueda
busquedaInput.addEventListener('input', function (event) {
    // Obtenemos el valor del campo busqueda en minuscula
    const busqueda = event.target.value.toLowerCase();
    // Selecionamos la zona de busqueda(productos)
    const productos = document.querySelectorAll('.producto');

    // Un for de java. ZONA.forEach(function (elemento(i)) { CODIGO })
    productos.forEach(function (producto) { 
        // Obtenemos el texto del producto en minuscula
        const textoProducto = producto.textContent.toLowerCase();
        // Si el texto del producto incluye la busqueda, muestra el producto
        if (textoProducto.includes(busqueda)) {
            producto.style.display = 'block';
        } else { // Si no, oculta el producto
            producto.style.display = 'none';
        }
    });
});

/* ACTIVIDAD 3.8 */

// Seleccionamos el formulario por su ID
const formulario = document.getElementById('formulario');
formulario.addEventListener('submit', function(event) { // Listener para el submit
    event.preventDefault(); // Si quitamos esta linea el Form se podria enviar vacio 
    validarFormulario(); // Llamamos a nuestra funcion
});

function validarFormulario() { 
    const nombre = document.getElementById('nombre').value.trim(); //.trim() nos elimina los espacios en balnco al principio y al final
    const email = document.getElementById('email').value.trim();
    const asunto = document.getElementById('asunto').value.trim();
    const mensaje = document.getElementById('mensaje').value.trim();
    // ! es un operador logico, si nombre es false (esta vacio), ejecuta el if
    if (!nombre || !email || !asunto || !mensaje) {
        mostrarMensaje('Todos los campos son obligatorios');
        return; // El return nos sirve para que no se ejecute el resto del codigo
    }
    // Guardamos la expresion regular en una variable, formato de email
    const comprobarEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!comprobarEmail.test(email)) { // Si el email no cumple con el formato
        mostrarMensaje('El email tiene un formato invalido') // Muestra un mensaje
        return; // El return nos sirve para que no se ejecute el resto del codigo
    }
    // Si todo esta correcto, muestra un mensaje de exito
    mostrarMensaje('Se ha enviado correctamente', true);
    formulario.reset(); // Resetea el formulario
}

function mostrarMensaje(mensaje, exito = false) { // Por defecto exito es false
    const mensajeResultado = document.getElementById('mensaje-resultado'); // Seleccionamos el elemento por su ID
    mensajeResultado.textContent = mensaje; // Cambiamos el texto del elemento
    mensajeResultado.style.color = exito ? 'green' : 'red'; // Usamos un operador ternario para cambiar el color del texto
    // condición ? valor_si_true : valor_si_false;
}

// console.log(); Para ventanas emergentes
