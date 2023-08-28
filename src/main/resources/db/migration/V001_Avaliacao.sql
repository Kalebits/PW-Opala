create table Avaliacao(
Id_Avaliacao numeric(10) constraint Id_Avaliacao_Pk primary key,
Comentario char (355) not null,
Nota numeric(5),
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario)
)

INSERT INTO Avaliacao(Comentario, Nota, fk_Id_Usuario) VALUES ('Tu eh foda d+', 5, 2)
INSERT INTO Avaliacao(Comentario, Nota, fk_Id_Usuario) VALUES ('Pessimo, melhore', 2, 2)