Feature: Catalogo de productos en Saucedemo

    Background:
        Given estoy autenticado en la tienda

    @Regression @Productos
    Scenario: Ver el catalogo de productos
        Then deberia ver al menos 1 producto en el catalogo