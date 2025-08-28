package loans;

import loans.enums.LoanStatus;

interface Approvable {
    LoanStatus evaluateRisk();

    default void printDecision(int applicationId, boolean approved) {
        if (approved) {
            System.out.println("Application ID: " + applicationId + " Validated Successfully !!");
        } else {
            System.out.println("Application ID: " + applicationId + " Validation Failed !!");
        }
    }
}
