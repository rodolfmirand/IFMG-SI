select * from cliente;
select * from veiculo;
select * from patio;
select * from estaciona;
select * from modelo;

-- nome e placa dos donos de todos os veiculos
select c.nome, v.placa from cliente as c inner join veiculo as v on c.cpf = v.cliente_cpf; 

-- nome e cpf do cliente que tem veiculo com placa 'JJJ-2020'
select c.nome, c.cpf from cliente as c inner join veiculo as v on v.placa = 'JJJ-2020' and c.cpf = v.cliente_cpf;

-- placa e cor de veiculos estacionados no patio 1
select v.placa, v.cor from veiculo as v join estaciona as e on e.veiculo_placa = v.placa and e.patio_num = 1;

-- endereço, data de entrada e saido do veiculo de placa 'JEG-1010'
select p.ender, e.dtEntrada, e.dtSaida from estaciona as e join patio as p on e.veiculo_placa = 'JEG-1010' and e.patio_num = p.num;

-- quantidade de vezes que veiculos brancos estacionaram
select count(e.veiculo_placa) as 'Qtd veiculos brancos estacinanaram' from estaciona as e inner join veiculo as v on e.veiculo_placa = v.placa and  v.cor = 'Branco';

-- clientes com veiculos de modelo 1
select * from cliente as c inner join veiculo as v on c.cpf = v.cliente_cpf and v.modelo_codMod = 1;

-- nome dos clientes que estacionaram no patio 2
select c.nome from cliente as c join veiculo as v on c.cpf = v.cliente_cpf join estaciona as e on e.patio_num = 2 and e.veiculo_placa = v.placa;

-- placa e descricao do modelo de todos os carros e nome de seus donos
select v.placa, c.nome, m.desc_2 from cliente as c join veiculo as v on c.cpf = v.cliente_cpf join modelo as m on v.modelo_codMod = m.codMod;

-- 9
select c.nome, v.placa, e.dtEntrada, e.dtSaida, e.patio_num, p.ender from cliente as c
join modelo as m on (m.desc_2 = 'HB20' or m.desc_2 = 'Corola') 
join veiculo as v on v.modelo_codMod = m.codMod and c.cpf = v.cliente_cpf
join estaciona as e on e.veiculo_placa = v.placa
join patio as p on p.num = e.patio_num;

-- 10
select c.cpf, c.nome from cliente as c
join veiculo as v on v.cliente_cpf = c.cpf
join estaciona as e on e.cod = 3 and e.veiculo_placa = v.placa;

use estacionamento;


