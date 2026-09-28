package SOLID.LSP;

public class LSP{
    public static void main(String[] args){
        LSPProblem lspProblem = new LSPProblem();

        //this will throwexception for FDAccount which user is not aware
        lspProblem.getAllAccounts().forEach(account->{
            account.deposit();
            account.withdraw();
        });

        //another alternative could be try catch block or condition for FDAccount but this does not make code maintainable and breaks LSP
        lspProblem.getAllAccounts().forEach(account->{
            account.deposit();
            if(!(account instanceof FDAccount)){
                account.withdraw();
            } 
        });

        //LSP Solution
        LSPSolution lspSolution = new LSPSolution();
        lspSolution.getAllDepositAccounts().forEach(account->{
            account.deposit();
        });
        lspSolution.getAllWithdrawAccounts().forEach(account->{
            account.withdraw();
        });
    }
}