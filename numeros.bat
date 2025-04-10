@echo off
set contador=1

:loop
echo numero: %contador%
set /a contador+=1
if %contador% leq 10 goto loop

pause