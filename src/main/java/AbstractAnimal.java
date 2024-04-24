import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class AbstractAnimal implements Animal, Serializable {

    protected String breed;

    protected String name;

    protected Double cost;

    protected String character;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)

    protected LocalDate birthDate;

    protected transient String secretInformation; //секретная информация о хозяине животного

    protected AbstractAnimal(String breed, String name, String character, Double cost, LocalDate birthDate) {
        this.character = character;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.birthDate = birthDate;
    }

    protected void saySome() {
        System.out.println("Голос?");
    }

    @Override
    public String getSecretInformation() {
        return secretInformation;
    }

    public void setSecretInformation(String secretInformation) {
        this.secretInformation = secretInformation;
    }

    @Override
    public String toString() {
        return breed + " | " + name + " | " + cost + " | " + character + " | " + this.localDateToStringFormat(birthDate, "dd-MM-yyyy") + " | " + secretInformation + " | " + "\n";
    }

    public static String localDateToStringFormat(LocalDate localDate, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(formatter);
    }
}

