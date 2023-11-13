package controlador;

import modelo.Persona;
import persistencia.IOPersona;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ControladorPersonas {
    private ArrayList<Persona> personas;
    private static ControladorPersonas instance=new ControladorPersonas();
    private IOPersona archivo;
    private ControladorPersonas() {
        personas=new ArrayList<>();
        archivo=new IOPersona("Personas.obj");
    }

    public static ControladorPersonas getInstance(){
        return instance;
    }

    public void agregaPersona(String nombre, String nacim){
        String[] pFecha=nacim.split("/|-");
        LocalDate fn=LocalDate.of(
                Integer.parseInt(pFecha[2]),
                Integer.parseInt(pFecha[1]),
                Integer.parseInt(pFecha[0]));
        personas.add(new Persona(nombre,fn));
    }
    public String listadoPersonas(){
        char[] linea=new char[52];
        Arrays.fill(linea, '-');
        String out="Listado de Personas\n";
        out+=new String(linea)+"\n";
        out+=String.format("%-40s %10s %n","Nombre", "Nacimiento");
        out+=new String(linea)+"\n";
        for (Persona p : personas) {
            LocalDate f=p.getNacim();
            String fecha=f.getDayOfMonth()+"/"+
                    f.getMonthValue()+"/"+f.getYear();
            out+=String.format("%-40s %10s %n",p.getNombre(), fecha);
        }
        out+=new String(linea)+"\n";
        out+="Total de personas: "+personas.size();
        return out;
    }

    public void leer(){
        try {
            personas=archivo.leerPersonas();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardar(){
        try {
            archivo.guardarPersonas(personas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
