import javax.swing.event.ListDataEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValueGenerator {

    ArrayList<String> characters = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> breads = new ArrayList<String>();
    ArrayList<Double> costs = new ArrayList<Double>();

    LocalDate birthDate;

    public String getRandomName() {
        names.add("Барсик");
        names.add("Алиса");
        names.add("Яна");
        names.add("Пушок");
        names.add("Витя");
        int nameIndex = (int) Math.floor(Math.random() * names.size());
        String name = names.get(nameIndex);
        return name;
    }

    public String getRandomBread() {
        breads.add("Порода1");
        breads.add("Порода2");
        breads.add("Порода3");
        int breadIndex = (int) Math.floor(Math.random() * breads.size());
        String bread = breads.get(breadIndex);
        return bread;
    }

    public String getRandomCharacter() {
        characters.add("Злой");
        characters.add("Добрый");
        characters.add("Пассивно-агрессивный");
        characters.add("Активно-агрессивный");
        int characterIndex = (int) Math.floor(Math.random() * characters.size());
        String character = characters.get(characterIndex);
        return character;
    }

    public Double getRandomCost() {
        costs.add(33.33);
        costs.add(444.55);
        costs.add(500.55);
        costs.add(666.00);
        int costIndex = (int) Math.floor(Math.random() * costs.size());
        Double cost = costs.get(costIndex);
        return cost;
    }

    public LocalDate getRandomDate() {
        int hundredYears = 100 * 365;
        birthDate = LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, LocalDate.now().getYear()));

        return birthDate;
    }
}
