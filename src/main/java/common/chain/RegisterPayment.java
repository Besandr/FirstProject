package common.chain;

public class RegisterPayment implements PaymentProcessor {

    private static int id;
    private PaymentProcessor nextProcessor;


    @Override
    public void processPayment(Payment payment) {
        payment.setID(++id);
        nextProcessor.processPayment(payment);
    }

    @Override
    public PaymentProcessor setNext(PaymentProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
        return nextProcessor;
    }

}
