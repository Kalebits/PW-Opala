create table UsuInst(
Id_UsuInst numeric(10) constraint Id_Usuinst_Pk primary key,
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario),
fk_Id_Instrumento numeric(10) foreign key references Instrumento(Id_Instrumento)
)

INSERT INTO UsuInst (Id_UsuInst, fk_Id_Usuari, fk_Id_Instrumento) VALUES (1, 1, 1)
INSERT INTO UsuInst (Id_UsuInst, fk_Id_Usuari, fk_Id_Instrumento) VALUES (2, 2, 1)
INSERT INTO UsuInst (Id_UsuInst, fk_Id_Usuari, fk_Id_Instrumento) VALUES (2, 2, 2)
