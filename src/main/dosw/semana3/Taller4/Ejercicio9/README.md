# Ejercicio 09 — Sistema de Aprobación de Créditos Bancarios

## Descripción del Problema

Un banco necesita evaluar solicitudes de crédito usando diferentes modelos de scoring crediticio: Conservador (penaliza fuertemente la deuda actual y exige historial largo), Estándar (equilibrado) y Flexible (prioriza el ingreso actual). Una vez calculado el score, la solicitud debe pasar por una cadena de validaciones en secuencia: edad del solicitante, puntaje mínimo, capacidad de pago (ratio cuota/ingreso) y deuda máxima permitida. Si cualquier validación falla, la solicitud es rechazada sin continuar.

---

## Solución Propuesta

Se combinan dos patrones que representan las dos fases del proceso crediticio:

- **Strategy** resuelve el cálculo del score: *¿cuánto vale este cliente?* Cada `AlgoritmoScoring` implementa `calcularScore(SolicitudCredito)` con su propia fórmula matemática. `ScoringConservador` penaliza más la deuda; `ScoringFlexible` valora más el ingreso; `ScoringEstandar` balancea ambos. El administrador elige el algoritmo al configurar el sistema.

- **Chain of Responsibility** resuelve las validaciones posteriores al scoring: *¿puede recibir el crédito?* Los cuatro validadores se encadenan: si uno falla, la cadena se detiene inmediatamente. Cada validador recibe tanto la solicitud como el score calculado, por lo que puede aplicar reglas que dependan de ambos.

La interacción es: el administrador configura el algoritmo de scoring y los parámetros de validación → el usuario ingresa sus datos de solicitud → `SistemaCrediticio` calcula el score con la Strategy elegida → pasa la solicitud y el score por la cadena de validadores → emite el resultado.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `AlgoritmoScoring` — declara `calcularScore(SolicitudCredito)` y `getNombre()`
- **Estrategias concretas:** `ScoringConservador`, `ScoringEstandar`, `ScoringFlexible`
- **Datos de entrada:** `SolicitudCredito` — encapsula nombre, edad, ingreso, monto, plazo, deuda e historial

### Chain of Responsibility
- **Validator abstracto:** `ValidadorCredito` — define `validar(solicitud, score)` y el encadenamiento
- **Validators concretos:** `ValidadorEdad` (rango min-max configurable), `ValidadorScore` (puntaje mínimo configurable), `ValidadorCapacidadPago` (ratio cuota/ingreso máximo configurable), `ValidadorDeuda` (deuda máxima configurable)
- **Orquestador:** `SistemaCrediticio` — recibe Strategy y cadena, coordina la evaluación completa

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `SolicitudCredito` | Clase de datos | Encapsula todos los datos del solicitante y el crédito pedido |
| `AlgoritmoScoring` | Interfaz | Contrato del patrón Strategy |
| `ScoringConservador` | Estrategia concreta | Penaliza fuertemente deuda; exige historial largo |
| `ScoringEstandar` | Estrategia concreta | Balancea ingreso, deuda, historial y ratio de cuota |
| `ScoringFlexible` | Estrategia concreta | Prioriza el ingreso actual; penaliza menos la deuda |
| `ValidadorCredito` | Validator abstracto | Define el encadenamiento del Chain of Responsibility |
| `ValidadorEdad` | Validator concreto | Verifica que la edad esté en el rango permitido |
| `ValidadorScore` | Validator concreto | Verifica que el score supere el mínimo requerido |
| `ValidadorCapacidadPago` | Validator concreto | Verifica que la cuota no supere el ratio máximo del ingreso |
| `ValidadorDeuda` | Validator concreto | Verifica que la deuda actual no supere el máximo permitido |
| `SistemaCrediticio` | Orquestador | Coordina Strategy + Chain en la evaluación de la solicitud |
| `Main` | Clase principal | Configura el sistema y gestiona la interacción con el usuario |

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
=== Sistema de Aprobacion de Creditos ===
Algoritmos de scoring: conservador, estandar, flexible
Seleccione algoritmo: estandar
Score minimo requerido (ej: 600): 600
Edad minima / maxima (ej: 18 70): 18 70
Ratio maximo cuota/ingreso % (ej: 35): 35
Deuda maxima permitida: $5000000

Nombre del solicitante: Maria Lopez
Edad: 32  Ingreso: $3500000  Monto: $8000000  Plazo: 36 meses
Deuda actual: $1200000  Historial: 24 meses

Evaluando solicitud de: Maria Lopez
  Scoring [Estandar]: 1000 puntos
  [Edad]        32 anos -> OK
  [Score]       1000 pts (minimo: 600) -> OK
  [Capacidad]   Cuota/Ingreso=6.3% (max 35%) -> OK
  [Deuda]       $1200000 (max $5000000) -> OK

  Resultado: CREDITO APROBADO
```
