import java.time.LocalDate;

abstract public class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected String character;
    protected Double cost;
    protected LocalDate birthDate;

    protected AbstractAnimal(String breed, String name, String character, Double cost, LocalDate birthDate) {
        this.character = character;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.birthDate = birthDate;
    }

    protected void saySome() {
        System.out.println("Голос?");
    }

}
