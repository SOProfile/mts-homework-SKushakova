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

        */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");

        int number = scanner.nextInt();

        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        Integer[] randomArray = randomValueGenerator.getRandomNums(number);
        MultiThreadsSorter multiThreadsSorter = new MultiThreadsSorter(randomArray);
        long startTime = System.nanoTime();

        multiThreadsSorter.start();
        try {
            multiThreadsSorter.join();
        } catch (Exception e) {

        }

        long endTime = System.nanoTime();
        for (int c = 0; c < number; c++) {
            System.out.println(multiThreadsSorter.getSorted()[c]);
        }

        StringBuilder loggerMulti = new StringBuilder();
        loggerMulti.append("Многопоточная сортировка: ");
        loggerMulti.append((double) (endTime - startTime) / 1_000_000_000);
        loggerMulti.append(" секунд");

        System.out.println(loggerMulti.toString());

        startTime = System.nanoTime();
        BaseSorter baseSorter = new BaseSorter(randomArray);
        baseSorter.sort();

        endTime = System.nanoTime();

        for (int c = 0; c < number; c++) {
            System.out.println(baseSorter.getSorted()[c]);
        }
        StringBuilder loggerBase = new StringBuilder();
        loggerBase.append("Однопоточная сортировка: ");
        loggerBase.append((double) (endTime - startTime) / 1_000_000_000);
        loggerBase.append(" секунд");
        System.out.println(loggerBase.toString());

        /*
        BaseNaturalNumsChecker baseNaturalNumsChecker = new BaseNaturalNumsChecker(naturalNums);
        baseNaturalNumsChecker.checkIsPrimary();
        for (int c = 0; c < naturalNums.length; c++) {
            System.out.println(baseNaturalNumsChecker.getChecked()[c]);
        }
        */
        MultiThreadsPrimaryNumsChecker multiThreadsPrimaryNumsChecker = new MultiThreadsPrimaryNumsChecker(randomArray);

        multiThreadsPrimaryNumsChecker.start();
        try {
            multiThreadsPrimaryNumsChecker.join();
        } catch (Exception e) {

        }
        System.out.println("Результат проверки на простые числа в многопоточном режиме:");
        for (int c = 0; c < multiThreadsPrimaryNumsChecker.getChecked().length; c++) {
            System.out.println(multiThreadsPrimaryNumsChecker.getChecked()[c]);
        }

    }
}
