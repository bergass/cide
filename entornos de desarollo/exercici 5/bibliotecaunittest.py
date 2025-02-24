import unittest
from biblioteca import Llibre, afegir_llibre, cercar_llibre, eliminar_llibre, llistar_llibres, biblioteca

class TestBiblioteca(unittest.TestCase):

    def setUp(self):
        biblioteca.clear()  # Limpiar la biblioteca antes de cada prueba
        self.llibre1 = Llibre("El Petit Príncep", "Antoine de Saint-Exupéry", 1943)
        self.llibre2 = Llibre("1984", "George Orwell", 1949)
        afegir_llibre(self.llibre1)
        afegir_llibre(self.llibre2)

    def test_afegir_llibre(self):
        llibre3 = Llibre("El Quixot", "Miguel de Cervantes", 1605)
        afegir_llibre(llibre3)
        self.assertIn(llibre3, biblioteca)

    def test_cercar_llibre(self):
        llibre = cercar_llibre("1984")
        self.assertEqual(llibre, self.llibre2)

    def test_eliminar_llibre(self):
        result = eliminar_llibre("El Petit Príncep")
        self.assertTrue(result)
        self.assertNotIn(self.llibre1, biblioteca)

    def test_llistar_llibres(self):
        llista = llistar_llibres()
        self.assertEqual(len(llista), 2)
        self.assertIn("El Petit Príncep - Antoine de Saint-Exupéry (1943)", llista)

if __name__ == "__main__":
    unittest.main()