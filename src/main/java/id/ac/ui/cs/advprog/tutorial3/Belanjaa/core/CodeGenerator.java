package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core;

import java.util.Random;

public class CodeGenerator {
    public static String generate() {
        // Taken from : https://www.baeldung.com/java-random-string
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
