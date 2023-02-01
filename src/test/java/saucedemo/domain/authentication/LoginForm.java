package saucedemo.domain.authentication;

import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.InputField;

public class LoginForm {
    public static final SearchableTarget USERNAME_FIELD = InputField.withPlaceholder("Username");
    public static final SearchableTarget PASSWORD_FIELD = InputField.withPlaceholder("Password");
    public static final SearchableTarget LOGIN_BUTTON = Button.withText("Login");
}
