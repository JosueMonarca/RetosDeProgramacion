package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = Controlador.getInstancia();
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);

        while (continuar) { 
            menu();
            String opcion = scanner.nextLine();
            
            switch (opcion){
                case "1" ->{
                    añadirPersonaje(controlador, scanner);
                }
                case "2" ->{
                    eliminarPersonaje(scanner, controlador);
                }
                case "3" ->{
                    for(IPersonaje per : controlador.getArbol()){
                        Personaje.printAll(per);
                    }
                }
                case "4" ->{
                    añadirHijo(scanner, controlador);
                }
                case "5" ->{
                    registrarPareja(scanner);
                }
                case "6" -> continuar = false;
                default -> System.out.println("Por favor ingrese una opcion valida");
            }
        }

        
    }

    private static  void menu(){
        System.out.println("----------------Menu-------------");
        System.out.println("1.Añadir un personaje");
        System.out.println("2.Eliminar un personaje");
        System.out.println("3.Imprimir arbol genealogico");
        System.out.println("4.Añadir un hijo a un personaje");
        System.out.println("5.Cambiar la pareja o añadir la pareja de un personaje");
        System.out.println("6.salir");
    }

    private static void añadirPersonaje(Controlador con, Scanner scanner){
        System.out.println("Ingrese el nombre del personaje");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese su ID ");
        String ID = scanner.nextLine();

        System.out.println("Ingrese el sexo del personaje");
        String sexo = scanner.nextLine();

        System.out.println("ingrese el nombre del padre o la madre");
        String pa = scanner.nextLine();
        IPersonaje padre = con.getPersonaje(pa);

        if(padre !=null ){
            Personaje nuevo = new Personaje(nombre, sexo, ID);
        
            con.addPersonaje(nuevo, padre);
    
            System.out.println("¿Tiene pareja?");
            String para = scanner.nextLine();
    
            if(para.equalsIgnoreCase("si")){
                System.out.println("Su pareja fue ingresada con aneterioridad ");
                String re = scanner.nextLine();
    
                if(re.equalsIgnoreCase("si")){
                    System.out.println("Ingrese el nombre del personaje ");
                    String nom = scanner.nextLine();
                    if(con.existe(nom)){
                        nuevo.setPareja(con.getPersonaje(nom));
                        System.out.println("Su pareja fue ingresada");
                    }else{
                        System.out.println("No se encontro a el personaje mensionado ¿Desea registrarlo?");
                        String regi = scanner.nextLine();
    
                        if(regi.equalsIgnoreCase("si")){
                            añadirPersonaje(con, scanner,nuevo);
                        }
                    }
                }
                else{
                    System.out.println("¿Desea registrarla?");
                    re = scanner.nextLine();

                    if(re.equalsIgnoreCase("si")){
                        añadirPersonaje(con, scanner);
                    }
                }
            }
        }else {
            System.out.println("No se encontro al padre ¿Desea volver a buscarlo?");
            String r = scanner.nextLine();

            if(r.equalsIgnoreCase("si")){
                System.out.println("Vuelva a ingresar el nombre :");
                String no = scanner.nextLine();

                if(con.existe(no)){
                    Personaje nuevo = new Personaje(nombre, sexo, ID);

                    padre = con.getPersonaje(no);
        
                    con.addPersonaje(nuevo, padre);
            
                    System.out.println("¿Tiene pareja?");
                    String para = scanner.nextLine();
            
                    if(para.equalsIgnoreCase("si")){
                        System.out.println("Su pareja fue ingresada con aneterioridad ");
                        String re = scanner.nextLine();
            
                        if(re.equalsIgnoreCase("si")){
                            System.out.println("Ingrese el nombre del personaje ");
                            String nom = scanner.nextLine();
                            if(con.existe(nom)){
                                nuevo.setPareja(con.getPersonaje(nom));
                                System.out.println("Su pareja fue ingresada");
                            }else{
                                System.out.println("No se encontro a el personaje mensionado ¿Desea registrarlo?");
                                String regi = scanner.nextLine();
            
                                if(regi.equalsIgnoreCase("si")){
                                    añadirPersonaje(con, scanner,nuevo);
                                }
                            }
                        }else{
                            System.out.println("¿Desea registrarla?");
                            re = scanner.nextLine();
                        
                            if(re.equalsIgnoreCase("si")){
                                añadirPersonaje(con, scanner);
                            }
                        }
                        
                    }
                }else{
                    System.out.println("no se encontro al personaje que indica ¿Desea reguistrarlo?");
                    String respuesta = scanner.nextLine();
                
                    if(respuesta.equalsIgnoreCase("si")){
                        añadirPersonaje(con, scanner);
                    }
                }
            }
        }

        
    }

    private static void añadirPersonaje(Controlador con, Scanner scanner, Personaje pareja){
        System.out.println("Ingrese el nombre del personaje");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese su ID ");
        String ID = scanner.nextLine();

        System.out.println("Ingrese el sexo del personaje");
        String sexo = scanner.nextLine();

        System.out.println("ingrese el nombre del padre o la madre");
        String pa = scanner.nextLine();
        IPersonaje padre = con.getPersonaje(pa);

        Personaje nuevo = new Personaje(nombre, sexo, ID);

        con.addPersonaje(nuevo, padre);

        nuevo.setPareja(pareja);
    }

    private static void eliminarPersonaje(Scanner sc, Controlador con){
        System.out.println("Ingrese el nombre del personaje a eliminar ");
        String nombre = sc.nextLine();

        if(con.existe(nombre)){
            con.removePersonaje(con.getPersonaje(nombre));
        }
        else{
            System.out.println("no existe el personaje ¿desea volver a intentaro?");
            String reString = sc.nextLine();

            if(reString.equalsIgnoreCase("si")){
                eliminarPersonaje(sc, con);
            }else{
                System.out.println("volviendo....");
            }
        }
    }

    private static void añadirHijo(Scanner scanner, Controlador contro){
        System.out.println("Ingrese el nombre del padre:");
        String nombre = scanner.nextLine();

        if(contro.existe(nombre)){
            System.out.println("Existe el hijo?");
            String re = scanner.nextLine();
            
            if(re.equalsIgnoreCase("si")){
                System.out.println("Ingrese el nombre del hijo");
                re = scanner.nextLine();

                if(contro.existe(re)){
                    contro.getPersonaje(nombre).addHijo(contro.getPersonaje(re));
                    System.out.println("se registro exitosomente");
                }
                else{
                    System.out.println("no se encontro el personaje mensionado ¿Desea volver a intentarlo?");
                    String res = scanner.nextLine();

                    if(res.equalsIgnoreCase("si")){
                        
                        System.out.println("Ingrese el nombre del hijo");
                        re = scanner.nextLine();
        
                        if(contro.existe(re)){
                            contro.getPersonaje(nombre).addHijo(contro.getPersonaje(re));
                            System.out.println("se registro exitosomente");
                        }
                        else{
                            System.out.println("no se encontro el personaje mensionado ¿Desea registralo?");
                            res = scanner.nextLine();
        
                            if(res.equalsIgnoreCase("si")){
                                añadirPersonaje(contro, scanner);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void registrarPareja(Scanner scanner){
        System.out.println("Ingrese el nombre del personaje que quiere como pareja");
        String nombrePareja = scanner.nextLine();
        Controlador controlador = Controlador.getInstancia();

        System.out.println("Ingrese el nombre del personaje al que desea asignar la pareja:");
        String nombrePersonaje = scanner.nextLine();

        if (!controlador.existe(nombrePersonaje)) {
            System.out.println("El personaje no existe. ¿Desea registrarlo? (si/no)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                añadirPersonaje(controlador, scanner);
            } else {
                System.out.println("Operación cancelada.");
                return;
            }
        }

        if (!controlador.existe(nombrePareja)) {
            System.out.println("La pareja no existe. ¿Desea registrarla? (si/no)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                añadirPersonaje(controlador, scanner);
            } else {
                System.out.println("Operación cancelada.");
                return;
            }
        }

        IPersonaje personaje = controlador.getPersonaje(nombrePersonaje);
        IPersonaje pareja = controlador.getPersonaje(nombrePareja);

        if (personaje != null && pareja != null) {
            personaje.setPareja(pareja);
            System.out.println("Pareja registrada exitosamente.");
        } else {
            System.out.println("No se pudo registrar la pareja. Verifique los datos.");
        }
    }
}