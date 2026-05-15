🛒 Proyecto de Automatización – Saucedemo
Este proyecto contiene pruebas automatizadas en formato Gherkin (Cucumber) 
para validar funcionalidades críticas del sitio Saucedemo, incluyendo:

Inicio de sesión

Catálogo de productos

Carrito de compras

Flujo de compra

Validaciones negativas en Checkout

    Estructura del Proyecto
Código
/features
├── login.feature
├── carrito.feature
└── productos.feature
/steps
/drivers
/reports

🖥️ Requisitos de Entorno
🔧 Software necesario
Node.js 18+ o Java 11+ (según framework)

Cucumber (CLI o integrado)

Selenium WebDriver / Playwright / Cypress

Navegador Chrome o Edge

ChromeDriver / WebDriver Manager

    Dependencias típicas
Si usas Node + Cucumber + WebDriverIO:

bash
npm install @wdio/cli @wdio/local-runner @wdio/cucumber-framework @wdio/selenium-standalone-service
Si usas Java + Maven + Cucumber:

xml
<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-java</artifactId>
<version>7.14.0</version>
</dependency>

    Comandos de Ejecución
Ejecutar todas las pruebas
bash
npm test
o

bash
mvn <test
Ejecutar solo regresión
bash
npm test -- --tags "@Regression"
Ejecutar por funcionalidad
bash
npm test -- --tags "@Carrito"
npm test -- --tags "@Login"
npm test -- --tags "@Productos"
Ejecutar escenarios negativos
bash
npm test -- --tags "@negative"

    Rutas de Reportes
Dependiendo del framework, los reportes se generan en:

Código
/reports/html
/reports/cucumber
/reports/json
Ejemplos:

Cucumber HTML Report: /reports/cucumber-html/index.html

Allure Report: /reports/allure-results/

    Escenarios Cubiertos
1. Carrito de compras
   Agregar un producto al carrito

Eliminar un producto

Flujo completo de compra

Validaciones obligatorias en Checkout

2. Inicio de sesión
   Login exitoso

Login fallido con múltiples combinaciones

Logout exitoso

3. Catálogo de productos
   Validación de que exista al menos un producto