package com.cuadragesimo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
          // Ruta del archivo original que quieres comprimir
        Path sourcePath = Paths.get("primer/src/main/resources/z.txt");

        // Ruta de salida del ZIP
        Path zipPath = Paths.get("archivo.zip");

        // Crear el ZIP
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipPath))) {

            // Crear la entrada ZIP con el nombre del archivo (sin directorios)
            ZipEntry entry = new ZipEntry(sourcePath.getFileName().toString());
            zos.putNextEntry(entry);

            // Leer el archivo original y escribir su contenido en el ZIP
            byte[] buffer = Files.readAllBytes(sourcePath);
            zos.write(buffer, 0, buffer.length);
            zos.closeEntry();

            System.out.println("Archivo comprimido correctamente: " + zipPath.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error al crear el ZIP: " + e.getMessage());
        }
    }
}