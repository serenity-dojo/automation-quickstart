package saucedemo.acceptancetests.authentication;

import net.serenitybdd.core.steps.WebDriverScenarios;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ui.PageElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import saucedemo.domain.authentication.LoginForm;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class LoginToTheApplication extends WebDriverScenarios {

    @Test
    void withAValidUsernameAndPassword() {
        openUrl("https://www.saucedemo.com/");

        $(LoginForm.USERNAME_FIELD).type("standard_user");
        $(LoginForm.PASSWORD_FIELD).type("secret_sauce");
        $(LoginForm.LOGIN_BUTTON).click();

        String title = $(".title").getText();

        assertThat(title).isEqualTo("PRODUCTS");
    }

    @Test
    void withAnInvalidUsernameAndPassword() {
        openUrl("https://www.saucedemo.com/");

        $(LoginForm.USERNAME_FIELD).type("standard_user");
        $(LoginForm.PASSWORD_FIELD).type("wrong_password");
        $(LoginForm.LOGIN_BUTTON).click();

        $(PageElement.withCSSClass("error")).shouldBeVisible();
    }
}
