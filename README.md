# ExemploMarvel
Pequeno projeto em Android que utiliza o Retrofit para chamadas via API

# Descrição do problema
Nossa parceira, a Marvel Comics, está precisando colocar na produção um app de exposição / vendas de suas revistas em quadrinhos. É um aplicativo básico, consiste de uma tela de listagem, uma tela de detalhamento (com opção de quantidade e botão para compra) e uma tela de verificação dos produtos selecionados pelo usuário.

# Solução implementada (A princípio)
. Uso das dependências: Retrofit, GSON, Picasso, Okhttp3
. Criação Models de alguns objetos para mapeamento
. Instância do Retrofit usando o endpoint da API Marvel como BASE_URL
. Uma classe Service que faz a 'chamada' para obter os objetos
. Um Adapter para exibir os objetos num layout RecyclerView
