agenda_de_contactos = {}  # inicialitza un diccionari buit per emmagatzemar els contactes

def es_numero_valido(numero):  # defineix una funcio per validar un numero de telefon
    return numero.isdigit() and 1 <= len(numero) <= 11  # comprova si el numero es numeric i te entre 1 i 11 digits

salir = False  # variable de control per sortir del bucle
while not salir:  # bucle principal del programa
    print("Que operacion quieres hacer?")  # mostra les opcions disponibles
    print("1) busqueda de contacto")  # opcio per buscar un contacte
    print("2) anadir un contacto")  # opcio per afegir un contacte
    print("3) actualizacion de contacto")  # opcio per actualitzar un contacte
    print("4) eliminar un contacto")  # opcio per eliminar un contacte
    print("5) salir")  # opcio per sortir del programa
    option = input()  # llegeix l'opcio triada per l'usuari

    if option == '1':  # si l'usuari tria buscar un contacte
        name = input("Introduce el nombre del contacto que buscas")  # demana el nom del contacte
        if name in agenda_de_contactos:  # comprova si el contacte existeix
            print(f"{name}: {agenda_de_contactos[name]}")  # mostra el numero de telefon del contacte
        else:
            print("Contacto no encontrado")  # mostra un missatge si el contacte no existeix

    if option == '2':  # si l'usuari tria afegir un contacte
        name = input("Introduce el nombre")  # demana el nom del contacte
        number = input("Introduce el num. de telefono")  # demana el numero de telefon
        if es_numero_valido(number):  # valida si el numero de telefon es correcte
            agenda_de_contactos[name] = number  # afegeix el contacte al diccionari
            print(f"Contacto {name} anadido con exito.")  # confirma que el contacte s'ha afegit
        else:
            print("Numero de telefono invalido. Debe ser numerico i contenir entre 1 i 11 digits.")  # mostra un missatge si el numero no es valid

    if option == '3':  # si l'usuari tria actualitzar un contacte
        name = input("Introduce el nombre del contacto a actualizar: ")  # demana el nom del contacte
        if name in agenda_de_contactos:  # comprova si el contacte existeix
            number = input("Introduce el nuevo numero de telefono: ")  # demana el nou numero de telefon
            if es_numero_valido(number):  # valida si el numero de telefon es correcte
                agenda_de_contactos[name] = number  # actualitza el numero de telefon del contacte
                print(f"Contacto {name} actualizado con exito.")  # confirma que el contacte s'ha actualitzat
            else:
                print("Numero de telefono invalido. Debe ser numerico i contenir entre 1 i 11 digits.")  # mostra un missatge si el numero no es valid
        else:
            print("Contacto no encontrado")  # mostra un missatge si el contacte no existeix

    if option == '4':  # si l'usuari tria eliminar un contacte
        name = input("Introduce el nombre del contacto a eliminar: ")  # demana el nom del contacte
        if name in agenda_de_contactos:  # comprova si el contacte existeix
            del agenda_de_contactos[name]  # elimina el contacte del diccionari
            print(f"Contacto {name} eliminado con exito.")  # confirma que el contacte s'ha eliminat
        else:
            print("Contacto no encontrado.")  # mostra un missatge si el contacte no existeix

    if option == '5':  # si l'usuari tria sortir del programa
        salir = True  # canvia la variable de control per sortir del bucle
    else:
        print("Opcion invalida")  # mostra un missatge si l'opcio no es valida