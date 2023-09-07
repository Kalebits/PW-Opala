create table Midia(
ID_MIDIA BIGINT PRIMARY KEY IDENTITY,
videoUrl TEXT not null,
Descricao TEXT,
ID_USUARIO BIGINT NOT NULL,
FOREIGN KEY (ID_USUARIO) REFERENCES Usuario(ID_USUARIO)
)

INSERT INTO Midia(videoUrl, Descricao, ID_USUARIO) VALUES ('https://www.youtube.com/watch?v=8N-6CSOyCU4', null, 2)
INSERT INTO Midia(videoUrl, Descricao, ID_USUARIO) VALUES ('https://www.youtube.com/watch?v=TCLGN6m6AMI', null, 1)