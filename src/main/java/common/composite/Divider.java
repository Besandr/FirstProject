package common.composite;

public class Divider extends OperationExpression {

    public Divider(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() / right.calculate();
    }
}
