create table usuarios(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    senha varchar(100) not null,
    ativo tinyint default 1,
    primary key(id)
);