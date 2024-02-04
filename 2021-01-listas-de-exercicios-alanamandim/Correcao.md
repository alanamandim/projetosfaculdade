### alanamandim
#### Lista 01
  - Organização do repositório está ok, mas o link no Readme.md para o diretório `lista-01` não deve ter `/` na frente.
  - Nota: 10
#### Lista 02
  - Exercício 3
      - Atributos da classe Torre devem ser exclusivos para representar uma torre. Não deveria usar atributos como se fossem "variáveis globais", "flags", como fez como `incorreto`, `ponto`, `px` e `py`.
  - Nota: 10

#### Lista 03

  - Exercício 02
      - A lógica de analisar se é M, D ou E é responsabilidade do Robô e não da classe Principal
      - Não apresenta a biblioteca `algs4.jar` e deveria estar no diretório do projeto.
  - Exercício 03
      - Deveria ter um método para movimentar sem parâmetros
  - Nota: 8

#### Lista 04

- Exercício 01
  - Os recursos (HDD e RAM) não são consumidos ou devolvidos a máquina real quando uma máquina virtual é criada ou excluída
- Exercício 02
  - Um rotor deveria representado como instância de uma classe Rotor. Fazer uma única classe `Rotores` não é adequado
  - O drone poderia ter 1 ou 2 câmeras de vídeo e isso não foi representado
  - Constantes devem ser escritas em CAIXA ALTA, porém a potência máxima e mínima é do Rotor e não do Drone.
  - A coordenada inicial é do Drone e não do GPs. 
- Nota: 8

#### Lista 05

- Teste de unidade deveria fazer uso direto dos retornos dos métodos. Por exemplo, em `FerrariTest` deveria invocar o `abrirCapota` dentro do `assert`.
- Colocar um `if` dentro do teste (em `testeCacamba` de `PampaTest`) indica que você não está testando a implementação em si. 
- Nota: 10

#### Lista 06
- Teste de unidade do exercício 2 não valida a ideia de ordenação. 
- Nota: 10


