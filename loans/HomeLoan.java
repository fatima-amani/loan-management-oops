package loans;

import annotations.AuditLog;
import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

public class HomeLoan extends LoanApplication implements Approvable {
    public HomeLoan(String customerName, Float amount) {
        super(customerName, amount, LoanType.HOME);
        System.out.println("Home Loan Created successfully with applicationID: " + applicationId + "\n");
    }

    @AuditLog
    public LoanStatus evaluateRisk() {
        if (amount < 5000000) {
            loanStatus = LoanStatus.APPROVED;
        } else {
            loanStatus = LoanStatus.REJECTED;
        }
        System.out.println("ID: " + applicationId + " after carefully evaluating, your loan Status is " + loanStatus);
        addProcessedApplication(LoanType.HOME, this);
        return loanStatus;
    }

    @Override
    public boolean validateApplication() throws LoanException {
        if (customerName.isEmpty()) {
            throw new LoanException("Customer Name cannot be empty");
        }
        if (this.amount <= 0) {
            throw new LoanException("Amount cannot be negative or zero");
        }
        if (this.loanType != LoanType.HOME) {
            throw new LoanException("Invalid LoanType");
        }
        if (this.loanStatus == null) {
            throw new LoanException("Please Apply first !!");
        }
        printDecision(applicationId, true);
        return true;
    }
}
