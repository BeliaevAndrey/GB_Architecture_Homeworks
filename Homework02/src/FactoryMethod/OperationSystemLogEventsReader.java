package FactoryMethod;

import TemplateMethod.LogEntry;
import TemplateMethod.LogReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationSystemLogEventsReader extends LogReader {

    String path;
    String filtered = null;


    public OperationSystemLogEventsReader() {
    }

    public OperationSystemLogEventsReader(String path) {
        this.path = path;
    }

    public OperationSystemLogEventsReader(String path, String filtered) {
        this.path = path;
        this.filtered = filtered;
    }

    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {

        List<String> logList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            logList.add(line);
        } catch (IOException e) { e.printStackTrace(); }


        return logList;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        if (stringEntry.contains(filtered)) return new LogEntry(stringEntry);
        return null;
    }
}
