package common.composite;

import utils.IOHelper;

public class CompositeApp {

    public void go(){
        IOHelper ioHelper = new IOHelper(System.in, System.out);
        ExpressionCreator creator = new ExpressionCreator();

        String receivedString = ioHelper.input("Enter an expression:");
        Expression expression = creator.buildExpression(receivedString);

        ioHelper.print("Result");
        ioHelper.print(expression.calculate());
    }

    public static void main(String[] args) {
        new CompositeApp().go();
    }

}
