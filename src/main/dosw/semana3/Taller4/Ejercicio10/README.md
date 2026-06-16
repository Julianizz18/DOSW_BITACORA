# Ejercicio 10 — Editor de Texto Enriquecido

## Descripción del Problema

Una aplicación de edición de texto permite aplicar transformaciones acumulativas sobre un texto: convertir a mayúsculas, censurar palabras específicas (reemplazándolas por asteriscos), numerar las líneas y/o invertir el texto completo. Las transformaciones pueden apilarse en cualquier orden y el texto base nunca debe modificarse. Adicionalmente, cada transformación debe poder deshacerse individualmente y rehacerse si el usuario cambia de opinión.

---

## Solución Propuesta

Se combinan dos patrones que se complementan a la perfección:

- **Decorator** resuelve la aplicación acumulativa de transformaciones. Cada transformador extiende `TransformadorTexto` y sobreescribe `obtenerTexto()` aplicando su lógica sobre el resultado de la capa interior. `TransfCensurar`, por ejemplo, recibe el texto ya procesado por los decoradores internos y aplica sobre él el reemplazo de palabras. Apilar decoradores encadena las transformaciones sin modificar el `TextoBase`.

- **Command** resuelve el historial de operaciones y el undo/redo. Cada transformación se encapsula en un objeto `ComandoTransformacion` con `ejecutar()` y `deshacer()`. Antes de ejecutar, el comando guarda el `TextoEditable` previo en `ContextoTexto`. El `EditorTexto` mantiene dos pilas (`historial` y `pilaRehace`) para soportar undo/redo irrestricto. El undo simplemente restaura la referencia anterior al decorador.

La interacción es: el usuario elige una transformación → el `Comando` guarda el estado actual y envuelve el texto con el `Decorator` correspondiente → el comando se apila en el historial → al deshacer, el `Comando` restaura el estado previo eliminando la capa.

---

## Patrones de Diseño Implementados

### Decorator
- **Componente:** `TextoEditable` — interfaz con `obtenerTexto()` y `getDescripcion()`
- **Componente concreto:** `TextoBase` — texto original, nunca modificado
- **Decorator abstracto:** `TransformadorTexto` — mantiene referencia al `TextoEditable` envuelto
- **Decoradores concretos:** `TransfMayusculas` (convierte a MAYÚSCULAS), `TransfCensurar` (reemplaza una palabra por asteriscos), `TransfNumerarLineas` (añade número de línea al inicio), `TransfInvertir` (invierte el texto completo)

### Command
- **Interfaz:** `ComandoTransformacion` — declara `ejecutar()`, `deshacer()` y `getNombre()`
- **Comandos concretos:** `CmdMayusculas`, `CmdCensurar` (solicita la palabra a censurar), `CmdNumerarLineas`, `CmdInvertir`
- **Contexto compartido:** `ContextoTexto` — mantiene referencia mutable al `TextoEditable` actual
- **Invocador:** `EditorTexto` — gestiona `historial` y `pilaRehace` para undo/redo

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `TextoEditable` | Interfaz | Componente base del patrón Decorator |
| `TextoBase` | Clase concreta | Texto original inmutable que los decoradores envuelven |
| `TransformadorTexto` | Clase abstracta | Decorator base; mantiene referencia al `TextoEditable` interior |
| `TransfMayusculas` | Decorator concreto | Convierte todo el texto a mayúsculas |
| `TransfCensurar` | Decorator concreto | Reemplaza una palabra específica por asteriscos |
| `TransfNumerarLineas` | Decorator concreto | Antepone número de línea a cada línea del texto |
| `TransfInvertir` | Decorator concreto | Invierte el texto carácter a carácter |
| `ComandoTransformacion` | Interfaz | Contrato del patrón Command con `ejecutar` y `deshacer` |
| `ContextoTexto` | Clase de contexto | Mantiene referencia mutable al `TextoEditable` actual |
| `CmdMayusculas` | Command concreto | Aplica/deshace la transformación a mayúsculas |
| `CmdCensurar` | Command concreto | Aplica/deshace la censura de una palabra; guarda la palabra censurada |
| `CmdNumerarLineas` | Command concreto | Aplica/deshace el numerado de líneas |
| `CmdInvertir` | Command concreto | Aplica/deshace la inversión del texto |
| `EditorTexto` | Invocador | Gestiona las pilas `historial` y `pilaRehace` para undo/redo |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 15 clases/interfaces**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Editor de Texto Enriquecido ===
Ingrese el texto a editar: Hola mundo desde Colombia

Comandos: aplicar, deshacer, rehacer, ver, salir
Transformaciones: mayusculas, censurar, numerarlineas, invertir

Comando: aplicar
  Transformacion: mayusculas
  [+] Mayusculas aplicado.
  Pipeline : [Original] -> [MAYUSCULAS]
  Resultado: HOLA MUNDO DESDE COLOMBIA

Comando: aplicar
  Transformacion: censurar
  Palabra a censurar: COLOMBIA
  [+] Censurado 'COLOMBIA'.
  Pipeline : [Original] -> [MAYUSCULAS] -> [Censurado:'COLOMBIA']
  Resultado: HOLA MUNDO DESDE ********

Comando: deshacer
  [-] Censura 'COLOMBIA' revertida.
  Pipeline : [Original] -> [MAYUSCULAS]
  Resultado: HOLA MUNDO DESDE COLOMBIA
```
