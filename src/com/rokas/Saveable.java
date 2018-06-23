package com.rokas;

import java.util.ArrayList;
import java.util.List;

public interface Saveable {
    List<String> write(); // List is abstract. So I can be used with any type of list in the future
    void read(List<String> savedValues);
}
