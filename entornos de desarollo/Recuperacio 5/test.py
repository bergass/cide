import pytest
from biblioteca import Llibre, Biblioteca

@pytest.fixture
def biblioteca():
    return Biblioteca()

@pytest.fixture
def llibre1():
    return Llibre("1984", "George Orwell", 1949)

@pytest.fixture
def llibre2():
    return Llibre("Dune", "Frank Herbert", 1965)

def test_afegir_llibre(biblioteca, llibre1):
    biblioteca.afegir_llibre(llibre1)
    assert llibre1 in biblioteca.llista_llibres

def test_cercar_llibre(biblioteca, llibre1):
    biblioteca.afegir_llibre(llibre1)
    assert biblioteca.cercar_llibre("1984") == llibre1

def test_eliminar_llibre(biblioteca, llibre1):
    biblioteca.afegir_llibre(llibre1)
    resultat = biblioteca.eliminar_llibre("1984")
    assert resultat is True
    assert llibre1 not in biblioteca.llista_llibres

def test_llistar_llibres(biblioteca, llibre1, llibre2):
    biblioteca.afegir_llibre(llibre1)
    biblioteca.afegir_llibre(llibre2)
    llibres_esperats = [str(llibre1), str(llibre2)]
    assert biblioteca.llistar_llibres() == llibres_esperats
