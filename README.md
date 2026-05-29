# ⚡ Programação Funcional e Lambda em Java

Estudos práticos sobre **Lambda**, **Streams** e **Interfaces Funcionais** em Java — baseado no curso do professor Nélio Alves (Udemy).

---

## 📁 Estrutura

```
src/
├── Comparator/          → Ordenação com Comparator e lambda
├── ExemploFuncoes/      → Function e Predicate na prática
├── InterfacesFuncionais/
│   ├── Consumer/
│   ├── Function/
│   └── Predicate/
├── MethodReference/     → Exemplos com ::
├── Stream/              → Pipelines e operações básicas
└── Exercicios/
    ├── Ex1/
    ├── Ex2/             → Filtro e soma de funcionários ⭐
    ├── Ex3_Sistema_Pedidos/         → Sistema completo com Generics ⭐
    ├── Ex4_Sistema_Biblioteca/      → Biblioteca com herança e Streams ⭐
    ├── Ex5_Sistema_Pontuacao_Jogos/ → Ranking de jogadores com interfaces ⭐
    └── Ex6_Controle_Funcionarios/   → Controle de funcionários com Generics ⭐
```

---

## 📚 Conceitos

| Conceito | Resumo |
|---|---|
| **Lambda** | Implementação anônima de interface funcional: `(a, b) -> a.compareTo(b)` |
| **Predicate\<T\>** | Recebe T, retorna boolean — usado para filtros |
| **Function\<T,R\>** | Recebe T, retorna R — usado para transformações |
| **Consumer\<T\>** | Recebe T, não retorna — usado para efeitos colaterais |
| **Supplier\<T\>** | Não recebe, retorna T — usado para fábricas |
| **Method Reference** | Atalho para lambda: `System.out::println` |
| **Stream** | Pipeline de operações sobre coleções sem modificar o original |

---

## ⭐ Exercício 2 — Filtro e Soma de Funcionários

Lê um `.csv`, filtra funcionários por salário e soma salários por inicial do nome.

```java
// emails de quem ganha mais que X
list.stream()
    .filter(emp -> emp.getSalary() > salary)
    .map(Employee::getEmail)
    .forEach(System.out::println);

// soma com Predicate genérico
empServ.filteredSum(list, emp -> emp.getName().charAt(0) == 'M');
```

---

## ⭐ Exercício 3 — Sistema de Pedidos

Sistema completo com **Generics**, **Enum**, **interface funcional própria** e **Streams**.

```java
@FunctionalInterface
public interface Desconto {
    double aplicar(double valor);
}

// na Main
Desconto desconto = valor -> valor - (valor * porcentagem / 100);
double totalComDesconto = pedido.aplicarDesconto(total, desconto);

// filtrar, calcular e ordenar
produtos.stream().filter(p -> p.getPreco() > valorMin).toList();
produtos.stream().mapToDouble(Produto::getPreco).sum();
produtos.sort((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));
```

---

## ⭐ Exercício 4 — Sistema de Biblioteca

Sistema com **herança**, **interface**, **Generics com bounded wildcards** e **Streams**.

### Estrutura

```
Ex4_Sistema_Biblioteca/
├── entities/
│   ├── Item.java        → Classe abstrata — Comparable<Item> por preço
│   ├── Book.java        → Herda Item, implementa Fineable — multa: 5% do preço
│   └── Magazine.java    → Herda Item, implementa Fineable — multa: 2% do preço
├── services/
│   ├── Fineable.java    → Interface funcional: calculateFine()
│   └── LibraryService.java → Métodos genéricos com bounded wildcards
└── application/
    └── Main.java
```

### Conceitos aplicados

**Interface `Fineable` e implementações:**
```java
// Book — 5% de multa
public double calculateFine() { return price * 0.05; }

// Magazine — 2% de multa
public double calculateFine() { return price * 0.02; }
```

**`LibraryService` com Generics e wildcards:**
```java
// retorna o item mais caro da lista
public static <T extends Comparable<? super T>> T max(List<T> list) { ... }

// imprime qualquer lista
public static void printList(List<?> list) { ... }
```

**Streams na Main:**
```java
// A) itens acima de R$50
items.stream()
    .filter(i -> i.getPrice() > 50)
    .forEach(System.out::println);

// B) só os títulos
items.stream()
    .map(Item::getTitle)
    .forEach(System.out::println);

// C) soma de todos os preços
double total = items.stream()
    .mapToDouble(Item::getPrice)
    .sum();
```

---

## ⭐ Exercício 5 — Sistema de Pontuação de Jogos

Sistema com **interfaces próprias**, **exceções customizadas**, **Streams para ranking** e **ordenação com lambda**.

### Estrutura

```
Ex5_Sistema_Pontuacao_Jogos/
├── application/
│   └── Main.java
├── entities/
│   ├── Jogador.java     → Jogador com nome e pontuação acumulada
│   ├── Partida.java     → Registra vencedor, perdedor e pontos ganhos
│   └── Sala.java        → Gerencia a lista de jogadores da sala
├── exceptions/
│   ├── NivelInvalido.java
│   └── PontuacaoInvalidaExcep.java → Exceção para pontuação inválida
├── interfaces/
│   ├── Notificavel.java → Interface para notificação de resultado
│   └── Rankeavel.java   → Interface para objetos que participam do ranking
└── services/
    └── RankingService.java → Ordena jogadores e calcula pontuação total
```

### Conceitos aplicados

**Finalizar uma partida e atualizar ranking:**
```java
Partida partida = new Partida(vencedor, perdedor, 500);
partida.finalizarPartida();

RankingService service = new RankingService();
List<Jogador> ranking = service.ordenarRanking(sala.listar());
```

**`RankingService` com lambda e Streams:**
```java
// ordenar por pontuação (maior primeiro)
jogadores.sort((j1, j2) -> Integer.compare(j2.getPontos(), j1.getPontos()));

// somar pontuação total da sala
Integer total = sala.listar().stream()
    .mapToInt(Jogador::getPontos)
    .sum();
```

**Interfaces de contrato:**
```java
// Rankeavel — garante que qualquer entidade pode ser rankeada
public interface Rankeavel {
    int getPontos();
}

// Notificavel — desacopla o envio de notificações do resultado
public interface Notificavel {
    void notificar(String mensagem);
}
```

---

## ⭐ Exercício 6 — Controle de Funcionários

Sistema com **classe genérica**, **Streams para ordenação e filtros** e **método genérico com bounded type parameter**.

### Estrutura

```
Ex6_Controle_Funcionarios/
├── application/
│   └── Main.java
├── entities/
│   ├── Funcionario.java → Funcionário com nome, cargo, salário e experiência
│   └── Empresa.java     → Classe genérica que gerencia a lista de funcionários
└── service/
    └── FuncionariosService.java → Ordenação, filtros e cálculos com Streams
```

### Conceitos aplicados

**`Empresa<T>` — classe genérica:**
```java
public class Empresa<T> {
    private List<T> funcionarios = new ArrayList<>();

    public void adicionar(T funcionario) {
        funcionarios.add(funcionario);
    }

    public List<T> listar() {
        return funcionarios;
    }
}
```

**`FuncionariosService` com Streams:**
```java
// ordenar por salário (maior primeiro)
public List<Funcionario> ordenarSalario(List<Funcionario> funcionarios) {
    return funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getSalario).reversed())
            .toList();
}

// filtrar por cargo
public String filtrarCargo(List<Funcionario> funcionarios, String cargo) {
    return funcionarios.stream()
            .filter(f -> f.getCargo().equals(cargo))
            .toList().toString();
}

// soma total de salários
public Double totalSalario(List<Funcionario> funcionarios) {
    return funcionarios.stream()
            .mapToDouble(f -> f.getSalario())
            .sum();
}

// filtrar por salário mínimo
public List<Funcionario> filtrarSalario(List<Funcionario> funcionarios, Double salario) {
    return funcionarios.stream()
            .filter(f -> f.getSalario() > salario)
            .toList();
}
```

**Método genérico com bounded type parameter:**
```java
public static <T extends Comparable<? super T>> T min(List<T> funcionarios) {
    if (funcionarios.isEmpty()) {
        throw new IllegalStateException("Não pode estar vazia!");
    }
    T min = funcionarios.get(0);
    for (T item : funcionarios) {
        if (item.compareTo(min) < 0) {
            min = item;
        }
    }
    return min;
}
```

---

## 🛠️ Tecnologias

Java 21 · IntelliJ IDEA · Git e GitHub

## 👨🏻‍💻 Autor

**André Peixoto Cano** — Engenharia de Software · FIAP