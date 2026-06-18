CREATE DATABASE db_videogames

USE db_videogames

CREATE TABLE tb_consoles (
    id INTEGER,
    nome TEXT,
    fabricante TEXT,
    anolancamento INTEGER,
    armazenamento DECIMAL(10,2),
    portatil TEXT
);

CREATE TABLE tb_jogos(
    id INTEGER,
    nome TEXT,
    genero TEXT,
    desenvolvedora TEXT,
    anoLancamento INT,
    classificacao TEXT
)