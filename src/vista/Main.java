package vista;

import controlador.ControladorPersonas;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static ControladorPersonas controlador=
           ControladorPersonas.getInstance();
    private static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {

        int op=5;
        do{
            menu();
            op=input.nextInt();
            switch (op){
                case 1 -> nuevaPersona();
                case 2 -> listar();
                case 3 -> guardar();
                case 4 -> leer();
                case 5 -> System.out.println("Adios");
                default -> System.out.println("opción no válida");
            }
        }while(op!=5);
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
        controlador.agregaPersona(nombre, fecha);
    }

    private static void menu() {
        System.out.println("Menu de opciones");
        System.out.println("1) nueva persona");
        System.out.println("2) listar personas");
        System.out.println("3) guardar personas");
        System.out.println("4) leer personas");
        System.out.println("5) Salir");
        System.out.println("Ingrese opcion:");
    }
}
