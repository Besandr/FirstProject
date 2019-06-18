package common.chain;

public class MoneyTransfer implements PaymentProcessor {

    private PaymentProcessor nextProcessor;


    @Override
    public void processPayment(Payment payment) {

        performMoneyTransfer(payment);
        System.out.println("Money transferred successfully");
        System.out.println("Result:");
        System.out.println("Creditor deposit: " + payment.getCreditor().getDeposit());
        System.out.println("Creditor deposit: " + payment.getDebtor().getDeposit());
    }

    @Override
    public PaymentProcessor setNext(PaymentProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
        return nextProcessor;
    }

    void performMoneyTransfer(Payment payment) {

        Account creditor = payment.getCreditor();
        creditor.setDeposit(creditor.getDeposit() - payment.getAmount() - payment.getCommission());

        Account debtor = payment.getDebtor();
        debtor.setDeposit(debtor.getDeposit() + payment.getAmount());

    }
}
