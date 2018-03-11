package exam_preparations.examIII.test.java.app.waste_disposal.fakeClassesForTests;

import b_recyclingStation.app.contracts.GarbageDisposalStrategy;
import b_recyclingStation.app.contracts.ProcessingData;
import b_recyclingStation.app.contracts.Waste;

public class FakeStrategy implements GarbageDisposalStrategy{

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        return null;
    }
}
