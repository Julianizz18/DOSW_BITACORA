# Ejercicio 07 — Pipeline CI/CD de Aprobación de Commits

## Descripción del Problema

Un equipo de desarrollo necesita que cada commit pase por un pipeline de integración continua antes de ser desplegado. El pipeline tiene etapas encadenadas: tests unitarios (con umbral de cobertura configurable), análisis de linter (con reglas configurables), escaneo de seguridad y despliegue en el ambiente elegido. Si cualquier etapa falla, el pipeline se detiene. Paralelamente, el commit tiene estados propios que evolucionan: PENDIENTE → EN_PIPELINE → DESPLEGADO o FALLIDO, según el resultado de las etapas.

---

## Solución Propuesta

Se combinan dos patrones que gestionan aspectos complementarios del proceso:

- **Chain of Responsibility** resuelve el enrutamiento del commit por las etapas del pipeline. Cada `EtapaPipeline` evalúa el commit y, si lo aprueba, lo pasa a la siguiente etapa. Si falla, detiene la cadena y marca el commit como fallido. La cadena se construye dinámicamente según la configuración del usuario.

- **State** resuelve la gestión de estados del commit sin condicionales dispersos. El `CommitJob` delega `aprobar()` y `fallar()` al objeto de estado actual. Cada estado sabe exactamente qué transiciones son válidas: un commit PENDIENTE puede entrar al pipeline, uno EN_PIPELINE puede ser aprobado o fallado, uno DESPLEGADO ya no puede fallar.

La interacción es: se crea el `CommitJob` en estado PENDIENTE → se llama `aprobar()` para entrar al pipeline → las etapas lo procesan en cadena → cada etapa puede llamar `aprobar()` o `fallar()` en el commit → el State gestiona la transición sin condicionales.

---

## Patrones de Diseño Implementados

### Chain of Responsibility
- **Etapa abstracta:** `EtapaPipeline` — define `ejecutar(CommitJob)`, `validar()` y gestiona el encadenamiento
- **Etapas concretas:** `EtapaTests` (verifica cobertura mínima), `EtapaLinter` (analiza estilo con reglas configurables), `EtapaSeguridad` (escanea dependencias en modo estricto o advertencia), `EtapaDespliegue` (despliega en el ambiente elegido)

### State
- **Interfaz de estado:** `EstadoPipeline` — declara `aprobar(CommitJob)`, `fallar(CommitJob, motivo)` y `getNombre()`
- **Estados concretos:** `EstadoPendiente`, `EstadoEnPipeline`, `EstadoDesplegado`, `EstadoFallido`
- **Contexto:** `CommitJob` — mantiene el estado actual y delega las transiciones; encapsula hash, autor y rama

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `EstadoPipeline` | Interfaz | Contrato del patrón State |
| `EstadoPendiente` | Estado concreto | El commit aún no ha entrado al pipeline |
| `EstadoEnPipeline` | Estado concreto | El commit está siendo procesado por las etapas |
| `EstadoDesplegado` | Estado concreto | El commit pasó todas las etapas y fue desplegado |
| `EstadoFallido` | Estado concreto | Una etapa falló; guarda el motivo del fallo |
| `CommitJob` | Contexto (State) | Mantiene estado actual y delega `aprobar/fallar`; guarda hash, autor, rama |
| `EtapaPipeline` | Etapa abstracta | Define el encadenamiento y flujo del Chain of Responsibility |
| `EtapaTests` | Etapa concreta | Valida cobertura de tests con umbral configurable |
| `EtapaLinter` | Etapa concreta | Analiza el estilo de código con reglas configurables |
| `EtapaSeguridad` | Etapa concreta | Escanea dependencias en modo estricto o de advertencia |
| `EtapaDespliegue` | Etapa concreta | Despliega el commit en el ambiente configurado |
| `Main` | Clase principal | Construye dinámicamente el pipeline y gestiona la interacción |

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
=== Pipeline CI/CD de Aprobacion de Commits ===
Hash del commit: a1b2c3d
Autor: Juan Perez
Rama: develop
Cobertura minima de tests %: 80
Reglas de linter: google-style
Escaneo estricto? (s/n): s
Ambiente: staging

-- Ejecutando pipeline --
  [Estado] Commit entra al pipeline CI/CD.
  [Tests(min=80%)] PASS
  [Linter(google-style)] PASS
  [SecurityScan] PASS
  [Deploy] Desplegando a1b2c3d en ambiente: staging
  [Estado] Todas las etapas pasaron -> DESPLEGADO.

Commit a1b2c3d | Estado: DESPLEGADO
```
