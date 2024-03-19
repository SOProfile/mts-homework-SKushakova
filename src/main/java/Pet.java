import java.time.LocalDate;

public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, String character, Double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getCharacter() {
        return character;
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
    public AbstractAnimal create(String name, String breed, String character, Double cost, LocalDate birthDate) {
        Pet pet = new Pet(breed, name, character, cost, birthDate);
        pet.breed = breed;
        pet.name = name;
        pet.cost = cost;
        pet.character = character;
        pet.birthDate = birthDate;
        return pet;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void returnAnimal(AbstractAnimal Animal) {
        System.out.println("Порода: " + this.getBreed() + " Характер: " + this.getCharacter() + " Имя: " + this.getName() + " Цена: " + this.getCost() + " День рождения: " + this.getBirthDate() + " А еще я домашний <3");
    }
}
