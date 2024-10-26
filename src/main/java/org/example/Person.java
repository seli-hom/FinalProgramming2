package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
abstract class Person {
    private String fName;
    private String lNAme;

    abstract public void getDescription(){
        System.out.println("Name: " + fName + " " + lNAme);
    }
}
