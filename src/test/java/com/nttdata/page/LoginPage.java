package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    //examen:
    public static By InicioElemento = By.cssSelector("div.user-info");
    public static By usuarioInput = By.id("field-email");
    public static By contrasenaInput = By.id("field-password");
    public static By IniciarSesionButton = By.id("submit-login");
    public static By IniciarSesionContenedorMenu = By.cssSelector("div.user-info");
    public static By IniciarSesionTextoMenu = By.cssSelector("span.hidden-sm-down");
    public static By seleccionCategoria = By.cssSelector("li.category");
    //public static By seleccionCategoria = By.cssSelector("li.category");
    public static By seleccionSubcategoria = By.cssSelector("ul.category-sub-menu");
    public static By catInfoTitulo = By.cssSelector("a.dropdown-item");
    public static By seleccionasubCat = By.cssSelector("li");
    public static By ubicaProducto = By.cssSelector("div.product");
    public static By productosInfoTitulo = By.cssSelector("h2.product-title");
    public static By productosInfoPrecio = By.cssSelector("span.price");
    public static By agregarCarritoBoton = By.cssSelector("button.add-to-cart");
    public static By continuarComprandoBoton = By.cssSelector("button.close");
    public static By badgeCarrito = By.cssSelector("span.cart-products-count");
    public static By cantidadAgregar = By.cssSelector("button.bootstrap-touchspin-up");
    //public static By productoAgregado = By.cssSelector("h6.product-name");
    public static By productoAgregado = By.cssSelector("h4.modal-title");
    public static By subtotalAgregado = By.cssSelector("p.product-total");
    public static By subtotalDetalleAgregado = By.cssSelector("span.value");
    public static By botonesModalCompra = By.cssSelector("div.cart-content-btn");
    public static By botonFinalizarCompra = By.cssSelector("a.btn-primary");
    public static By tituloCarrito = By.cssSelector("h1.h1");
    public static By precioCarrito = By.cssSelector("span.price");
    public static By cantidadCarritoDiv = By.cssSelector("div.input-group ");
    public static By cantidadCarrito = By.cssSelector("input.js-cart-line-product-quantity");
    public static By precioCalculadoCarrito = By.cssSelector("span.product-price");


}
