function començar() {
    var dificultat = document.getElementById("dificultat").value;
    var divMain = document.getElementById("divDificultat");
    var botonVolver = document.getElementById("volver");
    var subtitol = document.getElementById("subtitol");

    if (dificultat == "1") {
        divMain.style.display = "none";
        botonVolver.style.display = "block";
        subtitol.textContent = "Nivell 1, 10";
        var numero = document.createElement("input");


    } else if (dificultat == "2") {
        divMain.style.display = "none";
        botonVolver.style.display = "block";
        subtitol.textContent = "Nivell 2, 50";
        var numero = document.createElement("input");

    } else if (dificultat == "3") {
        divMain.style.display = "none";
        botonVolver.style.display = "block";
        subtitol.textContent = "Nivell 3, 100";
        var numero = document.createElement("input");

    }
}

function volver() {
    var divMain = document.getElementById("divDificultat");
    var botonVolver = document.getElementById("volver");
    var subtitol = document.getElementById("subtitol");

    divMain.style.display = "block"
    botonVolver.style.display = "none";
    subtitol.textContent = "Dificultat";

}