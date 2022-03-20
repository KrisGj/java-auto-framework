package utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {

    private static final Faker faker = new Faker();

    public static String generateRandomEmail() {
        return faker.name().username() + "@example.com";
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        String firstThree = String.valueOf(random.nextInt(900) + 100);
        String lastTwo = String.valueOf(random.nextInt(90) + 10);
        return firstThree + "555" + lastTwo;
    }
}
