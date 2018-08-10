package L16ExamPreparation.app.io;

import L16ExamPreparation.app.interfaces.OutputWriter;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
