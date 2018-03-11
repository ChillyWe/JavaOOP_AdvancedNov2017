package dependency_inversion_and_interface_segregation.main.java.models.boats_engines;


public class SterndriveEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 7;

    public SterndriveEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    protected int calculateCachedOutput(int horsepower, int displacement) {
        return (horsepower * MULTIPLIER) + displacement;
    }
}