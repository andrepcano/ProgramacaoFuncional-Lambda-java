# ⚡ Programação Funcional e Lambda em Java

Repositório criado para documentar os estudos práticos sobre **Programação Funcional**, **Expressões Lambda** e **Streams** em Java, desenvolvidos com base no curso do professor Nélio Alves (Udemy).

---

## 📁 Estrutura do Projeto

```
src/
├── Comparator/
│   ├── entities/
│   └── Main.java                        → Ordenação com Comparator e lambda
├── ExemploFuncoes/
│   ├── entities/
│   │   └── Product6.java               → Entidade de produto
│   ├── model.services/
│   │   └── ProductService.java         → Serviço usando Function e Predicate
│   └── Main.java                        → Exemplos de interfaces funcionais
├── Exercicios/
│   ├── Ex1/
│   │   ├── entities/
│   │   └── Main.java                    → Exercício 1
│   └── Ex2/
│       ├── entities/
│       │   └── Employee.java           → Entidade funcionário
│       ├── model.services/
│       │   └── EmployeeService.java    → Serviço com Predicate genérico
│       └── Main.java                    → Exercício 2 — filtro e soma de funcionários ⭐
├── InterfacesFuncionais/
│   ├── Consumer/                        → Exemplos de Consumer<T>
│   ├── Function/                        → Exemplos de Function<T, R>
│   └── Predicate/                       → Exemplos de Predicate<T>
├── MethodReference/
│   └── MethodReference.java            → Exemplos de method reference (::)
└── Stream/
    ├── Pipelines/                       → Operações encadeadas com Stream
    └── Stream1/                         → Exemplos básicos de Stream
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

### 🔹 Method Reference `::`

Atalho para lambda quando você só chama um método já existente:

```java
// lambda
list.forEach(s -> System.out.println(s));

// method reference — mesmo resultado, mais limpo
list.forEach(System.out::println);
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

### 🔹 Predicate como parâmetro de método

Passar um `Predicate` como argumento torna o método genérico e reutilizável para qualquer critério de filtragem:

```java
// o método não sabe qual critério vai receber — a lógica fica fora dele
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

### Exemplo de saída

```
Enter the full path: C:\temp\employees.csv
Enter salary: 3000.00
maria@gmail.com
anna@gmail.com
edu@gmail.com
marta@gmail.com
Sum = 12100.00
```

### Como funciona o código

**Leitura do arquivo e população da lista:**
```java
String line = br.readLine();
while (line != null) {
    String[] fields = line.split(",");
    list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
    line = br.readLine();
}
```

**Stream filtrando por salário e coletando emails:**
```java
List<String> emails = list.stream()
    .filter(emp -> emp.getSalary() > salary)  // só quem ganha mais que salary
    .map(emp -> emp.getEmail())               // transforma Employee em String (email)
    .collect(Collectors.toList());            // coleta numa lista

emails.forEach(System.out::println);          // imprime cada email
```

**Predicate genérico no EmployeeService:**
```java
// EmployeeService — recebe qualquer critério via Predicate
public double filteredSum(List<Employee> list, Predicate<Employee> criteria) {
    double sum = 0.0;
    for (Employee emp : list) {
        if (criteria.test(emp)) {
            sum += emp.getSalary();
        }
    }
    return sum;
}

// Main — passa o critério na chamada
double sum = empServ.filteredSum(list, emp -> emp.getName().charAt(0) == 'M');
```

O `EmployeeService` não sabe qual critério vai receber — isso é decidido em tempo de execução por quem chama o método. O mesmo serviço pode ser reutilizado para qualquer filtro sem precisar ser alterado.

### Estrutura do Exercício 2

```
Ex2/
├── entities/
│   └── Employee.java           → name, email, salary + getters + toString
├── model.services/
│   └── EmployeeService.java    → filteredSum(list, Predicate<Employee>)
└── Main.java                   → lê arquivo, aplica stream e chama o service
```

---

## 🧠 Conceito Principal

> Lambda e Streams permitem escrever código mais expressivo e compacto. Em vez de escrever loops manuais com `if` dentro, você declara **o que quer** — filtrar, transformar, coletar — e o Java cuida do **como**. Passar `Predicate` como parâmetro é a aplicação prática da programação funcional: o critério de filtragem vira um valor que pode ser passado, guardado e reutilizado.

---

## 🛠️ Tecnologias

Java 21 · IntelliJ IDEA · Git e GitHub

---

## 👨🏻‍💻 Autor

Feito por **André Peixoto Cano** — Estudante de Engenharia de Software na FIAP, aprendendo Java com o curso do professor Nélio Alves na Udemy.
