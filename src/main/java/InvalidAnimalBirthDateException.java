public class InvalidAnimalBirthDateException extends Exception {
    public InvalidAnimalBirthDateException(String message) {
        super(message);
    }

    public static InvalidAnimalBirthDateException nullBirthday(String animalType) {
        return new InvalidAnimalBirthDateException("У животного " + animalType + " не указана его дата рождения");
    }
}
