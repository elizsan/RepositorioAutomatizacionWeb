package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;
import static com.nttdata.core.DriverManager.scrollDown;


public class LoginStepsDef {

    private WebDriver driver;
    private int unidProd=0;


//examen
    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {

        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();

    }
    //examen
    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String contrasena) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.ingresarUsuario(usuario);
        loginSteps.ingresarContrasena(contrasena);
        loginSteps.iniciarSesion();
        loginSteps.validoSesion();
        screenShot();
    }
    //examen
    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.seleccionarCategoria(categoria);
        screenShot();
        loginSteps.seleccionarSubcategoria(subcategoria);
        screenShot();
    }
    //examen
    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        unidProd = unidades;
        //Revisamos productos listados
        LoginSteps loginStepsProducto = new LoginSteps(driver);
        loginStepsProducto.ingresarAlProducto();
        loginStepsProducto.anadirUnidadesProducto(unidades);
        screenShot();

    }
    //examen
    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        LoginSteps loginStepsConfirmacion = new LoginSteps(driver);
        String confirmacion = "Producto añadido correctamente a su carrito de compra";
        loginStepsConfirmacion.revisarProducto(confirmacion);
        screenShot();
    }
    //examen
    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        LoginSteps loginStepsRevision = new LoginSteps(driver);
        loginStepsRevision.revisarCalculoProducto(unidProd);
        screenShot();
    }
    //examen
    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        LoginSteps loginStepsFinaliza = new LoginSteps(driver);
        loginStepsFinaliza.FinalizarCompra();
        screenShot();
    }
    //examen
    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        LoginSteps loginStepsCarrito = new LoginSteps(driver);
        loginStepsCarrito.validarTitulo();
        screenShot();
    }
    //examen
    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        LoginSteps loginStepsPrecioCarrito = new LoginSteps(driver);
        loginStepsPrecioCarrito.validarPrecio();
        screenShot();
    }
}
