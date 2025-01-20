alter table usuarios add column activo tinyint default 1;
update usuarios set activo = 1 ;