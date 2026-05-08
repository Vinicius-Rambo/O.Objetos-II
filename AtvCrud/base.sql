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

INSERT INTO projetos(empresaResponsavel, tipoDeProjeto, nomeDoProjeto, dataDeInicio, dataDeFinalizacao, status)
VALUES
('Google', 'Sistema Web', 'Portal RH', '01-05-2026', '20-07-2026', 'Em andamento'),
('Microsoft', 'Aplicativo Mobile', 'App Financeiro', '10-03-2026', '15-06-2026', 'Finalizado'),
('Amazon', 'Banco de Dados', 'Controle Estoque', '05-01-2026', '30-12-2026', 'Não iniciado');

SELECT * FROM projetos;
