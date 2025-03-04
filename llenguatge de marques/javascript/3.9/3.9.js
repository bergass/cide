function afegir() {
    var url = document.getElementById("url").value;
    if (url) {
        var img = document.createElement("img");
        img.src = url;

        var borrarImg = document.createElement("button");
        borrarImg.innerText = "X";
        borrarImg.onclick = function () {
            img.remove();
            borrarImg.remove();
            canviarColor.remove();
        }

        var canviarColor = document.createElement("button");
        canviarColor.innerText = "canviarColor";
        canviarColor.onclick = function () {
            if (img.style.borderColor === 'black') { // si el color es negro
                img.style.borderColor === 'green'; // cambia el color a verde
            } else if (img.style.borderColor === 'green') {
                img.style.borderColor === 'blue';
            } else {
                img.style.borderColor === 'black';
            } 
        }

        document.getElementById("imatges").appendChild(img);
        document.getElementById("imatges").appendChild(borrarImg);
        document.getElementById("imatges").appendChild(canviarColor);
        document.getElementById("url").value = "";

    } else {
        alert("Introdueix una url valida")
    }
}

function xx() {
    var imatges = document.getElementById("imatges");
    document.body.removeChild(imatges)
}
