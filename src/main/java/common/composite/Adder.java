package common.composite;

public class Adder extends OperationExpression {

    public Adder(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() + right.calculate();
    }
}
