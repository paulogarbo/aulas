CREATE DATABASE bdagenda;

CREATE TABLE bdagenda.tabela_cadastro(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (100),
    telefone VARCHAR (15),
    email VARCHAR (100),
    endereco VARCHAR (100),
    nascimento VARCHAR (10),
    filhos VARCHAR (3)
);