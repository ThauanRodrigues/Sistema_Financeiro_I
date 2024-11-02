create table lancamentos(
    id bigint not null auto_increment,
    lancamento enum('RECEITA', 'DESPESA') not null,
    descricao varchar(100) not null,
    vencimento date not null,
    pagamento date not null,
    valor decimal(10,2) not null,
    observacao varchar(100) not null,
    ativo tinyint default 1,
    id_categoria bigint(20) not null,
    id_pessoa bigint(20) not null,
    primary key(id),
    foreign key(id_categoria) references categorias(id),
    foreign key(id_pessoa) references pessoas(id)
);
