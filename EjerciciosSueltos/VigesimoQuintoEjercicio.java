
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * EJERCICIO:
 * Explora el concepto de "logging" en tu lenguaje. Configúralo y muestra
 * un ejemplo con cada nivel de "severidad" disponible.
 *
 * DIFICULTAD EXTRA (opcional):
 * Crea un programa ficticio de gestión de tareas que permita añadir, eliminar
 * y listar dichas tareas.
 * - Añadir: recibe nombre y descripción.
 * - Eliminar: por nombre de la tarea.
 * Implementa diferentes mensajes de log que muestren información según la
 * tarea ejecutada (a tu elección).
 * Utiliza el log para visualizar el tiempo de ejecución de cada tarea.
 */
public class VigesimoQuintoEjercicio {
    public static void main(String[] args){
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        // Configuración del logger
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        logger.setUseParentHandlers(false);

        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");
        logger.fine("fine");
        logger.config("config");
        logger.finer("finer");
        logger.finest("finest");
        logger.entering("VigesimoQuintoEjercicio", "main");
        logger.exiting("VigesimoQuintoEjercicio", "main");
        //logger.log(Logger.getGlobal().getLevel(), "Log message with global level");
        logger.log(Level.INFO, "Log message with explicit level");
    }
}
