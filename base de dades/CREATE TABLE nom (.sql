CREATE TABLE autor (
   id number,
   nom varchar2(50),
   cognoms varchar2(9),
   datanaix date,
   nacionalitat varchar(50),
   primary key ( id )
);

CREATE TABLE llibre (
    id NUMBER,
    titol VARCHAR2(50),
    any NUMBER,
    exemplars NUMBER,
    idEditorial NUMBER,
    idSequela NUMBER,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES llibre(id),


    
    FOREIGN KEY (id) REFERENCES editorial(id)
)

CREATE TABLE autor_llibre (
    idAutor NUMBER,
    PRIMARY KEY (idAutor),
    FOREIGN KEY (idAutor) REFERENCES autor(id)
);
