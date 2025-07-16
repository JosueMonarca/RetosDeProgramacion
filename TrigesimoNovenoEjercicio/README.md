# Ejercicio No 39 – Batman Day Special

**Descripción:**

Este proyecto celebra el Batman Day con un reto doble en Java. El primero calcula las fechas futuras de la celebración hasta el centenario de Batman, y el segundo simula el sistema de seguridad de la Batcueva para monitorear amenazas en Gotham City.

---

## 🦇 Reto 1: Calendario del Batman Day

Calcula automáticamente las fechas en que se celebrará el Batman Day desde el año actual hasta el año en que Batman cumpla 100 años. El Batman Day se celebra el **tercer sábado de septiembre** de cada año.

---

## 🛡️ Reto 2: Sistema de Seguridad de la Batcueva

Simulación del sistema de defensa de la Batcueva con sensores distribuidos por toda Gotham.

### 🗺️ Especificaciones

- Mapa de Gotham: **cuadrícula 20x20**
- Cada sensor se define como una **tupla**: `(x, y, amenaza)`
- El sistema analiza la cuadrícula en bloques de **3x3 sensores**
- Se activa el **protocolo de seguridad** si la suma de amenazas en una zona 3x3 ≥ **20**

### 📊 Funcionalidades

- Identifica la **zona 3x3 más crítica**
- Calcula:
  - La **suma total de amenazas** en esa zona
  - La **distancia a la Batcueva (0, 0)** con distancia de Manhattan
  - Si se activa o no el **protocolo de seguridad**

---

## 🧪 Tecnologías utilizadas

- Java 17
- Estructuras de datos: Listas, Matrices
- Algoritmos: Búsqueda de máximos en submatrices

---

## 📅 Estado: Terminado

**Fecha de inicio:** 2025-07-14  
**Fecha de finalización:** 2025-07-16

---

## 🔗 Enlaces

- [Repositorio de GitHub](https://github.com/JosueMonarca/RetosDeProgramacion/blob/main/TrigésimoNovenoEjercicio/Main.java)

---

## 💥 Desafíos enfrentados

- Calcular correctamente el tercer sábado de septiembre de cada año.
- Representar sensores en coordenadas dentro de una cuadrícula y simular amenazas.
- Analizar submatrices 3x3 eficientemente en una matriz 20x20.
- Calcular distancia tipo Manhattan desde la Batcueva.
- Activar correctamente el protocolo según un umbral.

---

## 🧠 Lecciones aprendidas

- Manipulación de fechas en Java (`LocalDate`, `TemporalAdjusters`)
- Análisis de matrices y optimización de búsqueda local (submatrices)
- Diseño de sistemas simulados con lógica condicional compleja
- Aplicación de conceptos de sistemas de monitoreo en tiempo real

---

**Tags:** #java #proyecto #batman #matriz #fechas #simulación #csv #retos
