package hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw6.entities.JdiUser;
import hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {
    public LoginForm loginForm;

    @Css("#user-name")
    private Text userName;

    @Css("#user-icon")
    private Button userIcon;


    public String getUserName() {
        return userName.getText();
    }

    public void login(JdiUser jdiUser) {
        userIcon.click();
        loginForm.login(jdiUser);
    }

}
