create table Pagamento(
Id_Pagamento numeric(10) constraint Id_Pagamento_Pk primary key,
Valor float not null,
metodo char(20) not null,
fk_Id_Contrato numeric(10) foreign key references Contrato(Id_Contrato)
)

INSERT INTO Pagamento(Valor, metodo, fk_Id_Contrato) VALUES (60, 'Dinheiro', 1)
INSERT INTO Pagamento(Valor, metodo, fk_Id_Contrato) VALUES (80, 'Dinheiro', 2)