import loans.AuditLog;
import loans.HomeLoan;
import loans.LoanApplication;
import loans.PersonalLoan;

import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void printAnnotatedClass(Class myClass) {
        System.out.println("Class: "+myClass.getName()+" has annotated method: ");

        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(AuditLog.class)) {
                System.out.print(method.getName()+" ");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Smart Loan Processing App !! \n\n");

        printAnnotatedClass(PersonalLoan.class);
        printAnnotatedClass(HomeLoan.class);
    }
}