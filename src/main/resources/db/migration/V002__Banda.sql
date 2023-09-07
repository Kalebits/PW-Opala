create table Banda(
ID_BANDA BIGINT PRIMARY KEY IDENTITY,
NomeBanda varchar (38) not null,
Estilo varchar(20)
)

INSERT INTO Banda (NomeBanda, Estilo) VALUES ('Chitaozinho e Xororo', 'Brega Romantico')
INSERT INTO Banda (NomeBanda, Estilo) VALUES ('Baroes da Pisadinha', 'Piseiro')