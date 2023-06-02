CREATE SEQUENCE produtos_seq;
CREATE TABLE produtos (
  id INTEGER DEFAULT nextval('produtos_seq') PRIMARY KEY,
  nome VARCHAR(50) NOT NULL,
  preco NUMERIC(10, 2) NOT NULL,
  quantidade int NOT NULL
);


CREATE TABLE clientes (
  cpf int PRIMARY KEY NOT NULL,
  nome varchar(50) NOT NULL,
  telefone int NOT NULL
);
