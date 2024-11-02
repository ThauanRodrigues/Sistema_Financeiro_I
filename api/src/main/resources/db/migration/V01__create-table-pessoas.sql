create table pessoas(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(80) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    cidade varchar(80) not null,
    estado char(80) not null,
    ativo tinyint default 1,
    primary key(id)
);