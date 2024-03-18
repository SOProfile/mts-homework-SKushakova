import java.time.LocalDate;

public class InvalidAnimalException extends RuntimeException {

    public InvalidAnimalException(String message) {
        super(message);
    }

    public static InvalidAnimalException nullObject() {
        return new InvalidAnimalException("На вход пришел не корректный объект животного " + LocalDate.now());
    }
}
