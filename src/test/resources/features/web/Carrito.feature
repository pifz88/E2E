Feature: Carrito de compras en Saucedemo

    Background:
        Given estoy autenticado en la tienda

    @Carrito
    Scenario: Agregar un producto al carrito
        When agrego el primer producto al carrito
        Then el icono del carrito deberia mostrar 1 producto

    @Regression @Carrito
    Scenario: Eliminar un producto del carrito
        When agrego el primer producto al carrito
        And voy al carrito
        And elimino el producto del carrito
        Then el carrito deberia estar vacio

  @Regression @Compra
  Scenario Outline: Comprar un producto
    When agrego el primer producto al carrito
    And el icono del carrito deberia mostrar 1 producto
    And voy al carrito
    And voy al Checkout
    And ingreso el "<firstname>", el "<lastname>" y el "<postcode>"
    And presionar boton continue
    And presionar boton finish
    And validar compra de producto

    Examples:
      | firstname | lastname | postcode |
      | Pablo     | Figueroa | 4780000  |

  @negative @checkout
  Scenario Outline: Validaciones obligatorias en Checkout
    And agrego el primer producto al carrito
    And el icono del carrito deberia mostrar 1 producto
    And voy al carrito
    And voy al Checkout
    And ingreso el "<firstname>", el "<lastname>" y el "<postcode>"
    And presionar boton continue
    Then el sistema muestra el mensaje de validación "<mensajeEsperado>"

    Examples:
      | firstname | lastname | postcode | mensajeEsperado             |
      |           | Perez    | 28001    | Error: First Name is required  |
      | Juan      |          | 28001    | Error: Last Name is required   |
      | Juan      | Perez    |          | Error: Postal Code is required |


