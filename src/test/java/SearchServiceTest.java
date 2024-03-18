import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {
    SearchService searchService = new SearchServiceImpl();
    RandomValueGenerator randomGenerator = new RandomValueGenerator();
    Cat cat = new Cat(randomGenerator.getRandomBread(), randomGenerator.getRandomName(), randomGenerator.getRandomCharacter(), randomGenerator.getRandomCost(), randomGenerator.getRandomDate());

    @ParameterizedTest
    @DisplayName("Проверка метода checkLeapYearAnimal, Год високосный, Позитивный тест")
    @ValueSource(ints = {2024, 2020, 2016, 2012, 2008})
    void checkIsLeapYearAnimal(int year) throws InvalidAnimalBirthDateException {
        System.out.println(year);
        cat.setBirthDate(LocalDate.of(year,1, 1));
        assertEquals("Год високосный",searchService.checkLeapYearAnimal(cat));
    }

    @ParameterizedTest
    @DisplayName("Проверка метода checkIsNotLeapYearAnimal, Год не високосный, Позитивный тест")
    @ValueSource(ints = {2023, 2021, 2017, 2011, 2009})
    void checkIsNotLeapYearAnimal(int year) throws InvalidAnimalBirthDateException {
        System.out.println(year);
        cat.setBirthDate(LocalDate.of(year,1, 1));
        assertEquals("Год не високосный",searchService.checkLeapYearAnimal(cat));
    }

    @Test
    @DisplayName("Проверка метода checkIsNotLeapYearAnimal, дата рождения животного null")
    void checkIsNullYearAnimal(){
        cat.setBirthDate(null);
        assertThrows(InvalidAnimalBirthDateException.class,() -> searchService.checkLeapYearAnimal(cat));
    }

    @Test
    @DisplayName("Проверка метода checkIsNotLeapYearAnimal, животное null")
    void checkIsNullAnimal(){
        assertThrows(InvalidAnimalException.class,() -> searchService.checkLeapYearAnimal(null));
    }
}
