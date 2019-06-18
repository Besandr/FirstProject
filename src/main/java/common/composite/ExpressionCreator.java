package common.composite;

import java.util.Stack;

public class ExpressionCreator {

    public Expression buildExpression(String expressionString) {

        Stack<Character> operators = new Stack<>();
        Stack<Expression> expressions = new Stack<>();
        CreatorHelper helper = new CreatorHelper();

        //removing white spaces and check for wrong symbols
        expressionString = prepearingSetUp(expressionString, helper);

        for (int currentIndex = 0; currentIndex < expressionString.length(); currentIndex++) {

            char currentChar = expressionString.charAt(currentIndex);

            if (helper.isDigit(currentChar)) {

                int lastDigitIndex = helper.getLastDigitOfNumberIndex(expressionString, currentIndex);
                String number = expressionString.substring(currentIndex, lastDigitIndex + 1);
                currentIndex = lastDigitIndex;

                Expression constantExpr = createNumberExpression(number);
                expressions.push(constantExpr);

            } else if (helper.isOperator(currentChar)) {

                if (!operators.empty()) {

                    if (helper.isOperatorHasHigherPrecedence(operators.peek(), currentChar)) {

                        operators.push(currentChar);

                    } else {

                        Expression operation = getOperationExpression(operators, expressions);

                        expressions.push(operation);
                        operators.push(currentChar);
                    }

                } else {
                    operators.push(currentChar);
                }

            } else {

                int expressionClosingBracketIndex = helper.getExpressionClosingBracketIndex(expressionString, currentIndex);
                String parenthesesExpressionString = expressionString.substring(currentIndex + 1, expressionClosingBracketIndex);
                currentIndex = expressionClosingBracketIndex;

                Expression parenthesesExpr = buildExpression(parenthesesExpressionString);
                expressions.push(parenthesesExpr);
            }
        }

        while (!operators.empty()) {

            Expression operation = getOperationExpression(operators, expressions);

            expressions.push(operation);
        }

        return expressions.pop();
    }

    protected Expression getOperationExpression(Stack<Character> operators, Stack<Expression> expressions) {

        Expression rightExpr = expressions.pop();
        Expression leftExpr = expressions.pop();
        char operator = operators.pop();

        Expression operation = createOperationExpression(
                leftExpr,
                rightExpr,
                operator);

        return operation;
    }

    protected Expression createOperationExpression(Expression leftExpr, Expression rightExpr, char operator) {

        switch (operator) {
            case '+':
                return new Adder(leftExpr, rightExpr);
            case '-':
                return new Substracter(leftExpr, rightExpr);
            case '*':
                return new Multiplier(leftExpr, rightExpr);
            case '/':
                return new Divider(leftExpr, rightExpr);
            default:
                throw new IllegalStateException("App can't find correct operator");
        }

    }

    protected Expression createNumberExpression(String number) {
        return new ConstantExpression(number);
    }

    protected String prepearingSetUp(String expressionString, CreatorHelper helper) {

        expressionString = helper.removeSpaces(expressionString);

        if (helper.isExpressionContainsWrongChars(expressionString)) {
            throw new IllegalArgumentException("Expression string contains wrong chars!");
        }

        return expressionString;
    }

}
