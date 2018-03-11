package exam_preparations.examIII.test.java.app.waste_disposal;

import app.waste_disposal.contracts.*;
import app.waste_disposal.fakeClassesForTests.FakeDisposable;
import app.waste_disposal.fakeClassesForTests.FakeDisposableWaste;
import app.waste_disposal.fakeClassesForTests.FakeNonDisposableWasteWithAnotation;
import app.waste_disposal.fakeClassesForTests.FakeNonDisposableWasteWithoutAnnotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorTests {

    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private ProcessingData processingDataMock;
    private GarbageDisposalStrategy garbageDisposalStrategyMock;


    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageDisposalStrategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        this.garbageProcessor = new DefaultGarbageProcessor(strategyHolderMock);
        this.processingDataMock = Mockito.mock(ProcessingData.class);
        this.strategies.put(FakeDisposable.class, this.garbageDisposalStrategyMock);
    }

    @Test
    public void returnStrategyHolderIfPresent() {
        Assert.assertEquals(this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullStrategyHolderIsPassed() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonDisposableWasteIsProcessed() {
        this.garbageProcessor.processWaste((Waste) new FakeNonDisposableWasteWithAnotation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNonAnnotatedWasteIsProcessed() {
        this.garbageProcessor.processWaste((Waste) new FakeNonDisposableWasteWithoutAnnotation());
    }

    @Test
    public void returnProcessingDataIfDisposableWastePassed() {
        //arrange
        Mockito.when(this.garbageDisposalStrategyMock.processGarbage(Mockito.isA(FakeDisposableWaste.class)))
                .thenReturn(this.processingDataMock)
        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.strategies);

        //act
        ProcessingData result = this.garbageProcessor.processWaste((Waste) new FakeDisposableWaste());

        //assert
        Assert.assertSame(this.processingDataMock, result);
    }
}