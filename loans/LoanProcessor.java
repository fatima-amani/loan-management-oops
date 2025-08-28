package loans;

import exceptions.LoanException;

@FunctionalInterface
public interface LoanProcessor {
    void process(LoanApplication app) throws LoanException;
}
