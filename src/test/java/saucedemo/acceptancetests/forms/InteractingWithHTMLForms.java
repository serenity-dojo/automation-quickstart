package saucedemo.acceptancetests.forms;

import net.serenitybdd.core.steps.WebDriverScenarios;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ui.InputField;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class InteractingWithHTMLForms extends WebDriverScenarios {

    @Test
    void workingWithInputFields() {
        openAt("https://demoqa.com/automation-practice-form");

        find(InputField.withPlaceholder("First Name")).type("Fred");
        find(InputField.withPlaceholder("Last Name")).type("Flintstone");

        String enteredFirstName = find(InputField.withPlaceholder("First Name")).getValue();
        String enteredLastName = find(InputField.withPlaceholder("Last Name")).getValue();

        assertThat(enteredFirstName).isEqualTo("Fred");
        assertThat(enteredLastName).isEqualTo("Flintstone");

    }

}
