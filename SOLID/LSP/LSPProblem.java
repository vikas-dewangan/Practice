package SOLID.LSP;

import java.util.List;

public class LSPProblem{

    public List<Account> getAllAccounts(){
        return List.of(new SavingsAccount(), new CurrentAccount(), new FDAccount());
    }

}

class SavingsAccount implements Account{

    @Override 
    public void deposit(){
        System.out.println("Depositing in Savings Account...");
    }

    @Override 
    public void withdraw(){
        System.out.println("Withdrawing from Savings Account...");
    }
}

class CurrentAccount implements Account{

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
class FDAccount implements Account{

    @Override 
    public void deposit(){
        System.out.println("Depositing in FD Account...");
    }

    //handelling like this is not a good practice
    @Override 
    public void withdraw(){
        throw new Exception("Not able to withdraw from FD...");
    }
}