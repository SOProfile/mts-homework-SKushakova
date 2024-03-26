import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAnimalBirthDateException {
    /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число для цикла for: ");
        int number = scanner.nextInt();

        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();
        System.out.println("Цикл for:");
        animalService.createAnimal(number);
        System.out.println("Цикл do-while:");
        animalService.createAnimal();

        System.out.println("Цикл while:");
        CreateAnimalService createAnimalI = new CreateAnimalService() {
        };
        createAnimalI.createAnimal();

        SearchServiceImpl searchService = new SearchServiceImpl();
        Cat cat = new Cat("Порода", null, "Спокойный", 999.66, null);
        try {
            System.out.println(searchService.checkLeapYearAnimal(cat));
        } catch (InvalidAnimalBirthDateException ex) {
            throw new InvalidAnimalException("Работа метода завершилась с ошибкой: " + ex.getMessage());
        }

     */
        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();
        AnimalsRepositoryImpl animalsRepository = new AnimalsRepositoryImpl();
        System.out.println("Цикл do-while:");

        Map<String, List<Animal>> animals = animalService.createAnimal();
        System.out.println(animals);

        System.out.println("Животное, рожденное в високосный год:");
        Map<String, LocalDate> animalsLeapYears = animalsRepository.findLeapYearNames(animalService.createRandomListAnimal());
        System.out.println(animalsLeapYears);

        System.out.println("Самое старое животное:");
        Map<Animal, Integer> olderAnimal = animalsRepository.findOlderAnimal(animalService.createRandomListAnimal(), 500);
        System.out.println(olderAnimal);

        System.out.println("Дубликаты:");
        Map<String, Integer> animalsDuplicate = animalsRepository.findDuplicate(animalService.createRandomListAnimal());
        System.out.println(animalsDuplicate);

    }
}
