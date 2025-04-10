$base = "C:\TestCarpetes"
$carpetes = @("A", "B", "C", "D", "E")

if (-not (Test-Path $base)) {
    New-Item -Path $base -ItemType Directory | Out-Null
    Write-Host "Carpeta base creada: $base" -ForegroundColor Cyan
}

foreach ($carpeta in $carpetes) {
    $baseCompleta = Join-Path -Path $base -ChildPath $carpeta
    if (-not (Test-Path $baseCompleta)) {
        New-Item -Path $baseCompleta -ItemType Directory | Out-Null
        Write-Host "  -> Carpeta creada: $carpeta" -ForegroundColor Green
    } else {
        Write-Host "  -> La carpeta ja existeix: $carpeta" -ForegroundColor Yellow
    }
}