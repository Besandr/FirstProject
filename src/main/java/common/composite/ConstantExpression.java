package common.composite;

public class ConstantExpression implements Expression {

    double value;

    public ConstantExpression(String expressionString) {
        value = Double.parseDouble(expressionString);
    }

    @Override
    public double calculate() {
        return value;
    }
}