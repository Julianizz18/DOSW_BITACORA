# Ejercicio 05 — Integración con Sistema de Impresión Legado

## Descripción del Problema

El sistema moderno de gestión de documentos trabaja con una interfaz `TrabajoImpresion` que expone operaciones claras: `imprimir(contenido, copias)`, `consultarColaEspera()` y `consultarEstado()`. Sin embargo, la impresora física disponible es un modelo antiguo de matriz de puntos que solo entiende comandos ESC/P de bajo nivel: `enviarComandoESC()`, `insertarEnCola(bytes, prioridad)` y `leerRegistroEstado()`. Además, inicializar correctamente el driver de la impresora requiere 8 pasos técnicos que los usuarios no deberían conocer.

---

## Solución Propuesta

Se aplican dos patrones con responsabilidades complementarias:

- **Adapter** resuelve la incompatibilidad entre las interfaces. `AdaptadorImpresora` implementa `TrabajoImpresion` y traduce cada llamada moderna al protocolo ESC/P: convierte el contenido String en bytes, mapea el número de copias a la prioridad de la cola, envía los comandos ESC de inicialización y flush, y traduce el estado interno `"ONLINE|LISTA|TONER:OK"` al formato moderno `"Disponible"`.

- **Facade** resuelve la complejidad de inicialización. `FachadaImpresion` expone solo dos métodos de alto nivel: `enviarDocumento(texto, copias)` y `verEstado()`. En su constructor ejecuta automáticamente los 8 pasos de configuración del driver (detección de puerto, carga del driver ESC/P, negociación de velocidad, encendido, calibración, etc.) y luego crea internamente el `AdaptadorImpresora`.

La interacción es: el usuario llama a `FachadaImpresion` → Facade inicializa el driver y delega al `AdaptadorImpresora` → el Adapter traduce al protocolo ESC/P → `ImpresoraLegado` ejecuta la impresión real.

---

## Patrones de Diseño Implementados

### Adapter
- **Interfaz objetivo:** `TrabajoImpresion` — interfaz moderna que el sistema espera
- **Adaptee:** `ImpresoraLegado` — impresora antigua con comandos ESC/P incompatibles
- **Adapter:** `AdaptadorImpresora` — implementa `TrabajoImpresion` traduciendo a comandos ESC/P

### Facade
- **Facade:** `FachadaImpresion` — oculta los 8 pasos de inicialización del driver y expone API simple

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `TrabajoImpresion` | Interfaz | Interfaz moderna objetivo del patrón Adapter |
| `ImpresoraLegado` | Clase legada | Impresora antigua con API ESC/P de bajo nivel |
| `AdaptadorImpresora` | Adapter | Implementa `TrabajoImpresion` traduciendo a comandos ESC/P |
| `FachadaImpresion` | Facade | Oculta los 8 pasos de inicialización y expone métodos simples |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 5 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Integracion con Sistema de Impresion Legado ===
Modelo de impresora (ej: Epson LX-300): Epson LX-300

Inicializando driver de impresion...
  [Driver] Paso 1: Detectando puerto LPT/USB...
  ...
  [Driver] Paso 8: Driver listo.

Estado    : Disponible
En cola   : 0 trabajo/s

Texto a imprimir (o 'salir'): Factura #001 - Total: $50.000
Numero de copias: 2
  [LEGADO:Epson LX-300] ESC/P CMD: ESC@
  [LEGADO:Epson LX-300] Spool #1001 insertado (prior:2, bytes:28)
  [LEGADO:Epson LX-300] Spool #1002 insertado (prior:1, bytes:28)
Resultado: IMPRIMIENDO
```
