import unittest
from biblioteca import Llibre, Biblioteca  # Ahora importamos Biblioteca también

class TestBiblioteca(unittest.TestCase):

    def setUp(self):
        self.biblioteca = Biblioteca()  # Inicializamos una instancia de Biblioteca
        self.llibre1 = Llibre("El Petit Príncep", "Antoine de Saint-Exupéry", 1943)
        self.llibre2 = Llibre("1984", "George Orwell", 1949)
        self.biblioteca.afegir_llibre(self.llibre1)
        self.biblioteca.afegir_llibre(self.llibre2)

    def test_afegir_llibre(self):
        llibre3 = Llibre("El Quixot", "Miguel de Cervantes", 1605)
        self.biblioteca.afegir_llibre(llibre3)
        self.assertIn(llibre3, self.biblioteca.llibres)  # Verificamos si el libro está en la lista

    def test_cercar_llibre(self):
        llibre = self.biblioteca.cercar_llibre("1984")
        self.assertEqual(llibre, self.llibre2)  # Verificamos si el libro encontrado es el esperado

    def test_eliminar_llibre(self):
        result = self.biblioteca.eliminar_llibre("El Petit Príncep")
        self.assertTrue(result)  # Comprobamos que la eliminación fue exitosa
        self.assertNotIn(self.llibre1, self.biblioteca.llibres)  # Verificamos que el libro ya no está en la lista

    def test_llistar_llibres(self):
        llista = self.biblioteca.llistar_llibres()
        self.assertEqual(len(llista), 2)  # Verificamos que hay 2 libros en la lista
        self.assertIn("El Petit Príncep - Antoine de Saint-Exupéry (1943)", llista)  # Comprobamos que el libro esperado está en la lista

if __name__ == "__main__":
    unittest.main()
