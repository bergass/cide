document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault() // prevenir el envio del formulario

    // obtener los valores de los campos del formulario
    const nom = document.getElementById('nom').value.trim() // obtener el valor del campo nombre
    const email = document.getElementById('email').value.trim() // obtener el valor del campo correo electronico
    const assumpte = document.getElementById('assumpte').value.trim() // obtener el valor del campo asunto
    const descripcio = document.getElementById('descripcio').value.trim() // obtener el valor del campo descripcion
    const missatge = document.getElementById('missatge') // obtener el elemento para mostrar mensajes

    // expresion regular para validar el correo electronico
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/ // expresion regular para validar el correo electronico

    // validar que todos los campos sean obligatorios
    if (!nom || !email || !assumpte || !descripcio) {
        missatge.textContent = 'Tots els camps són obligatoris' // mostrar mensaje de error
        missatge.style.color = 'red' // cambiar el color del mensaje a rojo
        return // salir de la funcion
    }

    // validar el formato del correo electronico
    if (!emailRegex.test(email)) {
        missatge.textContent = 'El correu electrònic no té un format vàlid' // mostrar mensaje de error
        missatge.style.color = 'red' // cambiar el color del mensaje a rojo
        return // salir de la funcion
    }

    // si todas las validaciones son correctas
    missatge.textContent = "El formulari s'ha enviat correctament" // mostrar mensaje de exito
    missatge.style.color = 'green' // cambiar el color del mensaje a verde

    // aqui puedes agregar el codigo para enviar el formulario si es necesario
})