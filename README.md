# Encurtador-de-links
Api feita com SpringBoot, usando Jpa e um pouco de JDBC Template


Utilizado o Insomnia para teste de rotas: 

USUARIO

GET : http://localhost:8080/api/v2/url-curtas/usuario
Retornar um usuario já cadastrado através do email e senha.

GETONE : http://localhost:8080/api/v2/url-curtas/usuario/id
Retornar um usuario com os seus links já cadastrados.

POST: http://localhost:8080/api/v2/url-curtas/salvar
Salva um Usuario no banco de dados e retorna o seu body.

DELETE: http://localhost:8080/api/v2/url-curtas/deletar/id
Retorna 200 OK com o usuario já deletado do banco de dados.

PUT: http://localhost:8080/api/v2/url-curtas/alterar/id
Retorna um 201, ele muda a senha do usuario;


URL

POST: http://localhost:8080/api/v2/url-curtas/salvar/idUsuario
Retorna URL e a URL ja comprimida.

DELETE: http:localhost:8080/api/v2/url-curtas/deletarLink/idLink
Retorna 200 Ok com a url já deletada do banco de dados.

GET: http://localhost:8080/api/v2/url-curtas/decode/linkCurto
Retorna a página descompactada.
