def add(number1, number2):
    return number1 + number2

def subtract(number1, number2):
    return number1 - number2#s'ordre esteia malament sino no era logica

def multiplication(number1, number2):
    return number1 * number2#number 2 era number 1 tambe

def division(number1, number2):
    return number1 / number2#s'ordre esteia malament

def show_menu():
    print("1. Add")
    print("2. subtract")
    print("3. multiplication")
    print("4. division")
    print("5. exit")

def calculator():
    show_menu()

    number1 = float(input("Enter a number to calculate: "))#ha de ser un float perque el numbers puguin ser decimals
    number2 = float(input("Enter a number to calculate: "))#ha de ser un float perque el numbers puguin ser decimals

    option = int(input("Enter a opction: "))#perque sigui una variable usable ha de ser int o cualque altre, pero no pot ser directament el missatge

    if option == 1:
        print(add(number1, number2))
        return False
    elif option == 2:   
        print(subtract(number1, number2))
        return False
    elif option == 3:
        print(multiplication(number1, number2))
        return False
    elif option == 4:
        print(division(number1, number2))
    elif option == 5:
        return True#per sortir del programa
    else:
        print("Invalid option")#si no es un numero entre 1 i 5, no seria ninguna accio, per tant seria invalida

def run():
    exit = False
    while not exit:
        exit = calculator()

run()