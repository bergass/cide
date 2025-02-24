INSERT INTO persona (dni, nom, llinatges, adreca, codi_postal, telefon) VALUES
('89237121C', 'Marc', 'Martínez López', 'Carrer A, 10', 07001, 629084791);

INSERT INTO persona (dni, nom, llinatges, adreca, codi_postal, telefon) VALUES
('87654321B', 'Maria', 'Pérez García', 'Carrer B, 5', 07002, 600654321);

INSERT INTO vehicle (matricula, marca, model, dni_persona) VALUES
('9999LLJ', 'Toyota', 'Corolla', '89237121C');

INSERT INTO vehicle (matricula, marca, model, dni_persona) VALUES
('3333BBO', 'Ford', 'Focus', '87654321B');

INSERT INTO vehicle (matricula, marca, model, dni_persona) VALUES
('6666TRV', 'Volkswagen', 'Golf', '89237121C');

INSERT INTO multa (fecha, hora, lloc, importe, matricula_vehicle) VALUES
(SYSDATE, SYSDATE, 'Carrer Major', 150, '3333BBO');

INSERT INTO accident (fecha, lloc, hora) VALUES
(SYSDATE, 'Ronda Litoral', SYSDATE);

INSERT INTO accident_vehicle (matricula_vehicle, codi_accident, informe_participacio) VALUES
('3333BBO', (SELECT codi FROM accident WHERE lloc = 'Ronda Litoral' AND fecha = SYSDATE), 'Impacte frontal amb danys moderats.');

INSERT INTO accident_vehicle (matricula_vehicle, codi_accident, informe_participacio) VALUES
('6666TRV', (SELECT codi FROM accident WHERE lloc = 'Ronda Litoral' AND fecha = SYSDATE), 'Impacte lateral amb danys importants.');
