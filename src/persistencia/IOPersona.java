package persistencia;

import modelo.Persona;

import java.io.*;
import java.util.ArrayList;

public class IOPersona {
    String filename;

    public IOPersona(String filename) {
        this.filename = filename;
    }

    public void guardarPersonas(ArrayList<Persona> personas) throws IOException {
        ObjectOutputStream output=null;
        output=new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(personas);
        output.close();
    }

    public ArrayList<Persona> leerPersonas() throws IOException, ClassNotFoundException {
        ObjectInputStream input=new ObjectInputStream(new FileInputStream(filename));
        return (ArrayList<Persona>) input.readObject();
    }
}
