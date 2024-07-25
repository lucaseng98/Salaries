package assignment3;

public class NoEmployeesRegistered extends RuntimeException{
    public NoEmployeesRegistered() {
        super("No employees registered yet.");
    }

    public NoEmployeesRegistered (String message) throws RuntimeException {
        super(message);
    }
}
