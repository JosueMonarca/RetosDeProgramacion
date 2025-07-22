# 🥋 Dragon Ball: Sparking! ZERO – Simulador de Torneo de Artes Marciales

¡El último videojuego de Dragon Ball ya está aquí!  
Se llama **Dragon Ball: Sparking! ZERO**.

Este proyecto simula un **Torneo de Artes Marciales**, al más puro estilo de la saga, donde diferentes luchadores se enfrentarán hasta que el sistema decida quién es el campeón.

---

## 🧍‍♂️ Luchadores

Cada luchador cuenta con las siguientes características:

- **Nombre**
- **Tres atributos**:
  - `Velocidad` (0 - 100)
  - `Ataque` (0 - 100)
  - `Defensa` (0 - 100)
- **Salud inicial**: 100 puntos

---

## ⚔️ Batalla

Las reglas de batalla son:

- Se enfrentan 2 luchadores.
- El luchador con mayor **velocidad** ataca primero.
- El **daño** se calcula como:
- Daño = Ataque del atacante - Defensa del oponente

- Si la **defensa** del oponente es mayor que el ataque, solo recibe el **10% del valor de ataque** como daño.
- El oponente tiene un **20% de probabilidad de esquivar** el ataque.
- Después de cada turno, se **reduce la salud** del luchador atacado.
- La batalla termina cuando un luchador **queda sin salud**.

---

## 🏆 Torneo

Características del torneo:

- El torneo es válido solo si el **número de luchadores es una potencia de 2** (2, 4, 8, 16...).
- Las parejas se forman **al azar en cada ronda**.
- Se llevan a cabo **rondas eliminatorias**.
- El ganador de cada combate **avanza** a la siguiente ronda.
- El proceso continúa hasta que **sólo queda un ganador**.

---

## 📺 Consola

Durante el torneo, se debe mostrar por consola:

- Los enfrentamientos
- Los ataques y defensas
- La salud restante
- El avance de cada ronda
- El **ganador final del torneo**

---

¡Que gane el más fuerte! 🐉🔥
