package dependency_inversion_and_interface_segregation.main.java.exeptions;

public class NoSetRaceException extends Exception{
    public NoSetRaceException(String message) {
        super(message);
    }
}
