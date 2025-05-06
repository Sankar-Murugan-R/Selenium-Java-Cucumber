package utils;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomValueGenerator {
    private static final Logger log = LogManager.getLogger(RandomValueGenerator.class);

    /**
     * This method will return the random integer values
     */
    public String randomNumbers(int size) {
        StringBuilder num = new StringBuilder(size);
        Random objGenerator = new Random();
        for (int i = 0; i < size; i++) {
            int digit = objGenerator.nextInt(10);
            num.append(digit);
        }
        log.info("Here is a random generated numbers: " + num + "");
        return num.toString();
    }

    /**
     * This method will return the random alphabetic values
     */
    public String randomString(int size) {
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = (char) (random.nextInt(26) + 'A');
            sb.append(c);
        }
        log.info("Here is a random generated string: " + sb.toString() + "");
        return sb.toString();
    }
}


