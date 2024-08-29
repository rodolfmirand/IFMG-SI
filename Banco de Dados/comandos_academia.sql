-- 25/07 - Criação de um banco de dados
create database cadastro default character set utf8 default collate utf8_general_ci;
use cadastro;
show databases;

-- criando tabelas
create table pessoa(
idPessoa INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(30) NOT NULL,
nasc DATE,
sexo ENUM('M','F'),
peso DECIMAL(5, 2),
altura DECIMAL(3,2),
nacionalidade VARCHAR (20) default 'Brasil'
)default charset= utf8;

desc pessoa;

-- add dados
insert into pessoa(nome, nasc, sexo, peso, altura, nacionalidade) values("Joe Biden", "1947-11-20", "M", "10.0" ,"1.65", "Estados Unidos");
insert into pessoa values(default, 'Arnold Trump', '1917-12-20', 'F', '29.0' ,'1.81', 'Estados Unidos');
insert into pessoa values(default, 'Jaboc', current_date(), 'M', '100.0' ,'1.11', 'Italia');

select * from pessoa;

-- atualizando dados
update pessoa SET nasc = "2005-01-22" where idPessoa = 3;

-- nova tabela
CREATE TABLE inscritos (
id INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(130) NOT NULL UNIQUE
);
select * from inscritos;

-- Alterando a estrututra da tabela
-- add (adiciona) drop (apaga)

alter table pessoa add column profissao varchar (20);
alter table pessoa drop column profissao;


drop table inscritos;

-- aula 01/08
-- comando para modificar uma tabela
alter table pessoa modify profissao varchar(30);

-- comando para renomear uma coluna
alter table pessoa change profissao prof varchar(30);

-- comando para renomear uma tabela
alter table pessoa rename to aluno;

alter table aluno change idPessoa id int auto_increment;

-- nova tabela
CREATE TABLE curso (
idCurso INTEGER PRIMARY KEY auto_increment,
nome VARCHAR(30) NOT NULL UNIQUE,
descricao TEXT,
carga INT UNSIGNED,
total_aula INT UNSIGNED,
ano year default '2016'
);

select * from curso;

alter table curso add column idCurso INTEGER PRIMARY KEY auto_increment;

insert into curso values
(1, 'HTML4' , 'Curso de HTML5' , 40, 37, '2014'),
(2, 'Algoritmos' , 'Lógica de programação' , '20' , '15','2014'),
(3, 'Photoshop' , 'Dicas de Photoshop' , 10, 8, '2014'),
(4, 'PGP' , 'PHP para iniciantes' , 40, 20, '2010'),
(5, 'JARVA' , 'Introdução Linguagem Java' , 40, 29, '2000'),
(6, 'MySQL' , 'Banco de Dados MySQL' , 30, 15, '2016'),
(7, 'Word' , 'Curso Completo de Word' , 40, 30, '2016'),
(8, 'Sapateado' , 'Dança Rítmica' , 40, 30, '2018'),
(9, 'Cozinha árabe' , 'Aprenda a cozinhar' , 40, 30, '2018'),
(10, 'YOUTuber' , 'Ganhar seguidores' , 5, 2, '2018');

-- update
update curso set ano = '2014' where idCurso = 4;

update curso set ano = '2050', carga = '800' where ano = '2018' limit 2;

-- deletando
delete from curso where ano = '2018';

select * from aluno;

-- add chave estrangeira
alter table aluno
add idCurso int,
add constraint FK_Curso
foreign key (idCurso) references curso(idCurso);

update aluno
set idCurso = 6 
where id=1;