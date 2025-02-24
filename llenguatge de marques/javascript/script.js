// Sol·licitem a l'usuari les notes dels 3 exàmens
var nota1 = parseFloat(prompt("Introdueix la nota del primer examen:"));
var nota2 = parseFloat(prompt("Introdueix la nota del segon examen:"));
var nota3 = parseFloat(prompt("Introdueix la nota del tercer examen:"));

// Calculem la mitjana
var mitjana = (nota1 + nota2 + nota3) / 3;

console.log('examen1: ',nota1,"El sey tipus es:", typeof nota1);
console.log('examen2: ',nota2,"El sey tipus es:", typeof nota2);
console.log('examen3: ',nota3,"El sey tipus es:", typeof nota3);
console.log('mitjana: ',mitjana,"El sey tipus es:", typeof mitjana);

// Mostrem la nota final per la consola
console.log(`La teva nota final és: ${mitjana.toFixed(2)}`);