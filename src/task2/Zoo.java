package task2;

import java.util.ArrayList;

public class Zoo {
    private ArrayList<Animal> animals;
    public Zoo() {
        animals = new ArrayList<>();
    }
    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }
public Zoo(Zoo z) {
        this.animals = z.animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public int countAnimals(String type) {
        int count = 0;
        for (Animal a : animals) {
            if (a.getType().equals(type)) count++;
        }
        return count;
    }

    public boolean isGenderBalanced(String type) {
        int maleCount = 0;
        int femaleCount = 0;
        for (Animal a : animals) {
            if (a.getType().equals(type)) {
                if (a.getGender().equals("male")) maleCount++;
                else if (a.getGender().equals("female")) femaleCount++;
            }   
        }
        try {
            if (maleCount == 0 || femaleCount == 0) throw new ArithmeticException();
        } catch (ArithmeticException e) {
            return false;
        }
        return ((maleCount / femaleCount) >= 0.2 && (femaleCount / maleCount) >= 0.2);
    }

    public void removeOldest(String type) {
        int oldestAge = Integer.MIN_VALUE;
        for (Animal a : animals) {
            if (a.getType().equals(type) && a.getAge() > oldestAge) oldestAge = a.getAge();
        }
        final int finalOldestAge = oldestAge;
        animals.removeIf(a -> a.getType().equals(type) && a.getAge() == finalOldestAge);
    }

    @Override
public String toString() {
    return "Total Number of Animals:" + animals.size() + '\n' +
           "Male:" + animals.stream().filter(a -> a.getGender().equals("male")).count() + '\n' +
           "Female:" + animals.stream().filter(a -> a.getGender().equals("female")).count() + "\n" +
           "Cats:" + '\n' +
               "Number:" + countAnimals("cat") + '\n' +
               "Male:" + animals.stream().filter(a -> a.getType().equals("cat") && a.getGender().equals("male")).count() + '\n' +
               "Female:" + animals.stream().filter(a -> a.getType().equals("cat") && a.getGender().equals("female")).count() + '\n' +
               "balanced:" + isGenderBalanced("cat") + '\n' +
               "Oldest:" + animals.stream().filter(a -> a.getType().equals("cat")).mapToInt(Animal::getAge).max().orElse(0) + '\n' +
           "Dogs:" + '\n' +
               "Number:" + countAnimals("dog") + '\n' +
               "Male:" + animals.stream().filter(a -> a.getType().equals("dog") && a.getGender().equals("male")).count() + '\n' +
               "Female:" + animals.stream().filter(a -> a.getType().equals("dog") && a.getGender().equals("female")).count() + '\n' +
               "balanced:" + isGenderBalanced("dog") + '\n' +
               "Oldest:" + animals.stream().filter(a -> a.getType().equals("dog")).mapToInt(Animal::getAge).max().orElse(0) + '\n' +
           "Monkeys:" + '\n' +
               "Number:" + countAnimals("monkey") + '\n' +
               "Male:" + animals.stream().filter(a -> a.getType().equals("monkey") && a.getGender().equals("male")).count() + '\n' +
               "Female:" + animals.stream().filter(a -> a.getType().equals("monkey") && a.getGender().equals("female")).count() + '\n' +
               "balanced:" + isGenderBalanced("monkey") + '\n' +
               "Oldest:" + animals.stream().filter(a -> a.getType().equals("monkey")).mapToInt(Animal::getAge).max().orElse(0);
}

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Zoo)) return false;
        Zoo z = (Zoo) o;
        return this.animals.equals(z.animals);
    }
}