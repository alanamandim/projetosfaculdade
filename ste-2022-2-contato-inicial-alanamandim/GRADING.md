# Feedback

Nota final = 7.5

## Programa 1 - Interruptor LED
- Esquema elétrico do circuito: Não há envolvimento do ADC neste circuito. Também há uma conexão entre o cátodo do LED e o R2 que não deveria existir. O pino 3 (GND) no Arduino está conectado ao catodo do LED, e isso é estranho - para que serve este pino 3 no Arduino? Por fim, o KEY1 está sempre em alta-impedância. Você deveria conectar o R2 entre o pino 2 e o terra antes do botão.
- Máquina de estados: A condição de saída do E1 e do E2 deveria ser o tempo (o delay no loop principal). Desta forma, os repiques seriam ignorados enquanto nestes estados.
- Código-fonte: não está claro porque há a troca da sensibilidade do botão entre LOW/RISING nas mudanças de estado. O correto seria manter sempre em RISING.
- Nota: 6

## Programa 2 - Voltímetro Digital
- Esquema elétrico do circuito: A conexão dos resistores de pull-down (R2 e R3) dos botões está errada - eles devem estar diretamente nas saídas dos pinos -, deste modo os botões ficam em alta-impedância quando não pressionados.
- Máquina de estados: OK
- Código-fonte: não há necessidade de trocar a sensibilidade do botão na máquina de estados - basta fazer no setup.
- Nota: 9
