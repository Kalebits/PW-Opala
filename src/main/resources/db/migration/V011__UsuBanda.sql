create table UsuBanda(
Id_UsuBanda BIGINT PRIMARY KEY IDENTITY,
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO),
ID_BANDA BIGINT NOT NULL,
FOREIGN KEY (ID_BANDA) REFERENCES Banda(ID_BANDA)
)

INSERT INTO UsuBanda (ID_USUARIO, ID_BANDA) VALUES (2, 2)
INSERT INTO UsuBanda (ID_USUARIO, ID_BANDA) VALUES (2, 1)