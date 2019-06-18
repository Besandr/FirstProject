package common.chain;

public class ChainDemo {
    public static void main(String[] args) {
        new ChainDemo().go();
    }

    public void go() {
        Account first = new Account(1, 500);
        Account second = new Account(2, 1000);

        Payment payment = new Payment(first, second, 200, PaymentType.ORDINARY);

        // chain creating
        PaymentProcessor chain = new RegisterPayment();
        chain.setNext(new CommissionCharger())
                .setNext(new CheckPayment())
                .setNext(new MoneyTransfer());

        chain.processPayment(payment);
    }
}
