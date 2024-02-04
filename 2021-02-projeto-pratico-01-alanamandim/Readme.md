# Projeto : Jogo Bandeira

O projeto foi criado com o intuito de simular um jogo de captura de bandeiras onde o jogo necessita de dois jogadores para ser iniciado, foi implementado uma classe auditor que é responsável pelo controle do jogo e outra classe chamada MonitorGui com o objetivo de acompanhar a movimentação gŕafica dos jogadores.

## Compilação
Comandos:

Terminal 1:
docker compose build

docker compose run auditor (sobe o container do auditor no terminal 1)

Terminal 2:
docker compose run jogador Comando.txt (sobre o container de um jogador no terminal 2)

Terminal 3:
docker compose run jogador Comando2.txt (sobre o container de um jogador no terminal 3)

Para ativar o monitorgui basta rodar a aplicação no intelig (acompanhamento gráfico do jogo)





## Funcionalidades Implementadas
Foram implementados:
 RMI
 Docker
 Interfaces IAU e IMON
 Aplicação do Jogador 
 Aplicação do Auditor
 Aplicação do MonitorGUI
 
 obs: Devido ao delay verificou-se que os movimentos printados na tela para o jogador 1 e jogador 2 acompanhar apresentam algumas divergências porém a movimentação grafica está ok.

