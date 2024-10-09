package FactoryMethod;

import TemplateMethod.LogReader;
import TemplateMethod.PoemReader;

public class ConcreteReaderCreator extends BaseLogReaderCreator{
    @Override
    protected LogReader createLogReaderInstance(LogType logType) {

        return switch (logType) {
            case Poem -> new PoemReader();
            case Text -> new TextFileReader();
            case Database -> new DataBaseReader();
            case System -> new OperationSystemLogEventsReader();
        };
    }
}
