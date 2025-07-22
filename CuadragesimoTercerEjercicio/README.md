# Git CLI en Java

Este proyecto es una interfaz de línea de comandos (CLI) escrita en Java que permite interactuar con Git desde consola.

## Funcionalidades

- Establecer directorio de trabajo
- Crear repositorio (`git init`)
- Crear y cambiar de ramas (`git switch`)
- Ver estado del repositorio (`git status`)
- Hacer commits (`git add . && git commit`)
- Ver historial (`git log`)
- Eliminar ramas
- Conectar a repositorio remoto (`git remote add origin`)
- Hacer pull y push
- Salir del programa

## Requisitos

- Java 17+
- Git instalado y accesible desde terminal

## Cómo ejecutar

```bash
javac Main.java
java Main
