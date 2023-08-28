create table Habilidade(
Id_Habilidade numeric(10) constraint Id_Habilidade_Pk primary key,
Descricao TEXT not null,
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario)
)

INSERT INTO Habilidade(Descricao, fk_Id_Usuario) VALUES ('Ilusionismo', 2)
INSERT INTO Habilidade(Descricao, fk_Id_Usuario) VALUES ('Malabarismo', 2)