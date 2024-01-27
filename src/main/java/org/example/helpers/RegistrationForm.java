package org.example.helpers;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
public class RegistrationForm {
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String user_number;
    private final Calendar date_of_birth;
    private final String subject;
    private final String current_address;
    private int gender_index = (int) ((10 * Math.random()) % 3);
    private int hobbies_index = (int) ((10 * Math.random()) % 3);
    private String path_picture;
    private int state_index = (int) ((10 * Math.random()) % 4);
    @Setter
    private int city_index = (int) ((10 * Math.random()));


    public RegistrationForm(String first_name, String last_name, String email,
                            int radio, String user_number, Calendar date_of_birth,
                            String subject, int hobbies, String current_address,
                            int state_index, int city_index) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender_index = radio;
        this.user_number = user_number;
        this.date_of_birth = date_of_birth;
        this.subject = subject;
        this.hobbies_index = hobbies;
        this.current_address = current_address;
        this.state_index = state_index;
        this.city_index = city_index;
    }

    public RegistrationForm(String first_name, String last_name, String email, String user_number,
                            Calendar date_of_birth, String subject, String pathPicture, String current_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.user_number = user_number;
        this.date_of_birth = date_of_birth;
        this.subject = subject;
        this.path_picture = pathPicture;
        this.current_address = current_address;
    }
}
