create table Anuncio(
ID_Anuncio BIGINT PRIMARY KEY IDENTITY,
descricao TEXT not null,
data date,
valor double precision,
tipo varchar(11),
exclusao varchar(9),
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Anuncio (descricao, data, valor, tipo, exclusao, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'CONTRATANTE', 'ATIVO', 1)
INSERT INTO Anuncio (descricao, data, valor, tipo, exclusao, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'ARTISTA', 'ATIVO', 2)
INSERT INTO Anuncio (descricao, data, valor, tipo, exclusao, ID_USUARIO) VALUES ('tocar na casinha da esquina tal', '2024-01-12', 1000, 'CONTRATANTE', 'ATIVO', 2)
INSERT INTO Anuncio (descricao, data, valor, tipo, exclusao, ID_USUARIO) VALUES ('fotografar casamento em SP', '2024-01-07', 1000, 'ARTISTA', 'ATIVO', 1)
