create table UsuCont(
Id_UsuCont numeric(10) constraint Id_UsuCont_Pk primary key,
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario),
fk_Id_Contrato numeric(10) foreign key references Contrato(Id_Contrato)
)


INSERT INTO UsuCont (fk_Id_Usuario, fk_Id_Contrato) VALUES (2, 1)
INSERT INTO UsuCont (fk_Id_Usuario, fk_Id_Contrato) VALUES (1, 1)
INSERT INTO UsuCont (fk_Id_Usuario, fk_Id_Contrato) VALUES (2, 2)
INSERT INTO UsuCont (fk_Id_Usuario, fk_Id_Contrato) VALUES (1, 2)