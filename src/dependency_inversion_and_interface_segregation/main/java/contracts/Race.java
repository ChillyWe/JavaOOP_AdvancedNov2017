package dependency_inversion_and_interface_segregation.main.java.contracts;

import exeptions.DuplicateModelException;

import java.util.List;

public interface Race {

    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void addParticipant(Boat boat) throws DuplicateModelException;

    List<Boat> getParticipants();
}