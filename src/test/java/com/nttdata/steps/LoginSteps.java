package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.nttdata.core.DriverManager.screenShot;
import java.time.Duration;
import java.util.List;


public class LoginSteps {

    private WebDriver driver;

    //constructor
//    public LoginSteps(WebDriver driver){
//        this.driver = driver;
//    }
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }


    public void validoSesion() {
        //Bajo la logica de que el texto Iniciar sesión cambia al nombre del usuario cuando
        // se logra iniciar sesion
        WebElement loginElement = driver.findElement(LoginPage.IniciarSesionContenedorMenu);
        String textoInicio = loginElement.findElement(LoginPage.IniciarSesionTextoMenu).getText();

        if(textoInicio.equals("Iniciar sesión")){
            System.out.println("No se logró iniciar sesión");
        }
        Assertions.assertNotEquals(textoInicio, "Iniciar sesión");
    }

    public void ingresarUsuario(String usuario) {
        //Ingreso al elemento
        WebElement loginElement = driver.findElement(LoginPage.InicioElemento);
        loginElement.click();
        //Envio datos al elemento
        WebElement userInputElement = driver.findElement(LoginPage.usuarioInput);
        userInputElement.sendKeys(usuario);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
    }

    public void ingresarContrasena(String contrasena) {
        this.driver.findElement(LoginPage.contrasenaInput).sendKeys(contrasena);
    }

    public void iniciarSesion() {
        this.driver.findElement(LoginPage.IniciarSesionButton).click();
    }

    public void seleccionarCategoria(String categoria) {
        //this.driver.findElement(LoginPage.seleccionCategoria).click();
        String valorCat = this.driver.findElement(LoginPage.seleccionCategoria).getText();
        System.out.println("valorCat: "+valorCat);
        String categoriamayusculas = categoria.toUpperCase();
        Assertions.assertEquals(valorCat, categoriamayusculas);
        this.driver.findElement(LoginPage.seleccionCategoria).click();
    }

    public List<WebElement> validarInfoCategorias() {
        List<WebElement> categorias = this.driver.findElements(LoginPage.seleccionCategoria);
        return categorias;
    }

    public void seleccionarSubcategoria(String subcategoria) {
        //this.driver.findElement(LoginPage.seleccionSubcategoria);
        //Ubico categoría "Men"
        WebElement submenuElement = driver.findElement(LoginPage.seleccionSubcategoria);
        WebElement subCatElement =submenuElement.findElement(LoginPage.seleccionasubCat);
        System.out.println(subCatElement.getText());
        if(subCatElement.getText().equals(subcategoria)){
            subCatElement.click();
        }

    }

    public List<WebElement> validarInfoProductos() {
        List<WebElement> productos = this.driver.findElements(LoginPage.ubicaProducto);
        return productos;
    }

    public void ingresarAlProducto() {
        //Leo los productos listados
        LoginSteps loginSteps = new LoginSteps(driver);
        List<WebElement> prods = loginSteps.validarInfoProductos();
        int contador = 0;

        for (WebElement product : prods) {
            //Obtengo sus titulos y precio
            WebElement nombreActual = product.findElement(LoginPage.productosInfoTitulo);
            String nombreProd = nombreActual.getText();
            WebElement precioActual = product.findElement(LoginPage.productosInfoPrecio);
            String precioActualProd = precioActual.getText();

//            //Me quedo con los valores numéricos
//            String precioLimpio = precioActualProd.replaceAll("[^0-9,]", "");
//            precioLimpio = precioLimpio.replace(',', '.');
//            System.out.println("precioLimpio: "+precioLimpio);

            contador++;
            System.out.println("Nombre del producto " + contador + " : " + nombreProd + " - " + precioActualProd);
        }

        //Ahora añadimos 2 veces al carrito
        //Primero ingresamos al producto
        for (WebElement product : prods) {
            //titulop = product.findElement(LoginPage.productosInfoTitulo).getText();
            product.findElement(LoginPage.productosInfoTitulo).click();
            break;
        }

    }

    public void anadirUnidadesProducto(int unidades) {
        //Por si se desea conocer si hay productos en carrito
        String valorBadge = "";
        valorBadge = this.driver.findElement(LoginPage.badgeCarrito).getText();
        //System.out.println(valorBadge);

        //Agregamos 2 unidades
        for (int i = 1; i < unidades; i++) {
            this.driver.findElement(LoginPage.cantidadAgregar).click();
        }

        //Hacemos clic en boton Añadir al carrito
        //this.driver.findElement(LoginPage.agregarCarritoBoton).click();
        WebElement botonElement = driver.findElement(LoginPage.agregarCarritoBoton);
        botonElement.click();

    }

    public void revisarProducto(String confirmacion) {
        WebElement productoElement = driver.findElement(LoginPage.productoAgregado);
        productoElement.getText();

    }

    public void revisarCalculoProducto(int unidProd) {
        //Obtengo el subtotal en pantalla
        WebElement subtotalElement = driver.findElement(LoginPage.subtotalAgregado);
        String valorsubtotal = subtotalElement.findElement(LoginPage.subtotalDetalleAgregado).getText();
        System.out.println(valorsubtotal);
        String subTotLimpio = valorsubtotal.replaceAll("[^0-9,]", "");
        //System.out.println(subTotLimpio);

        subTotLimpio = subTotLimpio.replace(',', '.');
        double valorSubtotalLimpio =  Double.parseDouble(subTotLimpio);
        //System.out.println(unidProd);

        //Valido si el calculo esperado es igual al mostrado
        if (unidProd*19.12 == Double.parseDouble(subTotLimpio)){
            System.out.println("Se calculo correctamente el subtotal: "+valorSubtotalLimpio);
        }
        Assertions.assertEquals(unidProd*19.12, Double.parseDouble(subTotLimpio));
    }

    public void FinalizarCompra() {
        WebElement botonesElement = driver.findElement(LoginPage.botonesModalCompra);
        botonesElement.findElement(LoginPage.botonFinalizarCompra).click();
    }

    public void validarTitulo() {
        //Obtengo el titulo del carrito
        WebElement tituloElement = driver.findElement(LoginPage.tituloCarrito);
        String titulo = tituloElement.getText();
        String title = "CARRITO";

        if(titulo.equals(title)){
            System.out.println("El titulo coincide");
        }
        Assertions.assertEquals(titulo, title);
    }

    public void validarPrecio() {
        //Obtengo el precio del producto en el carrito
        WebElement precioElement = driver.findElement(LoginPage.precioCarrito);
        String precio = precioElement.getText();
        String precioLimpio = precio.replaceAll("[^0-9,]", "");
        precioLimpio = precioLimpio.replace(',', '.');
        double valorSubtotalCarrito =  Double.parseDouble(precioLimpio);
        //System.out.println(valorSubtotalCarrito);

        //Obtengo la unidad del producto en el carrito
        WebElement cantidadElement = driver.findElement(LoginPage.cantidadCarritoDiv);
        String cantidadCarrito = cantidadElement.findElement(LoginPage.cantidadCarrito).getAttribute("value");
        //System.out.println("cantidadCarrito:"+cantidadCarrito);

        //Obtengo el precio que el carrito ha calculado
        WebElement precioCalculadoElement = driver.findElement(LoginPage.precioCalculadoCarrito);
        String precioCalculado = precioCalculadoElement.getText();
        String precioCalculadoLimpio = precioCalculado.replaceAll("[^0-9,]", "");
        precioCalculadoLimpio = precioCalculadoLimpio.replace(',', '.');
        double valorSubtotalCalculadoCarrito =  Double.parseDouble(precioCalculadoLimpio);
        //System.out.println(valorSubtotalCalculadoCarrito);

        //Valido que los calculos sean correctos
        double calculoEnCarrito = valorSubtotalCarrito*Integer.parseInt(cantidadCarrito);
        if(calculoEnCarrito == valorSubtotalCalculadoCarrito){
            System.out.println("El precio calculado coincide");
        }
        Assertions.assertEquals(calculoEnCarrito, valorSubtotalCalculadoCarrito);

    }


}
