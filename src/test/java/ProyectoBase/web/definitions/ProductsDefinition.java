package ProyectoBase.web.definitions;

import static org.junit.Assert.assertTrue;

import ProyectoBase.base.ScenarioContext;
import ProyectoBase.base.Utils;
import ProyectoBase.web.pages.LoginPage;
import ProyectoBase.web.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductsDefinition extends BaseDefinitions {

    LoginPage loginPage;
    ProductsPage productsPage;

    public ProductsDefinition(ScenarioContext context) {
        super(context);
        loginPage = new LoginPage(context.getDriver());
        productsPage = new ProductsPage(context.getDriver());
    }

    @Given("estoy autenticado en la tienda")
    public void estoy_autenticado_en_la_tienda() throws Exception {
        loginPage.abrirPaginaLogin(data_global.get("url"));
        loginPage.ingresarCredenciales(
            data_global.get("usuario_valido"),
            data_global.get("contrasena_valida")
        );
        loginPage.clickIngresar();
        Utils.waitTime(1);
    }

    @Then("deberia ver al menos 1 producto en el catalogo")
    public void deberia_ver_al_menos_1_producto_en_el_catalogo() throws Exception {
        assertTrue("No se encontraron productos en el catalogo", productsPage.hayProductos());
        System.out.println("Productos encontrados: " + productsPage.cantidadProductos());
    }
}
