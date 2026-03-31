CREATE DATABASE dblocadora
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE tbveiculos(
    codigo int(4) not null AUTO_INCREMENT,
    marca varchar(30) not null,
    modelo varchar(40) not null,
    chassi varchar(30) not null,
    ano int(4) not null,
    PRIMARY KEY(codigo)
);

CREATE TABLE tbvendedores(
    codigo int(4) not null AUTO_INCREMENT,
    nome varchar(100) not null,
    contato varchar(20) not null,
    email varchar(100) not null,
    cpf varchar(14) not null,
    numCracha varchar(20) not null,
    anoAdmissao int not null,
    cargo varchar(20) not null,
    PRIMARY KEY(codigo) 
);