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

    public Person() {
    }

    public Person(String name, String lName) {
        fName = name;
        this.lNAme = lName;
    }

    abstract public String getDescription();
}
