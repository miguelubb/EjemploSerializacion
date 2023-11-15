package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDate;

public class Persona implements Serializable {
    String nombre;
    LocalDate nacim;
    //implementa la asociación con teléfono
    ArrayList<Telefono> telefonos;

    public Persona(String nombre, LocalDate nacim) {
        this.nombre = nombre;
        this.nacim = nacim;
        telefonos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacim() {
        return nacim;
    }

    public void setNacim(LocalDate nacim) {
        this.nacim = nacim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nacim);
    }

    @Override
    public String toString() {
        return "modelo.Persona{" +
                "nombre='" + nombre + '\'' +
                ", nacim=" + nacim +
                '}';
    }

    public boolean addTelefono(Telefono tel){
        if(telefonos.contains(tel)){
            return false;
        }
        return telefonos.add(tel);
    }
    public String getTelefono(int pos){
        if(pos < 0 || pos >= telefonos.size()){
            return "";
        }
        return telefonos.get(pos).toString();
    }
    public int cantTelefonos(){
        return telefonos.size();
    }
}
