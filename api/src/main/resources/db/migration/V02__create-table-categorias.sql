create table categorias(
    id bigint not null auto_increment,
    nome varchar(80) not null,
    ativo tinyint default 1,
    primary key(id)
);