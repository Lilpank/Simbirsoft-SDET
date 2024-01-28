import org.example.helpers.SubmittedRegistrationForm;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Month;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Utils {
    protected static String converterDateFromCalendar(Calendar calendar) {
        String[] s = calendar.getTime().toString().split(" ");
        String month = Month.of(calendar.get(Calendar.MONTH)).toString().toLowerCase();
        month = month.substring(0, 1).toUpperCase() + month.substring(1);
        return s[2] + " " + month + "," + s[5];
    }

    protected static SubmittedRegistrationForm submittedForm(RegistrationPage formPage) {
        List<WebElement> table = formPage.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
        HashMap<String, String> submitted_data = new HashMap<>();

        for (WebElement t : table) {
            submitted_data.put(t.findElement(By.xpath("./td[1]")).getText(), t.findElement(By.xpath("./td[2]")).getText());
        }
        return new SubmittedRegistrationForm(
                submitted_data.get("Student Name"),
                submitted_data.get("Student Email"),
                submitted_data.get("Gender"),
                submitted_data.get("Mobile"),
                submitted_data.get("Date of Birth"),
                submitted_data.get("Subjects"),
                submitted_data.get("Hobbies"),
                submitted_data.get("Picture"),
                submitted_data.get("Address"),
                submitted_data.get("State and City")
        );
    }
}
