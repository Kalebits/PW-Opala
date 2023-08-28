create table Midia(
Id_Midia numeric(10) constraint Id_Midia_Pk primary key,
videoUrl TEXT not null,
Descricao TEXT,
fk_Id_Usuario numeric(10) foreign key references Usuario(Id_Usuario)
)

INSERT INTO Midia(videoUrl, Descricao, fk_Id_Usuario) VALUES ('https://www.youtube.com/watch?v=8N-6CSOyCU4', null, 2)
INSERT INTO Midia(videoUrl, Descricao, fk_Id_Usuario) VALUES ('https://www.youtube.com/watch?v=TCLGN6m6AMI', null, 1)