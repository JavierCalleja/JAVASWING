package Clases;

import java.io.Serializable;
import java.util.Arrays;

public class Puerto {

    private Hub[] puerto = new Hub[3];

    public Puerto() {
        for(int i = 0; i < this.puerto.length; ++i) {
            this.puerto[i] = new Hub();
        }

    }

    public void apilarContenedor(Contenedor c) {
        boolean huecoTomado = false;
        if (this.puerto[0].Idduplicado(c) + this.puerto[1].Idduplicado(c) + this.puerto[2].Idduplicado(c) == 0) {
            for(int i = 0; i < 3 && !this.puerto[i].apilarContenedor(c); ++i) {
            }
        }

    }

    public Contenedor desapilarContenedor(int hub, int columna) {
        return hub > 0 && hub < 4 && columna > 0 && columna < 13 ? this.puerto[hub - 1].desapilarContenedor(columna) : null;
    }

    public void mostrarDatosContenedor(int id) {
        for(int i = 0; i < this.puerto.length; ++i) {
            this.puerto[i].mostrarDatosContenedor(id);
        }

    }

    public int contenedoresporPais(String pais) {
        int cantidad = 0;

        for(int i = 0; i < this.puerto.length; ++i) {
            cantidad += this.puerto[i].contenedoresPais(pais);
        }

        return cantidad;
    }

    public String toString(int hub) {
        return hub > 0 && hub < 4 ? this.puerto[hub - 1].toString() : null;
    }

    public String toString() {
        String s = "";

        for(int i = 0; i < this.puerto.length; ++i) {
            s = s + "\nHub " + (i + 1) + ":\n" + this.puerto[i].toString();
        }

        return s;
    }

}
