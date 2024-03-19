import java.time.LocalDate;

public interface Animal {
    public String getBreed();

    public String getName();

    public Double getCost();

    public String getCharacter();

    public LocalDate getBirthDate();

    public void setBirthDate(LocalDate birthday);

    void returnAnimal(AbstractAnimal Animal);

    AbstractAnimal create(String name, String bread, String character, Double cost, LocalDate birthDate);
}
