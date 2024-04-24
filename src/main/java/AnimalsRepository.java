import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalsRepository {
    public Map<String, LocalDate> findLeapYearNames(List<AbstractAnimal> animals) throws InvalidAnimalBirthDateException;

    public Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animals, Integer year);

    public Map<String, Integer> findDuplicate(List<AbstractAnimal> animals);
}
