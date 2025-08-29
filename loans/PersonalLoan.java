package loans;

import annotations.AuditLog;
import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

public class PersonalLoan extends LoanApplication implements Approvable {

    public PersonalLoan(String customerName, Float amount) {
        super(customerName, amount, LoanType.PERSONAL);
        System.out.println("Personal Loan Created successfully with applicationID: " + applicationId + "\n");
    }

    @AuditLog
    public LoanStatus evaluateRisk() {
        if (amount > 500000) {
            loanStatus = LoanStatus.REJECTED;
        } else {
            loanStatus = LoanStatus.APPROVED;
        }
        System.out.println("ID: " + applicationId + " after carefully evaluating, your loan Status is " + loanStatus);
        addProcessedApplication(LoanType.PERSONAL, this);
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
        if (this.loanType != LoanType.PERSONAL) {
            throw new LoanException("Invalid LoanType");
        }
        if (this.loanStatus == null) {
            throw new LoanException("Please Apply first !!");
        }
        printDecision(applicationId, true);
        return true;

    }
}
