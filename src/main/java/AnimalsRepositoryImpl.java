import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) throws InvalidAnimalBirthDateException {
        Map<String, LocalDate> animalsLeapYear = new HashMap<String, LocalDate>();
        SearchServiceImpl searchService = new SearchServiceImpl();
        for (Integer count = 0; count < animals.size(); count++) {
            if (searchService.checkLeapYearAnimal(animals.get(count))) {
                animalsLeapYear.put(animals.get(count).getClass().getName() + " " + animals.get(count).getName(), animals.get(count).getBirthDate());
            }
        }
        return animalsLeapYear;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, Integer year) {
        Map<Animal, Integer> animalsOlderYear = new HashMap<Animal, Integer>();
        for (Integer count = 0; count < animals.size(); count++) {
            Integer age = Period.between(animals.get(count).getBirthDate(), LocalDate.now()).getYears();
            if (age >= year) {
                animalsOlderYear.put(animals.get(count), animals.get(count).getBirthDate().getYear());
            }
        }
        if (animalsOlderYear.isEmpty()) {
            Integer resultIndex = 0;
            Integer resultAge = 0;
            for (Integer count = 0; count < animals.size(); count++) {
                Integer ageLeft = Period.between(animals.get(0).getBirthDate(), LocalDate.now()).getYears();
                Integer ageRight = Period.between(animals.get(count).getBirthDate(), LocalDate.now()).getYears();
                if (ageLeft < ageRight) {
                    resultAge = ageRight;
                    resultIndex = count;
                }
            }
            animalsOlderYear.put(animals.get(resultIndex), animals.get(resultIndex).getBirthDate().getYear());
        }
        return animalsOlderYear;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Integer cats = 0;
        Integer dogs = 0;
        Integer wolfs = 0;
        Integer lions = 0;
        Map<String, Integer> animalsDuplicate = new HashMap<String, Integer>();

        for (Integer count = 0; count < animals.size(); count++) {
            switch (animals.get(count).getClass().getName()) {
                case ("Cat"):
                    cats += cats;
                    break;
                case ("Dog"):
                    dogs += dogs;
                    break;
                case ("Wolf"):
                    wolfs += wolfs;
                    break;
                case ("Lion"):
                    lions += lions;
                    break;
            }
        }
        if (cats != 0) {
            animalsDuplicate.put("Cats", cats);
        }
        if (dogs != 0) {
            animalsDuplicate.put("Dogs", dogs);
        }
        if (wolfs != 0) {
            animalsDuplicate.put("Wolfs", wolfs);
        }
        if (lions != 0) {
            animalsDuplicate.put("Lions", lions);
        }

        return animalsDuplicate;
    }
}
