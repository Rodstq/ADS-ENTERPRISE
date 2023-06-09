Create table clientes(
cpf varchar(15) primary  key,
nome varchar(50),
dataNascimento varchar(10),
telefone varchar(15)
);



CREATE TABLE clientesEndereco (
  cep varchar(15),
  estado varchar(15),
  cidade varchar(25),
  bairro varchar(25),
  rua varchar(25),
  cpf varchar(15),
  FOREIGN KEY (cpf) REFERENCES clientes(cpf)
);


CREATE TABLE produtos (
  idProduto VARCHAR(50) PRIMARY KEY NOT NULL,
  nomeProduto VARCHAR(50),
  quantidadeProduto VARCHAR(50),
  valorProduto VARCHAR(50),
  dataValidade VARCHAR(50),
  dataEntrada VARCHAR(50),
  dataSaida VARCHAR(50)
);

create table  cliente_produto(
cpf varchar (15),
idProduto varchar(50),
foreign key(cpf) references clientes(cpf),
foreign key(idProduto) references produtos(idProduto)
);