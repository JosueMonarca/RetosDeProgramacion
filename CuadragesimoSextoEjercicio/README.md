# Simulador de Red Social Descentralizada

## 📘 Descripción

Este proyecto simula el funcionamiento básico de una red social descentralizada al estilo de **Bluesky**, la alternativa abierta a X (antes Twitter). Se implementan las operaciones fundamentales de gestión de usuarios, publicaciones, relaciones sociales y visualización de contenido.

---

## 🧩 Funcionalidades

### 👤 Gestión de usuarios

- Registrar un usuario con:
  - Nombre
  - Identificador único (ID)
- Seguir y dejar de seguir a otros usuarios.

### 📝 Gestión de publicaciones (posts)

- Crear un post asociado a un usuario, con:
  - Texto (máximo 200 caracteres)
  - Fecha de creación
  - Identificador único del post
- Eliminar un post.

### ❤️ Interacciones

- Hacer y eliminar "like" en un post.

---

## 📰 Feeds

### 🔹 Feed personal

- Muestra las **10 publicaciones más recientes** del usuario.
- Ordenadas de más reciente a más antigua.

### 🔹 Feed de seguidos

- Muestra las **10 publicaciones más recientes** de los usuarios que sigue.
- También ordenadas de más reciente a más antigua.

---

## 📄 Visualización de un post

Cada post debe mostrar:

- ID del usuario
- Nombre del usuario
- Texto del post
- Fecha de creación
- Número total de likes

---

## 🚫 Control de errores

El sistema debe controlar:

- Duplicados de usuarios o publicaciones.
- Acciones no permitidas como:
  - Seguirse a sí mismo.
  - Eliminar un post que no existe.
  - Dar like a un post inexistente o ya likado.

---

## 🧠 Inspiración

Basado en las características de redes sociales descentralizadas como **Bluesky**, fomentando la exploración de modelos distribuidos y control individual sobre la información.

---
