package Clases;

import java.io.Serializable;

public class Hub implements Serializable {

    //hub de contenedores
    private Contenedor[][] hub; //un hub tiene 10 filas y 12 columnas

    //constructor
    public Hub(){
        this.hub = new Contenedor[10][12];
    }

    //setter y getter
    public void setHub(Contenedor[][] hub) {
        if(this.hub != null) this.hub = hub;
    }
    public Contenedor[][] getHub(){
        return this.hub;
    }

    //metodo toString
    public String toString(){

        String s = " ";

        for (int i = 0; i < hub.length; i++) {
            for (int j = 0; j < hub[i].length; j++) {
                if (hub[i][j] == null) {
                    s += "[N]";
                } else {
                    s += "[" + hub[i][j].getID() + "]";
                }
                s += "\n";
            }
            s+="\n";

        }
        return s;
    }

}
