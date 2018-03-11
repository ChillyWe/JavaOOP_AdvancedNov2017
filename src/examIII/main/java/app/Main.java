package exam_preparations.examIII.main.java.app;


import exam_preparations.examIII.main.java.app.waste_disposal.DefaultGarbageProcessor;
import exam_preparations.examIII.main.java.app.waste_disposal.DefaultStrategyHolder;
import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Burnable;
import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Recyclable;
import exam_preparations.examIII.main.java.app.waste_disposal.annotations.Storable;
import exam_preparations.examIII.main.java.app.waste_disposal.contracts.*;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.strategies.BurnableGarbageStrategy;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.strategies.RecyclableGarbageStrategy;
import exam_preparations.examIII.main.java.app.waste_disposal.entities.strategies.StorableGarbageStrategy;
import exam_preparations.examIII.main.java.app.waste_disposal.io.ConsoleInputReader;
import exam_preparations.examIII.main.java.app.waste_disposal.io.ConsoleOutputWriter;
import exam_preparations.examIII.main.java.app.waste_disposal.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputReader reader =  new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        seedStrategyHolder(strategyHolder);
        GarbageProcessor processor = new DefaultGarbageProcessor(strategyHolder);
        Manager manager = new ManagerImpl(processor);

        while (true) {
            List<String> input = Arrays.asList(reader.readLine().split("\\s+"));
            String command = input.get(0);
            if ("TimeToRecycle".equalsIgnoreCase(command)) {
                break;
            }

            switch (command) {
                case "ProcessGarbage":
                    List<String> inputTokens = Arrays.asList(input.get(1).split("\\|"));
                    writer.writeLine(manager.processGarbage(inputTokens));
                    break;
                case "Status":
                    writer.writeLine(manager.status());
                    break;
                case "ChangeManagementRequirement":
                    List<String> inputTokensForChangeManagement = Arrays.asList(input.get(1).split("\\|"));
                    writer.writeLine(manager.changeManagementRequirement(inputTokensForChangeManagement));
                    break;
                default:
                    break;
            }
        }
    }

    private static void seedStrategyHolder(StrategyHolder strategyHolder) {
        GarbageDisposalStrategy recyclableGarbageStrategy = new RecyclableGarbageStrategy();
        GarbageDisposalStrategy burnableGarbageStrategy = new BurnableGarbageStrategy();
        GarbageDisposalStrategy storableGarbageStrategy = new StorableGarbageStrategy();
        strategyHolder.addStrategy(Recyclable.class, recyclableGarbageStrategy);
        strategyHolder.addStrategy(Burnable.class, burnableGarbageStrategy);
        strategyHolder.addStrategy(Storable.class, storableGarbageStrategy);
    }
}