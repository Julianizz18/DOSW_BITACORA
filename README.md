# DOSW_BITACORA

Bitácora de Julián Tinjacá para el curso de Diseño y Operación de Sistemas de Software (DOSW).

Este repositorio reúne, semana a semana, los ejercicios de práctica realizados en clase y en talleres: desde el manejo de la Stream API de Java hasta la aplicación de los patrones de diseño GoF (creacionales, estructurales y de comportamiento) sobre distintos casos de estudio.

---

## Estructura del repositorio

```text
src/main/dosw/
├── semana1/
│   └── streams/          → Introducción a la API de Streams de Java
├── semana2/
│   └── pokemon/          → Streams avanzados + primer acercamiento a patrones de diseño
│       ├── Ejercicio1..20
│       └── Epatron1..12
└── semana3/
    └── Taller4/
        └── Ejercicio1..10
```

> Los ejercicios de semana3/Taller4 ya cuentan cada uno con su propio README (descripción del problema, solución propuesta, patrones implementados, estructura de clases y ejecución), así que aquí solo se indexan. El resto de la bitácora (semana 1 y semana 2) se describe completa en este mismo documento.

---

## Semana 1 — Streams (semana1/streams)

Cinco ejercicios introductorios a la API de Streams de Java (filter, map, sorted, collect, reduce, anyMatch) usando listas de números, palabras y record (usuarios, transacciones).

| Clase | Descripción |
|---|---|
| Ejercicio1 | Filtra de una lista de enteros los valores que son a la vez mayores a 10 y pares. |
| Ejercicio2 | Filtra palabras de longitud mayor a 4, las convierte a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan. |
| Ejercicio3 | Usa un record Usuario(id, nombre, edad, activo) para extraer los nombres de los usuarios activos. |
| Ejercicio4 | Reutiliza el record Usuario para filtrar usuarios activos y mayores de edad. |
| Ejercicio5 | Usa un record Transaction(id, amount, approved) para verificar con anyMatch si existen transacciones no aprobadas. |

---

## Semana 2 — Pokémon: Streams y Patrones (semana2/pokemon)

### Streams (Ejercicio1 a Ejercicio20)

20 ejercicios de dificultad creciente sobre dos modelos de apoyo: Pokemon (id, nombre, tipo, nivel, poderCombate, región, legendario) y Entrenador (id, nombre, medallas, equipo de Pokemon).

| Clase | Operación principal |
|---|---|
| Ejercicio1 | filter por tipo de elemento (criaturas de tipo Fuego). |
| Ejercicio2 | filter + map para transformar nombres a mayúsculas. |
| Ejercicio3 | reduce para sumar los niveles del equipo. |
| Ejercicio4 | filter sobre nivel y conteo de resultados. |
| Ejercicio5 | filter por nivel mayor a 80 y conteo con collect. |
| Ejercicio6 | distinct para eliminar capturas duplicadas. |
| Ejercicio7 | sorted alfabético de la pokédex. |
| Ejercicio8 | filter por bandera booleana (listos para evolucionar). |
| Ejercicio9 | sorted por Comparator.comparingDouble (poder de combate descendente). |
| Ejercicio10 | map para proyectar solo los nombres de la pokédex. |
| Ejercicio11 | mapToDouble/average para calcular el promedio de una métrica. |
| Ejercicio12 | Recorrido con forEach sobre la pokédex. |
| Ejercicio13 | groupingBy por tipo, agrupando nombres. |
| Ejercicio14 | groupingBy por región. |
| Ejercicio15 | Búsqueda del entrenador con más medallas (campeón de gimnasios). |
| Ejercicio16 | filter de entrenadores con más de 5 medallas. |
| Ejercicio17 | Cálculo del entrenador con mayor poder acumulado de equipo. |
| Ejercicio18 | sorted + limit para obtener el top 5 más fuerte. |
| Ejercicio19 | sorted con Comparator personalizado + limit para el top 3. |
| Ejercicio20 | Estadísticas combinadas: conteo por tipo y región, total de legendarios, nivel promedio y el Pokémon más fuerte. |

### Patrones de diseño (Epatron1 a Epatron12)

Cada carpeta EpatronN aísla un único patrón GoF aplicado a un mini-caso de uso distinto:

| Carpeta | Patrón | Caso de uso |
|---|---|---|
| Epatron1 | Factory Method | Procesador de pagos: cada subclase de ProcesadorPago fabrica su propio MetodoPago (tarjeta, PayPal, transferencia) sin que el flujo común lo conozca. |
| Epatron2 | Abstract Factory | Motor de videojuego: ConsolaFactory crea familias completas y compatibles de componentes (control, juego, interfaz) según la consola: PlayStation o Xbox. |
| Epatron3 | Builder | Fábrica de muñecos: FabricaMuneco (director) ejecuta siempre los mismos pasos de ensamblaje sobre un MunecoBuilder (de acción o clásico) intercambiable. |
| Epatron4 | Adapter | Estación de servicio: adapta cargadores eléctricos (cargar(kwh)) a la interfaz SurtidorGasolineria.abastecer(litros) que ya usan los vehículos de combustión. |
| Epatron5 | Bridge | Formas geométricas (círculo, cuadrado, triángulo) combinables con cualquier color (rojo, azul, verde) sin multiplicar clases. |
| Epatron6 | Composite | Bodega con productos individuales y cajas que pueden contener productos u otras cajas, calculando el precio total de forma recursiva. |
| Epatron7 | Decorator | Barco de guerra equipable con módulos combinables (blindaje, radar, misiles, antitorpedos) que modifican ataque y defensa apilándose dinámicamente. |
| Epatron8 | Chain of Responsibility | Control migratorio: la solicitud del viajero pasa por una cadena de validaciones (pasaporte/visa → antecedentes → motivo de viaje → aprobación). |
| Epatron9 | Command | Control de videojuego: cada botón (A, B, X, Y) ejecuta un Comando distinto (caminar, saltar, atacar, defenderse) sobre el personaje, sin conocer la acción concreta. |
| Epatron10 | Sin terminar | Carpeta con una única clase vacía (test.java); no llegó a implementarse el caso de uso ni el patrón. |
| Epatron11 | Strategy | Aplicación de navegación que calcula rutas (más rápida, más corta, escénica, transporte público) según la estrategia activa. |
| Epatron12 | Strategy | Ordenador de arreglos que intercambia algoritmos de ordenamiento (burbuja, selección, inserción) en tiempo de ejecución. |

---

## Semana 3 — Taller 4: Combinación de Patrones (semana3/Taller4)

Taller integrador de 10 ejercicios. A diferencia de la semana 2, aquí cada ejercicio combina dos patrones de diseño trabajando juntos sobre un caso de negocio completo. Cada uno ya tiene su propia descripción (problema, solución, clases y ejecución) en su respectivo README:

| Ejercicio | Caso de negocio | Patrones combinados |
|---|---|---|
| Ejercicio1 | Plataforma de pagos inteligente | Strategy + Factory Method |
| Ejercicio2 | Notificaciones multicanal | Observer + Builder |
| Ejercicio3 | Reportes empresariales (PDF/Excel/CSV) | Template Method + configuración por formato |
| Ejercicio4 | Personajes de videojuego | Builder + Decorator |
| Ejercicio5 | Integración con impresora legada | Adapter + Facade |
| Ejercicio6 | Monitoreo de servidores | Strategy + Observer |
| Ejercicio7 | Pipeline CI/CD de commits | Chain of Responsibility + State |
| Ejercicio8 | Reservas de hotel | Builder + Observer |
| Ejercicio9 | Aprobación de créditos bancarios | Strategy + Chain of Responsibility |
| Ejercicio10 | Editor de texto enriquecido | Command + Decorator |

---

## Tecnologías

- Lenguaje: Java (uso de record, Stream API, Comparator, Collectors avanzados)
- IDE: IntelliJ IDEA (carpeta `.idea/` incluida)

## Ejecución general

Cada ejercicio es autocontenido. Para los patrones de la semana 2 y el Taller 4:

```bash
cd src/main/dosw/<semana>/<carpeta-del-ejercicio>
javac *.java
java Main
```

Para los streams de la semana 1 y los Ejercicio1..20 de la semana 2, cada clase trae su propio main y se ejecuta individualmente:

```bash
cd src/main/dosw/semana1/streams
javac Ejercicio1.java
java main.dosw.semana1.streams.Ejercicio1
```
