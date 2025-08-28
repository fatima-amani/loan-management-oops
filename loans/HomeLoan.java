package loans;

import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

import java.lang.reflect.Method;

public class HomeLoan extends LoanApplication implements Approvable{
    public HomeLoan(String customerName, Float amount, LoanType loanType, LoanStatus loanStatus) {
        super(customerName, amount, loanType, loanStatus);
    }

    @Override
    @AuditLog
    public LoanStatus evaluateRisk() {
        if(amount < 5000000) {
            loanStatus=LoanStatus.APPROVED;
        } else {
            loanStatus=LoanStatus.REJECTED;
        }
        return loanStatus;
    }

    @Override
    boolean validateApplication() throws LoanException {
        if(loanStatus == LoanStatus.APPROVED) {
            return true;
        }
        throw new LoanException("Request Rejected !!");
    }


}
