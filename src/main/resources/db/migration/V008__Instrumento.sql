create table Instrumento(
ID_INSTRUMENTO BIGINT PRIMARY KEY IDENTITY,
descricao varchar(20)
)

INSERT INTO Instrumento (descricao) VALUES ('teclado');
INSERT INTO Instrumento (descricao) VALUES ('violao')