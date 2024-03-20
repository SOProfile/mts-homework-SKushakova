import java.time.LocalDate;
import java.time.Year;


public class SearchServiceImpl implements SearchService {
    @Override
    public boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException {
        if (animal == null) {
            throw InvalidAnimalException.nullObject();
        }
        LocalDate birthDate = animal.getBirthDate();
        if(birthDate == null){
            throw InvalidAnimalBirthDateException.nullBirthday(animal.getClass().getName());
        }

        if ( Year.of(birthDate.getYear()).isLeap()) {
            return true;
        } else {
            return  false;
        }
    }

    public Long getDaysOfYear(LocalDate date) {
        int year = date.getYear();
        LocalDate startYear = LocalDate.of(year, 1, 1);
        LocalDate endYear = LocalDate.of(year, 12, 31);
        Long days = java.time.temporal.ChronoUnit.DAYS.between(startYear, endYear);
        return days;
    }
}
