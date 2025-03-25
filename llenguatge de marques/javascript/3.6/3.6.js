function afegirTasca() {
    var input = document.getElementById("escriureTasca").value;
    if (input) {
        var tasca = document.createElement("p");
        tasca.textContent = input;

        var check = document.createElement("input");
        check.type = "checkbox";
        check.addEventListener('change', function () {
            if (check.checked) {
                tasca.classList.add('completed');
            } else {
                tasca.classList.remove('completed');
            }
        });

        var borrarTasca = document.createElement("button");
        borrarTasca.innerText = "X";
        borrarTasca.style.color = "red";
        borrarTasca.onclick = function () {
            check.remove();
            tasca.remove();
            borrarTasca.remove();
        }

        var contenedor = document.createElement("div");
        contenedor.className = "contenedor";
        contenedor.appendChild(tasca);
        contenedor.appendChild(check);
        contenedor.appendChild(borrarTasca);

        document.getElementById("tasques").appendChild(contenedor);
    }
}

function borrarCompletades() {
    var completades = document.querySelectorAll("#tasques .contenedor input[type='checkbox'] :checked");
    completades.forEach(function (check) {
        check.parentElement.remove();   
    });
}

function filtrarTotes() {
    var tasques = document.querySelectorAll("#tasques .contenedor");
    tasques.forEach(function (contenedor) {
            contenedor.style.display = "flex";
    })
}
function filtrarActives() {
    var tasques = document.querySelectorAll("#tasques .contenedor");
    tasques.forEach(function (contenedor) {
        var check = contenedor.querySelector("input[type='checkbox']");
        if (check && check.checked) {
            contenedor.style.display = "none";
        } else {
            contenedor.style.display = "flex";
        }
    })
}
function filtrarCompletades() {
    var tasques = document.querySelectorAll("#tasques .contenedor");
    tasques.forEach(function (contenedor) {
        var check = contenedor.querySelector("input[type='checkbox']");
        if (check && check.checked) {
            contenedor.style.display = "flex";
        } else {
            contenedor.style.display = "none";
        }
    })
}
//Actividad 7 buscador
inputCercador.addEventListener("input", function () {
    const textCercar = inputCercador.value.toLowerCase();
    productes.forEach(producte => {
        const textProducte = producte.textContent.toLowerCase();
        if (textProducte.includes(textCercat)) {
            producte.style.display = "block";
        } else {
            producte.style.display = "none";
        }
    })

}); 


