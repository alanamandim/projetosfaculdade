# 2021-02-projeto-pratico-02-alanamandim

Para executar o programa basta, abrir um terminal ir até a pasta do projeto e dar o seguinte comando: ./gradlew bootRun

Para consumir o serviço rest  abra um terminal e utilize os seguintes comando abaixo utilizando o curl:

Obter ambientes ok

curl -L -X GET 'http://localhost:8080/ambiente' 

obter dispositivos ok

curl -L -X GET 'http://localhost:8080/dispositivos'

obter cenário ok

curl -L -X GET 'http://localhost:8080/cenario'
 
Obter ambiente especifico: ok
curl -L -X GET 'http://localhost:8080/ambiente/sala'

obter dispositivo espcífico: ok

curl -L -X GET 'http://localhost:8080/dispositivos/1' 

obter cenario específico ok 

curl -L -X GET 'http://localhost:8080/cenario/amanhecer' 

obter dispositivo específico de um ambiente específico

curl -L -X GET 'https://localhost:8080/ambiente/sala/dispositivos/?id=2'

obter dispositivo específico de um cenario especifico

curl -L -X GET

Adiciona ambientes: ok

curl -L -X POST 'http://localhost:8080/ambiente/sala'

adiciona cenario ok

curl -L -X POST 'http://localhost:8080/cenario/amanhecer/1/2'


adiciona dispositivo no ambiente: ok
curl -L -X POST 'http://localhost:8080/ambiente/sala/dispositivos?id=1'
curl -L -X POST 'http://localhost:8080/ambiente/sala/dispositivos?id=2'
curl -L -X POST 'http://localhost:8080/ambiente/sala/dispositivos?id=10'

adiciona dispositivo no cenario: ok
curl -L -X POST 'http://localhost:8080/cenario/amanhecer/dispositivos?id=10'
curl -L -X POST 'http://localhost:8080/cenario/amanhecer/dispositivos?id=6'
curl -L -X POST 'http://localhost:8080/cenario/amanhecer/dispositivos?id=7'

Atualiza ambiente ok

curl -L -X PUT 'http://localhost:8080/ambiente/sala?nome=quarto'

Atualiza cenario  ok

curl -L -X PUT 'http://localhost:8080/cenario/amanhecer?nome=amanhecer&inicio=3&fim=7'

Atualizar dispositivo

curl -L -X PUT 'http://localhost:8080/dispositivos/lampada/1' \
-H 'Content-Type: application/json' \
--data-raw '{
"id" : "1",
"nome" : "lampada",
"luminosidade": "2",
"ligar" : "true"
}'

curl -L -X PUT 'http://localhost:8080/dispositivos/cortina/2' \
-H 'Content-Type: application/json' \
--data-raw '{
"id" : "2",
"nome" : "cortina",
"aberta": "true"
}'

Atualiza dispositivo do ambiente
curl -L -X PUT 'http://localhost:8080/ambiente/sala/dispositivos/lampada?id=1' \
-H 'Content-Type: application/json' \
--data-raw '{
"id" : "1",
"nome" : "lampada",
"luminosidade": "5"
}'

curl -L -X PUT 'http://localhost:8080/ambiente/sala/dispositivos/cortina?id=2' \
-H 'Content-Type: application/json' \
--data-raw '{
"id" : "6",
"nome" : "cortina",
"aberta": "true"
}'

Atualiza dispositivo do cenário
curl -L -X PUT 'http://localhost:8080/cenario/amanhecer/dispositivos/lampada?id=7' \
-H 'Content-Type: application/json' \
--data-raw '{
"id" : "7",
"nome" : "lampada",
"luminosidade": "7"
}'


deleta cenario ok

curl -L -X DELETE 'http://localhost:8080/cenario/amanhecer'

deleta ambiente ok

curl -L -X DELETE 'http://localhost:8080/ambiente/sala'

deleta dispositivo do ambiente ok

curl -L -X DELETE 'http://localhost:8080/ambiente/sala/dispositivos?id=10'

deleta dispositivo do cenario ok

curl -L -X DELETE 'http://localhost:8080/cenario/amanhecer/dispositivos?id=10'

Funções implementadas:
-agrupar os dispositivos em ambientes
-definir cenários
-interagir diretamente com os dispositivos

