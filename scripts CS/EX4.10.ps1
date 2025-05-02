$elDia = Read-Host "Hola, dim a quin dia esteim avui"

switch ($elDia) {
    "lunes"     { Write-Output "Animm!" }
    "martes"    { Write-Output "Bona sort acaba de començar" }
    "miercoles" { Write-Output "Mitja part" }
    "jueves"    { Write-Output "Ja casi, tu pots" }
    "viernes"   { Write-Output "A sobarla" }
    "sabado"    { Write-Output "A sobarla x2" }
    "domingo"   { Write-Output "Paella amb se famili" }
    default     { Write-Output "Intenta de nou" }
}