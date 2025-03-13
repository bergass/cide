var numeroAleatorio;
var intents;

function començar() {
    var dificultat = document.getElementById("dificultat").value;
    if (!dificultat) {
        alert("Selecciona un nivell per començar el joc.");
        return;
    }

    var numMax;
    if (dificultat == "1") {
        numMax = 10;
    } else if (dificultat == "2") {
        numMax = 50;
    } else if (dificultat == "3") {
        numMax = 100;
    }

    numeroAleatorio = Math.floor(Math.random() * numMax) + 1;
    intents = 0;

    document.getElementById("subtitolJoc").textContent = `Nivell ${dificultat}, número màxim: ${numMax}`;
    document.getElementById("seccionInicial").style.display = "none";
    document.getElementById("seccionJoc").style.display = "block";
    document.getElementById("input").value = "";
    document.getElementById("missatge").textContent = "";
}

function comprovar() {
    var input = parseInt(document.getElementById("input").value);
    var dificultat = document.getElementById("dificultat").value;
    var numMax;

    if (dificultat == "1") {
        numMax = 10;
    } else if (dificultat == "2") {
        numMax = 50;
    } else if (dificultat == "3") {
        numMax = 100;
    }

    if (isNaN(input) || input < 1 || input > numMax) {
        document.getElementById("missatge").textContent = `Introdueix un número entre 1 i ${numMax}.`;
        return;
    }

    intents++;
    if (input < numeroAleatorio) {
        document.getElementById("missatge").textContent = "El número és més alt.";
    } else if (input > numeroAleatorio) {
        document.getElementById("missatge").textContent = "El número és més baix.";
    } else {
        document.getElementById("missatge").textContent = `¡Felicidades! Has adivinado el número en ${intents} intents.`;
    }
}

function reiniciar() {
    document.getElementById("seccionInicial").style.display = "block";
    document.getElementById("seccionJoc").style.display = "none";
    document.getElementById("dificultat").value = "";
    document.getElementById("input").value = "";
    document.getElementById("missatge").textContent = "";
}