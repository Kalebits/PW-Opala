create table Instrumento(
Id_Instrumento numeric(10) constraint Id_Instrumento_Pk primary key,
descricao char(20)
)

INSERT INTO Instrumento (descricao) VALUES ('teclado');
INSERT INTO Instrumento (descricao) VALUES ('violao')