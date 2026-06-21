# DOSW_BITACORA

Bitácora de **Julián Tinjacá** para el curso de **Diseño y Operación de Sistemas de Software (DOSW)**.

Este repositorio reúne, semana a semana, los ejercicios de práctica realizados en clase y en talleres: desde el manejo de la **Stream API** de Java hasta la aplicación de los **patrones de diseño GoF** (creacionales, estructurales y de comportamiento) sobre distintos casos de estudio.

---

## Estructura del repositorio

```
src/main/dosw/
├── semana1/
│   └── streams/          → Introducción a la API de Streams de Java
├── semana2/
│   └── pokemon/           → Streams avanzados + primer acercamiento a patrones de diseño
│       ├── Ejercicio1..20    (streams con tema Pokémon)
│       └── Epatron1..12      (un patrón de diseño por carpeta)
└── semana3/
    └── Taller4/            → Taller integrador: 10 ejercicios, cada uno combina
        └── Ejercicio1..10    dos patrones de diseño sobre un caso de negocio real
```

Cada carpeta de ejercicio es independiente y contiene sus propias clases Java y, cuando aplica, su propio `Main.java` ejecutable.

---

## Semana 1 — Streams (`semana1/streams`)

Cinco ejercicios introductorios a la API de Streams de Java (`filter`, `map`, `sorted`, `collect`, `anyMatch`, etc.) usando listas de números, palabras y `records` (usuarios, transacciones).

📄 Ver [`semana1/streams/README.md`](src/main/dosw/semana1/streams/README.md)

---

## Semana 2 — Pokémon: Streams y Patrones (`semana2/pokemon`)

Dos bloques de práctica bajo la temática Pokémon:

- **`Ejercicio1` a `Ejercicio20`**: 20 ejercicios de Stream API de dificultad creciente (filtrado, agrupamiento con `groupingBy`, reducción, ordenamiento por comparadores, estadísticas) aplicados sobre una Pokédex y un listado de entrenadores.
  📄 Ver [`semana2/pokemon/README.md`](src/main/dosw/semana2/pokemon/README.md)

- **`Epatron1` a `Epatron12`**: doce mini-ejercicios, cada uno dedicado a implementar **un único patrón de diseño GoF** de forma aislada (Strategy, Abstract Factory, Builder, Adapter, Bridge, Composite, Decorator, Chain of Responsibility, Command, etc.). Cada carpeta tiene su propio README explicando el patrón y el caso de uso.

| Carpeta | Patrón |
|---|---|
| [Epatron1](src/main/dosw/semana2/pokemon/Epatron1/README.md) | Factory Method |
| [Epatron2](src/main/dosw/semana2/pokemon/Epatron2/README.md) | Abstract Factory |
| [Epatron3](src/main/dosw/semana2/pokemon/Epatron3/README.md) | Builder |
| [Epatron4](src/main/dosw/semana2/pokemon/Epatron4/README.md) | Adapter |
| [Epatron5](src/main/dosw/semana2/pokemon/Epatron5/README.md) | Bridge |
| [Epatron6](src/main/dosw/semana2/pokemon/Epatron6/README.md) | Composite |
| [Epatron7](src/main/dosw/semana2/pokemon/Epatron7/README.md) | Decorator |
| [Epatron8](src/main/dosw/semana2/pokemon/Epatron8/README.md) | Chain of Responsibility |
| [Epatron9](src/main/dosw/semana2/pokemon/Epatron9/README.md) | Command |
| [Epatron10](src/main/dosw/semana2/pokemon/Epatron10/README.md) | (pendiente / sin implementar) |
| [Epatron11](src/main/dosw/semana2/pokemon/Epatron11/README.md) | Strategy |
| [Epatron12](src/main/dosw/semana2/pokemon/Epatron12/README.md) | Strategy |

---

## Semana 3 — Taller 4: Combinación de Patrones (`semana3/Taller4`)

Taller integrador de 10 ejercicios. A diferencia de la semana 2, aquí **cada ejercicio combina dos patrones de diseño** trabajando juntos sobre un caso de negocio completo (pagos, notificaciones, reportes, videojuegos, sistemas legados, monitoreo, CI/CD, hotelería, créditos bancarios, editor de texto).

Cada ejercicio ya cuenta con su propio README detallado (descripción del problema, solución propuesta, patrones implementados, estructura de clases y modo de ejecución):

| Ejercicio | Caso de negocio | Patrones combinados |
|---|---|---|
| [Ejercicio1](src/main/dosw/semana3/Taller4/Ejercicio1/README.md) | Plataforma de pagos inteligente | Strategy + Factory Method |
| [Ejercicio2](src/main/dosw/semana3/Taller4/Ejercicio2/README.md) | Notificaciones multicanal | Observer + Builder |
| [Ejercicio3](src/main/dosw/semana3/Taller4/Ejercicio3/README.md) | Reportes empresariales (PDF/Excel/CSV) | Template Method + configuración por formato |
| [Ejercicio4](src/main/dosw/semana3/Taller4/Ejercicio4/README.md) | Personajes de videojuego | Builder + Decorator |
| [Ejercicio5](src/main/dosw/semana3/Taller4/Ejercicio5/README.md) | Integración con impresora legada | Adapter + Facade |
| [Ejercicio6](src/main/dosw/semana3/Taller4/Ejercicio6/README.md) | Monitoreo de servidores | Strategy + Observer |
| [Ejercicio7](src/main/dosw/semana3/Taller4/Ejercicio7/README.md) | Pipeline CI/CD de commits | Chain of Responsibility + State |
| [Ejercicio8](src/main/dosw/semana3/Taller4/Ejercicio8/README.md) | Reservas de hotel | Builder + Observer |
| [Ejercicio9](src/main/dosw/semana3/Taller4/Ejercicio9/README.md) | Aprobación de créditos bancarios | Strategy + Chain of Responsibility |
| [Ejercicio10](src/main/dosw/semana3/Taller4/Ejercicio10/README.md) | Editor de texto enriquecido | Command + Decorator |

---

## Tecnologías

- **Lenguaje:** Java (uso de `record`, Stream API, `Comparator`, Collectors avanzados)
- **IDE:** IntelliJ IDEA (carpeta `.idea/` incluida)

## Ejecución general

Cada ejercicio es autocontenido. Para ejecutar cualquiera de ellos:

```bash
cd src/main/dosw/<semana>/<carpeta-del-ejercicio>
javac *.java
java Main
```

(En la semana 1 y en los `Ejercicio1..20` de la semana 2, cada clase es ejecutable por sí misma, ya que cada una trae su propio `main`.)
