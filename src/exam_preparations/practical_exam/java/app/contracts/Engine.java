package exam_preparations.practical_exam.java.app.contracts;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface Engine {
    void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
