import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    */
        SearchServiceImpl searchService = new SearchServiceImpl();
        Cat cat = new Cat("Порода", null, "Спокойный", 999.66, null);
        try {
            System.out.println(searchService.checkLeapYearAnimal(cat));
        } catch (InvalidAnimalBirthDateException ex) {
            throw new InvalidAnimalException("Работа метода завершилась с ошибкой: " + ex.getMessage());
        }
    }
}
