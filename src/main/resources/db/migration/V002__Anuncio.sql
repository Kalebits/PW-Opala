create table Anuncio(
ID_Anuncio BIGINT PRIMARY KEY IDENTITY,
descricao TEXT not null,
data date,
valor double precision,
tipo varchar(11),
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'CONTRATANTE', 1)
INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'CONTRATANTE', 2)
INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'CONTRATANTE', 2)
INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('fotografar casamento em SP', '2024-01-07', 1000, 'CONTRATANTE', 1)
INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('Dançar no evento cultural em SP', '2024-01-15', 1000, 'CONTRATANTE', 1)
INSERT INTO Anuncio (descricao, data, valor, tipo, ID_USUARIO) VALUES ('Cantar no grill bar - RJ', '2024-01-18', 1000, 'CONTRATANTE', 2)