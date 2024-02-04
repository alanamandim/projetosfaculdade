# Comentários

## Modelagem

- Tabela `Preço` não faz sentido. Será necessário rever `produto`, `históriopreço` e `preço`
  - Poderia eu associar o mesmo "preço" a diferentes produtos? Por qual motivo isso seria necessário?
  - Um mesmo produto poderia estar associado a diferentes "preços" em uma mesma data
- Uma mesma máquina poderá estar associada em diferentes locais em um mesmo período. Isso está errado
- No `consumo` eu poderei registrar qualquer cadeia de caracteres no 'idProduto' (mesmo que troque para INT) que pode gerar inconsistência. É necessário ter aqui uma chave estrangeira para saber o que de fato foi consumido, pois só assim conseguirá saber o valor do produto na data do consumo
- No `consumo` campo dataact deve ser do tipo `DATETIME`
- Um mesmo `usuário` poderá estar associado com múltiplos `titulares` ou `dependentes`. Isso não faz sentido. 
- Como permitir que o limite de um dependente seja aumentado somente no mês atual (caso o dependente já tenha atingido o limite no mês) e nos próximos meses continue com o limite padrão?
- No campus São José existem 4 locais onde são disponibilizadas as cafeteiras. Da forma que fez eu teria uma redundância de informações como rua, cidade, etc. Ou seja, tabela `local` não está na 3FN
- Qual dia do mês que será gerada a cobrança?
- Qual o valor da fatura? Quando ela foi paga?

### Entrega das correções

- Precisará fazer as correções antes de iniciar a implementação da aplicação em Java. 
- As correções da modelagem deverão ser colocadas no GitHub até o dia **08/06/2023**.

## Modelagem corrigida

- Remova a coluna `idPreco` da tabela `HistoricoPreco`
- Um modelo de máquina de café é capaz de fazer alguns tipos de café. Logo, um N-pra-N entre Modelo e Produto. Podem existir N máquinas reais de um mesmo modelo. Logo, um 1-pra-N entre Modelo e e Máquina. Isso precisa ser corrigido e impactará no relacionamento entre OpcoesMaquina e Consumo.

## Correção da implementação Java

- Não forneceu as dados de exemplo para executar as consultas, impossibilitando a correção
- Leia novamente a especificação do projeto e forneça as informações solicitadas

## Recuperação

- Data limite para entrega: 01/07/2023

### Correção

- Tudo ok
- Nota: 10