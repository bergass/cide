function afegirTasca() {
    var input = document.getElementById("escriureTasca");
    var llista = document.getElementById("tasques");
    if (input.value.trim() === "") return;
    
    var novaTasca = document.createElement("li");
    novaTasca.innerHTML = '<input type="checkbox" onclick="marcarCompletat(this)"> ' + input.value + ' <button onclick="esborrarTasca(this)">X</button>';
    llista.appendChild(novaTasca);
    input.value = "";
}

function marcarCompletat(checkbox) {
    if (checkbox.checked) {
        checkbox.parentElement.classList.add("completed");
    } else {
        checkbox.parentElement.classList.remove("completed");
    }
}

function esborrarTasca(boto) {
    boto.parentElement.remove();
}

function esborrarCompletades() {
    var tasques = document.querySelectorAll(".completed");
    tasques.forEach(tasca => tasca.remove());
}

function filtrarTasques(filtre) {
    var tasques = document.querySelectorAll("#tasques li");
    tasques.forEach(tasca => {
        if (filtre === "totes") {
            tasca.style.display = "";
        } else if (filtre === "actives" && tasca.classList.contains("completed")) {
            tasca.style.display = "none";
        } else if (filtre === "completades" && !tasca.classList.contains("completed")) {
            tasca.style.display = "none";
        } else {
            tasca.style.display = "";
        }
    });
}
