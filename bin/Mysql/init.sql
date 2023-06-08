Create table clientes(
nome varchar(50),
cpf varchar(15) primary  key not null,
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
