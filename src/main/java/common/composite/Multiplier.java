package common.composite;

public class Multiplier extends OperationExpression {

    public Multiplier(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() * right.calculate();
    }
}
