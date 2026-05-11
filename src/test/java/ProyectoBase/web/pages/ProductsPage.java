package ProyectoBase.web.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends WebBasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> listaProductos;

    public boolean hayProductos() throws Exception {
        waitUntilElementIsPresent(listaProductos.get(0));
        return listaProductos.size() > 0;
    }

    public int cantidadProductos() {
        return listaProductos.size();
    }
}
