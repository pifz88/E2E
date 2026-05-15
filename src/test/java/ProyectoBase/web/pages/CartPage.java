package ProyectoBase.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends WebBasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement iconoCarrito;

    @FindBy(className = "shopping_cart_badge")
    List<WebElement> badgeCarrito;

    @FindBy(className = "inventory_item")
    List<WebElement> listaProductos;

    @FindBy(css = ".btn_primary.btn_inventory")
    List<WebElement> botonesAgregarCarrito;

    @FindBy(className = "cart_item")
    List<WebElement> itemsEnCarrito;

    @FindBy(className = "cart_button")
    List<WebElement> botonesEliminar;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement txtPostalCode;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//button[text()='Finish']")
    WebElement btnFinish;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    WebElement textCompra;

    @FindBy(xpath = "//div[@class='error-message-container error']//h3")
    WebElement mensajeError;

    public void agregarPrimerProducto() throws Exception {
        waitUntilElementIsPresent(botonesAgregarCarrito.get(0));
        botonesAgregarCarrito.get(0).click();
    }

    public void agregarPrimerosNProductos(int cantidad) throws Exception {
        waitUntilElementIsPresent(botonesAgregarCarrito.get(0));
        for (int i = 0; i < cantidad && i < botonesAgregarCarrito.size(); i++) {
            botonesAgregarCarrito.get(i).click();
        }
    }

    public int obtenerCantidadEnCarrito() {
        if (badgeCarrito.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badgeCarrito.get(0).getText());
    }

    public void irAlCarrito() throws Exception {
        waitUntilElementIsPresent(iconoCarrito);
        iconoCarrito.click();
    }

    public void eliminarPrimerProductoDelCarrito() throws Exception {
        waitUntilElementIsPresent(botonesEliminar.get(0));
        botonesEliminar.get(0).click();
    }

    public boolean carritoEstaVacio() {
        return itemsEnCarrito.isEmpty();
    }

    public void irAlCheckout() throws Exception {
        waitUntilElementIsPresent(btnCheckout);
        btnCheckout.click();
    }

    public void ingresarDatosCheckout(String firstName,String lastName,String postCode) throws Exception {
        waitUntilElementIsPresent(txtFirstName);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);//Pablo
        waitUntilElementIsPresent(txtLastName);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);//Figueroa
        waitUntilElementIsPresent(txtPostalCode);
        txtPostalCode.clear();
        txtPostalCode.sendKeys(postCode);//4780000
    }

    public String obtenerMensajeError() throws Exception {
        waitUntilElementIsPresent(mensajeError);
        return mensajeError.getText();
    }

    public void irAlContinue() throws Exception {
        waitUntilElementIsPresent(btnContinue);
        btnContinue.click();
    }

    public void irAFinish() throws Exception {
        waitUntilElementIsPresent(btnFinish);
        btnFinish.click();
    }

    public void validarCompraProducto() throws Exception {
        waitUntilElementIsPresent(textCompra);
    }

    }



