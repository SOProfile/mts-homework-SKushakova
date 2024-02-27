import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число для цикла for: ");
        int number = scanner.nextInt();

        AnimalServiceImpl animalService = new AnimalServiceImpl();
        System.out.println("Цикл for:");
        animalService.createAnimal(number);
        System.out.println("Цикл do-while:");
        animalService.createAnimal();

        System.out.println("Цикл while:");
        CreateAnimalService createAnimalNotOverride = new CreateAnimalService();
        createAnimalNotOverride.createAnimal();
    }
}
