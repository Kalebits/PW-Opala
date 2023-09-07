create table Contrato(
ID_CONTRATO BIGINT PRIMARY KEY IDENTITY,
dt_Cont date not null,
Duracao int not null,
dt_Apresentacao date not null
)

INSERT INTO Contrato (dt_Cont, Duracao, dt_Apresentacao) VALUES ('2023-08-23', '90', '2024-01-12');
INSERT INTO Contrato (dt_Cont, Duracao, dt_Apresentacao) VALUES ('2023-09-22', '120', '2024-02-12');