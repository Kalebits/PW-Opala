create table Usuario(
ID_USUARIO BIGINT PRIMARY KEY IDENTITY,
Nome varchar (38) not null,
Email varchar(20) not null,
Senha varchar(38) not null,
Telefone int,
Endereco varchar(30),
tipoUsuario varchar(13),
genero varchar(10) not null
)

INSERT INTO Usuario (Nome, Email, Senha, Telefone, Endereco, tipoUsuario, genero) VALUES ('Pedro Silva', 'PedroS@gmail.com', 'pedrinho123', null, null, 'FISICA', 'MASCULINO');
INSERT INTO Usuario (Nome, Email, Senha, Telefone, Endereco, tipoUsuario, genero) VALUES ('Gustavo Henrique', 'gHenrique@gmail.com', 'henrique123', null, null, 'FISICA', 'MASCULINO');