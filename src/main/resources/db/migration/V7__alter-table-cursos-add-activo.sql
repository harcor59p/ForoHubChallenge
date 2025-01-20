alter table cursos add column activo tinyint default 1;
update cursos set activo = 1 ;