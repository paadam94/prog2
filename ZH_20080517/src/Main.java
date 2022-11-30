import java.util.TreeSet;

enum AnimalType implements Comparable<AnimalType>{
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

    Animal(long ade, boolean visible, AnimalType type) {
        this.age = age;
        this.visible = visible;
        this.type = type;
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    static String youngestVisibleMammal(TreeSet<Animal> animals) {
        return animals.stream()
                .filter(animal -> animal.type == AnimalType.MAMMAL)
                .filter(animal -> animal.visible)
                .min((animal1, animal2) -> Long.compare(animal1.age, animal2.age))
                .orElse(new Animal())
                .type
                .toString();

    }
}
