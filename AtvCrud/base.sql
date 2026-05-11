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

--Para testes legais:

INSERT INTO projetos 
(empresaResponsavel, tipoDeProjeto, nomeDoProjeto, dataDeInicio, dataDeFinalizacao, status)
VALUES
('TechNova Solutions', 'Sistema Web', 'Portal Corporativo','2025-01-10', '2025-04-20', 'Em andamento'),
('InovaTI', 'Aplicativo Mobile', 'App Delivery Fast','2025-02-01', '2025-06-15', 'Não iniciado'),
('CodeWorks', 'Banco de Dados', 'Migração Oracle','2024-11-05', '2025-01-30', 'Finalizado'),
('Alpha Engenharia', 'Infraestrutura', 'Servidor Central','2025-03-12', '2025-07-25', 'Em andamento'),
('VisionTech', 'Inteligência Artificial', 'ChatBot Atendimento','2025-01-18', '2025-05-10', 'Cancelado'),
('DataCore', 'Sistema Desktop', 'Controle Financeiro','2024-09-02', '2024-12-18', 'Finalizado'),
('CyberLink', 'Segurança', 'Monitoramento de Rede','2025-04-01', '2025-08-30', 'Não iniciado'),
('FutureDev', 'Sistema Web', 'Plataforma Educacional','2025-02-22', '2025-09-12', 'Em andamento'),
('NexusSoft', 'Cloud Computing', 'Backup em Nuvem','2024-10-10', '2025-02-14', 'Finalizado'),
('ByteForce', 'Automação', 'Controle Industrial','2025-05-05', '2025-11-30', 'Não iniciado');
