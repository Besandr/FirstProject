package common.chain;

public class Payment {

    private Account creditor;
    private Account debtor;
    private PaymentType type;
    private int amount;

    private int ID;

    Payment(Account creditor, Account debtor, int amount, PaymentType type) {
        this.creditor = creditor;
        this.debtor = debtor;
        this.type = type;
        this.amount = amount;
    }

    Account getCreditor() {
        return creditor;
    }

    Account getDebtor() {
        return debtor;
    }

    PaymentType getType() {
        return type;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    void setID(int ID) {
        this.ID = ID;
    }
}
