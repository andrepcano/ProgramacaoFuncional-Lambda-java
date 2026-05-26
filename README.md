# ⚡ Programação Funcional e Lambda em Java

Repositório criado para documentar os estudos práticos sobre **Programação Funcional**, **Expressões Lambda** e **Streams** em Java, desenvolvidos com base no curso do professor Nélio Alves (Udemy).

---

## 📁 Estrutura do Projeto

```
src/
├── Comparator/
│   ├── entities/
│   └── Main.java                           → Ordenação com Comparator e lambda
├── ExemploFuncoes/
│   ├── entities/
│   │   └── Product6.java                  → Entidade de produto
│   ├── model.services/
│   │   └── ProductService.java            → Serviço usando Function e Predicate
│   └── Main.java                           → Exemplos de interfaces funcionais
├── Exercicios/
│   ├── Ex1/
│   │   ├── entities/
│   │   └── Main.java                       → Exercício 1
│   ├── Ex2/
│   │   ├── entities/
│   │   │   └── Employee.java              → Entidade funcionário
│   │   ├── model.services/
│   │   │   └── EmployeeService.java       → Serviço com Predicate genérico
│   │   └── Main.java                       → Exercício 2 — filtro e soma de funcionários ⭐
│   └── Ex3_Sistema_Pedidos/
│       ├── entities/
│       │   ├── Produto.java               → Entidade produto com nome, preço e categoria
│       │   ├── Pedido.java                → Classe genérica Pedido<T>
│       │   └── Categoria.java             → Enum de categorias
│       ├── interfaces/
│       │   └── Desconto.java              → Interface funcional de desconto
│       ├── services/
│       │   └── ProdutoServico.java        → Serviço com Streams e lambda
│       └── Main.java                       → Exercício 3 — sistema de pedidos ⭐
├── InterfacesFuncionais/
│   ├── Consumer/                           → Exemplos de Consumer<T>
│   ├── Function/                           → Exemplos de Function<T, R>
│   └── Predicate/                          → Exemplos de Predicate<T>
├── MethodReference/
│   └── MethodReference.java               → Exemplos de method reference (::)
└── Stream/
    ├── Pipelines/                          → Operações encadeadas com Stream
    └── Stream1/                            → Exemplos básicos de Stream
```

---

## 📚 O que aprendi

### 🔹 Lambda

Lambda é uma função anônima — uma forma compacta de implementar uma interface funcional sem precisar criar uma classe inteira:

```java
// forma antiga
Collections.sort(list, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

// com lambda
Collections.sort(list, (a, b) -> a.compareTo(b));
```

### 🔹 Interfaces Funcionais

Interface com apenas um método abstrato — é o que o lambda implementa:

| Interface | Método | O que faz |
|---|---|---|
| `Predicate<T>` | `test(T t)` | recebe T, retorna boolean |
| `Function<T, R>` | `apply(T t)` | recebe T, retorna R |
| `Consumer<T>` | `accept(T t)` | recebe T, não retorna nada |
| `Supplier<T>` | `get()` | não recebe nada, retorna T |

### 🔹 Interface funcional própria

É possível criar sua própria interface funcional com `@FunctionalInterface`:

```java
@FunctionalInterface
public interface Desconto {
    double aplicar(double valor);
}

// implementada com lambda na Main
Desconto desconto = valor -> valor - (valor * porcentagem / 100);
```

### 🔹 Method Reference `::`

Atalho para lambda quando você só chama um método já existente:

```java
// lambda
list.forEach(s -> System.out.println(s));

// method reference — mesmo resultado, mais limpo
list.forEach(System.out::println);

// usado no ProdutoServico para somar preços
.mapToDouble(Produto::getPreco).sum();
```

### 🔹 Streams

Pipeline de operações sobre coleções sem modificar a original:

```java
List<Integer> result = numbers.stream()
    .filter(n -> n > 0)              // filtra
    .map(n -> n * 2)                 // transforma
    .sorted()                        // ordena
    .collect(Collectors.toList());   // coleta
```

### 🔹 Generics em classes próprias

Uma classe pode ser genérica usando `<T>`, tornando-a reutilizável para qualquer tipo:

```java
public class Pedido<T> {
    private List<T> itens = new ArrayList<>();

    public void adicionarItem(T item) { itens.add(item); }
    public void listarItens() { itens.forEach(System.out::println); }
}

// uso com Produto
Pedido<Produto> pedido = new Pedido<>();
pedido.adicionarItem(new Produto(...));
```

### 🔹 Predicate como parâmetro de método

Passar um `Predicate` como argumento torna o método genérico e reutilizável para qualquer critério de filtragem:

```java
public double filteredSum(List<Employee> list, Predicate<Employee> criteria) {
    double sum = 0.0;
    for (Employee emp : list) {
        if (criteria.test(emp)) {
            sum += emp.getSalary();
        }
    }
    return sum;
}

// quem chama decide o critério
empServ.filteredSum(list, emp -> emp.getName().charAt(0) == 'M');
empServ.filteredSum(list, emp -> emp.getSalary() > 5000);
```

---

## ⭐ Exercício 2 — Filtro e Soma de Funcionários

Exercício desenvolvido de forma independente combinando **leitura de arquivo CSV**, **Streams**, **lambda** e **Predicate como parâmetro**.

### O que o programa faz

1. Lê o caminho de um arquivo `.csv` digitado pelo usuário
2. Carrega os funcionários (nome, email, salário) em uma lista
3. Pede um salário mínimo e lista os **emails** de quem ganha mais que esse valor
4. Calcula a **soma dos salários** de funcionários cujo nome começa com a letra `M`

### Arquivo de entrada (`employees.csv`)

```
Maria Brown,maria@gmail.com,6000.00
Alex Green,alex@gmail.com,3100.00
Bob Grey,bob@gmail.com,3100.00
Anna White,anna@gmail.com,3500.00
Alex Black,alex2@gmail.com,2450.00
Eduardo Rose,edu@gmail.com,4390.00
Willian Red,will@gmail.com,2900.00
Marta Blue,marta@gmail.com,6100.00
```

### Como funciona o código

**Stream filtrando por salário e coletando emails:**
```java
List<String> emails = list.stream()
    .filter(emp -> emp.getSalary() > salary)  // só quem ganha mais que salary
    .map(emp -> emp.getEmail())               // transforma Employee em String (email)
    .collect(Collectors.toList());            // coleta numa lista

emails.forEach(System.out::println);
```

**Predicate genérico no EmployeeService:**
```java
double sum = empServ.filteredSum(list, emp -> emp.getName().charAt(0) == 'M');
```

---

## ⭐ Exercício 3 — Sistema de Pedidos

Exercício desenvolvido de forma independente criando um sistema completo de pedidos com **Generics**, **Enum**, **interface funcional própria**, **Streams** e **lambda**.

### O que o programa faz

1. Cadastra N produtos com nome, preço e categoria (via Enum)
2. Adiciona todos os produtos num `Pedido<Produto>` genérico
3. Calcula o total com Stream
4. Aplica um desconto via interface funcional `Desconto`
5. Lista produtos acima de um valor mínimo filtrado por Stream
6. Ordena os produtos por preço com lambda
7. Exibe o total com desconto aplicado

### Exemplo de saída

```
=== ITENS DO PEDIDO ===
Notebook - R$:4500.0 - ELETRONICOS
Mouse - R$:150.0 - ELETRONICOS
Camisa - R$:89.9 - ROUPAS

=== TOTAL DO PEDIDO ===
Valor total gasto: R$4739.9

=== PRODUTOS ACIMA DE R$100.0 ===
Notebook - R$:4500.0 - ELETRONICOS
Mouse - R$:150.0 - ELETRONICOS

=== PRODUTOS ORDENADOS POR PREÇO ===
Camisa - R$:89.9 - ROUPAS
Mouse - R$:150.0 - ELETRONICOS
Notebook - R$:4500.0 - ELETRONICOS

=== TOTAL COM DESCONTO DE 10.0% ===
R$4265.91
```

### Como funciona o código

**Classe genérica `Pedido<T>` com interface funcional:**
```java
public class Pedido<T> {
    private List<T> itens = new ArrayList<>();

    public void adicionarItem(T item) { itens.add(item); }
    public void listarItens() { itens.forEach(System.out::println); }

    public double aplicarDesconto(double total, Desconto desconto) {
        return desconto.aplicar(total); // executa o lambda passado
    }
}
```

**Interface funcional própria:**
```java
@FunctionalInterface
public interface Desconto {
    double aplicar(double valor);
}

// na Main — implementada com lambda
Desconto desconto = valor -> valor - (valor * qntDesconto / 100);
double totalComDesconto = pedido.aplicarDesconto(total, desconto);
```

**Streams no ProdutoServico:**
```java
// filtrar produtos caros
public List<Produto> produtosCaros(List<Produto> produtos, double valorMin) {
    return produtos.stream()
        .filter(p -> p.getPreco() > valorMin)
        .toList();
}

// calcular total
public double calculoTotal(List<Produto> produtos) {
    return produtos.stream()
        .mapToDouble(Produto::getPreco)
        .sum();
}

// ordenar por preço
public void ordenarPrecos(List<Produto> p) {
    p.sort((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));
}
```

### Estrutura do Exercício 3

```
Ex3_Sistema_Pedidos/
├── entities/
│   ├── Produto.java      → nome, preco, categoria + toString
│   ├── Pedido.java       → classe genérica com adicionarItem, listarItens, aplicarDesconto
│   └── Categoria.java    → enum com categorias disponíveis
├── interfaces/
│   └── Desconto.java     → interface funcional com método aplicar(double valor)
├── services/
│   └── ProdutoServico.java → ordenarPrecos, produtosCaros, calculoTotal
└── Main.java             → cadastro, filtros, ordenação e exibição
```

---

## 🧠 Conceito Principal

> Lambda e Streams permitem escrever código mais expressivo e compacto. Em vez de escrever loops manuais com `if` dentro, você declara **o que quer** — filtrar, transformar, coletar — e o Java cuida do **como**. Criar sua própria interface funcional e passar lambda como argumento é a aplicação prática da programação funcional: comportamentos viram valores que podem ser passados, guardados e reutilizados.

---

## 🛠️ Tecnologias

Java 21 · IntelliJ IDEA · Git e GitHub

---

## 👨🏻‍💻 Autor

Feito por **André Peixoto Cano** — Estudante de Engenharia de Software na FIAP, aprendendo Java com o curso do professor Nélio Alves na Udemy.