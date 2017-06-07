package output;

import java.util.List;

public interface OutputGenerator<T> {

    public void printOutput(List<T> input);
}
