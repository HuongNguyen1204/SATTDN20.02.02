package helpers;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHelper {
    private static Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    /***
     * Return number random from 1 to n
     * @param num
     * @return
     */
    public static int randomNumber(int num) {
        return faker.number().numberBetween(1, num);
    }

    public static String randomText() {
        return faker.name().title();
    }


}
