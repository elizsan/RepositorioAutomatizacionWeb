#language: es
@qalabProducto
Característica: : Product - Store
  @testEscenario1Qalab
  Esquema del escenario: Validación del precio de un producto


  Dado estoy en la página de la tienda
  Y me logueo con mi usuario "<usuario>" y clave "<contrasena>"
  Cuando navego a la categoria "<categoria>" y subcategoria "Men"
  Y agrego 2 unidades del primer producto al carrito
  Entonces valido en el popup la confirmación del producto agregado
  Y valido en el popup que el monto total sea calculado correctamente
  Cuando finalizo la compra
  Entonces valido el titulo de la pagina del carrito
  Y vuelvo a validar el calculo de precios en el carrito

  Ejemplos:
    | usuario  | contrasena | categoria   |
    | elizsan2020@gmail.com | Hubidaisy2027 | Clothes  |
    | elizsan2027@gmail.com | Hubirose2027 | Clothes  |
    | elizsan2020@gmail.com | Hubidaisy2027 | Autos  |
