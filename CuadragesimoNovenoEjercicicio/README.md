# 🎄 Ejercicio: El Código Secreto de Papá Noel 🎅

¡Papá Noel tiene un problema! 😱  
Ha olvidado el código secreto que abre el almacén de regalos... ¡Y necesita tu ayuda para descifrarlo!

---

## 🧩 Descripción del Juego

Debes desarrollar un programa que permita al usuario adivinar un **código secreto** para que Papá Noel pueda repartir los regalos a tiempo.  
El juego se ejecuta en consola.

---

## 🔐 El Código Secreto

- El código tiene una **longitud de 4 caracteres**.
- Cada carácter puede ser:
  - Una **letra**: `A`, `B`, o `C`
  - Un **número**: `1`, `2`, o `3`
- No se permiten caracteres **repetidos**.
- Se genera **aleatoriamente** al iniciar el programa.

---

## 🧑‍💻 El Usuario

- Tiene **10 intentos** para descubrir el código.
- En cada intento, debe ingresar una **combinación de 4 caracteres válidos**.
- El programa responderá con una pista para **cada carácter** ingresado:

| Resultado    | Significado                                                             |
|--------------|-------------------------------------------------------------------------|
| ✅ Correcto   | El carácter está en la posición correcta.                              |
| 🔄 Presente   | El carácter está en el código, pero en otra posición.                  |
| ❌ Incorrecto | El carácter no existe en el código secreto.                            |

- Se debe validar que:
  - El código tenga exactamente **4 caracteres**.
  - Todos los caracteres sean **válidos** (`A–C` y `1–3`).
  - No haya **repeticiones** en el intento.

---

## 🏁 Final del Juego

- **🎉 Victoria:** El jugador acierta el código antes del intento número 10.
- **💥 Derrota:** El jugador no adivina el código en 10 intentos.  
  ¡Papá Noel no podrá entregar los regalos a tiempo!

---

## 🎯 Objetivo

¡Ayuda a Papá Noel a desbloquear el almacén a tiempo y salva la Navidad! 🎁🎄
