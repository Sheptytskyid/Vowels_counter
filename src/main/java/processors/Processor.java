package processors;

import java.util.List;

public interface Processor<T> {

    public List<T> processInputFromIoSource();
}
