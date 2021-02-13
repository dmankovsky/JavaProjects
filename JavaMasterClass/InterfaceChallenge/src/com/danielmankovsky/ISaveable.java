package com.danielmankovsky;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ISaveable {

    void readArrayList(List<String> savedValues);
    List<String> writeArrayList();

}
