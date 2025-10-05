# Projeto Final - Programação Orientada a Objetos 🎲

Este repositório contém o projeto final da disciplina de **Programação Orientada a Objetos (POO)**.  
O tema escolhido foi o desenvolvimento de um **jogo de RPG baseado em texto**, utilizando conceitos fundamentais de POO em Java.  

---

## 📖 Sobre o Projeto

O jogo é inspirado em sistemas clássicos de RPG de mesa, onde o jogador poderá criar personagens, realizar ações e interagir com o jogo por meio de texto no console.  
Entre os conceitos de POO aplicados estão:  

- **Abstração** → com a classe abstrata `Personagem`.  
- **Herança** → classes específicas como `Guerreiro`, `Ladino` e `Mago` que estendem `Personagem`.  
- **Polimorfismo** → diferentes comportamentos para cada classe de personagem.  
- **Encapsulamento** → atributos privados com métodos de acesso (getters e setters).  

---

## 🛠️ Estrutura do Projeto

As principais classes planejadas são:  

- **`Roll`** → responsável por realizar rolagens de dados (ex.: d6, d20).  
- **`Personagem` (abstrata)** → atributos e métodos comuns, como vida, mana, nível, ataque, defesa.  
- **`Guerreiro`** → personagem focado em combate corpo a corpo e alta defesa.  
- **`Ladino`** → especialista em furtividade, ataques críticos e agilidade.  
- **`Mago`** → usuário de magias com grande poder ofensivo, mas baixa defesa.  
- **(Outras classes)** → novas classes e funcionalidades podem ser adicionadas conforme a evolução do projeto.  

---

## 🚀 Como Executar

1. Clone este repositório:  
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
2. Compile os arquivos Java:  
   ```bash
   javac src/*.java
   ```
3. Execute o jogo:  
   ```bash
   java -cp src Main
   ```

---

## 📌 Funcionalidades Planejadas

- Criação e personalização de personagens.  
- Combates baseados em turnos com rolagens de dados.  
- Diferentes habilidades e estilos de jogo dependendo da classe escolhida.  

---

## 📚 Conceitos de POO Aplicados

✔️ Abstração  
✔️ Encapsulamento  
✔️ Herança  
✔️ Polimorfismo  
✔️ Interface  
✔️ Collections  

---

## 👨‍💻 Autores

Este projeto foi desenvolvido como **trabalho final da disciplina de Programação Orientada a Objetos**.  

- Arthur Moreira Tenório
- Matheus Ferreira Bezerra  
