create table Usuario(
ID_USUARIO BIGINT PRIMARY KEY IDENTITY,
Nome varchar (38) not null,
Email varchar(20) not null,
Senha varchar(38) not null,
foto varchar(max), -- novo
descricao varchar(255), -- novo
Telefone int,
Endereco varchar(30),
CEP BIGINT, -- novo
genero varchar(10) not null,
exclusao varchar(9)
)

INSERT INTO Usuario (Nome, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao) VALUES ('Pedro Silva', 'PedroS@gmail.com', 'pedrinho123', 'Ja fiz covers de jorge e matheus', null, null, null, null, 'MASCULINO', 'ATIVO');
INSERT INTO Usuario (Nome, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao) VALUES ('Gustavo Henrique', 'gHenrique@gmail.com', 'henrique123', 'EU VOU TOMAR UM TAKAKA', null, null, null, null, 'MASCULINO', 'ATIVO');