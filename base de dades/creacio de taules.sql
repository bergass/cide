create table persona (
   dni         varchar2(9),
   nom         varchar2(50),
   llinatges   varchar2(50),
   adreca      varchar2(50),
   codi_postal number CONSTRAINT  CK_Codi_Postal CHECK (Codi_Postal <> '07430'),
   telefon     number,
   primary key ( dni )
);

create table vehicle (
   matricula   varchar2(7),
   marca       varchar2(50),
   model       varchar2(50) CONSTRAINT CK_Model CHECK (Model <> 'RB19'),
   dni_persona varchar2(9),
   primary key ( matricula ),
   foreign key ( dni_persona )
      references persona ( dni )
);

create table multa (
   codi              number
      generated as identity
   primary key,
   fecha              date,
   hora              date,
   lloc              varchar2(50),
   importe            number CONSTRAINT CK_Import CHECK (Import >= 100),
   matricula_vehicle varchar2(7),
   foreign key ( matricula_vehicle )
      references vehicle ( matricula )
);

create table accident (
   codi number
      generated as identity
   primary key,
   fecha date,
   lloc varchar2(50),
   hora date
);

create table accident_vehicle (
   matricula_vehicle    varchar2(7),
   codi_accident        number,
   informe_participacio varchar2(50),
   primary key ( matricula_vehicle,
                 codi_accident ),
   foreign key ( matricula_vehicle )
      references vehicle ( matricula ),
   foreign key ( codi_accident )
      references accident ( codi )
);