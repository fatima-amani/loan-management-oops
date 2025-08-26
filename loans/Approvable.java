package loans;

import loans.enums.LoanStatus;

public interface Approvable {
    LoanStatus evaluateRisk();

    default void printDecision() {
        System.out.println("Your Loan is "+this.evaluateRisk());
    }
}
