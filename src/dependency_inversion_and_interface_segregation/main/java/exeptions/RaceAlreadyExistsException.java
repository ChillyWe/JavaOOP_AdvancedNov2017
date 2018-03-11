package dependency_inversion_and_interface_segregation.main.java.exeptions;

public class RaceAlreadyExistsException extends Exception {
    public RaceAlreadyExistsException(String message) {
        super(message);
    }
}
