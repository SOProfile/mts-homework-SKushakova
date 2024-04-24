import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalsRepositoryImpl implements AnimalsRepository {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalBirthDateException {
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
    public Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, Integer year) {
        Map<AbstractAnimal, Integer> animalsOlderYear = new HashMap<AbstractAnimal, Integer>();
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
        writeToFile(animalsOlderYear);
        return animalsOlderYear;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<AbstractAnimal> animals) {
        Integer cats = 0;
        Integer dogs = 0;
        Integer wolfs = 0;
        Integer lions = 0;
        Map<String, Integer> animalsDuplicate = new HashMap<String, Integer>();

        for (Integer count = 0; count < animals.size(); count++) {
            switch (animals.get(count).getClass().getName()) {
                case ("Cat"):
                    cats++;
                    break;
                case ("Dog"):
                    dogs++;
                    break;
                case ("Wolf"):
                    wolfs++;
                    break;
                case ("Lion"):
                    lions++;
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
    private static String encodeSecret(String secretInfo) {
        return Base64.getEncoder().encodeToString(secretInfo.getBytes());
    }
    private static void writeToFile(Map<AbstractAnimal, Integer> animals) {
        String path = "src/main/resources/results/findOlderAnimals.json";
        File file = new File(path);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        for (AbstractAnimal animal : animals.keySet()) {
            String encodeSecretInformation = encodeSecret(animal.getSecretInformation());
            animal.setSecretInformation(encodeSecretInformation);
        }

        try {
            objectMapper.writeValue(file, animals.keySet());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
