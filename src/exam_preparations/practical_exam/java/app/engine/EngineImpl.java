package exam_preparations.practical_exam.java.app.engine;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by Chilly on 22.12.2017 г..
 */
public class EngineImpl implements Engine {
    private Battlefield battlefield;
    private Reader reader;

    public EngineImpl(Battlefield battlefield, Reader reader) {
        this.battlefield = battlefield;
        this.reader = reader;
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String line = reader.readLine();

        while (!line.equals("Peace")){
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()){
                case "createparticipant" :
                    this.battlefield.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "createaction" :
                    this.battlefield.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                case "statparticipants":
                    this.battlefield.reportParticipants();
                    break;
                case "statactions":
                    this.battlefield.reportActions();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            line = reader.readLine();
        }
    }
}
