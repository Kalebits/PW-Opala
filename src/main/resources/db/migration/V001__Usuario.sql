create table Usuario(
ID_USUARIO BIGINT PRIMARY KEY IDENTITY,
Nome varchar (38) not null,
cpf BIGINT not null,
Email nvarchar(255) not null,
Senha varchar(38) not null,
foto TEXT, -- novo
descricao TEXT, -- novo
Telefone int,
Endereco varchar(30),
CEP BIGINT, -- novo
genero varchar(10) not null,
exclusao varchar(9)
)

INSERT INTO Usuario (Nome, cpf, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao) VALUES ('Pedro Silva', 04986984594, 'PedroS@gmail.com', 'pedrinho123', 'Ja fiz covers de jorge e matheus', null, null, null, null, 'MASCULINO', 'ATIVO');
INSERT INTO Usuario (Nome, cpf, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao) VALUES ('Gustavo Henrique', 4986984594, 'gHenrique@gmail.com', 'henrique123', 'EU VOU TOMAR UM TAKAKA', null, null, null, null, 'MASCULINO', 'ATIVO');