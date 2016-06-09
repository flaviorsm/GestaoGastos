CREATE database gestao;

use gestao;

CREATE TABLE Movimentacao (
id_mov int NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_categoria int NOT NULL,
valor float NOT NULL,
data date NOT NULL,
descricao varchar(50) NOT NULL,
status binary NOT NULL
)ENGINE=InnoDB;


CREATE TABLE Categoria (
id_categoria int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome_categoria varchar(50) NOT NULL
);

CREATE TABLE Saldo (
id_saldo int NOT NULL AUTO_INCREMENT PRIMARY KEY,
saldo float
);

CREATE TABLE Fixa (
id_fixa int NOT NULL AUTO_INCREMENT PRIMARY KEY,
id_categoria int NOT NULL,
valor float NOT NULL,
descricao varchar(50) NOT NULL,
dia date NOT NULL,
FOREIGN KEY(id_categoria) REFERENCES Categoria (id_categoria)
ON DELETE CASCADE
)ENGINE=InnoDB;


ALTER TABLE Movimentacao ADD CONSTRAINT FOREIGN KEY(id_categoria) REFERENCES Categoria (id_categoria) ON DELETE CASCADE;
