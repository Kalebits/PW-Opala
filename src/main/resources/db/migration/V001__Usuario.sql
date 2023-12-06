create table Usuario(
ID_USUARIO BIGINT PRIMARY KEY IDENTITY,
Nome varchar (38) not null,
cpf varchar(20) not null,
Email nvarchar(255) not null,
Senha varchar(38) not null,
foto varchar(MAX), -- novo
descricao varchar(MAX), -- novo
Telefone varchar(20),
Endereco varchar(30),
CEP BIGINT, -- novo
genero varchar(10),
exclusao varchar(9),
ID_CONTRATO BIGINT
)

INSERT INTO Usuario (Nome, cpf, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao, ID_CONTRATO) VALUES
('Pedro Silva', 04986984594, 'PedroS@gmail.com', 'pedrinho123', 'cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png',
 'Ja fiz covers de jorge e matheus', null, null, null, 'MASCULINO', 'ATIVO', 1);

INSERT INTO Usuario (Nome, cpf, Email, Senha, foto, descricao, Telefone, Endereco, CEP, genero, exclusao, ID_CONTRATO) VALUES
    ('Gustavo Henrique', 4986984594, 'gHenrique@gmail.com', 'henrique123', 'cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png',
     'EU VOU TOMAR UM TAKAKA', null, null, null, 'MASCULINO', 'ATIVO', 1);