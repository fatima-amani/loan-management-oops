package loans;

import exceptions.LoanException;
import loans.enums.LoanStatus;
import loans.enums.LoanType;

public class PersonalLoan extends LoanApplication implements Approvable{

    public PersonalLoan(String customerName, Float amount, LoanType loanType, LoanStatus loanStatus) {
        super(customerName, amount, loanType, loanStatus);
    }

    @Override
    public LoanStatus evaluateRisk() {
        if(amount > 500000) {
            loanStatus=LoanStatus.REJECTED;
        } else {
            loanStatus=LoanStatus.APPROVED;
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
