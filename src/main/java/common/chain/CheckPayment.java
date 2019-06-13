package common.chain;

public class CheckPayment implements PaymentProcessor {

    private PaymentProcessor nextProcessor;


    @Override
    public void processPayment(Payment payment) {

        if (payment.getCreditor().getDeposit() > payment.getAmount()) {
            nextProcessor.processPayment(payment);
        } else {
            System.out.println("There is not enough money!");
        }
    }

    @Override
    public PaymentProcessor setNext(PaymentProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
        return nextProcessor;
    }

}
