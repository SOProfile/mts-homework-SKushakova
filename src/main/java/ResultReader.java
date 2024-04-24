import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

public class ResultReader {

    /**
     * Функция Чтения объекта из файла.
     * Вывод результата в консоль
     */
    public void readObject() {
        String path = "src/main/resources/results/findOlderAnimals.json";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new File(path);

        try {
            AnimalJson[] animals = objectMapper.readValue(file, AnimalJson[].class);
            for (AnimalJson animal : animals) {
                String decodeSecretInfo = decodeSecret(animal.getSecretInformation());
                animal.setSecretInformation(decodeSecretInfo);
            }
            System.out.println("Прочитали объект из json: " + Arrays.toString(animals));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Функция для подсчета кол-ва строк в logData.txt.
     */
    public void getLogData() {
        Path path = Paths.get("src/main/resources/animals/logData.txt");

        try {
            Long count  = Files.readAllLines(path).stream().count();
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Функция декодирования строки из формата Base64 в String.
     */
    private static String decodeSecret(String secretInfo) {
        byte[] decodedBytes = Base64.getDecoder().decode(secretInfo);
        return new String(decodedBytes);
    }
}