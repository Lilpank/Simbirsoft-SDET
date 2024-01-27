package org.example.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Helper {
    public static final Map<Integer, String> genders = Map.of(
            0, "Male", 1, "Female", 2, "Other"
    );
    private static final ArrayList<String> subjects = new ArrayList<>(List.of(
            "Maths", "Accounting", "Arts", "English", "Physics"
    ));

    public static final Map<Integer, String> hobbies = Map.of(
            0, "Sports", 1, "Reading", 2, "Music"
    );

    public static String getRandomSubject() {
        return subjects.get((int) (Math.random() * (subjects.toArray().length)));
    }

    public static Iterable<String> getRandomSubjects() {
        var start = (int) (Math.random() * (subjects.toArray().length));
        var end = 0;
        return subjects.subList(start, end);
    }

    public static final Map<Integer, Map<Integer, String>> states_and_cities = Map.of(
            0, Map.of(
                    0, "NCR Delhi",
                    1, "NCR Gurgaon",
                    2, "NCR Noida"
            ),
            1, Map.of(
                    0, "Uttar Pradesh Agra",
                    1, "Uttar Pradesh Lucknow",
                    2, "Uttar Pradesh Merrut"
            ),
            2, Map.of(
                    0, "Haryana Karnal",
                    1, "Haryana Panipat"
            ),
            3, Map.of(
                    0, "Rajasthan Jaipur",
                    1, "Rajasthan Jaiselmer"
            )
    );
}
