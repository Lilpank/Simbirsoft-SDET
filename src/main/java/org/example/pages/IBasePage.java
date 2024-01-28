package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IBasePage {
    default void clickJS(WebElement webElement) {
        webElement.click();
    }

    default void click(WebElement webElement) {
        webElement.click();
    }

    default void send(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    WebElement findElement(By locator);

    Iterable<WebElement> findElements(By locator);

    default void submit(WebElement webElement) {
        webElement.submit();
    }
}
