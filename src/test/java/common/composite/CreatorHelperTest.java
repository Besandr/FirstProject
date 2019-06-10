package common.composite;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatorHelperTest {

    private CreatorHelper helper;

    @Before
    public void init(){
        helper = new CreatorHelper();
    }

    @Test
    public void isExpressionContainsWrongCharsMustReturnFalse(){

        String expressionString = "2*(2+6.9)-1/8";
        assertFalse(helper.isExpressionContainsWrongChars(expressionString));
    }

    @Test
    public void isExpressionContainsWrongCharsMustReturnTrue(){

        String expressionString = "q6*(5+2)/4-7";
        assertTrue(helper.isExpressionContainsWrongChars(expressionString));
    }

    @Test
    public void getLastDigitOfNumberIndexShouldReturn13(){

        String expressionString = "2-3*(34+3/(355-4)*8)+4*(3+2)";
        int startDigitIndex = 11;
        int result = helper.getLastDigitOfNumberIndex(expressionString, startDigitIndex);

        assertEquals(13, result, 0);
    }

    @Test
    public void getLastDigitOfNumberIndexShouldReturn2(){

        String expressionString = "2-3*(34+3/(355-4)*8)+4*(3+2)";
        int startDigitIndex = 2;
        int result = helper.getLastDigitOfNumberIndex(expressionString, startDigitIndex);

        assertEquals(2, result, 0);
    }

    @Test
    public void testGetExpressionClosingBracket() {

        String expressionString = "2-3*(34+3/(355-4)*8)+4*(3+2)";
        int openBracketIndex = 4;
        int expectedIndex = 19;

        int closingBracket = helper.getExpressionClosingBracketIndex(expressionString, openBracketIndex);

        assertEquals("Wrong closing bracket index", expectedIndex, closingBracket);
    }

}