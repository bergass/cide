CREATE TABLE Empleat (
    N_SS NUMBER,
    Nom VARCHAR2,
    Llinatges VARCHAR2,
    Email VARCHAR2,
    IBAN NUMBER,
    PRIMARY KEY (N_SS)
)
CREATE TABLE Tipus_De_Plasa (
    Nom VARCHAR2,
    Funcio VARCHAR2,
    PRIMARY KEY (Nom)
)
CREATE TABLE Supervisio (
    Codi NUMBER,
    Informe VARCHAR2,
    PRIMARY KEY (Codi)
)
CREATE TABLE Plasa (
    Codi NUMBER,
    Nom VARCHAR2,
    Salari VARCHAR2,
    Codi_Supervisio NUMBER,
    Nom_Tipus_De_Plasa VARCHAR2,
    PRIMARY KEY (Codi),
    FOREIGN KEY (Codi_Supervisio) REFERENCES Supervisio(Codi),
    FOREIGN KEY (Nom_Tipus_De_Plasa) REFERENCES Tipus_De_Plasa(Nom)
)

CREATE TABLE Nomina (
    ID NUMBER,
    Import VARCHAR2,
    IBAN_Pagament NUMBER,
    N_SS_Empleat NUMBER,
    Codi_Plasa NUMBER,
    PRIMARY KEY (ID),
    FOREIGN KEY (N_SS) REFERENCES Empleat(N_SS),
    FOREIGN KEY (Codi_Plasa) REFERENCES Plasa(Codi)
)
CREATE TABLE Ocupa (
    Data_Inici DATE,
    Data_Fi DATE,
    N_SS_Empleat VARCHAR2,
    Codi_Plasa VARCHAR2,
    PRIMARY KEY (N_SS_Empleat),
    PRIMARY KEY (Codi_Plasa),
    FOREIGN KEY (N_SS_Empleat) REFERENCES Empleat(N_SS),
    FOREIGN KEY (Codi_Plasa) REFERENCES Plasa(Codi)
)
