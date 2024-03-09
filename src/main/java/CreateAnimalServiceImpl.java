public class CreateAnimalServiceImpl implements CreateAnimalService {

    public void createAnimal(int _animalsNum) {
        Integer count = 0;
        for (count = 0; count < _animalsNum; count++) {
            this.createRandomAnimal();
        }
    }

    @Override
    public void createAnimal() {
        Integer count = 0;
        do {
            this.createRandomAnimal();
            count = count + 1;
        } while (count < 10);
    }
}
