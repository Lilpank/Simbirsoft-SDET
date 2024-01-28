import com.google.common.collect.Streams;

import java.util.Arrays;
import java.util.List;

public class NameGenerator {
    private static final String[] FIRST_NAMES = {"Dora", "Mary", "James", "Elizabeth", "David", "Sarah", "Michael", "Emily", "William", "Emma"};
    private static final String[] LAST_NAMES = {"Sergeevna", "Johnson", "Brown", "Taylor", "Miller", "Anderson", "Wilson", "Clark", "Davis", "Martin"};

    public static List<String> generateFullName() {
        return Streams.zip(Arrays.stream(FIRST_NAMES), Arrays.stream(LAST_NAMES), (first, last) -> first + " " + last).toList();
    }

    public static void main(String[] args) {
        System.out.println(generateFullName());
    }
}
