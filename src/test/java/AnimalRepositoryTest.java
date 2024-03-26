import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalRepositoryTest {
    AnimalsRepository animalsRepository = new AnimalsRepositoryImpl();
    CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();

    Cat cat1 = new Cat("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2024, 1, 1));
    Cat cat2 = new Cat("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2023, 1, 1));
    Dog dog1 = new Dog("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2024, 1, 1));
    Dog dog2 = new Dog("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2023, 1, 1));
    Wolf wolf1 = new Wolf("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2024, 1, 1));
    Wolf wolf2 = new Wolf("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2023, 1, 1));
    Lion lion1 = new Lion("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2024, 1, 1));
    Lion lion2 = new Lion("Порода1", "Имя1", "Характер1", 333.33, LocalDate.of(2023, 1, 1));

    List<Animal> animalsTestList = new ArrayList<>();


    @Test
    @DisplayName("Проверка метода findLeapYearNames, все животные родились в високосный год")
    void checkFindLeapYearNames() throws InvalidAnimalBirthDateException {
        animalsTestList.clear();
        animalsTestList.add(cat1);
        animalsTestList.add(dog1);
        animalsTestList.add(lion1);
        animalsTestList.add(wolf1);

        Map<String, LocalDate> animalsLeapYear = new HashMap<String, LocalDate>();
        animalsLeapYear.put("Cat" + " Имя1", LocalDate.of(2024, 1, 1));
        animalsLeapYear.put("Dog" + " Имя1", LocalDate.of(2024, 1, 1));
        animalsLeapYear.put("Lion" + " Имя1", LocalDate.of(2024, 1, 1));
        animalsLeapYear.put("Wolf" + " Имя1", LocalDate.of(2024, 1, 1));

        assertEquals(animalsLeapYear, animalsRepository.findLeapYearNames(animalsTestList));
    }

    @Test
    @DisplayName("Проверка метода findLeapYearNames, все животные не родились в високосный год")
    void checkFindNoLeapYearNames() throws InvalidAnimalBirthDateException {
        animalsTestList.clear();
        animalsTestList.add(cat2);
        animalsTestList.add(dog2);
        animalsTestList.add(lion2);
        animalsTestList.add(wolf2);

        Map<String, LocalDate> animalsNoLeapYear = new HashMap<String, LocalDate>();

        assertEquals(animalsNoLeapYear, animalsRepository.findLeapYearNames(animalsTestList));
    }

    @Test
    @DisplayName("Проверка метода findLeapYearNames, часть животных родилась в високосный год")
    void checkFindPartLeapYearNames() throws InvalidAnimalBirthDateException {
        animalsTestList.clear();
        animalsTestList.add(cat1);
        animalsTestList.add(dog2);
        animalsTestList.add(lion1);
        animalsTestList.add(wolf2);

        Map<String, LocalDate> animalsPartLeapYear = new HashMap<String, LocalDate>();

        animalsPartLeapYear.put("Cat" + " Имя1", LocalDate.of(2024, 1, 1));
        animalsPartLeapYear.put("Lion" + " Имя1", LocalDate.of(2024, 1, 1));

        assertEquals(animalsPartLeapYear, animalsRepository.findLeapYearNames(animalsTestList));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода findOlderAnimal, есть животное старше указанного возраста")
    @ValueSource(ints = {10, 15, 20})
    void checkIsOlderYearAnimal(int age) {
        System.out.println(age);

        animalsTestList.clear();

        cat1.setBirthDate(LocalDate.of(2000, 1, 1));

        animalsTestList.add(cat1);
        animalsTestList.add(dog1);
        animalsTestList.add(lion1);

        Map<Animal, Integer> olderAnimals = new HashMap<Animal, Integer>();

        olderAnimals.put(cat1, 2000);

        assertEquals(olderAnimals, animalsRepository.findOlderAnimal(animalsTestList, age));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода findOlderAnimal, нет животного старше указанного возраста")
    @ValueSource(ints = {1, 15, 20})
    void checkIsNoOlderYearAnimal(int age) {
        animalsTestList.clear();
        System.out.println(age);

        animalsTestList.add(cat1);
        animalsTestList.add(dog2);
        animalsTestList.add(lion1);

        Map<Animal, Integer> olderAnimals = new HashMap<Animal, Integer>();

        olderAnimals.put(dog2, 2023);

        assertEquals(olderAnimals, animalsRepository.findOlderAnimal(animalsTestList, age));
    }

    @Test
    @DisplayName("Проверка метода findDuplicate, есть два кота")
    void checkFindDuplicate() {
        animalsTestList.clear();
        animalsTestList.add(cat1);
        animalsTestList.add(cat2);
        animalsTestList.add(lion2);
        animalsTestList.add(wolf2);

        Map<String, Integer> animalsDuplicate = new HashMap<String, Integer>();
        animalsDuplicate.put("Cats", 2);
        animalsDuplicate.put("Lions", 1);
        animalsDuplicate.put("Wolfs", 1);

        assertEquals(animalsDuplicate, animalsRepository.findDuplicate(animalsTestList));
    }

    @Test
    @DisplayName("Проверка метода findDuplicate, дубликатов нет")
    void checkFindDuplicateIsEmpty() {

        Map<String, Integer> animalsDuplicate = new HashMap<String, Integer>();

        assertEquals(animalsDuplicate, animalsRepository.findDuplicate(animalsTestList));
    }

}
