CREATE TABLE estoque(
   id_estoque int PRIMARY KEY,
   quantidade int,
   data_entrada date
);

CREATE TABLE loja (
   id_loja int PRIMARY KEY,
   nome_loja varchar(50),
   id_estoque int,
   foreign key (id_estoque) references estoque (id_estoque)
);

CREATE TABLE vendedor(
  cpf_vendedor char(11) PRIMARY KEY,
  nome_vendedor varchar(50),
  data_nascimento date,
  id_loja int,
  foreign key (id_loja) references loja (id_loja)
);

CREATE TABLE vendedor_endereco(
  cep varchar(8),
  estado varchar(50),
  cidade varchar(50),
  rua varchar(50),
  complemento varchar(50),
  cpf_vendedor char(11),
  foreign key (cpf_vendedor) references vendedor (cpf_vendedor)
);

CREATE TABLE cliente(
  cpf_cliente char(11) PRIMARY KEY,
  nome_cliente varchar(50),
  nascimento_cliente date,
  telefone varchar(20)
);

CREATE TABLE cliente_endereco(
  cep char(8),
  estado varchar(20),
  cidade varchar(50),
  bairro varchar(50),
  rua varchar(50),
  complemento varchar(50),
  cpf_cliente char(11),
  foreign key (cpf_cliente) references cliente (cpf_cliente)
);

CREATE TABLE produtos(
   id_produto int PRIMARY KEY, 
   nome_produto varchar(50), 
   quantidade int, 
   valor float(10,2), 
   id_estoque int,
   foreign key (id_estoque) references estoque (id_estoque)
);

CREATE TABLE pedido (
	id_pedido int PRIMARY KEY,
	data_pedido date,
	valor_produtos float(10,2),
	cpf_vendedor char(11),
	cpf_cliente char(11),
	id_loja int,
	id_produto int,
	foreign key (cpf_cliente) references cliente (cpf_cliente),
	foreign key (cpf_vendedor) references vendedor (cpf_vendedor),
	foreign key (id_loja) references loja (id_loja)
);

CREATE TABLE pedido_produto(
   id_produto int,
   id_pedido int,
   foreign key (id_produto) references produtos (id_produto),
   foreign key (id_pedido) references pedido (id_pedido)
);

INSERT INTO estoque (id_estoque, quantidade, data_entrada)
VALUES (1, 50, '2023-06-01');

INSERT INTO loja (id_loja, nome_loja, id_estoque)
VALUES (1, 'Loja A', 1);

INSERT INTO vendedor (cpf_vendedor, nome_vendedor, data_nascimento, id_loja)
VALUES ('12345678901', 'vendedor', '1990-01-01', 1);

INSERT INTO vendedor_endereco (cep, estado, cidade, rua, complemento, cpf_vendedor)
VALUES ('12345678', 'São Paulo', 'São Paulo', 'Rua A', 'Complemento A', '12345678901');

INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone)
VALUES ('98765432101', 'rafael', '2030-05-10', '819');

INSERT INTO cliente_endereco (cep, estado, cidade, bairro, rua, complemento, cpf_cliente)
VALUES ('87654321', 'PE', 'recife', 'Centro', 'Rua B', 'Complemento B', '98765432101');

INSERT INTO produtos (id_produto, nome_produto, quantidade, valor, id_estoque)
VALUES (1, 'Produto A', 10, 9.99, 1);

INSERT INTO pedido (id_pedido, data_pedido, valor_produtos, cpf_vendedor, cpf_cliente, id_loja, id_produto)
VALUES (2, '2023-06-10', 29.97, '12345678901', '98765432101', 1, 1);

INSERT INTO pedido_produto (id_produto, id_pedido)
VALUES (1, 1);



