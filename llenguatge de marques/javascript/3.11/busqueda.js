function buscar() {
    var origen = document.getElementById("origen").value;
    var destino = document.getElementById("destino").value;
    var fechaIni = document.getElementById("fechaIni").value;
    var fechaFi = document.getElementById("fechaFi").value;
    var numAdultos = document.getElementById("numAdultos").value;
    var numNiños = document.getElementById("numNiños").value;
    var descuentos = document.getElementById("descuentos").value;

    var urlCompleta = "dispo.html?paramOrigen=" + encodeURIComponent(origen);
    urlCompleta += "&paramDestino=" + encodeURIComponent(destino);
    urlCompleta += "&paramFechaInicio=" + encodeURIComponent(fechaIni);
    urlCompleta += "&paramFechaFin=" + encodeURIComponent(fechaFi);
    urlCompleta += "&paramNumAdultos=" + encodeURIComponent(numAdultos);
    urlCompleta += "&paramNumNinos=" + encodeURIComponent(numNiños);
    urlCompleta += "&paramDescuentos=" + encodeURIComponent(descuentos);

    window.location.href = urlCompleta;
}