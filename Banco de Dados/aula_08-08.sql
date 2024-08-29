
create database biblioteca;
use biblioteca;

CREATE TABLE GENERO (
ID_GENERO CHAR(3) NOT NULL PRIMARY KEY,
DESCRICAO VARCHAR(25) NOT NULL );

CREATE TABLE AUTOR (
ID_AUTOR INTEGER NOT NULL PRIMARY KEY,
NOME VARCHAR(40) NOT NULL );

CREATE TABLE USUARIO (
MATRICULA INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
NOME VARCHAR(50) NOT NULL,
SEXO CHAR(1) NOT NULL,
DATA_NASCIMENTO DATE NOT NULL,
ENDERECO VARCHAR(60) NOT NULL );

CREATE TABLE EDITORA (
ID_EDITORA CHAR(5) NOT NULL,
NOME_FANTASIA VARCHAR(60) NOT NULL,
PRIMARY KEY(ID_EDITORA) );

CREATE TABLE OBRA (
NR_OBRA INTEGER NOT NULL AUTO_INCREMENT,
TITULO VARCHAR (60) NOT NULL,
ID_GENERO CHAR (3) NOT NULL,
PRIMARY KEY (NR_OBRA),
FOREIGN KEY (ID_GENERO) 
REFERENCES GENERO (ID_GENERO) ON DELETE RESTRICT );

CREATE TABLE LIVRO (
NR_LIVRO INTEGER NOT NULL AUTO_INCREMENT,
DATA_AQUISICAO DATE NOT NULL,
EDICAO INTEGER,
NR_OBRA INTEGER NOT NULL,
ID_EDITORA CHAR(5) NOT NULL,
PRIMARY KEY (NR_LIVRO),
FOREIGN KEY (NR_OBRA) REFERENCES OBRA (NR_OBRA)
ON DELETE RESTRICT,
FOREIGN KEY (ID_EDITORA) REFERENCES
EDITORA (ID_EDITORA) ON DELETE RESTRICT );

CREATE TABLE AUTORIA (
NR_OBRA INTEGER NOT NULL,
ID_AUTOR INTEGER NOT NULL,
PRIMARY KEY (NR_OBRA, ID_AUTOR),
FOREIGN KEY (NR_OBRA) REFERENCES
OBRA (NR_OBRA) ON DELETE RESTRICT,
FOREIGN KEY (ID_AUTOR) REFERENCES
AUTOR (ID_AUTOR) ON DELETE CASCADE );

CREATE TABLE MOVIMENTACAO (
MATRICULA INTEGER NOT NULL,
NR_LIVRO INTEGER NOT NULL,
DATA_EMPRESTIMO DATE NOT NULL,
DATA_PREVISTA DATE NOT NULL,
DATA_DEVOLUCAO DATE,
PRIMARY KEY (MATRICULA, NR_LIVRO, DATA_EMPRESTIMO ) );

ALTER TABLE MOVIMENTACAO ADD MULTA NUMERIC(5,2);

ALTER TABLE MOVIMENTACAO ADD FOREIGN KEY (MATRICULA)
REFERENCES USUARIO (MATRICULA) ON DELETE RESTRICT;

ALTER TABLE MOVIMENTACAO ADD FOREIGN KEY (NR_LIVRO)
REFERENCES LIVRO (NR_LIVRO) ON DELETE RESTRICT;

-- Inserir dados na tabela GENERO
INSERT INTO GENERO (ID_GENERO, DESCRICAO) VALUES
('FIC', 'Ficção'),
('TEC', 'Tecnologia'),
('BIO', 'Biografia'),
('HIS', 'História'),
('ROM', 'Romance'),
('MYS', 'Mistério'),
('SFI', 'Ficção Científica'),
('ADV', 'Aventura'),
('HOR', 'Terror'),
('POE', 'Poesia');

-- Inserir dados na tabela AUTOR
INSERT INTO AUTOR (ID_AUTOR, NOME) VALUES
(1, 'J.K. Rowling'),
(2, 'Isaac Asimov'),
(3, 'Stephen King'),
(4, 'Jane Austen'),
(5, 'George Orwell'),
(6, 'Agatha Christie'),
(7, 'J.R.R. Tolkien'),
(8, 'Mark Twain'),
(9, 'F. Scott Fitzgerald'),
(10, 'Ernest Hemingway');

-- Inserir dados na tabela USUARIO
INSERT INTO USUARIO (NOME, SEXO, DATA_NASCIMENTO, ENDERECO) VALUES
('Carlos Silva', 'M', '1980-05-15', 'Rua das Flores, 123'),
('Maria Oliveira', 'F', '1990-07-22', 'Avenida Central, 456'),
('Pedro Santos', 'M', '1985-09-30', 'Praça do Comércio, 789'),
('Ana Costa', 'F', '1982-04-12', 'Rua dos Limoeiros, 321'),
('Roberto Almeida', 'M', '1978-11-05', 'Avenida das Palmeiras, 654'),
('Juliana Pereira', 'F', '1995-03-22', 'Rua dos Coqueiros, 987'),
('Eduardo Mendes', 'M', '1988-06-17', 'Rua das Orquídeas, 234'),
('Laura Gomes', 'F', '1992-08-30', 'Rua das Acácias, 567'),
('Bruno Lima', 'M', '1987-12-25', 'Avenida dos Jacarandás, 890'),
('Clara Martins', 'F', '1991-09-15', 'Praça das Azaléias, 345');

-- Inserir dados na tabela EDITORA
INSERT INTO EDITORA (ID_EDITORA, NOME_FANTASIA) VALUES
('P001', 'Editora ABC'),
('P002', 'Editora XYZ'),
('P003', 'Editora Global'),
('P004', 'Editora Novo Mundo'),
('P005', 'Editora Primavera'),
('P006', 'Editora Ouro'),
('P007', 'Editora Horizonte'),
('P008', 'Editora Infinito'),
('P009', 'Editora Aquarela'),
('P010', 'Editora Legado');

-- Inserir dados na tabela OBRA
INSERT INTO OBRA (TITULO, ID_GENERO) VALUES
('Harry Potter e a Pedra Filosofal', 'FIC'),
('Fundação', 'TEC'),
('O Iluminado', 'FIC'),
('Orgulho e Preconceito', 'ROM'),
('1984', 'BIO'),
('Assassinato no Expresso Oriente', 'MYS'),
('O Senhor dos Anéis', 'FIC'),
('As Aventuras de Tom Sawyer', 'ADV'),
('O Grande Gatsby', 'ROM'),
('O Velho e o Mar', 'BIO');

-- Inserir dados na tabela LIVRO
INSERT INTO LIVRO (DATA_AQUISICAO, EDICAO, NR_OBRA, ID_EDITORA) VALUES
('2024-01-10', 1, 1, 'P001'),
('2024-01-15', 1, 2, 'P002'),
('2024-02-01', 1, 3, 'P003'),
('2024-03-01', 1, 4, 'P001'),
('2024-03-10', 1, 5, 'P004'),
('2024-04-01', 1, 6, 'P005'),
('2024-04-15', 1, 7, 'P006'),
('2024-05-01', 1, 8, 'P007'),
('2024-05-15', 1, 9, 'P008'),
('2024-06-01', 1, 10, 'P009');

-- Inserir dados na tabela AUTORIA
INSERT INTO AUTORIA (NR_OBRA, ID_AUTOR) VALUES
(1, 1),  -- Harry Potter e a Pedra Filosofal - J.K. Rowling
(2, 2),  -- Fundação - Isaac Asimov
(3, 3),  -- O Iluminado - Stephen King
(4, 4),  -- Orgulho e Preconceito - Jane Austen
(5, 5),  -- 1984 - George Orwell
(6, 6),  -- Assassinato no Expresso Oriente - Agatha Christie
(7, 7),  -- O Senhor dos Anéis - J.R.R. Tolkien
(8, 8),  -- As Aventuras de Tom Sawyer - Mark Twain
(9, 9),  -- O Grande Gatsby - F. Scott Fitzgerald
(10, 10); -- O Velho e o Mar - Ernest Hemingway

-- Inserir dados na tabela MOVIMENTACAO
INSERT INTO MOVIMENTACAO (MATRICULA, NR_LIVRO, DATA_EMPRESTIMO, DATA_PREVISTA, DATA_DEVOLUCAO, MULTA) VALUES
(1, 1, '2024-07-01', '2024-07-15', NULL, NULL),
(2, 2, '2024-07-05', '2024-07-20', NULL, NULL),
(3, 3, '2024-07-10', '2024-07-25', '2024-07-20', 5.00),
(4, 4, '2024-07-12', '2024-07-26', NULL, NULL),
(5, 5, '2024-07-15', '2024-07-30', '2024-07-28', 2.00),
(6, 6, '2024-07-20', '2024-08-05', NULL, NULL),
(7, 7, '2024-07-22', '2024-08-10', NULL, NULL),
(8, 8, '2024-07-25', '2024-08-15', '2024-08-10', 3.00),
(9, 9, '2024-07-28', '2024-08-20', NULL, NULL),
(10, 10, '2024-07-30', '2024-08-25', NULL, NULL);

SELECT * FROM GENERO;
SELECT * FROM AUTOR;
SELECT * FROM USUARIO;
SELECT * FROM EDITORA;
SELECT * FROM OBRA;
SELECT * FROM LIVRO;
SELECT * FROM AUTORIA;
SELECT * FROM MOVIMENTACAO;

select * from obra where titulo like 'O%';

select * from usuario where (2024 - year(DATA_NASCIMENTO)) >= 38;
select * from usuario where year(DATA_NASCIMENTO) >= 1980 and year(DATA_NASCIMENTO) <= 1990;
-- between
select * from usuario where year(DATA_NASCIMENTO) between 1980 and 1990;

select NOME, ENDERECO from usuario where year(DATA_NASCIMENTO) > 1990;
-- in
select NOME, ENDERECO from usuario where year(DATA_NASCIMENTO) in (select distinct year(DATA_NASCIMENTO) from usuario where year(DATA_NASCIMENTO) > 1990);

select * from obra where NR_OBRA > 2 and ID_GENERO = 'FIC';

select * from usuario where SEXO = 'F' and year(DATA_NASCIMENTO) > 1985;