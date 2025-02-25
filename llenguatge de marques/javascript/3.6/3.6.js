function afegirTasca() {
    var input = document.getElementById("escriureTasca");
    var llista = document.getElementById("tasques");
    if (input.value.trim() === "") return;

    var novaTasca = document.createElement("li");
    novaTasca.innerHTML = '<input type="checkbox" onclick="marcarCompletat(this)"> ' 
        + input.value + ' <button class="delete" onclick="esborrarTasca(this)">X</button>';
    llista.appendChild(novaTasca);
    input.value = "";
}



