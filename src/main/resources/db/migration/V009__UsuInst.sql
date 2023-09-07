create table UsuInst(
Id_UsuInst BIGINT PRIMARY KEY IDENTITY,
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO),
ID_INSTRUMENTO BIGINT NOT NULL,
FOREIGN KEY (ID_INSTRUMENTO) REFERENCES Instrumento(ID_INSTRUMENTO)
)

INSERT INTO UsuInst (ID_USUARIO, ID_INSTRUMENTO) VALUES (1, 1)
INSERT INTO UsuInst (ID_USUARIO, ID_INSTRUMENTO) VALUES (2, 1)
INSERT INTO UsuInst (ID_USUARIO, ID_INSTRUMENTO) VALUES (2, 2)
