# Ejercicio 02 — Sistema de Notificaciones Multicanal

## Descripción del Problema

Cuando un pedido cambia de estado, el sistema debe notificar automáticamente a todos los canales activos del usuario: correo electrónico, SMS y push. No todos los usuarios tienen los mismos canales activos, y cada canal tiene su propia lógica para construir y formatear el mensaje (HTML para email, texto plano para SMS, JSON para push).

---

## Solución Propuesta

Se combinan dos patrones para desacoplar completamente el emisor, la construcción del mensaje y su entrega:

- **Observer** desacopla el pedido de los canales. El `Pedido` es el Subject y notifica cambios de estado a todos los `ObservadorNotificacion` registrados. Agregar un canal nuevo no requiere modificar el `Pedido`.

- **Factory Method** desacopla la construcción del mensaje. Cada notificador posee su propio `ConstructorMensaje` que sabe cómo formatear el contenido para su canal. La lógica de formateo queda aislada: `ConstructorEmail` genera HTML, `ConstructorSms` genera texto plano truncado a 160 caracteres, `ConstructorPush` genera JSON.

La interacción es: el `Pedido` cambia de estado → crea un `EventoPedido` → notifica a cada `ObservadorNotificacion` registrado → cada notificador llama a su `ConstructorMensaje` para obtener el texto formateado y lo envía.

---

## Patrones de Diseño Implementados

### Observer
- **Subject:** `Pedido` — mantiene la lista de observadores y notifica cambios de estado
- **Interfaz Observer:** `ObservadorNotificacion` — declara `actualizar(EventoPedido)`
- **Observadores concretos:** `NotificadorEmail`, `NotificadorSms`, `NotificadorPush`
- **Evento:** `EventoPedido` — encapsula el ID del pedido y el estado nuevo

### Factory Method
- **Interfaz de fábrica:** `ConstructorMensaje` — declara `construir(EventoPedido)`
- **Fábricas concretas:** `ConstructorEmail` (HTML), `ConstructorSms` (texto ≤160 chars), `ConstructorPush` (JSON)

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `EventoPedido` | Clase de datos | Encapsula ID y estado del pedido para el evento |
| `ConstructorMensaje` | Interfaz | Contrato Factory Method para construir mensajes |
| `ConstructorEmail` | Fábrica concreta | Construye mensajes en formato HTML |
| `ConstructorSms` | Fábrica concreta | Construye mensajes de texto plano ≤160 caracteres |
| `ConstructorPush` | Fábrica concreta | Construye payload JSON para notificación push |
| `ObservadorNotificacion` | Interfaz | Contrato del patrón Observer |
| `NotificadorEmail` | Observer concreto | Usa `ConstructorEmail` y simula envío por correo |
| `NotificadorSms` | Observer concreto | Usa `ConstructorSms` y simula envío por SMS |
| `NotificadorPush` | Observer concreto | Usa `ConstructorPush` y simula envío push |
| `Pedido` | Subject | Mantiene observadores y notifica al cambiar de estado |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 11 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Notificaciones Multicanal ===
ID del pedido: PED-55
Canales disponibles: email, sms, push
Canales activos (separados por coma): email,sms
Nuevo estado (o 'salir'): EN_CAMINO

-- Pedido PED-55 -> EN_CAMINO --
[EMAIL] <html><p>Tu pedido <b>PED-55</b> esta: <b>EN_CAMINO</b></p></html>
[SMS]   Pedido PED-55: EN_CAMINO
```
