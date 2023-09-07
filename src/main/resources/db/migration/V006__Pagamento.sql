create table Pagamento(
ID_PAGAMENTO BIGINT PRIMARY KEY IDENTITY,
Valor float not null,
metodo varchar(20) not null,
ID_CONTRATO BIGINT NOT NULL,
FOREIGN KEY (ID_CONTRATO) REFERENCES Contrato(ID_CONTRATO)
)

INSERT INTO Pagamento(Valor, metodo, ID_CONTRATO) VALUES (60, 'Dinheiro', 1)
INSERT INTO Pagamento(Valor, metodo, ID_CONTRATO) VALUES (80, 'Dinheiro', 2)