CREATE TABLE estoque(
  id_estoque int PRIMARY KEY NOT NULL,
  quantidade_produto int NOT NULL
);


CREATE TABLE vendedor(
 cpf_vendedor char(11) PRIMARY KEY NOT NULL,
 nome_vendedor varchar(50) NOT NULL,
 data_nascimento date NOT NULL
);


CREATE TABLE vendedor_endereco(
 cep varchar(8) NOT NULL,
 estado varchar(50) NOT NULL,
 cidade varchar(50) NOT NULL, 
 rua varchar(50) NOT NULL,
 complemento varchar(50) NOT NULL,
 cpf_vendedor char(11) NOT NULL,
 foreign key (cpf_vendedor) references vendedor (cpf_vendedor)
);


CREATE TABLE cliente(
 cpf_cliente char(11) PRIMARY KEY NOT NULL,
 nome_cliente varchar(50) NOT NULL,
 nascimento_cliente date NOT NULL,
 telefone varchar(20)
);


CREATE TABLE cliente_endereco(
 cep char(8) NOT NULL,
 estado varchar(20) NOT NULL,
 cidade varchar(50) NOT NULL,
 bairro varchar(50) NOT NULL,
 rua varchar(50) NOT NULL,
 complemento varchar(50) NOT NULL,
 cpf_cliente char(11) NOT NULL,
 foreign key (cpf_cliente) references cliente (cpf_cliente)
);

CREATE TABLE fornecedor(
   cnpj_fornecedor char(14) PRIMARY KEY NOT NULL,
   nome_fornecedor varchar(50) NOT NULL
);

CREATE TABLE fornecedor_endereco(
 cep char(8) NOT NULL,
 estado varchar(20) NOT NULL,
 cidade varchar(50) NOT NULL,
 bairro varchar(50) NOT NULL,
 rua varchar(50) NOT NULL,
 complemento varchar(50) NOT NULL,
 cnpj_fornecedor char(14) NOT NULL,
 foreign key (cnpj_fornecedor) references fornecedor (cnpj_fornecedor)
);


CREATE TABLE produto(
  id_produto int PRIMARY KEY NOT NULL,
  nome_produto varchar(50) NOT NULL,
  valor_de_venda float(10,2) NOT NULL,
  id_estoque int NOT NULL,
  cnpj_fornecedor char(14) NOT NULL,
  foreign key (id_estoque) references estoque (id_estoque),
  foreign key (cnpj_fornecedor) references fornecedor (cnpj_fornecedor)
);


CREATE TABLE pedido (
 id_pedido int PRIMARY KEY NOT NULL,
 data_pedido date NOT NULL,
 cpf_cliente char(11) NOT NULL,
 cpf_vendedor char(11) NOT NULL,
 foreign key (cpf_cliente) references cliente (cpf_cliente),
 foreign key (cpf_vendedor) references vendedor (cpf_vendedor)
);


CREATE TABLE pedido_produto(
  id_produto int NOT NULL,
  id_pedido int NOT NULL,
  valor_total_produto_comprado float(10,2) NOT NULL,
  quantidade_comprada int NOT NULL,
  foreign key (id_produto) references produto (id_produto),
  foreign key (id_pedido) references pedido (id_pedido)
);

INSERT INTO estoque (id_estoque, quantidade_produto)
VALUES (1, 50);

INSERT INTO estoque (id_estoque, quantidade_produto)
VALUES (2, 50);

INSERT INTO vendedor (cpf_vendedor, nome_vendedor, data_nascimento)
VALUES ('12345678901', 'otavio', '1990-01-01');

INSERT INTO vendedor_endereco (cep, estado, cidade, rua, complemento, cpf_vendedor)
VALUES ('12345678', 'São Paulo', 'São Paulo', 'Rua A', 'Complemento A', '12345678901');

INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone)
VALUES ('98765432101', 'julia', '1995-05-10', '(11) 98765-4321');

INSERT INTO cliente_endereco (cep, estado, cidade, bairro, rua, complemento, cpf_cliente)
VALUES ('87654321', 'Acre', 'acre', 'Centro', 'Rua B', 'Complemento B', '98765432101');

INSERT INTO cliente (cpf_cliente, nome_cliente, nascimento_cliente, telefone)
VALUES ('99995555222', 'julia', '1995-05-10', '(22) 21');

INSERT INTO cliente_endereco (cep, estado, cidade, bairro, rua, complemento, cpf_cliente)
VALUES ('33334444', 'mg', 'mg', 'longe', 'Rua c', 'Complemento c', '99995555222');

INSERT INTO fornecedor(cnpj_fornecedor, nome_fornecedor)
VALUES('11112222444499', 'loja');

INSERT INTO fornecedor_endereco(cep, estado, cidade, bairro, rua, complemento, cnpj_fornecedor)
VALUES('44448888', 'PE', 'recife', 'bairro', 'rua', 'complemento', '11112222444499');

INSERT INTO produto(id_produto, nome_produto, valor_de_venda, id_estoque, cnpj_fornecedor)
VALUES (1, 'Produto A', 9.99, 1, '11112222444499');

INSERT INTO produto(id_produto, nome_produto, valor_de_venda, id_estoque, cnpj_fornecedor)
VALUES (2, 'Produto B', 100.99, 2, '11112222444499');

INSERT INTO pedido (id_pedido, data_pedido, cpf_vendedor, cpf_cliente)
VALUES (1, '2023-06-10','12345678901','98765432101');

INSERT INTO pedido (id_pedido, data_pedido, cpf_vendedor, cpf_cliente)
VALUES (2, '2010-06-17','12345678901','99995555222');

INSERT INTO pedido_produto (id_produto, id_pedido, valor_total_produto_comprado, quantidade_comprada)
VALUES (1, 1, 19.98, 2);

INSERT INTO pedido_produto (id_produto, id_pedido, valor_total_produto_comprado, quantidade_comprada)
VALUES (2, 1, 201.98, 2);

INSERT INTO pedido_produto (id_produto, id_pedido, valor_total_produto_comprado, quantidade_comprada)
VALUES (1, 2, 19.98, 2);

