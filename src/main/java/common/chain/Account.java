package common.chain;

public class Account {

    private int deposit;
    private int accountNumber;

    Account(int accountNumber, int deposit) {
        this.deposit = deposit;
        this.accountNumber = accountNumber;
    }

    public Account(int accountNumber) {
        this(accountNumber, 0);
    }

    int getDeposit() {
        return deposit;
    }

    void setDeposit(int deposit) {
        this.deposit = deposit;
    }
}
