import java.util.*;


public interface CreateAnimalService {

    List<Animal> cats = new ArrayList<>();
    List<Animal> lions = new ArrayList<>();
    List<Animal> wolfs = new ArrayList<>();
    List<Animal> dogs = new ArrayList<>();
    Map<String, List<Animal>> animals = new HashMap<String, List<Animal>>();

    default Map<String, List<Animal>> createAnimal() {

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


    default void createMapAnimal(List<Animal> animal) {
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
        Animal animal = this.createRandomAnimal();
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

    default Animal createRandomAnimal() {
        RandomValueGenerator randomGenerator = new RandomValueGenerator();
        Random random = new Random();
        Animal animal = null;
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
        return animal;
    }
}
