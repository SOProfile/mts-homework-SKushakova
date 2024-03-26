import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) throws InvalidAnimalBirthDateException {
        Map<String, LocalDate> animalsLeapYear = new HashMap<String, LocalDate>();
        animals.stream().filter(animal -> (Year.of(animal.getBirthDate().getYear()).isLeap())).forEach(animal -> {
            animalsLeapYear.put(animal.getName(), animal.getBirthDate());
        });
        /*
        SearchServiceImpl searchService = new SearchServiceImpl();
        for (Integer count = 0; count < animals.size(); count++) {
            if (searchService.checkLeapYearAnimal(animals.get(count))) {
                animalsLeapYear.put(animals.get(count).getClass().getName() + " " + animals.get(count).getName(), animals.get(count).getBirthDate());
            }
        }
        */
        return animalsLeapYear;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, Integer year) {
        Map<Animal, Integer> animalsOlderYear = new HashMap<Animal, Integer>();
        /*
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
         */
        animals.stream().filter(p -> (Period.between(p.getBirthDate(), LocalDate.now()).getYears() > year)).forEach(animal -> {
            animalsOlderYear.put(animal, animal.getBirthDate().getYear());
        });
        if (animalsOlderYear.isEmpty()) {
            Animal animal = animals.stream().max(Comparator.comparing(Animal::getBirthDate)).orElse(null);
            animalsOlderYear.put(animal, animal.getBirthDate().getYear());
        }
        return animalsOlderYear;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Integer cats = 0;
        Integer dogs = 0;
        Integer wolfs = 0;
        Integer lions = 0;
        Map<String, Integer> animalsDuplicate = animals.stream().collect(Collectors.groupingBy(animal -> animal.getClass().getName(), collectingAndThen(counting(), Long::intValue)));
        /*
        animalsDuplicate = animals.stream().collect(Collectors.toMap(animal -> animal.getClass().getName(), value -> 1, Integer::sum));

        for (Integer count = 0; count < animals.size(); count++) {
            switch (animals.get(count).getClass().getName()) {
                case ("Cat"):
                    cats = cats + 1;
                    break;
                case ("Dog"):
                    dogs = dogs + 1;
                    break;
                case ("Wolf"):
                    wolfs = wolfs + 1;
                    break;
                case ("Lion"):
                    lions = lions + 1;
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
         */
        return animalsDuplicate;
    }

    @Override
    public double findAverageAge(List<Animal> animals) {
        double averageAge = animals.stream()
                .mapToInt(animal -> Period.between(animal.getBirthDate(), LocalDate.now()).getYears())
                .summaryStatistics()
                .getAverage();
        return averageAge;
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animals) {
        List<Animal> resultAnimals = animals.stream().filter(p -> (Period.between(p.getBirthDate(), LocalDate.now()).getYears() > 5)).filter(animal -> animal.getCost() > animals.stream()
                .mapToInt(animalAge -> animalAge.getCost().intValue())
                .summaryStatistics()
                .getAverage()).collect(Collectors.toList());
        return resultAnimals;
    }

    @Override
    public List<String> findMinConstAnimals(List<Animal> animals) {
        List<String> resultAnimals = new ArrayList<>();
        animals.stream().sorted(Comparator.comparing(Animal::getCost)).limit(3).sorted(Comparator.comparing(Animal::getName).reversed()).collect(Collectors.toList()).forEach(animal -> {
            resultAnimals.add(animal.getName());
        });
        return resultAnimals;
    }
}
