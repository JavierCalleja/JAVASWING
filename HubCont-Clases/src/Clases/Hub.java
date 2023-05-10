package Clases;

import java.io.PrintStream;
import java.io.Serializable;

public class Hub{

    //hub de contenedores
    private Contenedor[][] complex = new Contenedor[10][12]; //un hub tiene 10 filas y 12 columnas
    private byte[] libresPrioridad = new byte[3];
    //constructor
    public Hub() {
        this.libresPrioridad[0] = 10;
        this.libresPrioridad[1] = 10;
        this.libresPrioridad[2] = 100;
    }

    public int Idduplicado(Contenedor c) {
        for(int j = 0; j < 12; ++j) {
            for(int k = 9; k >= 0; --k) {
                if (this.complex[k][j] != null && this.complex[k][j].getID() == c.getID()) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean apilarContenedor(Contenedor c) {
        int i;
        if (c.getPrioridad() > 0 && c.getPrioridad() < 3 && this.libresPrioridad[c.getPrioridad() - 1] != 0 && this.Idduplicado(c) != 1) {
            for(i = 9; i >= 0; --i) {
                if (this.complex[i][c.getPrioridad() - 1] == null) {
                    this.complex[i][c.getPrioridad() - 1] = c;
                    --this.libresPrioridad[c.getPrioridad() - 1];
                    return true;
                }
            }
        } else if (c.getPrioridad() == 3 && this.libresPrioridad[2] != 0 && this.Idduplicado(c) != 1) {
            for(i = 2; i < 12; ++i) {
                for(int j = 9; j >= 0; --j) {
                    if (this.complex[j][i] == null) {
                        this.complex[j][i] = c;
                        --this.libresPrioridad[2];
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Contenedor desapilarContenedor(int columna) {
        Contenedor c = null;
        int i;
        if (columna >= 0 && columna < 3 && this.libresPrioridad[columna - 1] != 10) {
            for(i = 0; i < 10; ++i) {
                if (this.complex[i][columna - 1] != null) {
                    c = this.complex[i][columna - 1];
                    this.complex[i][columna - 1] = null;
                    ++this.libresPrioridad[columna - 1];
                    break;
                }
            }
        }

        if (columna >= 2 && columna < 13 && this.libresPrioridad[2] != 100) {
            for(i = 0; i < 10; ++i) {
                if (this.complex[i][columna - 1] != null) {
                    c = this.complex[i][columna - 1];
                    this.complex[i][columna - 1] = null;
                    ++this.libresPrioridad[2];
                    return c;
                }
            }
        }

        return c;
    }

    //setter y getter
    public void setHub(Contenedor[][] hub) {
        if(this.complex != null) this.complex = hub;
    }
    public Contenedor[][] getHub(){
        return this.complex;
    }

    //metodo toString
    public String toString() {
        String s = "  ";

        int i;
        for(i = 0; i < 12; ++i) {
            if (i < 9) {
                s = s + "   " + (i + 1);
            }

            if (i >= 9) {
                s = s + "  " + (i + 1);
            }
        }

        s = s + "\n";

        for(i = 0; i < 10; ++i) {
            if (i < 9) {
                s = s + " " + (i + 1) + ": ";
            }

            if (i == 9) {
                s = s + (i + 1) + ": ";
            }

            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] == null) {
                    s = s + "[ ] ";
                } else {
                    if (this.complex[i][j].getPrioridad() == 1) {
                        s = s + "[X] ";
                    }

                    if (this.complex[i][j].getPrioridad() == 2) {
                        s = s + "[X] ";
                    }

                    if (this.complex[i][j].getPrioridad() == 3) {
                        s = s + "[X] ";
                    }
                }
            }

            s = s + "\n";
        }

        return s;
    }
    public void mostrarDatosContenedor(int id) {
        boolean presente = false;

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] != null && this.complex[i][j].getID() == id) {
                    presente = true;
                    PrintStream var10000 = System.out;
                    int var10001 = this.complex[i][j].getID();
                    var10000.println("Identificador: " + var10001 + "\nPrioridad: " + this.complex[i][j].getPrioridad() + "\nPeso: " + this.complex[i][j].getPeso() + "\nPais de procedencia: " + this.complex[i][j].getPaisProcedencia() + "\nEmpresa emitido: " + this.complex[i][j].getEmpresaEnvia() + "\nEmpresa Receptor: " + this.complex[i][j].getEmpresaRecibe() + "\nDescripción: " + this.complex[i][j].getDescripcionContenido());
                }
            }
        }

    }

    public  int contenedoresPais(String país) {
        int cantidad = 0;

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] != null && this.complex[i][j].getPaisProcedencia().equals(país)) {
                    ++cantidad;
                }
            }
        }

        return cantidad;
    }
}
