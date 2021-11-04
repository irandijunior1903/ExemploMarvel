# ExemploMarvel
Pequeno projeto em Android que utiliza o Retrofit para chamadas via API

# Descrição do problema
Nossa parceira, a Marvel Comics, está precisando colocar na produção um app de exposição / vendas de suas revistas em quadrinhos. É um aplicativo básico, consiste de uma tela de listagem, uma tela de detalhamento (com opção de quantidade e botão para compra) e uma tela de verificação dos produtos selecionados pelo usuário.

# Solução implementada
- Uso das dependências: Retrofit, GSON, Picasso, Okhttp3;
- Criação de Models para mapeamento;
- Uma interface Presenter que mostra os métodos a serem implementados por quem a chama;
- Uma classe Presenter que fica responsável por exibir os Comics;
- Uma classe Service que contém a instância do Retrofit, usando o endpoint da API Marvel;
- Uma interface Service que faz o Get no endpoint, passando parâmetros específicos;
- Um Adapter para exibir os objetos num layout RecyclerView;
- Para exibir os Comics raros, tem um método trata isso de forma aleatória na classe Presenter.
