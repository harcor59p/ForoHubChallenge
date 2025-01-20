alter table topicos add column activo tinyint default 1;
update topicos set activo = 1 ;