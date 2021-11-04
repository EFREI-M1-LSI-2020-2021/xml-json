package fr.efrei;

import java.util.List;

public class Person {
    private String name;
    private Gender gender;
    private List<Person> sons;
    private List<Person> daughters;
    
    public Person(String name, Gender gender, List<Person> sons, List<Person> daughters) {
        this.name = name;
        this.gender = gender;
        this.sons = sons;
        this.daughters = daughters;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Person> getSons() {
        return sons;
    }

    public List<Person> getDaughters() {
        return daughters;
    }
}
