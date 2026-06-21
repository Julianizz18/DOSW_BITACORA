# Bitácora DOSW — Julián Tinjacá

Repositorio de práctica para el curso de Diseño y Operación de Sistemas de Software. Aquí va quedando el registro de cada semana: primero el repaso de la Stream API de Java, después la implementación aislada de los patrones de diseño GoF, y por último un taller donde esos patrones se combinan de a dos sobre casos de negocio completos.

Índice rápido:

1. Mapa del repositorio
2. Semana 1 — Streams
3. Semana 2 — Pokémon (streams y patrones)
4. Semana 3 — Taller 4 y Manual de Identidad
5. Tecnologías y cómo ejecutar

## 1. Mapa del repositorio

```text
src/main/dosw/
├── semana1/
│   └── streams/        Cinco ejercicios de introducción a Streams
├── semana2/
│   └── pokemon/
│       ├── Ejercicio1..20   Streams aplicados sobre Pokémon y Entrenadores
│       └── Epatron1..12     Un patrón de diseño aislado por carpeta
└── semana3/
    └── Taller4/
        └── Ejercicio1..10   Dos patrones combinados por ejercicio
```

Los diez ejercicios de `semana3/Taller4` tienen cada uno su propio README (problema, solución, patrones, clases y ejecución), por lo que más abajo solo se indexan. Todo lo demás —semana 1 completa y semana 2 completa— queda documentado aquí mismo.

## 2. Semana 1 — Streams

Carpeta: `semana1/streams`. Cinco ejercicios cortos para practicar `filter`, `map`, `sorted`, `collect`, `reduce` y `anyMatch` sobre listas de números, palabras y un par de `record` (usuarios y transacciones).

1. **Ejercicio1** — de una lista de enteros, filtra los valores que son a la vez mayores a 10 y pares.
2. **Ejercicio2** — filtra palabras de más de 4 letras, las pasa a mayúsculas, las ordena alfabéticamente y cuenta cuántas quedan.
3. **Ejercicio3** — con `record Usuario(id, nombre, edad, activo)`, extrae los nombres de los usuarios activos.
4. **Ejercicio4** — reutiliza ese mismo `record Usuario` para quedarse solo con los activos y mayores de edad.
5. **Ejercicio5** — con `record Transaction(id, amount, approved)`, usa `anyMatch` para detectar si hay transacciones sin aprobar.

## 3. Semana 2 — Pokémon: streams y patrones

Carpeta: `semana2/pokemon`. Dos modelos de apoyo se repiten en todo el bloque: `Pokemon` (id, nombre, tipo, nivel, poderCombate, región, legendario) y `Entrenador` (id, nombre, medallas, equipo de Pokemon).

### 3.1 Streams — Ejercicio1 a Ejercicio20

| # | Qué hace |
|---|---|
| 1 | filtra por tipo de elemento (criaturas de tipo Fuego) |
| 2 | filter + map para pasar los nombres a mayúsculas |
| 3 | reduce para sumar los niveles del equipo |
| 4 | filter por nivel y conteo de resultados |
| 5 | filter por nivel mayor a 80 y conteo con collect |
| 6 | distinct para quitar capturas duplicadas |
| 7 | sorted alfabético de la pokédex |
| 8 | filter por bandera booleana (listos para evolucionar) |
| 9 | sorted con Comparator.comparingDouble (poder de combate descendente) |
| 10 | map para proyectar solo los nombres |
| 11 | mapToDouble + average para una métrica promedio |
| 12 | recorrido con forEach |
| 13 | groupingBy por tipo, agrupando nombres |
| 14 | groupingBy por región |
| 15 | búsqueda del entrenador con más medallas |
| 16 | filter de entrenadores con más de 5 medallas |
| 17 | entrenador con mayor poder acumulado de equipo |
| 18 | sorted + limit, top 5 más fuerte |
| 19 | sorted con Comparator personalizado + limit, top 3 |
| 20 | estadísticas combinadas: conteo por tipo y región, legendarios, nivel promedio y el más fuerte |

### 3.2 Patrones de diseño — Epatron1 a Epatron12

Cada carpeta `EpatronN` resuelve un único patrón GoF sobre un mini-caso de uso independiente. Primero el panorama general y después el detalle de clases de cada una.

| Carpeta | Patrón | Caso de uso |
|---|---|---|
| Epatron1 | Factory Method | Procesador de pagos: cada subclase de ProcesadorPago fabrica su propio MetodoPago (tarjeta, PayPal, transferencia) |
| Epatron2 | Abstract Factory | Motor de videojuego: ConsolaFactory arma familias completas de componentes según la consola, PlayStation o Xbox |
| Epatron3 | Builder | Fábrica de muñecos: un Director ejecuta siempre la misma secuencia de ensamblaje sobre un MunecoBuilder intercambiable |
| Epatron4 | Adapter | Estación de servicio: adapta cargadores eléctricos a la interfaz que ya usan los vehículos de combustión |
| Epatron5 | Bridge | Formas geométricas combinables con cualquier color sin multiplicar clases |
| Epatron6 | Composite | Bodega con productos y cajas que pueden contener productos u otras cajas, precio total recursivo |
| Epatron7 | Decorator | Barco de guerra equipable con módulos combinables que modifican ataque y defensa |
| Epatron8 | Chain of Responsibility | Control migratorio: la solicitud del viajero recorre una cadena de validaciones |
| Epatron9 | Command | Control de videojuego: cada botón ejecuta un Comando distinto sobre el personaje |
| Epatron10 | — | Sin terminar: solo queda una clase vacía (test.java) |
| Epatron11 | Strategy | Navegación que calcula rutas (rápida, corta, escénica, transporte público) según la estrategia activa |
| Epatron12 | Strategy | Ordenador de arreglos que intercambia algoritmos de ordenamiento en tiempo de ejecución |

**Epatron1 — Factory Method**
- `MetodoPago`: interfaz del producto (procesarPago)
- `TarjetaCredito`, `PayPal`, `TransferenciaBancaria`: productos concretos
- `ProcesadorPago`: creador abstracto, declara el factory method y el flujo común (realizarPago)
- `ProcesadorTarjeta`, `ProcesadorPayPal`, `ProcesadorTransferencia`: creadores concretos, cada uno fabrica su MetodoPago
- `Main`: ejecuta el flujo con cada procesador

**Epatron2 — Abstract Factory**
- `Control`, `Juego`, `InterfazGrafica`: interfaces de productos
- `ControlPlayStation`, `JuegoPlayStation`, `InterfazGraficaPlayStation`: familia PlayStation
- `ControlXbox`, `JuegoXbox`, `InterfazGraficaXbox`: familia Xbox
- `ConsolaFactory`: fábrica abstracta
- `PlayStationFactory`, `XboxFactory`: fábricas concretas
- `MotorJuego`: cliente, arma los componentes sin conocer la consola concreta
- `Main`: clase de prueba

**Epatron3 — Builder**
- `Muneco`: producto complejo a construir
- `MunecoBuilder`: interfaz constructora, declara los pasos del ensamblaje
- `MunecoAccionBuilder`, `MunecoClasicaBuilder`: builders concretos
- `FabricaMuneco`: director, ejecuta la secuencia de construcción sobre el builder activo
- `Main`: clase de prueba

**Epatron4 — Adapter**
- `SurtidorGasolineria`: interfaz objetivo esperada por el cliente
- `VehiculoCombustion`: implementación nativa de esa interfaz
- `CargadorElectricoRapido`, `CargadorElectricoLento`: clases adaptadas, interfaz incompatible (cargar)
- `AdaptadorCargadorRapido`, `AdaptadorCargadorLento`: adaptadores, traducen abastecer a cargar
- `Main`: clase de prueba

**Epatron5 — Bridge**
- `Forma`: abstracción, mantiene una referencia a Color
- `Circulo`, `Cuadrado`, `Triangulo`: abstracciones refinadas
- `Color`: interfaz de implementación (aplicarColor)
- `Rojo`, `Azul`, `Verde`: implementaciones concretas del color
- `Main`: clase de prueba

**Epatron6 — Composite**
- `ItemBodega`: componente, interfaz común para hojas y compuestos
- `Producto`: hoja, artículo individual con precio fijo
- `Caja`: compuesto, contiene una lista de ItemBodega y agrega sus resultados
- `Main`: clase de prueba

**Epatron7 — Decorator**
- `Barco`: componente, contrato común
- `BarcoBase`: componente concreto, barco sin módulos
- `ModuloBarco`: decorador abstracto, envuelve un Barco y delega por defecto
- `BlindajeReforzado`, `RadarAvanzado`, `Misiles`, `SistemaAntitorpedos`: decoradores concretos
- `Main`: clase de prueba

**Epatron8 — Chain of Responsibility**
- `ControlMigratorio`: manejador abstracto, mantiene el enlace al siguiente control
- `ControlPasaporteVisa`, `ControlAntecedentes`, `ControlMotivoViaje`, `AprobacionMigracion`: manejadores concretos, cada uno valida un aspecto y delega al siguiente
- `Viajero`: objeto de solicitud que recorre la cadena
- `Main`: clase de prueba

**Epatron9 — Command**
- `Comando`: interfaz del comando (ejecutar)
- `ComandoCaminar`, `ComandoSaltar`, `ComandoAtacar`, `ComandoDefenderse`: comandos concretos, encapsulan la invocación sobre Personaje
- `Personaje`: receptor, ejecuta realmente la acción
- `ControlJuego`: invocador, dispara el comando asignado a cada botón
- `Main`: clase de prueba

**Epatron10 — pendiente**
- `test`: clase vacía, nunca se llegó a implementar el caso de uso ni el patrón

**Epatron11 — Strategy**
- `EstrategiaRuta`: interfaz de la estrategia (calcularRuta)
- `RutaMasRapida`, `RutaMasCorta`, `RutaEscenica`, `RutaTransportePublico`: estrategias concretas
- `AplicacionNavegacion`: contexto, usa la estrategia activa para calcular la ruta
- `Main`: clase de prueba

**Epatron12 — Strategy**
- `EstrategiaOrdenamiento`: interfaz de la estrategia (ordenar)
- `OrdenamientoBurbuja`, `OrdenamientoSeleccion`, `OrdenamientoInsercion`: algoritmos concretos de ordenamiento
- `Ordenador`: contexto, ejecuta el ordenamiento usando la estrategia activa
- `Main`: clase de prueba

## 4. Semana 3 — Taller 4 y Manual de Identidad

Carpeta: `semana3/Taller4`. Diez ejercicios integradores; a diferencia de la semana 2, cada uno combina dos patrones de diseño trabajando juntos sobre un caso de negocio completo. Cada ejercicio ya documenta en su propio README el problema, la solución, las clases y cómo ejecutarlo:

- **Ejercicio1** — Plataforma de pagos inteligente → Strategy + Factory Method
- **Ejercicio2** — Notificaciones multicanal → Observer + Builder
- **Ejercicio3** — Reportes empresariales (PDF/Excel/CSV) → Template Method + configuración por formato
- **Ejercicio4** — Personajes de videojuego → Builder + Decorator
- **Ejercicio5** — Integración con impresora legada → Adapter + Facade
- **Ejercicio6** — Monitoreo de servidores → Strategy + Observer
- **Ejercicio7** — Pipeline CI/CD de commits → Chain of Responsibility + State
- **Ejercicio8** — Reservas de hotel → Builder + Observer
- **Ejercicio9** — Aprobación de créditos bancarios → Strategy + Chain of Responsibility
- **Ejercicio10** — Editor de texto enriquecido → Command + Decorator

### Manual de Identidad — Scuderia 44 Legacy

Documento de identidad visual y conceptual desarrollado como complemento de la Semana 3. Define la esencia de la marca, sus elementos gráficos, colores, tipografía, público objetivo y lineamientos de uso.

El producto central, *Scuderia 44 Legacy*, es un guante inspirado en la Fórmula 1 que combina los colores característicos de Ferrari con el número 44 de Lewis Hamilton. Su diseño en rojo, blanco y detalles dorados transmite velocidad, precisión, pasión y excelencia.

La identidad de la marca también refleja rasgos de la personalidad de su creador: disciplina, perseverancia, competitividad, creatividad y búsqueda constante de superación. De esta manera, el producto no solo representa un accesorio deportivo, sino también una filosofía de liderazgo, esfuerzo y determinación aplicada tanto dentro como fuera de la pista.

El manual establece las bases visuales y comunicativas de la marca, garantizando coherencia en su presentación y fortaleciendo el mensaje de innovación, rendimiento y legado que caracteriza a Scuderia 44 Legacy.

## 5. Tecnologías y cómo ejecutar

- Lenguaje: Java, con uso de `record`, Stream API, `Comparator` y Collectors avanzados.
- IDE: IntelliJ IDEA (carpeta `.idea/` incluida en el repositorio).

Para los ejercicios de patrones (semana 2 y Taller 4), cada carpeta trae su propio `Main`:

```bash
cd src/main/dosw/<semana>/<carpeta-del-ejercicio>
javac *.java
java Main
```

Para los streams de la semana 1 y los `Ejercicio1..20` de la semana 2, cada clase es ejecutable por separado:

```bash
cd src/main/dosw/semana1/streams
javac Ejercicio1.java
java main.dosw.semana1.streams.Ejercicio1
```
