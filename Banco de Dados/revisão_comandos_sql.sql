-- criar database
create database loja;

-- usar database criada
use loja;

-- criar cliente 
create table cliente(
	id integer primary key unique auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null
);

-- criar pedido
create table pedido(
	id integer primary key unique auto_increment,
    data_pedido datetime,
    valor dec(10,2) not null
);

-- criar tabela relacionando cliente e pedido
create table cliente_pedido(
	id_cliente int,
    id_pedido int unique,
    constraint fk_cliente foreign key (id_cliente) references cliente(id),
    constraint fk_pedido foreign key (id_pedido) references pedido(id)
);

-- adicionar coluna telefone na tabela cliente
alter table cliente add column telefone varchar(10);

-- adicionar coluna status na tabela pedido
alter table pedido add column status varchar(50);

-- alterar tamanho do varchar da coluna telefone de cliente
alter table cliente modify telefone varchar(20);

-- alterar nome da coluna telefone de cliente
alter table cliente change telefone telefone_contato varchar(20);

-- deletando a coluna status de pedido
alter table pedido drop column status;

-- alterando nome da tabela cliente
rename table cliente to cliente_info;
