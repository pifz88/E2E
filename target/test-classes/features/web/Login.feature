Feature: Inicio de sesion en Saucedemo

    Background:
        Given abro el navegador en la pagina de login

    @Loginp
    Scenario: Login exitoso con credenciales validas
        When ingreso el usuario "standard_user" y contrasena "secret_sauce"
        And hago clic en Ingresar
        Then deberia ver el catalogo de productos

    @Regression @Login
    Scenario Outline: Login fallido con credenciales invalidas
        When ingreso el usuario "<usuario>" y contrasena "<contrasena>"
        And hago clic en Ingresar
        Then deberia ver el mensaje de error "<mensaje>"

        Examples:
            | usuario       | contrasena   | mensaje                                                                   |
            | usuario_malo  | secret_sauce | Epic sadface: Username and password do not match any user in this service |
            | standard_user | pass_malo    | Epic sadface: Username and password do not match any user in this service |
            |               | secret_sauce | Epic sadface: Username is required                                        |
            | standard_user |              | Epic sadface: Password is required                                        |

    @Login
    Scenario: Logout exitoso
        When ingreso el usuario "standard_user" y contrasena "secret_sauce"
        And hago clic en Ingresar
        And cierro sesion desde el menu
        Then deberia ver la pagina de login