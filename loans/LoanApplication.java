package loans;

import loans.enums.LoanStatus;
import loans.enums.LoanType;

public abstract class LoanApplication {
    static Integer counter;

    static {
        counter = 0;
        System.out.println("SmartLoan System initialized");
    }

    Integer applicationId;
    String customerName;
    Float amount;
    LoanType loanType;
    LoanStatus loanStatus;

    public LoanApplication(String customerName, Float amount, LoanType loanType, LoanStatus loanStatus) {
        this.applicationId = ++counter;
        this.customerName = customerName;
        this.amount = amount;
        this.loanType = loanType;
        this.loanStatus = loanStatus;
    }

    abstract boolean validateApplication();

    void apply(){
        loanStatus=LoanStatus.PENDING;
    }

    @Override
    public String toString() {
        String str = "Application ID: "+applicationId;
        str += "\n Customer Name: "+customerName;
        str += "\n Amount: "+amount;
        str += "\n Loan Type: "+loanType;
        str += "\n Loan Status: "+loanStatus+"\n";
        return str;
    }


}
