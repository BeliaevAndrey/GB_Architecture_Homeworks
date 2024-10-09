package FactoryMethod;

import TemplateMethod.LogEntry;
import TemplateMethod.LogReader;
import util.ReadFileUtil;

import java.io.IOException;

public class Program {


    public static void main(String[] args) {
        Program p = new Program();
        p.poemLogReader();
    }

    public void poemLogReader() {
        String path = "/home/andrew/Documents/geekbrains/2024_Architecture/GB_Architecture/GB_Architecture_HW/Homework02/sample_data/poem.txt";
        ReadFileUtil rfu = new ReadFileUtil(path);

        LogReader logReader = new ConcreteReaderCreator().createLogReader(LogType.Poem, rfu.readFile().toString());

        for (LogEntry log : logReader.readLogEntry()) {
            System.out.println(log.getText());
        }

    }
}
