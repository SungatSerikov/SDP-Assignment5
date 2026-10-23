public class Calculator {
    private CalculationStrategy strategy;

    public Calculator(CalculationStrategy strategy) {
        this.strategy = strategy;
    }
    public double execute(double a, double b) {
        return strategy.execute(a, b);
    }
    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = strategy;
    }
}
