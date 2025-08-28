package loans;

import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LoanApplication {
    private static Integer counter;
    private static final Map<LoanType, List<LoanApplication>> processedApplication;

    static {
        counter = 0;
        System.out.println("\n ------SmartLoan System initialized ----- \n");
        processedApplication = new HashMap<LoanType, List<LoanApplication>>();
        for (LoanType loanType : LoanType.values()) {
            List<LoanApplication> loanApplications = new ArrayList<LoanApplication>();
            processedApplication.put(loanType, loanApplications);
        }
    }

    Integer applicationId;
    String customerName;
    Float amount;
    LoanType loanType;
    LoanStatus loanStatus;

    public LoanApplication(String customerName, Float amount, LoanType loanType) {
        this.applicationId = ++counter;
        this.customerName = customerName;
        this.amount = amount;
        this.loanType = loanType;
        this.loanStatus = null;
    }

    public static void printProcessedApplications() {
        System.out.println("\n----- Processed Applications: ------");
        for (Map.Entry<LoanType, List<LoanApplication>> entry : processedApplication.entrySet()) {
            System.out.println("Loan Type: " + entry.getKey());
            if(entry.getValue().isEmpty()){
                System.out.println("No Processed Application Under this category");
            }
            for (LoanApplication app : entry.getValue()) {
                System.out.println(app);
            }
            System.out.println();
        }
        System.out.println();
    }

    protected static void addProcessedApplication(LoanType loanType, LoanApplication loanApplication) {
        List<LoanApplication> list=processedApplication.get(loanType);
        list.add(loanApplication);
    }

    public abstract boolean validateApplication() throws LoanException;

    public void apply(){
        System.out.println("ID: "+applicationId+" successfully applied for "+this.loanType+" loan");
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

    public void printLoanApplication(){
        System.out.println(this);
    }

    public abstract LoanStatus evaluateRisk();
}
