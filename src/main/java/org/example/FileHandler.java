package org.example;

import java.util.ArrayList;

public interface FileHandler{
     void saveToFile(String file, ArrayList<Student> students);

     void loadFromFile(String file);
}
