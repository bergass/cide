class Person:
    def __init__(self, first_name, last_name):#no es initialize 
        self.first = first_name
        self.last = last_name#no esteia definit completament last
    def speak(self):
        print("My name is" + self.fname + " " + self.last)#les cometes no esteien ben situades

me = Person("Brandon", "Walsh")
you = Person("Ethan", "Reed")

me.speak()
you.speak()#el self enmig no hauria de estar