import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public void saySome() {
        System.out.println("Гав!");
    }
}
