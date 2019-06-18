package common.chain;

public interface PaymentProcessor {

    void processPayment(Payment payment);

    PaymentProcessor setNext(PaymentProcessor nextProcessor);
}
