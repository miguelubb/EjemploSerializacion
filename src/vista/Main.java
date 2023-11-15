package vista;

import controlador.ControladorPersonas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ControladorPersonas controlador=
           ControladorPersonas.getInstance();
    private static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {
        controlador.leer();
        input.useDelimiter("\n" +
                "|[\n" +
                "\n" +
                "\u2028\u2029\u0085]");
        int op=5;
        do{
            menu();
            op=input.nextInt();
            switch (op){
                case 1 -> nuevaPersona();
                case 2 -> nuevoTelefono();
                case 3 -> listar();
                case 4 -> guardar();
                case 5 -> leer();
                case 6 -> System.out.println("Adios");
                default -> System.out.println("opción no válida");
            }
        }while(op!=6);
        controlador.guardar();
    }

    private static void nuevoTelefono() {
        System.out.println("Nuevo teléfono");
        System.out.println("Ingrese Nombre persona:");
        String nombre=input.next();
        System.out.println("Telefono:");
        String telefono=input.next();
        System.out.println("tipo:");
        String tipo=input.next();
        boolean ok = controlador.agregaTelefono(nombre, telefono, tipo);
        if(!ok){
            System.out.println("Error: La persona no existe o el teléfono está duplicado!!!");
        }
    }

    private static void leer() {
        controlador.leer();
    }

    private static void guardar() {
        controlador.guardar();
    }

    private static void listar() {
        System.out.println(controlador.listadoPersonas());
    }

    private static void nuevaPersona() {
        char[] linea=new char[52];
        Arrays.fill(linea, '-');
        System.out.println("Agregar persona");
        System.out.println(linea);
        System.out.println("Ingrese Nombre:");
        String nombre=input.next();
        System.out.println("Ingrese Fecha nacimiento: ");
        String fecha=input.next();
        boolean ok=controlador.agregaPersona(nombre, fecha);
        if(!ok){
            System.out.println("Error: Persona ya existe!!!");
        }
    }

    private static void menu() {
        System.out.println("Menu de opciones");
        System.out.println("1) nueva persona");
        System.out.println("2) nuevo telefono");
        System.out.println("3) listar personas");
        System.out.println("4) guardar personas");
        System.out.println("5) leer personas");
        System.out.println("6) Salir");
        System.out.println("Ingrese opcion:");
    }
}
