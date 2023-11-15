package controlador;

import modelo.Persona;
import modelo.Telefono;
import modelo.TipoFono;
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

    public boolean agregaPersona(String nombre, String nacim){
        String[] pFecha=nacim.split("/|-");
        LocalDate fn=LocalDate.of(
                Integer.parseInt(pFecha[2]),
                Integer.parseInt(pFecha[1]),
                Integer.parseInt(pFecha[0]));
        Persona p=new Persona(nombre,fn);
        if(personas.contains(p)){
            return false;
        }
        return personas.add(p);
    }
    public String listadoPersonas(){
        char[] linea=new char[72];
        Arrays.fill(linea, '-');
        String out="Listado de Personas\n";
        out+=new String(linea)+"\n";
        out+=String.format("%-40s %10s %20s%n","Nombre", "Nacimiento", "Telefonos");
        out+=new String(linea)+"\n";
        for (Persona p : personas) {
            LocalDate f=p.getNacim();
            String fecha=f.getDayOfMonth()+"/"+
                    f.getMonthValue()+"/"+f.getYear();
            out+=String.format("%-40s %10s %20S%n",p.getNombre(), fecha,p.getTelefono(0));
            for (int i = 1; i < p.cantTelefonos(); i++) {
                out+=String.format("%-40s %10s %20S%n","", "",p.getTelefono(i));
            }
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

    public boolean agregaTelefono(String nombre, String telefono, String tipo) {
        int pos=personas.indexOf(new Persona(nombre, LocalDate.now()));
        if(pos==-1){
            return false;
        }
        Persona p=personas.get(pos);
        Telefono t=new Telefono(telefono, TipoFono.valueOf(tipo.toUpperCase()));
        return p.addTelefono(t);
    }
}
