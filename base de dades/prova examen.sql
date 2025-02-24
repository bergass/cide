-- 1. Crea les taules necessàries amb CREATE TABLE.
CREATE TABLE Camioner (
    ID NUMBER PRIMARY KEY,
    Nom VARCHAR2(100) NOT NULL
);

CREATE TABLE Camio (
    ID NUMBER PRIMARY KEY,
    Model VARCHAR2(100) NOT NULL
);

CREATE TABLE Client (
    ID NUMBER PRIMARY KEY,
    Nom VARCHAR2(100) NOT NULL
);

CREATE TABLE Paquet (
    ID NUMBER PRIMARY KEY,
    Descripcio VARCHAR2(2000) NOT NULL,
    Estat VARCHAR2(50) NOT NULL,
    Camioner_ID NUMBER,
    Client_ID NUMBER NOT NULL,
    FOREIGN KEY (Camioner_ID) REFERENCES Camioner(ID),
    FOREIGN KEY (Client_ID) REFERENCES Client(ID)
);

CREATE TABLE Condueix (
    Camioner_ID NUMBER,
    Camio_ID NUMBER,
    Data_Inici DATE NOT NULL,
    Data_Fi DATE,
    PRIMARY KEY (Camioner_ID, Camio_ID, Data_Inici),
    FOREIGN KEY (Camioner_ID) REFERENCES Camioner(ID),
    FOREIGN KEY (Camio_ID) REFERENCES Camio(ID)
);

-- 2. Introdueix la següent informació
-- 2 camioners
INSERT INTO Camioner (ID, Nom) VALUES (1, 'Camioner 1');
INSERT INTO Camioner (ID, Nom) VALUES (2, 'Camioner 2');

-- 1 camió
INSERT INTO Camio (ID, Model) VALUES (1, 'Model 1');

-- Un dels camioners ha d'haver conduit el camió durant tot el mes de desembre de 2024
INSERT INTO Condueix (Camioner_ID, Camio_ID, Data_Inici, Data_Fi) VALUES (1, 1, DATE '2024-12-01', DATE '2024-12-31');

-- l'altre l'ha de conduir ha partir del 2 de Gener de 2025, encara sense data de finalització
INSERT INTO Condueix (Camioner_ID, Camio_ID, Data_Inici) VALUES (2, 1, DATE '2025-01-02');

-- 2 clients
INSERT INTO Client (ID, Nom) VALUES (1, 'Client 1');
INSERT INTO Client (ID, Nom) VALUES (2, 'Client 2');

-- 2 paquets
-- Un assignat a qualsevol dels 2 camioners i en estat COMPLETAT
INSERT INTO Paquet (ID, Descripcio, Estat, Camioner_ID, Client_ID) VALUES (1, 'Paquet 1', 'COMPLETAT', 1, 1);

-- l'altre sense camioner assignat i en estat PENDENT
INSERT INTO Paquet (ID, Descripcio, Estat, Client_ID) VALUES (2, 'Paquet 2', 'PENDENT', 2);

-- 3. Realitza les següents operacions:
-- Elimina la columna "Potència" de Camió.
ALTER TABLE Camio DROP COLUMN Potència;

-- Modifica la columna "Descripció" de paquet perquè sigui un VARCHAR2 de mida 2000.
ALTER TABLE Paquet MODIFY (Descripcio VARCHAR2(2000));

-- Canvia el nom de qualsevol dels camioners a un diferent al que teníen.
UPDATE Camioner SET Nom = 'Camioner 3' WHERE ID = 1;

-- Elimina la conducció ja acabada (la que té data de fi).
DELETE FROM Condueix WHERE Data_Fi IS NOT NULL;

-- Elimina tota la informació introduïda la taula PAQUET, amb només 1 sentència
DELETE FROM Paquet;