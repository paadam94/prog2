import java.util.Scanner;
import java.util.TreeSet;

enum AnimalType {
    MAMMAL,
    REPTILE,
    UNDEFINED
};

class Animal {
    long age;
    boolean visible;
    AnimalType type;

    Animal() {
        this.age = 0;
        this.visible = false;
        this.type = AnimalType.UNDEFINED;
    }

    Animal(long age, boolean visible, AnimalType type) {
        this.age = age;
        this.visible = visible;
        this.type = type;
    }

}

public class Main {
    static TreeSet<Animal> testSet1 = new TreeSet<>(Main::staticComparator);
    static TreeSet<Animal> testSet2 = new TreeSet<>(Main::staticComparator);

    static {
        testSet1.add(new Animal(23, true, AnimalType.MAMMAL));
        testSet1.add(new Animal(21, false, AnimalType.MAMMAL));
        testSet1.add(new Animal(12, true, AnimalType.REPTILE));

        testSet2.add(new Animal(23, true, AnimalType.REPTILE));
        testSet2.add(new Animal(21, false, AnimalType.REPTILE));
        testSet2.add(new Animal(12, true, AnimalType.REPTILE));
    }
    public static void main(String[] args) {
        // part 11
        System.out.println("this shall return with a string");
        System.out.println(youngestVisibleMammal(testSet1));
        System.out.println("-----------------------------");

        System.out.println("this shall return with a empty string");
        System.out.println(youngestVisibleMammal(testSet2));
        System.out.println("-----------------------------");
    }

    static String youngestVisibleMammal(TreeSet<Animal> animals) {
        return animals.stream()
                .filter(animal -> animal.type == AnimalType.MAMMAL)
                .filter(animal -> animal.visible)
                .min((animal1, animal2) -> staticComparator(animal1, animal2))
                .isPresent()
                ? AnimalType.MAMMAL.toString()
                : new String("");
    }

    static int staticComparator(Animal a1, Animal a2) {
        return Long.compare(a1.age, a2.age);
    }
}
