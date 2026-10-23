# SDP-Assignment5ф    # Calculator - Strategy Pattern

A Java 17 console calculator for Assignment #5, Option B. It implements addition, subtraction, and multiplication as interchangeable strategies.

`Calculator` stores the selected strategy and delegates calculations to it. The client, `Main`, selects operations and switches strategies at runtime. `Calculator` contains no `if` or `switch` statements for selecting an operation type.

## Requirements

- JDK 17.
- A terminal or IntelliJ IDEA.
- No external libraries are required.

## Project Structure

This version keeps all classes in a single `Main.java` file. Only `Main` is declared `public`.

```text
strategy-calculator/
├── Main.java
└── README.md
```

| Component | Pattern Role | Responsibility |
| --- | --- | --- |
| `CalculationStrategy` | Strategy Interface | Declares `double execute(double a, double b)` |
| `AddStrategy` | Concrete Strategy | Adds two numbers |
| `SubtractStrategy` | Concrete Strategy | Subtracts the second number from the first |
| `MultiplyStrategy` | Concrete Strategy | Multiplies two numbers |
| `Calculator` | Context | Stores a strategy, replaces it through `setStrategy()`, and delegates calculations |
| `Main` | Client | Creates the calculator, selects strategies, and prints results |

## Build and Run

Open a terminal in the directory containing `Main.java`. Check your JDK installation:

```shell
java -version
javac -version
```

Compile and run the application:

```shell
javac --release 17 Main.java
java Main
```

The application adds, subtracts, and multiplies `8` and `5`, in that order.

Expected output:

```text
13.0
3.0
40.0
```

In IntelliJ IDEA, select JDK 17 as the project SDK, open `Main.java`, and run `Main.main()`.

## Runtime Strategy Switching

```java
Calculator calculator = new Calculator(new AddStrategy());
System.out.println(calculator.calculate(8, 5)); // 13.0

calculator.setStrategy(new SubtractStrategy());
System.out.println(calculator.calculate(8, 5)); // 3.0

calculator.setStrategy(new MultiplyStrategy());
System.out.println(calculator.calculate(8, 5)); // 40.0
```

All three calculations use the same `Calculator` instance. The strategy object changes, while `calculate()` continues to call `strategy.execute(a, b)`.

## Adding a New Strategy

For example, to support exponentiation, add a class implementing `CalculationStrategy` to `Main.java`:

```java
class PowerStrategy implements CalculationStrategy {
    @Override
    public double execute(double a, double b) {
        return Math.pow(a, b);
    }
}
```

Then select the new strategy inside `Main.main()`:

```java
calculator.setStrategy(new PowerStrategy());
System.out.println(calculator.calculate(2, 3)); // 8.0
```

Compile and run the application again. No changes are required to `Calculator`, `CalculationStrategy`, or the existing strategies. The client selects the new implementation and passes it to the context, extending the available behavior through the common interface.
