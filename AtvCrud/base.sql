-- Active: 1773959705348@@127.0.0.1@3306@dbProjetos
CREATE DATABASE dbProjetos;
USE dbProjetos;


CREATE TABLE projetos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    empresaResponsavel VARCHAR(150) NOT NULL,
    tipoDeProjeto VARCHAR(150) NOT NULL,
    nomeDoProjeto VARCHAR(150) NOT NULL,
    dataDeInicio DATE NOT NULL,
    dataDeFinalizacao DATE NOT NULL,
    status VARCHAR(50) NOT NULL
);

