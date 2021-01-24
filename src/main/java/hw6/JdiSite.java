package hw6;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw6.entities.Data;
import hw6.entities.JdiUser;
import hw6.pages.JdiHomePage;
import hw6.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/")
    @Title("Home Page")
    public static JdiHomePage jdiHomePage;


    @Url("/metals-colors.html")
    @Title("Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css(".m-l8")
    static Menu headerMenu;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(JdiUser jdiUser) {
        jdiHomePage.login(jdiUser);
    }

    public static void submitMetalsAndColorsFormFilledWithData(Data data) {
        metalsAndColorsPage.metalsAndColorsForm.submit(data);
    }

}
