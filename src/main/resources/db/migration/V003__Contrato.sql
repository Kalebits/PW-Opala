create table Contrato(
ID_CONTRATO BIGINT PRIMARY KEY IDENTITY,
dt_Cont date not null,
Duracao int not null,
dt_Apresentacao date not null,
ID_Anuncio BIGINT NOT NULL,
FOREIGN KEY (ID_Anuncio) REFERENCES Anuncio(ID_Anuncio),
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Contrato (dt_Cont, Duracao, dt_Apresentacao, ID_Anuncio, ID_USUARIO) VALUES
('2023-08-23', '90', '2024-01-12', '1', '1');

INSERT INTO Contrato (dt_Cont, Duracao, dt_Apresentacao, ID_Anuncio, ID_USUARIO) VALUES
('2023-09-22', '120', '2024-02-12', '2', '2');

ALTER TABLE Usuario
ADD FOREIGN KEY (ID_CONTRATO) REFERENCES Contrato(ID_CONTRATO);