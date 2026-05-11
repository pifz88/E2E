package ProyectoBase.web.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import ProyectoBase.base.ScenarioContext;
import ProyectoBase.web.pages.LoginPage;
import ProyectoBase.web.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition extends BaseDefinitions {

    LoginPage loginPage;
    ProductsPage productsPage;

    public LoginDefinition(ScenarioContext context) {
        super(context);
        loginPage = new LoginPage(context.getDriver());
        productsPage = new ProductsPage(context.getDriver());
    }

    @Given("abro el navegador en la pagina de login")
    public void abro_el_navegador_en_la_pagina_de_login() {
        loginPage.abrirPaginaLogin(data_global.get("url"));
    }

    @When("ingreso el usuario {string} y contrasena {string}")
    public void ingreso_el_usuario_y_contrasena(String usuario, String contrasena) {
        loginPage.ingresarCredenciales(usuario, contrasena);
    }

    @And("hago clic en Ingresar")
    public void hago_clic_en_ingresar() {
        loginPage.clickIngresar();
    }

    @Then("deberia ver el catalogo de productos")
    public void deberia_ver_el_catalogo_de_productos() throws Exception {
        assertTrue("No se cargo el catalogo de productos", productsPage.hayProductos());
    }

    @Then("deberia ver el mensaje de error {string}")
    public void deberia_ver_el_mensaje_de_error(String mensajeEsperado) throws Exception {
        String mensajeActual = loginPage.obtenerMensajeError();
        assertEquals("El mensaje de error no coincide", mensajeEsperado, mensajeActual);
    }

    @And("cierro sesion desde el menu")
    public void cierro_sesion_desde_el_menu() throws Exception {
        loginPage.cerrarSesion();
    }

    @Then("deberia ver la pagina de login")
    public void deberia_ver_la_pagina_de_login() {
        assertTrue("No se cargo la pagina de login", loginPage.esPaginaDeLogin());
    }
}
