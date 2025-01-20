alter table perfiles add column activo tinyint default 1;
update perfiles set activo = 1 ;