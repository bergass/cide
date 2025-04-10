$num = Read-Host "Escriu un nombre"

if ($num % 2 -eq 0) {
    Write-Host "El nombre es par"
} else {
    Write-Host "El nombre es impar"
}