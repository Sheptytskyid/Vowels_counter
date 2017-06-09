package com.myproject.output;

import java.util.List;

public interface OutputGenerator<T> {

    void printOutput(List<T> input);
}
