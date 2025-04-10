$archiu = "log.txt"

if (-not (Test-Path $archiu)) {
    New-Item -Path $archiu -ItemType File | Out-Null
    Write-Host "S'ha creat $archiu perque no existia"
} else {
    Write-Host "$archiu ja existeix"
}

# Ni idea de aquest ayudita de chat, pido perdon a la audiencia