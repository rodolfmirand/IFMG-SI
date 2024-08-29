use loja;

load data infile 'C:/dadosCliente.csv'
into table cliente_info
fields terminated by ','
enclosed by '"'
lines terminated by '\n'
ignore 1 lines 
(nome, email, telefone_contato);

select * from cliente_info;