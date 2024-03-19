import java.time.LocalDate;

public class Lion extends Predator {
    public Lion(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public void saySome() {
        System.out.println("Р-р-р!");
    }
}
