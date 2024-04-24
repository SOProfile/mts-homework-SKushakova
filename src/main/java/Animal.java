import java.time.LocalDate;

public interface Animal {
    public String getBreed();
    public void setBreed();

    public String getName();
    public void setName();

    public Double getCost();
    public void setCost();

    public String getCharacter();
    public void setCharacter();

    public LocalDate getBirthDate();
    public void setBirthDate(LocalDate birthday);

    public String getSecretInformation();

    public void setSecretInformation();

    void returnAnimal(AbstractAnimal Animal);

    AbstractAnimal create(String name, String bread, String character, Double cost, LocalDate birthDate);
}
