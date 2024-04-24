import java.time.LocalDate;

public class Predator extends AbstractAnimal {

    public Predator(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public void setBreed() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName() {

    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public void setCost() {

    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public void setCharacter() {

    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthday) {
        this.birthDate = birthday;
    }

    @Override
    public void setSecretInformation() {

    }

    @Override
    public AbstractAnimal create(String name, String breed, String character, Double cost, LocalDate birthDate) {
        Predator predator = new Predator(breed, name, character, cost, birthDate);
        predator.breed = breed;
        predator.name = name;
        predator.cost = cost;
        predator.character = character;
        return predator;
    }

    @Override
    public void returnAnimal(AbstractAnimal Animal) {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: " + this.getName() + " День рождения: " + this.getBirthDate() + " Цена: " + this.getCost() + " У меня нет дома ((");
    }
}

