import java.time.Instant;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomValueGenerator {

    String[] characters = new String[]{"Злой", "Добрый", "Пассивно-агрессивный"};
    String[] breads = new String[]{"Порода1", "Порода2"};
    String[] names = new String[]{"Имя1", "Имя2", "Имя3", "Имя4"};
    Double[] costs = new Double[]{Double.valueOf(1), Double.valueOf(355), Double.valueOf(400), Double.valueOf(500)};

    LocalDate birthDate;

    public String getRandomName() {
        int nameIndex = (int) Math.floor(Math.random() * names.length);
        String name = names[nameIndex];
        return name;
    }

    public String getRandomBread() {
        int breadIndex = (int) Math.floor(Math.random() * breads.length);
        String bread = breads[breadIndex];
        return bread;
    }

    public String getRandomCharacter() {
        int characterIndex = (int) Math.floor(Math.random() * characters.length);
        String character = characters[characterIndex];
        return character;
    }

    public Double getRandomCost() {
        int costIndex = (int) Math.floor(Math.random() * costs.length);
        Double cost = costs[costIndex];
        return cost;
    }

    public LocalDate getRandomDate() {
        int hundredYears = 100 * 365;
        birthDate = LocalDate.ofEpochDay(ThreadLocalRandom
                .current().nextInt(-hundredYears, hundredYears));

        return birthDate;
    }
}
