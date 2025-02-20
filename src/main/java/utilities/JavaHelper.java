package utilities;

import com.github.javafaker.Faker;

public class JavaHelper {

    private static final Faker faker = new Faker();

    public static String generateRandomEmail() {
        return faker.name().firstName() + "@melaka.com";
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomPhoneNumber() {
        return "8"+faker.number().digits(10);
    }

    public static String generateRandomJob() {
        return faker.job().title();
    }


}
