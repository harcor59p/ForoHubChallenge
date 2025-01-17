create table topicos (
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(4000) not null ,
    fechaCreacion date not null,
    status varchar(100) ,
    usuario_id bigint not null ,
    curso_id bigint not null ,


    primary key(id) ,
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id) ,
    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id)
)
