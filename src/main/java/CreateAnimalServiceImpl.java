import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    public Map<String, List<Animal>> createAnimal(int _animalsNum) {
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
    public Map<String, List<Animal>> createAnimal() {
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

    public List<Animal> createRandomListAnimal()
    {
        List<Animal> animalList = new ArrayList<>();
        for (Integer count = 0; count < 10; count ++)
        {
            animalList.add(this.createRandomAnimal());
        }
        return animalList;
    }
}
