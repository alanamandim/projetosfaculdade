### alanamandim
  - O diagrama de classes UML está errado. Indica que a classe `Entrada de dados` contém objetos de todas as demais classes (misc, article, etc), o que é um erro
  - Classe  `Entrada de dados`  contém todos os atributos possíveis de todas as entradas, logo, quem herda também terá. Isso é um erro
  - Na classe `BaseBibliografica` os métodos `adicionar` poderiam receber objetos (article, book, etc) e não os atributos para criar tais objetos. Assim, só teria um único método `adicionar` e não vários, como foi feito
  - Nota: 8

