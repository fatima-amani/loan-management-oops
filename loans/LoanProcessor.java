package loans;

import exceptions.LoanException;

@FunctionalInterface
interface LoanProcessor {
    void process(LoanApplication app) throws LoanException;
}
