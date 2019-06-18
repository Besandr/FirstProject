package common.state;

public class Demo {
    public static void main(String[] args) {
        new Demo().go();
    }

    public void go() {

        Apply apply = new Apply();

        apply.forward();
        apply.forward();
        apply.forward();
        apply.forward();
        apply.forward();
    }
}
