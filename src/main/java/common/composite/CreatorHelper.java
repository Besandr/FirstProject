package common.composite;

public class CreatorHelper {

    protected boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }

    protected boolean isOperator(char c){
        return c == '+'
                || c == '-'
                || c == '*'
                || c == '/';
    }

    protected int getLastDigitOfNumberIndex(String expressionString, int firstDigitIndex){
        for (int i = firstDigitIndex; i < expressionString.length(); i++) {
            char currentChar = expressionString.charAt(i);

            if (!isDigit(currentChar)) {
                return i - 1;
            }
        }
        return expressionString.length() - 1;
    }

    protected int getExpressionClosingBracketIndex(String expressionString, int openBracketIndex) {

        int bracketsCounter = 1;
        int lastClosingBracketIndex = -1;

        for (int i = openBracketIndex + 1; bracketsCounter > 0; i++) {

            char currentChar = expressionString.charAt(i);

            if (currentChar == '(') {

                bracketsCounter++;

            } else if (currentChar == ')') {

                bracketsCounter--;
                lastClosingBracketIndex = i;
            }
        }

        return lastClosingBracketIndex;
    }

    protected boolean isOperatorHasHigherPrecedence(char baseOperator, char comparedOperator) {

        if (baseOperator == '*' || baseOperator == '/') {
            return false;
        }

        if (comparedOperator == '*' || comparedOperator == '/') {
            return true;
        }

        return false;
    }

    protected String removeSpaces(String expressionString) {
        return expressionString.replaceAll(" ", "");
    }

    protected boolean isExpressionContainsWrongChars(String expressionString) {
        return !expressionString.matches("[\\d\\+\\-\\*\\/\\(\\)\\.]+");
    }
}
