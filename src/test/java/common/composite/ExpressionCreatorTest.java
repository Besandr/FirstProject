package common.composite;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionCreatorTest {

    private ExpressionCreator creator;

    @Before
    public void init(){
        creator = new ExpressionCreator();
    }

    @Test
    public void testBuildExpressionWithAdding() {

        String expressionString = "2-3+5-2-1";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(1, result, 0);

    }

    @Test
    public void testBuildExpressionWithDividing() {

        String expressionString = "2+3*4+12/3-8";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(10, result, 0);

    }

    @Test
    public void testBuildPrimitiveParenthesesExpression(){

        String expressionString = "(3+4)";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(7, result, 0);
    }

    @Test
    public void testBuildSimpleParenthesesExpression(){

        String expressionString = "2*(3+4)";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(14, result, 0);
    }

    @Test
    public void testBuildWithInnerParenthesesExpression(){

        String expressionString = "2*(3+4*(1+2))";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(30, result, 0);
    }

    @Test
    public void testBuildWithInnerParenthesesExpressionShouldReturn57(){

        String expressionString = "(1+2)*4+5*(3+6)";
        Expression expression = creator.buildExpression(expressionString);

        double result = expression.calculate();

        assertEquals(57, result, 0);
    }
}