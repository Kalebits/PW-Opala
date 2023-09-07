create table Habilidade(
ID_HABILIDADE BIGINT PRIMARY KEY IDENTITY,
Descricao TEXT not null,
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Habilidade(Descricao, ID_USUARIO) VALUES ('Ilusionismo', 2)
INSERT INTO Habilidade(Descricao, ID_USUARIO) VALUES ('Malabarismo', 2)