import java.util.*;

public class Main {
    public static void main(String[] str) {
        try (Scanner scanner = new Scanner(System.in)) {
            int front = 0;
            int back = 0;
            int mobile = 0;
            int data = 0;
            int opcion = 0;
            String nombre;

            System.out.println("-------------------- El Sombrero Seleccionador de Hogwarts (Programación)-------------------");
            System.out.println("Ingrese su nombre por favor:");
            nombre = scanner.nextLine();

            String[] preguntas = {
                """
                1. ¿Qué parte de un proyecto disfrutas más?
                    1) Diseñar la interfaz de usuario 
                    2) Crear la lógica del servidor 
                    3) Desarrollar apps para móviles 
                    4) Analizar grandes cantidades de datos 
                """,
                """
                2. ¿Qué herramienta prefieres usar?
                    1) Figma o herramientas de diseño 
                    2) Postman o herramientas de APIs 
                    3) IDEs para desarrollo móvil 
                    4) Jupyter Notebook 
                """,
                """
                3. ¿Qué lenguaje te gusta más?
                    1) HTML, CSS, JavaScript 
                    2) Java, C#, Node.js 
                    3) Kotlin, Swift 
                    4) Python
                """,
                """
                4. ¿Qué tarea te resulta más interesante?
                    1) Hacer sitios web atractivos 
                    2) Optimizar bases de datos y servidores 
                    3) Publicar apps en Play Store/App Store 
                    4) Encontrar patrones en los datos
                """,
                """
                5. ¿Qué te motiva aprender más?
                    1) Animaciones y experiencias de usuario 
                    2) Seguridad y rendimiento del servidor 
                    3) Nuevas tecnologías móviles 
                    4) Machine Learning y Big Data
                """,
                """
                6. ¿Cuál es tu lugar de trabajo ideal?
                    1) En contacto directo con diseñadores
                    2) En coordinación con equipos de infraestructura 
                    3) Con equipos de hardware y dispositivos
                    4) Con científicos de datos y analistas
                """,
                """
                7. ¿Qué aplicación te gustaría desarrollar?
                    1) Una página web impactante 
                    2) Un sistema de reservas complejo 
                    3) Una app de fitness para smartphones 
                    4) Un dashboard de visualización de datos
                """,
                """
                8. ¿Qué te gustaría mejorar de tus habilidades?
                    1) Creatividad visual
                    2) Algoritmos y estructuras de datos 
                    3) Programación multiplataforma 
                    4) Análisis estadístico
                """,
                """
                9. ¿Qué valoras más?
                    1) La estética y usabilidad 
                    2) La eficiencia y robustez 
                    3) La accesibilidad y portabilidad
                    4) La precisión y la información
                """,
                """
                10. ¿Qué superpoder elegirías?
                    1) Crear interfaces mágicas al instante 
                    2) Controlar servidores sin caídas 
                    3) Adaptar apps a cualquier dispositivo 
                    4) Descubrir secretos ocultos en datos
                """
            };

            for (String pregunta : preguntas) {
                System.out.println(pregunta);
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1 -> front++;
                    case 2 -> back++;
                    case 3 -> mobile++;
                    case 4 -> data++;
                }
            }

            Map<String, Integer> casas = new HashMap<>();
            casas.put("Frontend", front);
            casas.put("Backend", back);
            casas.put("Mobile", mobile);
            casas.put("Data", data);

            int maxPuntos = Collections.max(casas.values());
            List<String> casasGanadoras = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : casas.entrySet()) {
                if (entry.getValue() == maxPuntos) {
                    casasGanadoras.add(entry.getKey());
                }
            }

            String casaElegida;
            if (casasGanadoras.size() > 1) {
                // Desempate aleatorio
                casaElegida = casasGanadoras.get(new Random().nextInt(casasGanadoras.size()));
                System.out.println(nombre + ", la decisión ha sido complicada...");
            } else {
                casaElegida = casasGanadoras.get(0);
            }

            System.out.println(nombre + ", el sombrero seleccionador ha decidido que tu camino es: " + casaElegida);

        }
    }
}
