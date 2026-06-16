# Ejercicio 04 — Plataforma de Videojuegos: Personajes

## Descripción del Problema

Un videojuego necesita crear unidades de combate con estadísticas numéricas configurables: puntos de vida (HP), ataque (ATK), defensa (DEF) y velocidad (VEL). Durante la partida, las unidades pueden activar modificadores temporales combinables que alteran matemáticamente sus estadísticas: Furia (+50% ATK, -20% DEF), Coraza (+80% DEF, +30% HP, -30% VEL) y Veneno (+15 ATK tóxico, -10% HP propia). El usuario debe poder ver cómo cambian los stats con cada modificador activo.

---

## Solución Propuesta

Se combinan dos patrones que actúan en momentos distintos de la partida:

- **Builder** resuelve la construcción de la unidad al inicio. `UnidadBuilder` permite al usuario definir numéricamente cada estadística (`vida(120).ataque(35).defensa(20)...`). Esto es más preciso y flexible que manejar nombres de atributos como strings. El método `construir()` retorna la `UnidadBase` completamente configurada.

- **Decorator** resuelve la modificación dinámica de estadísticas. Cada modificador extiende `ModificadorUnidad` y sobreescribe `getStats()` aplicando multiplicadores sobre los stats de la unidad interior. Al anidar decoradores (`ModFuria(ModCoraza(unidad))`), los cálculos se propagan en cadena: cada capa recibe los stats ya modificados por la capa anterior y aplica su propia transformación. Esto permite combinaciones arbitrarias sin explosión de subclases.

La interacción es: el usuario define los stats base con el Builder → activa modificadores uno a uno → el sistema muestra los stats recalculados después de cada modificador → al ejecutar el turno, el comportamiento refleja todas las capas activas.

---

## Patrones de Diseño Implementados

### Builder
- **Builder:** `UnidadBuilder` — configura `UnidadBase` con stats numéricos mediante método encadenado
- **Producto:** `UnidadBase` — implementación concreta de `Unidad` con stats fijos
- **Objeto de estadísticas:** `Stats` — encapsula HP, ATK, DEF y VEL como valores numéricos

### Decorator
- **Componente:** `Unidad` — interfaz con `getNombre()`, `getStats()` y `ejecutarTurno()`
- **Componente concreto:** `UnidadBase` — unidad base que los modificadores envuelven
- **Decorator abstracto:** `ModificadorUnidad` — mantiene referencia a la `Unidad` envuelta
- **Decoradores concretos:** `ModFuria` (ATK×1.5, DEF×0.8), `ModCoraza` (HP×1.3, DEF×1.8, VEL×0.7), `ModVeneno` (ATK+15, HP×0.9)

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `Stats` | Clase de datos | Encapsula HP, ATK, DEF, VEL con sus valores numéricos |
| `Unidad` | Interfaz | Componente base del patrón Decorator |
| `UnidadBase` | Clase concreta | Producto del Builder, componente concreto del Decorator |
| `UnidadBuilder` | Builder | Construye `UnidadBase` con stats numéricos configurables |
| `ModificadorUnidad` | Clase abstracta | Decorator base que envuelve cualquier `Unidad` |
| `ModFuria` | Decorator concreto | Aumenta ATK 50%, reduce DEF 20% |
| `ModCoraza` | Decorator concreto | Aumenta HP 30%, DEF 80%, reduce VEL 30% |
| `ModVeneno` | Decorator concreto | Añade 15 de ATK tóxico, reduce HP propia 10% |
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
=== Plataforma de Videojuegos: Personajes ===
Nombre del personaje: Thorin
Clases: Guerrero, Mago, Arquero, Asesino
Clase: Guerrero
Puntos de vida (ej: 120): 120
Ataque base (ej: 35): 35
Defensa base (ej: 15): 20
Velocidad (ej: 8): 6

Unidad creada:
Nombre : Thorin [Guerrero]
Stats  : HP:120 | ATK:35 | DEF:20 | VEL:6

Modificadores disponibles: furia, coraza, veneno
Activar modificador (o 'listo'): furia
  Stats actuales: HP:120 | ATK:52 | DEF:16 | VEL:6
Activar modificador (o 'listo'): coraza
  Stats actuales: HP:156 | ATK:52 | DEF:28 | VEL:4
```
