public class Main {
    static void main(String[] args) {
        Calculator calc = new Calculator(new AddStrategy());
        System.out.println(calc.execute(1, 2));

        calc.setStrategy(new SubtractStrategy());
        System.out.println(calc.execute(1, 2));

        calc.setStrategy(new MultiplyStrategy());
        System.out.println(calc.execute(1, 2));
    }
}
