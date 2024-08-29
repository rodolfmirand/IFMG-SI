use faculdade;

select nacionalidade from aluno;

select distinct(nacionalidade) from aluno;

select distinct(nacionalidade) as 'Nacionalidades Distintas' from aluno;

select count(distinct(nacionalidade)) as 'Nacionalidades Distintas' from aluno;

select count(nome) from aluno;

select max(peso) as 'Maior Peso' from aluno;

select max(totalAulas) as 'Total Aulas em 2016' from curso where ano = '2016';

select min(peso) as 'Menor Peso' from aluno;

select min(totalAulas) as 'Total Aulas em 2018' from curso where ano = '2018';

select sum(carga) as 'Somas de Carga Horária' from curso;

select sum(peso) as 'Soma dos pesos de alunos irlandeses' from aluno  where nacionalidade = 'Irlanda';

select round(avg(peso), 2) from aluno;
select avg(peso) from aluno;
select format(avg(peso),2) from aluno;

select * from curso where carga > (select avg(carga) from curso);

alter table curso rename column totaulas to totalAulas;

select nome from aluno where cursopreferido in (select idcurso from curso where carga > (select avg(carga) from curso));
select nome from aluno where cursopreferido in (select idcurso from curso where carga = (select max(carga) from curso));

-- group by != distinct()
select carga from curso group by carga; -- agrupados
select distinct(carga) from curso; -- distinguidos

select carga, count(nome) as 'Quantidade de Cursos' from curso group by carga;

select nacionalidade, count(nacionalidade) as 'qtd' from aluno group by nacionalidade order by qtd;

select cursopreferido, count(nome) from aluno where nacionalidade = 'EUA' group by cursopreferido;

-- filtro para agrupamento
select carga, count(nome) as 'qtd' from curso group by carga having count(nome) > 3;

select profissao, count(profissao) from aluno group by profissao;
select sexo, count(sexo) from aluno where nascimento > '2005-01-01' group by sexo;
select nacionalidade, count(nacionalidade) as 'qtd' from aluno where nacionalidade != 'Brasil' group by nacionalidade having qtd > 3;
select peso, count(*) from aluno where peso > 100 and altura > (select avg(altura) from aluno) group by altura; -- errado
select * from curso where ano >= 2015 group by carga having carga > (select avg(carga) from curso); -- errado

-- join
select aluno.nome, aluno.cursopreferido, curso.nome, curso.ano from aluno join curso;
select aluno.nome, aluno.cursopreferido, curso.nome, curso.ano from aluno, curso where aluno.cursopreferido = curso.idCurso;
select aluno.nome, aluno.cursopreferido, curso.nome, curso.ano from aluno inner join curso on aluno.cursopreferido = curso.idCurso;
select a.nome, a.cursopreferido, c.nome, c.ano from aluno as a inner join curso as c on a.cursopreferido = c.idCurso;
-- left join 
select a.nome, c.nome from aluno as a left join curso as c on a.cursopreferido = c.idCurso;
-- right join
select a.nome, c.nome from aluno as a right join curso as c on a.cursopreferido = c.idCurso;
-- full join 
select a.nome, c.nome from aluno as a left join curso as c on a.cursopreferido = c.idCurso union select a.nome, c.nome from aluno as a right join curso as c on a.cursopreferido = c.idCurso;

select * from assiste;
select a.nome, c.nome from aluno as a join assiste as s on a.id = s.idaluno join curso as c on s.idcurso = c.idcurso;
select * from aluno as a join assiste as s on a.id = s.idaluno;
select * from aluno as a left join assiste as s on a.id = s.idaluno;
select * from aluno as a right join assiste as s on a.id = s.idaluno;

select * from curso order by carga;
use faculdade;
select * from aluno;
select * from curso;