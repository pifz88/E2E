    Hallazgos Principales
El flujo de compra funciona correctamente cuando se ingresan datos válidos.

El sistema valida adecuadamente campos obligatorios en Checkout.

El login muestra mensajes de error consistentes ante credenciales inválidas.

El catálogo siempre presenta al menos un producto, lo que permite continuar con pruebas dependientes.

    Problemas Detectados
En Checkout, si falta un campo obligatorio, el sistema detiene el flujo pero no limpia los campos previos, lo que puede generar confusión en pruebas encadenadas.

El botón Continue no siempre muestra mensajes de error inmediatamente; en algunos navegadores se detectó un pequeño retraso.

El ícono del carrito no siempre refresca instantáneamente en algunos drivers (posible problema de sincronización).

    Decisiones Tomadas
Se agregaron esperas explícitas para asegurar que los mensajes de error aparezcan antes de validar.

Se decidió centralizar el login en el Background para evitar repetición de pasos.

Se implementó un tagging estratégico:

@Regression para ejecuciones completas

@Carrito, @Login, @Productos para ejecuciones modulares

@negative para pruebas de validación

Se mantuvo un Scenario Outline para pruebas de datos variables en login y checkout.