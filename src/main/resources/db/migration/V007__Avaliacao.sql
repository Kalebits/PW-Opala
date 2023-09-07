create table Avaliacao(
ID_AVALIACAO BIGINT PRIMARY KEY IDENTITY,
Comentario varchar (355) not null,
Nota float(5),
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Avaliacao(Comentario, Nota, ID_USUARIO) VALUES ('Tu eh foda d+', 5, 2)
INSERT INTO Avaliacao(Comentario, Nota, ID_USUARIO) VALUES ('Pessimo, melhore', 2, 2)