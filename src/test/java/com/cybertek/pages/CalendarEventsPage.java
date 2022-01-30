package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "div[class='btn btn-link dropdown-toggle']")
    public WebElement optionsLink;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(css = "button[class='btn dropdown-toggle ']")
    public WebElement viewPerPage;


}