package common.composite;

public class Substracter extends OperationExpression {

    public Substracter(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() - right.calculate();
    }
}
