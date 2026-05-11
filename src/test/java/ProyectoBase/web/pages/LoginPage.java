package ProyectoBase.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement inputUsuario;

    @FindBy(id = "password")
    WebElement inputContrasena;

    @FindBy(id = "login-button")
    WebElement buttonIngresar;

    @FindBy(css = "[data-test='error']")
    WebElement mensajeError;

    @FindBy(id = "react-burger-menu-btn")
    WebElement buttonMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement linkLogout;

    public void abrirPaginaLogin(String url) {
        getDriver().get(url);
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        inputUsuario.clear();
        inputUsuario.sendKeys(usuario);
        inputContrasena.clear();
        inputContrasena.sendKeys(contrasena);
    }

    public void clickIngresar() {
        buttonIngresar.click();
    }

    public String obtenerMensajeError() throws Exception {
        waitUntilElementIsPresent(mensajeError);
        return mensajeError.getText();
    }

    public void cerrarSesion() throws Exception {
        waitUntilElementIsPresent(buttonMenu);
        buttonMenu.click();
        waitUntilElementIsPresent(linkLogout);
        linkLogout.click();
    }

    public boolean esPaginaDeLogin() {
        return getDriver().getCurrentUrl().contains("saucedemo.com") &&
               inputUsuario.isDisplayed();
    }
}