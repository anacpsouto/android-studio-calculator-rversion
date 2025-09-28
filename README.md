# 📱 Calculator App – Android

Projeto desenvolvido na unidade curricular **Laboratório de Aplicativos Móveis** utilizando **Android Studio**.  
O objetivo é implementar uma calculadora simples para Android com suporte a operações básicas.

---

## 🚀 Funcionalidades
- Entrada de números de `0` a `9`.
- Operações básicas: **adição (+), subtração (-), multiplicação (x), divisão (/)**.
- Uso de **ponto (.)** para números decimais.
- **Botão C** para limpar expressão e resultado.
- **Backspace** (imagem) para apagar o último caractere.
- **Botão =** que avalia a expressão e mostra o resultado.
- Tratamento de resultados inteiros e decimais.

---

## 🛠️ Tecnologias e Dependências
- **Java** (linguagem principal).
- **Android Studio** (IDE).
- **Pixel 4 API 30** (emulador de testes).
- **Biblioteca [exp4j](https://www.objecthunter.net/exp4j/)** para avaliação de expressões matemáticas.

### Dependência no `build.gradle`:
```gradle
implementation "net.objecthunter:exp4j:0.4.8"
