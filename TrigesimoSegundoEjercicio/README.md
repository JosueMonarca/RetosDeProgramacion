# 🧠 Deadpool vs Wolverine: Simulación de Batalla

Este proyecto simula una épica batalla por turnos entre **Deadpool** y **Wolverine**. Cada personaje tiene sus propias habilidades de ataque, evasión y comportamiento al recibir daño máximo.

---

## 🎮 ¿Cómo Funciona?

- El usuario ingresa la vida inicial de cada personaje.
- En cada turno:
  - Se decide aleatoriamente si el personaje logra esquivar el ataque.
  - Se calcula un daño aleatorio dentro de su rango.
  - Si recibe el **máximo daño posible**, **pierde su turno siguiente (regeneración sin curación)**.
- El combate continúa hasta que uno de los dos llegue a 0 de vida.

---

## 📊 Reglas del Juego

### 🎯 Daño de Ataque por Turno

    **Deadpool**: 10 - 100
    **Wolverine**: 10 - 120

### 🛡️ Probabilidad de Esquivar

    **Deadpool**: 25%
    **Wolverine**: 20%

### 💥 Regla Especial

> Si un personaje recibe **el daño máximo posible**, en el siguiente turno **no puede atacar** (está regenerándose).

---

## 🚀 Cómo Ejecutar

Asegúrate de tener Java instalado.

    javac *.java
    java Main
