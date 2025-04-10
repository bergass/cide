$contraseña = Read-Host "Ingresa la contraseña" -AsSecureString
$contraseñaProva = [System.Runtime.InteropServices.Marshal]::PtrToStringAuto(
    [System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($contraseña)
)

if ($contraseñaProva -eq "admin123") {
    Write-Host "¡Acces concedit!" -ForegroundColor Green
} else {
    Write-Host "Acces denegat. Contraseña incorrecta." -ForegroundColor Red
}