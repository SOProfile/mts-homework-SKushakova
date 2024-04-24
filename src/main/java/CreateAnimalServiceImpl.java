import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public Map<String, List<AbstractAnimal>> createAnimal(int _animalsNum) {
        Integer count = 0;
        for (count = 0; count < _animalsNum; count++) {
            this.createListAnimal();
        }
        this.createMapAnimal(cats);
        this.createMapAnimal(dogs);
        this.createMapAnimal(lions);
        this.createMapAnimal(wolfs);

        return animals;
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimal() {
        Integer count = 0;
        do {
            this.createListAnimal();
            count = count + 1;
        } while (count < 10);
        this.createMapAnimal(cats);
        this.createMapAnimal(dogs);
        this.createMapAnimal(lions);
        this.createMapAnimal(wolfs);
        return animals;
    }

    public List<AbstractAnimal> createRandomListAnimal()
    {
        String animal;
        List<AbstractAnimal> animalList = new ArrayList<>();
        for (Integer count = 0; count < 10; count ++)
        {
            animalList.add(this.createRandomAnimal());
            Object LocalDateFormatter;
            animal = count + 1 + " " + animalList.get(count).getClass().getName() + " " + animalList.get(count).getName() + " " + animalList.get(count).getCost() + " " + animalList.get(count).getBirthDate() + "\n";
            this.write(animal);
        }
        return animalList;
    }
    /**
     * Функция для записи в файл строки.
     */
    static void write(String animal) {
        Path path = Paths.get("src/main/resources/animals/logData.txt");

        try {
            Files.writeString(path, animal, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
