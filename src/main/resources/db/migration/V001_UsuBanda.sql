create table UsuBanda(
Id_UsuBanda numeric(10) constraint Id_UsuBanda_Pk primary key,
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario),
fk_Id_Banda numeric(10) foreign key references Banda(Id_Banda)
)

INSERT INTO UsuBanda (fk_Id_Usuario, fk_Id_Banda) VALUES (2, 2)
INSERT INTO UsuBanda (fk_Id_Usuario, fk_Id_Banda) VALUES (2, 1)