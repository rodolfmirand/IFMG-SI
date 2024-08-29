use biblioteca;

select * from autor where id_autor > 5;

select * from livro;
select * from obra;
select * from autor;

select * from livro where year(DATA_AQUISICAO) = 2024 and NR_OBRA <= 5;

select * from livro where EDICAO = 1 and NR_OBRA = (select NR_OBRA from obra where titulo like '%Senhor%'); 

select NR_OBRA from obra where TITULO like '%Senhor%';

select * from autor where NOME like '%King%' and ID_AUTOR <= 5;

select * from obra where ID_GENERO = 'FIC' or ID_GENERO = 'ROM'; 

select * from livro where DATA_AQUISICAO > '2024-01-15';

select * from movimentacao where DATA_EMPRESTIMO between '2024-07-01' and '2024-07-15';

drop database biblioteca;
