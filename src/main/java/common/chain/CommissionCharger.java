package common.chain;

public class CommissionCharger implements PaymentProcessor {

    private PaymentProcessor nextProcessor;

    @Override
    public void processPayment(Payment payment) {

        addCommission(payment);
        nextProcessor.processPayment(payment);
    }

    @Override
    public PaymentProcessor setNext(PaymentProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
        return nextProcessor;
    }

    void addCommission(Payment payment) {

        double commission;
        switch (payment.getType()) {
            case ORDINARY:
                commission = 0.1;
                pause(100);
                break;
            case INNER:
                commission = 0;
                break;
            case PREFERENTIAL:
                commission = 0;
                pause(1000);
                break;
            case GOVERNMENT:
                commission = 0.02;
                pause(500);
                break;
            default:
                commission = 0;
                break;
        }

        commission = (int) (payment.getAmount() * commission);
        payment.setCommission((int) commission);
    }

    private void pause(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
