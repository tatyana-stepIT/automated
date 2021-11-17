package com.workshop.smadshop.driver;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

@Log4j2
public class EventListener extends AbstractWebDriverEventListener {
//    private static final Logger log = LogManager.getLogger(EventListener.class);

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.info("Clicking on {}", getElement(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Changing value " + Arrays.toString(keysToSend) + " for " + getElement(element));
    }

    private String getElement(WebElement element) {
        String text = element.getText();
        if (!text.isEmpty()) {
            return text;
        }
        if (!element.getAttribute("id").isEmpty()) {
            return element.getAttribute("id");
        }
        if (!element.getAttribute("class").isEmpty()) {
            return element.getAttribute("class");
        }
        return "";
    }
}
