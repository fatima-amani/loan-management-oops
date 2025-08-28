package loans;

import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LoanApplication {
    static Integer counter;
    static Map<LoanType, List<LoanApplication>> processedApplication;

    static {
        counter = 0;
        System.out.println("SmartLoan System initialized");
        processedApplication = new HashMap<LoanType, List<LoanApplication>>();
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

    abstract boolean validateApplication() throws LoanException;

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

    static <T extends LoanApplication> void printProcessedApplications() {
        System.out.println("Processed Applications: ");
        for (Map.Entry<LoanType, List<LoanApplication>> entry : processedApplication.entrySet()) {
            System.out.println("Loan Type: " + entry.getKey());
            for (LoanApplication app : entry.getValue()) {
                System.out.println(app);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printLoanApplication(){
        System.out.println(this);
    }




}
