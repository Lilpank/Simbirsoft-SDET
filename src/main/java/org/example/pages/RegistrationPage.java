package org.example.pages;

import lombok.Getter;
import org.example.helpers.RegistrationForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Month;
import java.util.Calendar;
import java.util.List;

@Getter
public class RegistrationPage extends BasePage {
    @FindBy(id = "firstName")
    private WebElement search_first_name;
    @FindBy(id = "lastName")
    private WebElement search_last_name;
    @FindBy(id = "userEmail")
    private WebElement search_email;
    @FindAll({
            @FindBy(css = "input#gender-radio-1"),
            @FindBy(css = "input#gender-radio-2"),
            @FindBy(css = "input#gender-radio-3")
    })
    private List<WebElement> search_gender_radio;
    @FindBy(id = "userNumber")
    private WebElement search_user_number;
    @FindBy(xpath = "//div[@id='dateOfBirth']//input")
    private WebElement search_date_of_birth;
    @FindBy(css = "input#subjectsInput")
    private WebElement search_subjects;
    @FindAll({
            @FindBy(css = "input#hobbies-checkbox-1"),
            @FindBy(css = "input#hobbies-checkbox-2"),
            @FindBy(css = "input#hobbies-checkbox-3")
    })
    private List<WebElement> search_hobbies;
    @FindBy(id = "currentAddress")
    private WebElement search_current_address;
    @FindBy(css = "button#submit")
    private WebElement submit;
    @FindBy(css = "input#uploadPicture")
    private WebElement search_upload_picture;
    @FindBy(xpath = "//div[@id='state']")
    private WebElement search_state;
    @FindBy(id = "city")
    private WebElement search_city;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendAll(RegistrationForm registration) throws Exception {
        if (registration == null) {
            throw new Exception("Registration is null");
        }

        send(getSearch_first_name(), registration.getFirst_name());
        send(getSearch_last_name(), registration.getLast_name());
        send(getSearch_email(), registration.getEmail());
        clickWithoutVisible(getSearch_gender_radio().get(registration.getGender_index()));
        send(getSearch_user_number(), registration.getUser_number());
        clickJS(getSearch_date_of_birth());
        setDate(registration.getDate_of_birth());
        send(getSearch_subjects(), registration.getSubject().substring(0, 1));
        clickJS(findElement(By.cssSelector(".subjects-auto-complete__menu")).findElement(By.xpath("//div[text()='" + registration.getSubject() + "']")));
        clickWithoutVisible(getSearch_hobbies().get(registration.getHobbies_index()));
        getSearch_upload_picture().sendKeys(registration.getPath_picture());
        send(getSearch_current_address(), registration.getCurrent_address());

        click(getSearch_state());
        clickJS(getSearch_state().findElement(By.id("react-select-3-option-" + registration.getState_index())));
        click(getSearch_city());

        List<WebElement> elements = findElements(By.xpath("//div[starts-with(@id, 'react-select-4-option-')]"));
        registration.setCity_index(registration.getCity_index() % (elements.size()));
        clickJS(getSearch_city().findElement(By.id("react-select-4-option-" + registration.getCity_index())));
    }

    private void setDate(Calendar date) {
        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);

        WebElement selYear = findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        By.xpath("//*[@class='react-datepicker__year-select']");

        selYear.click();
        String y = Integer.toString(year);
        selYear.sendKeys(y);
        selYear.click();

        WebElement selMonth = findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        selMonth.click();
        String m = Month.of(month).toString();
        selMonth.sendKeys(m);
        selMonth.click();
        String d = Integer.toString(day);
        String xp = "//*[@class='react-datepicker__week']//*[text()='" + d + "']";
        WebElement selDate = findElement(By.xpath(xp));
        selDate.click();
    }
}
