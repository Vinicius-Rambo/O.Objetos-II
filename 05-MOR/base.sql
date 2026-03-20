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