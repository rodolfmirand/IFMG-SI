load data infile 'C:\Users\rodol\Área de Trabalho\IFMG-SI\Banco de Dados\dadosCliente'
into table cliente_info
fields terminated by ','
lines terminated by '\n'
ignore 1 lines 
(nome, email, telefone_contato);

