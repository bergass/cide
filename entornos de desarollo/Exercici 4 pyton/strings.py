year = int(input("Greetings! What is your year of origin?"))#int.input esta incorrecte

if year <= 1900:#no havia ":" al final del if
    print ("Woah, that's the past!")
elif 1900 < year < 2020:#he simplificat l'operacio perque si el year era major que els dos colapsaba
    print ("That's totally the present!")
else:#com no hi ha condicio he posat else, sino seria elif com a l'altre
    print ("Far out, that's the future!!")