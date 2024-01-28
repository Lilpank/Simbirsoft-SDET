package org.example.helpers;

public record SubmittedRegistrationForm(String student_name, String email, String gender, String mobile,
                                        String date_of_birth,
                                        String subjects, String hobbies, String picture, String address,
                                        String state_and_city) {
}
