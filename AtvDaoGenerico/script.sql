CREATE DATABASE db_videogames;

USE db_videogames;

CREATE TABLE tb_consoles (
    id INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    fabricante TEXT NOT NULL,
    anolancamento INTEGER NOT NULL,
    armazenamento DECIMAL(10,2),
    portatil TEXT
);

CREATE TABLE tb_jogos (
    id INTEGER PRIMARY KEY,
    nome TEXT NOT NULL,
    genero TEXT NOT NULL,
    desenvolvedora TEXT NOT NULL,
    anolancamento INTEGER,
    classificacao TEXT
);