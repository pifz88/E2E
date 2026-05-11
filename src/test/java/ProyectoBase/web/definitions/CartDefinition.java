package ProyectoBase.web.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ProyectoBase.base.ScenarioContext;
import ProyectoBase.web.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDefinition extends BaseDefinitions {

    CartPage cartPage;

    public CartDefinition(ScenarioContext context) {
        super(context);
        cartPage = new CartPage(context.getDriver());
    }

    @When("agrego el primer producto al carrito")
    public void agrego_el_primer_producto_al_carrito() throws Exception {
        cartPage.agregarPrimerProducto();
    }

    @When("agrego los primeros {int} productos al carrito")
    public void agrego_los_primeros_productos_al_carrito(int cantidad) throws Exception {
        cartPage.agregarPrimerosNProductos(cantidad);
    }

    @Then("el icono del carrito deberia mostrar {int} producto")
    public void el_icono_del_carrito_deberia_mostrar_producto(int cantidad) {
        assertEquals("La cantidad en el carrito no es la esperada",
            cantidad, cartPage.obtenerCantidadEnCarrito());
    }

    @Then("el icono del carrito deberia mostrar {int} productos")
    public void el_icono_del_carrito_deberia_mostrar_productos(int cantidad) {
        assertEquals("La cantidad en el carrito no es la esperada",
            cantidad, cartPage.obtenerCantidadEnCarrito());
    }

    @And("voy al carrito")
    public void voy_al_carrito() throws Exception {
        cartPage.irAlCarrito();
    }

    @And("elimino el producto del carrito")
    public void elimino_el_producto_del_carrito() throws Exception {
        cartPage.eliminarPrimerProductoDelCarrito();
    }

    @Then("el carrito deberia estar vacio")
    public void el_carrito_deberia_estar_vacio() {
        assertTrue("El carrito no esta vacio", cartPage.carritoEstaVacio());
    }
}
