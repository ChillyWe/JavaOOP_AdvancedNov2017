package exam_preparations.practical_exam.java.app.io;


import exam_preparations.practical_exam.java.app.contracts.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {
    private BufferedReader bf;

    public ConsoleReader(){
        this.bf = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return bf.readLine();
    }
}
