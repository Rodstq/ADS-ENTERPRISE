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
  estado varchar(2),
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

CREATE TABLE pedido(
   id_pedido int PRIMARY KEY, 
   data_pedido date, 
   produtos_comprados int, 
   valor_produtos float(10,2), 
   cpf_vendedor char(11),
   cpf_cliente char(11), 
   id_loja int,
   id_produto int,
   foreign key (cpf_cliente) references cliente (cpf_cliente),
   foreign key (cpf_vendedor) references vendedor (cpf_vendedor),
   foreign key (id_loja) references loja (id_loja),
   foreign key (id_produto) references produtos (id_produto)	
);

CREATE TABLE pedido_produto(
   id_produto int,
   id_pedido int,
   foreign key (id_produto) references produtos (id_produto),
   foreign key (id_pedido) references pedido (id_pedido)
);

