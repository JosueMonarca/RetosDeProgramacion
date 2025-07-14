# 🎧 Oasis vs Linkin Park - Comparador de Popularidad en Spotify

Dos de las bandas más grandes de la historia están de vuelta...  
Pero, ¿quién es más popular actualmente según Spotify?

Este proyecto se conecta a la API de Spotify para comparar a **Oasis** y **Linkin Park** con base en datos reales.

---

## 📌 Objetivo

Desarrollar un programa que consulte la API de Spotify y compare la popularidad de Oasis y Linkin Park utilizando múltiples métricas.

---

## ✅ Requisitos

1. Crear una cuenta de desarrollador en [Spotify for Developers](https://developer.spotify.com).
2. Obtener tus credenciales (Client ID y Client Secret).
3. Conectarte a la API de Spotify desde el lenguaje de programación que prefieras.
4. Consultar datos desde al menos 3 endpoints distintos.

---

## 📊 Acciones a implementar

- Obtener estadísticas clave de ambas bandas:
  - Número total de seguidores.
  - Oyentes mensuales.
  - Canción más reproducida.
- Comparar los datos obtenidos.
- Mostrar todos los resultados por consola.
- Establecer un criterio para determinar cuál banda es más popular.

---

## 🔌 Endpoints recomendados

- `GET /v1/search?q={band name}&type=artist`  
  → Para obtener el ID del artista.

- `GET /v1/artists/{id}`  
  → Para obtener popularidad y número de seguidores.

- `GET /v1/artists/{id}/top-tracks?market=US`  
  → Para conocer las canciones más populares y sus reproducciones.

---

## 🧠 Criterio de comparación (ejemplo)

```text
Puntaje final = (Seguidores * 0.4) + (Oyentes mensuales * 0.4) + (Reproducciones de canción más popular * 0.2)
