package exam_preparations.examIV.main.java.bg.softuni.contacts;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.utils.RegistrationTime;

/**
 * Created by Chilly on 19.12.2017 г..
 */
public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();
}