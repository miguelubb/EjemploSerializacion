package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Telefono implements Serializable {
    String numero;
    TipoFono tipo;

    public Telefono(String numero, TipoFono tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoFono getTipo() {
        return tipo;
    }

    public void setTipo(TipoFono tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefono)) return false;
        Telefono telefono = (Telefono) o;
        return Objects.equals(numero, telefono.numero) && tipo == telefono.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, tipo);
    }

    @Override
    public String toString() {
        return numero + '(' + tipo + ')';
    }
}
