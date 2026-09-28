package SOLID.LSP;

public interface Account {
    public void deposit();
    public void withdraw();
}

//Solution for LSP
interface DepositAccount {
    public void deposit();
}

interface WithdrawAccount {
    public void withdraw();
}