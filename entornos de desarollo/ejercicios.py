A = int(input("Introduce el valor de A:"))
B = int(input("Introduce el valor de B:"))

A, B = B, A

print(f"Despues del intercambio, A vale {A} y B vale {B}")


num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))

suma = num1 + num2
resta = num1 - num2
producto = num1 * num2
division = num1 / num2 if num2 != 0 else "No se puede dividir por cero"

print(f"Suma: {suma}")
print(f"Resta: {resta}")
print(f"Producto: {producto}")
print(f"División: {division}")


num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))

if num1 > num2:
    print(f"El número mayor es: {num1}")
elif num1 < num2:
    print(f"El número mayor es: {num2}")
else:
    print("Ambos números son iguales")
    

num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))
num3 = float(input("Introduce el tercer número: "))

if num1 > num2 and num1 > num3:
    print(f"El número mayor es: {num1}")
elif num2 > num1 and num2 > num3:
    print(f"El número mayor es: {num2}")
else:
    print(f"El número mayor es: {num3}")
    

num1 = float(input("Introduce el primer número: "))
num2 = float(input("Introduce el segundo número: "))
num3 = float(input("Introduce el tercer número: "))

if num1 < 0:
    resultado = num1 * num2 * num3
    print(f"El producto de los tres números es: {resultado}")
else:
    resultado = num1 + num2 + num3
    print(f"La suma de los tres números es: {resultado}")

import math


num = float(input("Introduce un número: "))

if num <= 0:
    print("Error: El número debe ser mayor que cero.")
else:
    cuadrado = num ** 2
    raiz_cuadrada = math.sqrt(num)
    print(f"Del número {num}, su potencia es {cuadrado} y su raíz cuadrada es {raiz_cuadrada}")
