# Ejercicio 03 — Sistema de Reportes Empresariales

## Descripción del Problema

La empresa necesita generar reportes en PDF, Excel y CSV. Todos los reportes comparten el mismo flujo de 4 pasos: extraer datos, transformarlos, darles formato y escribirlos en disco. Los pasos 1 y 2 son idénticos para todos los formatos; los pasos 3 y 4 varían por completo según el formato de salida. Adicionalmente, el usuario puede configurar parámetros específicos según el formato elegido: márgenes y portada para PDF, número de hojas y gráficos para Excel, carácter separador y cabecera para CSV.

---

## Solución Propuesta

Se combinan dos patrones para resolver la estructura del algoritmo y su creación parametrizada:

- **Template Method** define el pipeline fijo de 4 pasos en `PlantillaReporte` con el método `final ejecutar()`. Los pasos 1 y 2 (`paso1_extraerDatos`, `paso2_transformar`) están implementados en la clase base y son iguales para todos. Los pasos 3 y 4 (`paso3_formatear`, `paso4_escribir`) son abstractos: cada subclase los implementa con la lógica específica de su formato.

- **Factory Method** centraliza la creación parametrizada en `CreadorReporte`. A diferencia de una fábrica simple, este creador solicita al usuario los parámetros adicionales que necesita cada formato (márgenes para PDF, número de hojas para Excel, separador para CSV) y construye el objeto concreto correctamente configurado. El cliente solo interactúa con `PlantillaReporte`.

La interacción es: el usuario elige el formato y el nombre del archivo → `CreadorReporte` solicita los parámetros adicionales específicos del formato → instancia la subclase concreta con esos parámetros → el cliente llama `ejecutar()` → Template Method corre los 4 pasos.

---

## Patrones de Diseño Implementados

### Template Method
- **Clase abstracta:** `PlantillaReporte` — define `final ejecutar()` con los 4 pasos del pipeline; implementa los fijos y declara abstractos los variables
- **Subclases concretas:** `ReportePDF` (con portada y márgenes configurables), `ReporteExcel` (con hojas y gráficos configurables), `ReporteCSV` (con separador y cabecera configurables)

### Factory Method
- **Fábrica:** `CreadorReporte` — método estático `crear(formato, archivo, scanner)` que solicita parámetros adicionales al usuario e instancia la subclase correcta

---

## Estructura de Clases

| Clase / Interfaz | Tipo | Rol |
|---|---|---|
| `PlantillaReporte` | Clase abstracta | Define el Template Method con el pipeline de 4 pasos |
| `ReportePDF` | Subclase concreta | Implementa pasos 3 y 4 para PDF; recibe portada y margenMm |
| `ReporteExcel` | Subclase concreta | Implementa pasos 3 y 4 para Excel; recibe numHojas y conGraficos |
| `ReporteCSV` | Subclase concreta | Implementa pasos 3 y 4 para CSV; recibe separador e incluirCabecera |
| `CreadorReporte` | Fábrica estática | Solicita parámetros al usuario y construye la subclase correcta |
| `Main` | Clase principal | Punto de entrada e interacción con el usuario |

**Total: 6 clases**

---

## Ejecución

```bash
cd src
javac *.java
java Main
```

### Ejemplo de interacción

```
=== Sistema de Reportes Empresariales ===
Formatos disponibles: PDF, EXCEL, CSV

Formato del reporte (o 'salir'): PDF
Nombre del archivo de salida: informe_ventas.pdf
Configurando reporte PDF:
  Incluir portada? (s/n): s
  Margen en mm (ej: 25): 20
Ejecutando pipeline:
  >> Iniciando pipeline...
  [Paso 1] Extrayendo registros de la base de datos...
  [Paso 2] Aplicando reglas de negocio y calculos...
  [Paso 3] Mapeando datos a estructura PDF...
           + Agregando portada con logo corporativo
           + Configurando margenes de 20mm
  [Paso 4] Serializando binario PDF -> informe_ventas.pdf
  >> Pipeline finalizado: informe_ventas.pdf
```
