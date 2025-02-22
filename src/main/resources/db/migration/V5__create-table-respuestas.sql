create table respuestas (
    id bigint not null auto_increment,
    mensaje varchar(4000) not null,
    topico_id bigint not null  ,
    fechaCreacion date not null ,
    usuario_id bigint not null ,
    solucion varchar(4000) not null,

    primary key(id) ,
    constraint fk_respuestas_usuario_id foreign key(usuario_id) references usuarios(id) ,
    constraint fk_respuestas_topico_id foreign key(topico_id) references topicos(id)
)
