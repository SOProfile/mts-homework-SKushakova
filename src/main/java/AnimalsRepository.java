import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalsRepository {
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) throws InvalidAnimalBirthDateException;

    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, Integer year);

    public Map<String, Integer> findDuplicate(List<Animal> animals);

    public double findAverageAge(List<Animal> animals);

    public List<Animal> findOldAndExpensive(List<Animal> animals);

    public List<String> findMinConstAnimals(List<Animal> animals);
}
