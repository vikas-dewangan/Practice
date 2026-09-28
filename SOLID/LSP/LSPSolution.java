package SOLID.LSP;

import java.util.List;

public class LSPSolution{

    public List<DepositAccount> getAllDepositAccounts(){
        return List.of(new LSPSavingsAccount(), new LSPCurrentAccount(), new LSPFDAccount());
    }

    public List<WithdrawAccount> getAllWithdrawAccounts(){
        return List.of(new LSPSavingsAccount(), new LSPCurrentAccount());
    }

}

class LSPSavingsAccount implements DepositAccount, WithdrawAccount{

    @Override 
    public void deposit(){
        System.out.println("Depositing in Savings Account...");
    }

    @Override 
    public void withdraw(){
        System.out.println("Withdrawing from Savings Account...");
    }
}

class LSPCurrentAccount implements DepositAccount, WithdrawAccount{

    @Override 
    public void deposit(){
        System.out.println("Depositing in Current Account...");
    }

    @Override 
    public void withdraw(){
        System.out.println("Withdrawing from Current Account...");
    }
}


// FixedDepositAccount does not have feature of Withdraw breaking the LSP
class LSPFDAccount implements DepositAccount{

    @Override 
    public void deposit(){
        System.out.println("Depositing in FD Account...");
    }
}