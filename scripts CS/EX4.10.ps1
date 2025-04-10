$elDia = Read-Host "Hola, "

switch ($elDia) {
    "lunes"     { Write-Output "Animo bro" }
    "martes"    { Write-Output "Palmadita en la espalda bro" }
    "miercoles" { Write-Output "hoy es normalito" }
    "jueves"    { Write-Output "Ya casi bro" }
    "viernes"   { Write-Output "Lo lograaaste brooo" }
    "sabado"    { Write-Output "Torradita chill" }
    "domingo"   { Write-Output "Aprovecha el ultimo dia..." }
    default     { Write-Output "Intenta de nuevo" }
}