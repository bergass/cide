class Llibre:
    def __init__(self, titol, autor, any_publicacio):
        self.titol = titol
        self.autor = autor
        self.any_publicacio = any_publicacio
    
    def __str__(self):
        return f"{self.titol} - {self.autor} ({self.any_publicacio})"

class Biblioteca:
    def __init__(self):
        self.llista_llibres = []
    
    def afegir_llibre(self, llibre):
        self.llista_llibres.append(llibre)
    
    def cercar_llibre(self, titol):
        for llibre in self.llista_llibres:
            if llibre.titol == titol:
                return llibre
        return None
    
    def eliminar_llibre(self, titol):
        for llibre in self.llista_llibres:
            if llibre.titol == titol:
                self.llista_llibres.remove(llibre)
                return True
        return False
    
    def llistar_llibres(self):
        return [str(llibre) for llibre in self.llista_llibres]
