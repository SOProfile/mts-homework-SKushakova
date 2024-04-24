import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public interface CreateAnimalService {

    List<AbstractAnimal> cats = new ArrayList<>();
    List<AbstractAnimal> lions = new ArrayList<>();
    List<AbstractAnimal> wolfs = new ArrayList<>();
    List<AbstractAnimal> dogs = new ArrayList<>();
    Map<String, List<AbstractAnimal>> animals = new HashMap<String, List<AbstractAnimal>>();

    default Map<String, List<AbstractAnimal>> createAnimal() {

        Integer count = 0;

        while (count < 10) {
            this.createListAnimal();
            count = count + 1;
        }
        this.createMapAnimal(cats);
        this.createMapAnimal(dogs);
        this.createMapAnimal(lions);
        this.createMapAnimal(wolfs);
        return animals;
    }


    default void createMapAnimal(List<AbstractAnimal> animal) {
        if (!animal.isEmpty() && animal.get(0).getClass().getName() == "Cat") {
            animals.put("Cat", animal);
        }
        if (!animal.isEmpty() && animal.get(0).getClass().getName() == "Dog") {
            animals.put("Dog", animal);
        }
        if (!animal.isEmpty() && animal.get(0).getClass().getName() == "Lion") {
            animals.put("Lion", animal);
        }
        if (!animal.isEmpty() && animal.get(0).getClass().getName() == "Wolf") {
            animals.put("Wolf", animal);
        }

    }

    default void createListAnimal() {
        AbstractAnimal animal = this.createRandomAnimal();
        switch (animal.getClass().getName()) {
            case ("Cat"):
                cats.add(animal);
                break;
            case ("Dog"):
                dogs.add(animal);
                break;
            case ("Wolf"):
                wolfs.add(animal);
                break;
            case ("Lion"):
                lions.add(animal);
                break;
        }
    }

    default AbstractAnimal createRandomAnimal() {
        RandomValueGenerator randomGenerator = new RandomValueGenerator();
        Random random = new Random();
        AbstractAnimal animal = null;
        int randomValue = random.nextInt(4) + 1;
        switch (randomValue) {
            case (1):
                Cat cat = new Cat(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                animal = cat;
                break;
            case (2):
                Dog dog = new Dog(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                animal = dog;
                break;
            case (3):
                Lion lion = new Lion(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                animal = lion;
                break;
            case (4):
                Wolf wolf = new Wolf(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                animal = wolf;
                break;
        }
        animal.setSecretInformation(getRandomSecretInformation());
        return animal;
    }

    /**
     * Функция получения рандомной строки из файла secretInformation.txt.
     */
    private String getRandomSecretInformation() {
        Path path = Paths.get("src/main/resources/secretStore/secretInformation.txt");

        try {
            List<String> secretStrings = Files.readAllLines(path);
            int randomIndex = new Random().nextInt(secretStrings.size() - 1);
            return  secretStrings.get(randomIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
