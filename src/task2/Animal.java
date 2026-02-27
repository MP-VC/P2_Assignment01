package task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Animal {
    private String name;
    private String gender;
    private int age;
    private String type;
    private ArrayList<String> legalTypes = new ArrayList<>(Arrays.asList("cat", "dog", "monkey"));

    public Animal(String name, String gender, int age, String type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        if (isTypeValid(type)) this.type = type;
    }

    public Animal() {
        name = null;
        gender = null;
        age = 0;
        type = null;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
        if (isTypeValid(type)) this.type = type;
    }

    public boolean isTypeValid(String type) {
        return legalTypes.contains(type);
    }

    public void extendLegalTypes(String newType) {
        legalTypes.add(newType);
    }

    public void removeLegalType(String type) {
        legalTypes.remove(type);
    }

    @Override
    public String toString() {
        return  "Name:" + name + '\'' +
                "Gender:" + gender + '\'' +
                "Age:" + age +
                "Type:" + type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Animal animal = (Animal) obj;

        if (age != animal.age) return false;
        if (!name.equals(animal.name)) return false;
        if (!gender.equals(animal.gender)) return false;
        return type.equals(animal.type);
    }
}