import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.example.helpers.Helper;
import org.example.helpers.RegistrationForm;
import org.example.helpers.SubmittedRegistrationForm;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class TestFormPage {
    private WebDriver driver;
    private RegistrationPage formPage;
    private final String titleThankForSubmittingTheForm = "Thanks for submitting the form";
    private final String pathToImagesDirectory = "C:\\Users\\Даниил\\IdeaProjects\\Simbirsoft-SDET\\Simbisoft-SDET\\src\\main\\resources\\uploadPictures\\";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-win64/chromedriver.exe");
    }

    @Test
    @Description("Тест проверяет страницу регистрации генерируя данные и отправляя всю форму")
    @Link(name = "Registration", url = "https://demoqa.com/automation-practice-form")
    public void testFullForm() {
        List<String> names = NameGenerator.generateFullName();
        for (var name : names) {
            String[] fullName = name.split(" ");
            try {
                driver = new ChromeDriver();
                driver.get("https://demoqa.com/automation-practice-form");
                formPage = new RegistrationPage(driver);
                Calendar calendar1 = DateOfBirthGenerator.getCalendar();
                RegistrationForm registration = new RegistrationForm(
                        fullName[0],
                        fullName[1],
                        "name@example.com",
                        PhoneGenerator.generatePhone(),
                        calendar1,
                        Helper.getRandomSubject(),
                        (pathToImagesDirectory + "img.png"),
                        "Samara"
                );
                formPage.sendAll(registration);
                formPage.submit(formPage.getSubmit());

                SubmittedRegistrationForm submittedForm = Utils.submittedForm(formPage);
                testTitle(formPage.findElement(By.id("example-modal-sizes-title-lg")).getText());
                testName(registration.getFirst_name() + " " + registration.getLast_name(), submittedForm.student_name());
                testEmail(submittedForm.email(), registration.getEmail());
                testGender(submittedForm.gender(), Helper.genders.get(registration.getGender_index()));
                testPhone(submittedForm.mobile(), registration.getUser_number());
                testBirthday(submittedForm.date_of_birth(), Utils.converterDateFromCalendar(registration.getDate_of_birth()));
                testSubject(submittedForm.subjects(), registration.getSubject());
                testHobbies(submittedForm.hobbies(), Helper.hobbies.get(registration.getHobbies_index()));
                Assert.assertEquals(submittedForm.picture(), registration.getPath_picture().substring(pathToImagesDirectory.length()));
                testPicture(submittedForm.picture(), registration.getPath_picture().substring(pathToImagesDirectory.length()));
                testCurrentAddress(submittedForm.address(), registration.getCurrent_address());
                testStateAndCity(submittedForm.state_and_city(), Helper.states_and_cities.get(registration.getState_index()).get(registration.getCity_index()));
                driver.quit();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Step("Title")
    public void testTitle(String formTitle) {
        Assert.assertEquals(titleThankForSubmittingTheForm, formTitle);
    }

    @Step("Name")
    public void testName(String registrationName, String submittedName) {
        Assert.assertEquals(registrationName, submittedName);
    }

    @Step("Email")
    public void testEmail(String submittedEmail, String registrationEmail) {
        Assert.assertEquals(submittedEmail, registrationEmail);
    }

    @Step("Gender")
    public void testGender(String submittedGender, String registrationGender) {
        Assert.assertEquals(submittedGender, registrationGender);
    }

    @Step("Phone")
    public void testPhone(String submittedPhone, String registrationPhone) {
        Assert.assertEquals(submittedPhone, registrationPhone);
    }

    @Step("Subject")
    public void testSubject(String submittedSubject, String registrationSubject) {
        Assert.assertEquals(submittedSubject, registrationSubject);
    }

    @Step("Picture")
    public void testPicture(String submittedPicture, String registrationPicture) {
        Assert.assertEquals(submittedPicture, registrationPicture);
    }

    @Step("Hobbies")
    public void testHobbies(String submittedHobbies, String registrationHobbies) {
        Assert.assertEquals(submittedHobbies, registrationHobbies);
    }

    @Step("Birthday")
    public void testBirthday(String submittedBirthDay, String registrationBirthDay) {
        Assert.assertEquals(submittedBirthDay, registrationBirthDay);
    }

    @Step("Address")
    public void testCurrentAddress(String submittedAddress, String registrationAddress) {
        Assert.assertEquals(submittedAddress, registrationAddress);
    }

    @Step("State and city")
    public void testStateAndCity(String submittedStateAndCity, String registrationStateAndCity) {
        Assert.assertEquals(submittedStateAndCity, registrationStateAndCity);
    }
}
