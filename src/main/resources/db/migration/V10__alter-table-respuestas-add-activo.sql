alter table respuestas add column activo tinyint default 1;
update respuestas set activo = 1 ;