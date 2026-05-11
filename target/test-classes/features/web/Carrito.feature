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