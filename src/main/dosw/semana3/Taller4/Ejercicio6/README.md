# Ejercicio 06 — Motor de Monitoreo de Servidores

## Descripción del Problema

Un equipo de operaciones necesita monitorear servidores evaluando sus métricas de CPU, memoria y disco. El administrador puede elegir entre diferentes algoritmos de detección de problemas: por umbrales individuales, por promedio global o por criterio combinado (ambos). Cada vez que llega una nueva métrica o se cambia el algoritmo activo, todos los monitores registrados deben actualizarse automáticamente: la consola, el servicio de email y el sistema de log.

---

## Solución Propuesta

Se combinan dos patrones que cubren dimensiones ortogonales del problema:

- **Strategy** resuelve el algoritmo de evaluación de métricas. `AlgoritmoDeteccion` define el contrato `evaluar(MetricaServidor)`. El administrador puede cambiar el algoritmo en tiempo de ejecución sin modificar ni los monitores ni el panel. Cada algoritmo tiene su propia lógica: `DeteccionUmbral` verifica cada métrica individualmente contra umbrales configurables, `DeteccionPromedio` calcula el promedio de las tres métricas, `DeteccionCombinada` aplica ambos criterios a la vez.

- **Observer** resuelve la propagación automática de eventos. `PanelMonitoreo` es el Subject: cuando recibe una métrica o cuando se cambia el algoritmo activo, notifica a todos los `MonitorObservador` registrados. Cada monitor reacciona de forma independiente. `MonitorEmail` solo envía correo si el diagnóstico detecta un problema; `MonitorLog` registra siempre; `MonitorConsola` muestra el resultado en pantalla.

La interacción es: el usuario cambia el algoritmo o ingresa métricas → `PanelMonitoreo` notifica a todos los monitores → cada monitor llama `algoritmo.evaluar(metrica)` y reacciona según su lógica propia.

---

## Patrones de Diseño Implementados

### Strategy
- **Interfaz:** `AlgoritmoDeteccion` — declara `evaluar(MetricaServidor)` y `getNombre()`
- **Estrategias concretas:** `DeteccionUmbral` (umbrales individuales por métrica), `DeteccionPromedio` (umbral sobre el promedio de las tres), `DeteccionCombinada` (ambos criterios simultáneamente)
- **Datos de entrada:** `MetricaServidor` — encapsula nombre del servidor, CPU%, memoria% y disco%

### Observer
- **Subject:** `PanelMonitoreo` — mantiene algoritmo activo y lista de monitores; notifica al recibir métricas o cambiar algoritmo
- **Interfaz Observer:** `MonitorObservador` — declara `alCambiarAlgoritmo(metrica, algoritmo)`
- **Observadores concretos:** `MonitorConsola`, `MonitorEmail` (filtra por severidad), `MonitorLog` (registra siempre)

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `MetricaServidor` | Clase de datos | Encapsula nombre del servidor y sus tres métricas porcentuales |
| `AlgoritmoDeteccion` | Interfaz | Contrato del patrón Strategy |
| `DeteccionUmbral` | Estrategia concreta | Evalúa cada métrica contra umbrales individuales configurables |
| `DeteccionPromedio` | Estrategia concreta | Evalúa el promedio de las tres métricas contra un umbral global |
| `DeteccionCombinada` | Estrategia concreta | Combina criterio individual y de promedio simultáneamente |
| `MonitorObservador` | Interfaz | Contrato del patrón Observer |
| `MonitorConsola` | Observer concreto | Muestra servidor, algoritmo y diagnóstico en consola |
| `MonitorEmail` | Observer concreto | Envía alerta por email solo si hay problema detectado |
| `MonitorLog` | Observer concreto | Registra siempre las métricas y el diagnóstico en un archivo |
| `PanelMonitoreo` | Subject | Mantiene el algoritmo activo y notifica a los monitores |
| `Main` | Clase principal | Punto de entrada, configura monitores e interactúa con el usuario |

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
=== Motor de Monitoreo de Servidores ===
Email del administrador para alertas: admin@empresa.com
Nombre del archivo de log: servidor.log

Opcion: 2 (Cambiar algoritmo)
Algoritmo: umbral
  Umbral CPU%: 80
  Umbral Mem%: 75
  Umbral Disco%: 90

Opcion: 1 (Ingresar metricas)
Nombre del servidor: web-01
CPU%: 85.0  Memoria%: 60.0  Disco%: 92.0

[Panel] Nueva metrica recibida de web-01
  [CONSOLA]  web-01 | Diagnostico: ALERTA: CPU CRITICA(85.0%) DISCO CRITICO(92.0%)
  [EMAIL -> admin@empresa.com] INCIDENTE en web-01: ALERTA: ...
  [LOG:servidor.log] web-01 cpu=85.0% mem=60.0% disco=92.0% -> ALERTA: ...
```
