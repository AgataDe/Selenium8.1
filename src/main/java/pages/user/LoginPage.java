package pages.user;

import handlers.UserFactory;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    User getAlreadyRegisteredUser = new UserFactory().getAlreadyRegisteredUser();
    @FindBy(css = "#login-form")
    private WebElement loginForm;
    @FindBy(css = "input.form-control[type='email']")
    private WebElement emailInput;
    @FindBy(css = "input.form-control[type='password']")
    private WebElement passwordInput;
    @FindBy(css = "#submit-login")
    private WebElement signInButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public UserAccountPage logIn(User registeredUser) {
        waitToBeVisible(loginForm);
        emailInput.sendKeys(registeredUser.getEmail());
        passwordInput.sendKeys(registeredUser.getPassword());
        click(signInButton);
        return new UserAccountPage(driver);
    }
}
