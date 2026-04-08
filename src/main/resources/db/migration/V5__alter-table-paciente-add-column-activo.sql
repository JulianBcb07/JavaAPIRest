ALTER TABLE pacientes ADD activo tinyint;
UPDATE pacientes set activo = 1;
ALTER TABLE pacientes modify activo tinyint not null;