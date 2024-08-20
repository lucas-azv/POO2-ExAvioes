-- Dropar o banco de dados se ele já existir

DROP DATABASE IF EXISTS db_avioes;
-- Criar o banco de dados
CREATE DATABASE db_avioes;
-- Usar o banco de dados recém-criado
USE db_avioes;

-- Criar a tabela tb_fabricante
CREATE TABLE tb_fabricante (
cod_fabricante INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome_fabricante VARCHAR(255),
pais_fabricante VARCHAR(255)
);

-- Criar a tabela tb_aviao
CREATE TABLE tb_aviao (
cod_aviao INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome_aviao VARCHAR(255),
cod_fabricante INTEGER NOT NULL,
FOREIGN KEY (cod_fabricante) REFERENCES tb_fabricante(cod_fabricante)
);

-- Inserir dados na tabela tb_fabricante
INSERT INTO tb_fabricante(nome_fabricante, pais_fabricante) VALUES
('Embraer', 'Brasil'),
('Boeing', 'USA'),
('Airbus', 'França');

-- Inserir dados na tabela tb_aviao
INSERT INTO tb_aviao(nome_aviao, cod_fabricante) VALUES
('EMB 100', 1),
('Boeing 737 MAX', 2),
('A320', 3);