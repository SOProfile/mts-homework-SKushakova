import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class AnimalJson extends AbstractAnimal {
    public AnimalJson(@JsonProperty("breed")String breed, @JsonProperty("name")String name, @JsonProperty("character")String character, @JsonProperty("cost")Double cost, @JsonProperty("birthDate")LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public void setBreed() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName() {

    }

    @Override
    public Double getCost() {
        return this.cost;
    }

    @Override
    public void setCost() {

    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public void setCharacter() {

    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthday) {

    }

    @Override
    public void setSecretInformation() {

    }

    @Override
    public void returnAnimal(AbstractAnimal Animal) {

    }

    @Override
    public AbstractAnimal create(String name, String bread, String character, Double cost, LocalDate birthDate) {
        return null;
    }
}