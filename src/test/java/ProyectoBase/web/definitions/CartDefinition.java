package ProyectoBase.web.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ProyectoBase.base.ScenarioContext;
import ProyectoBase.web.pages.CartPage;
import ProyectoBase.web.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDefinition extends BaseDefinitions {
    LoginPage loginPage;
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

    @And("voy al Checkout")
    public void ingresar_a_Checkout() throws Exception {
        cartPage.irAlCheckout();
    }

/*    @And("ingreso el firstname, el lastname y el postcode")
    public void ingreso_el_firstname_el_lastname_y_el_postcode() throws Exception {
        cartPage.ingresarDatosCheckout();
    }*/

    @And("ingreso el {string}, el {string} y el {string}")
    public void ingreso_el_firstname_el_lastname_y_el_postcode(String firstname,String lastname, String postcode) throws Exception {
        cartPage.ingresarDatosCheckout(firstname,lastname,postcode);
    }

    @And("el sistema muestra el mensaje de validación {string}")
    public void el_sistema_muestra_el_mensaje_de_validación(String mensajeEsperado)throws Exception {
        String mensajeActual = cartPage.obtenerMensajeError();
        assertEquals("El mensaje de error no coincide", mensajeEsperado, mensajeActual);
    }

    @And("presionar boton continue")
    public void presionar_boton_continue() throws Exception {
        cartPage.irAlContinue();
    }

    @And("presionar boton finish")
    public void presionar_boton_finish() throws Exception {
        cartPage.irAFinish();
    }

    @And("validar compra de producto")
    public void validar_compra_de_producto() throws Exception {
        cartPage.validarCompraProducto();
    }



}
