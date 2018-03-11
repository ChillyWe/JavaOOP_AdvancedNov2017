package dependency_inversion_and_interface_segregation.main.java.exeptions;

public class NonExistantModelException extends Exception {
    public NonExistantModelException(String message) {
        super(message);
    }
}
