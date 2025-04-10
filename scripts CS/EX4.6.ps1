$edad = Read-Host "Escriu la teva edad"

if ([int]$edad -lt 18) {
    Write-Host "Ets menor d'edad"
} else {
    Write-Host "Ets major d'edad"
}