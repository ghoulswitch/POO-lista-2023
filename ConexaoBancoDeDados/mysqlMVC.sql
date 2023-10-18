CREATE DATABASE MILLYCONEXAO;
USE MILLYCONEXAO;

CREATE TABLE Funcionario(

   codigo INTEGER AUTO_INCREMENT,
   nome VARCHAR(200) NOT NULL,
   cargo VARCHAR(100) NOT NULL,
   salario decimal(9,2) NOT NULL,
   PRIMARY KEY(codigo)

 );
 
 SELECT codigo, nome, cargo, salario FROM Funcionario;
 
 INSERT INTO Funcionario(nome, cargo, salario) VALUES(?, ?, ?);