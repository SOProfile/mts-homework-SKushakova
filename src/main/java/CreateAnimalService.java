import java.util.Random;

public interface CreateAnimalService {
    default void createAnimal() {
        Integer count = 0;
        while (count < 10) {
            this.createRandomAnimal();
            count = count + 1;
        }
    }

    default void createRandomAnimal() {
        RandomValueGenerator randomGenerator = new RandomValueGenerator();
        Random random = new Random();
        int randomValue = random.nextInt(4) + 1;
        switch (randomValue) {
            case (1):
                Cat cat = new Cat(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                System.out.println("Это кот:");
                cat.returnAnimal(cat);
                cat.saySome();
                break;
            case (2):
                Dog dog = new Dog(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                System.out.println("Это собаня:");
                dog.returnAnimal(dog);
                dog.saySome();
                break;
            case (3):
                Lion lion = new Lion(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                System.out.println("Это лев:");
                lion.returnAnimal(lion);
                lion.saySome();
                break;
            case (4):
                Wolf wolf = new Wolf(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());
                System.out.println("Это волк:");
                wolf.returnAnimal(wolf);
                wolf.saySome();
                break;
        }
    }
}
