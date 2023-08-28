create table Usuario(
Id_Usuario numeric(10) constraint Id_Usuario_Pk primary key,
Nome char (38) not null,
Email varchar(20) not null,
Senha varchar(38) not null,
Telefone numeric (11),
endereco char(30),
tipoUsuario char(13),
genero char(10) not null
)

INSERT INTO Usuario (Nome, Email, Senha, Telefone, endereco, tipoUsuario, genero) VALUES ('Pedro Silva', 'PedroS@gmail.com', 'pedrinho123', null, null, 'Contratante', 'Masculino');
INSERT INTO Usuario (Nome, Email, Senha, Telefone, endereco, tipoUsuario, genero) VALUES ('Gustavo Henrique', 'gHenrique@gmail.com', 'henrique123', null, null, 'Artista', 'Masculino');