# Ejercicio 08 — Sistema de Reservas de Hotel

## Descripción del Problema

Un hotel necesita que el recepcionista pueda armar una reserva configurando: tipo de habitación (Sencilla, Doble, Suite, Presidencial), número de habitación, cantidad de noches, servicios adicionales (desayuno, parqueadero) y peticiones especiales. El sistema calcula automáticamente el total según la tarifa por noche y los servicios incluidos. Al confirmar la reserva, los subsistemas del hotel deben ser notificados simultáneamente: recepción (prepara la llave), housekeeping (prepara el cuarto), restaurante (registra el desayuno) y parking (asigna el cupo).

---

## Solución Propuesta

Se combinan dos patrones que actúan en momentos distintos del ciclo de vida de la reserva:

- **Builder** resuelve la construcción de la reserva. `ReservaBuilder` permite configurar paso a paso todos los atributos con métodos encadenados. El total se calcula automáticamente en el momento del `construir()` usando la tarifa base de `TipoHabitacion` más los cargos adicionales. El objeto `Reserva` resultante es inmutable: ningún subsistema puede modificarlo accidentalmente.

- **Observer** resuelve la notificación desacoplada al confirmar. `Reserva` actúa como Subject: al llamar `confirmar()`, itera la lista de `ServicioHotel` registrados y cada uno recibe la reserva completa para ejecutar su propia lógica. El servicio de restaurante, por ejemplo, solo actúa si `tieneDesayuno()` es verdadero; el parking actúa solo si `tieneParking()` es verdadero.

La interacción es: el recepcionista configura la reserva con `ReservaBuilder` → `construir()` calcula el total y retorna la `Reserva` inmutable → se registran los servicios a notificar → `confirmar()` notifica a cada Observer.

---

## Patrones de Diseño Implementados

### Builder
- **Builder:** `ReservaBuilder` — configura la reserva paso a paso con métodos encadenados y valores por defecto
- **Producto:** `Reserva` — objeto inmutable; su constructor es package-private, solo accesible por el Builder
- **Enum de apoyo:** `TipoHabitacion` — define los tipos con su tarifa base por noche

### Observer
- **Subject:** `Reserva` — mantiene lista de servicios y los notifica al confirmar
- **Interfaz Observer:** `ServicioHotel` — declara `alConfirmarReserva(Reserva)`
- **Observers concretos:** `Recepcion`, `Housekeeping`, `Restaurante`, `Parking`

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `TipoHabitacion` | Enum | Define los tipos de habitación con su tarifa por noche |
| `ServicioHotel` | Interfaz | Contrato del patrón Observer |
| `Recepcion` | Observer concreto | Prepara la llave y registra peticiones especiales |
| `Housekeeping` | Observer concreto | Prepara y acondiciona la habitación |
| `Restaurante` | Observer concreto | Registra el desayuno diario si está incluido |
| `Parking` | Observer concreto | Asigna cupo de parqueadero si está incluido |
| `Reserva` | Producto + Subject | Objeto inmutable del Builder y Subject del Observer; calcula el total |
| `ReservaBuilder` | Builder | Configura la reserva con setters encadenados y calcula el total |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 9 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Reservas de Hotel ===
Codigo de reserva: RES-001
Nombre del huesped: Carlos Gomez
Tipos: SENCILLA, DOBLE, SUITE, PRESIDENCIAL
Tipo de habitacion: SUITE
Numero de habitacion: 305
Numero de noches: 3
Incluir desayuno? (s/n): s
Incluir parqueadero? (s/n): s
Peticion especial: Cuna adicional

Resumen: RES-001 | Carlos Gomez | SUITE | Hab:305 | 3 noche/s | Total: $1170000
Servicios a notificar: recepcion,housekeeping,restaurante,parking

>> Confirmando reserva RES-001...
  [Recepcion]    Preparando llave hab.305 para Carlos Gomez (3 noche/s)
                 Peticion especial: Cuna adicional
  [Housekeeping] Preparando habitacion 305 tipo SUITE
  [Restaurante]  Registrando desayuno diario para: Carlos Gomez | Dias: 3
  [Parking]      Asignando cupo de parqueadero por 3 dia/s
>> Reserva confirmada. Total a pagar: $1170000
```
