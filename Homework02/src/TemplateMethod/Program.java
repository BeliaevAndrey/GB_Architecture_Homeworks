package TemplateMethod;

public class Program {

    public static String data = """
    У лукоморья дуб зелёный;
    Златая цепь на дубе том:
    И днём, и ночью кот учёный
    Всё ходит по цепи кругом;
    Идёт направо -- песнь заводит,
    Налево -- сказку говорит.""";

    public static void main(String[] args) {
        LogReader logReader = new PoemReader(data);

        logReader.setCurrentPosition(3);

        for (LogEntry le : logReader.readLogEntry()) {
            System.out.println(le.getText());
        }

    }

}
