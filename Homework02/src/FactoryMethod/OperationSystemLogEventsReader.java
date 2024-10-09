package FactoryMethod;

import TemplateMethod.LogEntry;
import TemplateMethod.LogReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationSystemLogEventsReader extends LogReader {

    String path;
    Path filePath = null;



    public OperationSystemLogEventsReader() {
    }

    public OperationSystemLogEventsReader(String path) {
        this.path = path;
        filePath = Path.of(path);
    }

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {
        path = data.toString();
        filePath = Path.of(path);
    }

    @Override
    protected Iterable<String> readEntries(Integer position) {

        List<String> logList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                logList.add(line);
            }
        } catch (IOException e) { e.printStackTrace(); }


        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return new LogEntry(stringEntry);
    }
}
