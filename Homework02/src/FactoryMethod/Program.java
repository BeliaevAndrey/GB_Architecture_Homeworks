package FactoryMethod;

import TemplateMethod.LogEntry;
import TemplateMethod.LogReader;
import util.ReadFileUtil;

import java.io.IOException;
import java.nio.file.Path;

public class Program {

    public static void main(String[] args) {

//        Path poemPath = Path.of(
//                System.getProperty("user.dir"),
//                "Homework02", "sample_data", "poem.txt");

        Path logPath2 = Path.of(
                System.getProperty("user.dir"),
                "Homework02", "sample_data", "example_auth.log");


        Program p = new Program();
//        p.poemLogReader(poemPath);
        p.osLogEventReader(logPath2);
    }

    public void osLogEventReader(Path logPath) {
        String path = logPath.toString();
        LogReader logReader = new ConcreteReaderCreator().createLogReader(LogType.System, path);
        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }


    }
    public void poemLogReader(Path logPath) {
        String path = logPath.toString();
        ReadFileUtil rfu = new ReadFileUtil(path);

        LogReader logReader = new ConcreteReaderCreator().createLogReader(LogType.Poem, rfu.readFile());

        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }

    }
}
