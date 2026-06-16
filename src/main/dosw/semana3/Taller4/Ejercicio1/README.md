# Ejercicio 01 — Plataforma de Pagos Inteligentes

## Descripción del Problema

Una aplicación de e-commerce necesita soportar múltiples métodos de pago según el país del usuario. Colombia dispone de PSE, Nequi y Tarjeta de crédito; USA dispone de PayPal y Stripe. El sistema debe seleccionar automáticamente el proveedor correcto según el país y delegar el procesamiento al método elegido, sin que el flujo de compra cambie en absoluto.

---

## Solución Propuesta

Se combinan dos patrones para separar responsabilidades claramente:

- **Strategy** resuelve *cómo se ejecuta el pago*: cada método de pago es una clase independiente que implementa la misma interfaz `MetodoPago`. El `ProcesadorCompra` opera exclusivamente contra esa interfaz sin conocer el medio concreto.

- **Factory Method** resuelve *quién construye el método correcto*: `FabricaColombia` y `FabricaUsa` crean la instancia de `MetodoPago` adecuada según el tipo solicitado. El `SelectorFabrica` elige entre las fábricas según el país ingresado. Nunca se instancia un método de pago directamente desde el Main.

La interacción es: el usuario ingresa su país → `SelectorFabrica` entrega la fábrica correspondiente → la fábrica instancia el `MetodoPago` concreto → `ProcesadorCompra` ejecuta el pago usando esa estrategia.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `MetodoPago` — declara el contrato `ejecutarPago(double monto)`
- **Implementaciones concretas:** `PagoTarjeta`, `PagoPse`, `PagoNequi`, `PagoPaypal`, `PagoStripe`
- **Contexto:** `ProcesadorCompra` — recibe cualquier `MetodoPago` y finaliza la compra sin conocer la implementación

### Factory Method
- **Interfaz de fábrica:** `FabricaPagos` — declara `crear(String tipo)`
- **Fábricas concretas:** `FabricaColombia` (crea PSE, Nequi, Tarjeta), `FabricaUsa` (crea PayPal, Stripe)
- **Selector:** `SelectorFabrica` — elige la fábrica concreta según el país ingresado

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `MetodoPago` | Interfaz | Contrato del patrón Strategy |
| `PagoTarjeta` | Clase concreta | Estrategia de pago con tarjeta de crédito |
| `PagoPse` | Clase concreta | Estrategia de transferencia bancaria PSE |
| `PagoNequi` | Clase concreta | Estrategia de pago móvil Nequi |
| `PagoPaypal` | Clase concreta | Estrategia de pago internacional PayPal |
| `PagoStripe` | Clase concreta | Estrategia de cobro con Stripe |
| `FabricaPagos` | Interfaz | Contrato del patrón Factory Method |
| `FabricaColombia` | Fábrica concreta | Crea métodos de pago disponibles en Colombia |
| `FabricaUsa` | Fábrica concreta | Crea métodos de pago disponibles en USA |
| `SelectorFabrica` | Clase utilitaria | Selecciona la fábrica correcta según el país |
| `ProcesadorCompra` | Clase contexto | Ejecuta la compra usando la Strategy recibida |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 12 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Plataforma de Pagos Inteligentes ===
Ingrese su pais (colombia / usa): colombia
Metodos: pse, nequi, tarjeta
Elija metodo de pago: nequi
Monto a pagar: $80000
Procesando compra...
[Nequi] Pago movil de $80000.00 enviado.
Transaccion exitosa.
```
