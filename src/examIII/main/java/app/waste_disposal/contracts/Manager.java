package exam_preparations.examIII.main.java.app.waste_disposal.contracts;

import java.util.List;

/**
 * Created by Chilly on 21.12.2017 г..
 */
public interface Manager {
    String processGarbage(List<String> arguments);

    String status();

    String changeManagementRequirement(List<String> arguments);
}
