package Clases;
import java.io.Serializable;
import java.net.IDN;

public class Contenedor implements Serializable {

    //informacion asociada a un contenedor
    private int ID;
    private int peso;
    private String paisProcedencia;
    private boolean inspeccionado;
    private int prioridad;
    private String descripcionContenido;
    String limDescCont = descripcionContenido.substring(0, 100);
    private String empresaEnvia;
    String limEmpEnv = empresaEnvia.substring(0, 20);
    private String empresaRecibe;
    String limEmpRec = empresaRecibe.substring(0, 20);
    //atributos que hacen falta
    private int columna;
    //creamos un hub
    private Contenedor[][] hub;

    //constructores
    public Contenedor(int ID){
        if(ID < 0) ID = -ID; //si el id pasado es negativo se pone positivo
        this.ID = ID;
        this.prioridad = 3;
    }
    public Contenedor(int ID, int prioridad, int peso, String paísProcedencia, String descripción, String empresaEmisora, String empresaReceptora) {
        this.ID = ID;
        if (prioridad >= 0 && prioridad <= 3) {
            this.prioridad = prioridad;
        }

        if (peso >= 100) {
            this.peso = peso;
        }

        this.paisProcedencia = paísProcedencia;
        if (descripción.length() <= 100) {
            this.descripcionContenido = descripción;
        }

        if (empresaEmisora.length() <= 20) {
            this.empresaEnvia = empresaEmisora;
        }

        if (empresaReceptora.length() <= 20) {
            this.empresaRecibe= empresaReceptora;
        }

    }

    //setters y getters
    public void setID(int ID){
        this.ID = ID;
    }
    public int getID(){
        return this.ID;
    }
    public void setPeso(int peso){
        if(this.peso > 0) this.peso = peso;
    }
    public int getPeso(){
        return this.peso;
    }
    public void setPaisProcedencia(String paisProcedencia){
        this.paisProcedencia = paisProcedencia;
    }
    public String getPaisProcedencia(){
        return this.paisProcedencia;
    }
    public void setInspeccionado(boolean inspeccionado){
        this.inspeccionado = inspeccionado;
    }
    public boolean isInspeccionado(){ //getter de un boolean
        return this.inspeccionado;
    }
    public void setPrioridad(int prioridad){
        if(this.prioridad >= 1 && this.prioridad <=3) this.prioridad = prioridad;
    }
    public int getPrioridad(){
        return this.prioridad;
    }
    public void setDescripcionContenido(String descripcionContenido){
        this.descripcionContenido = descripcionContenido;
    }
    public String getDescripcionContenido(){
        return this.descripcionContenido;
    }
    public void setEmpresaEnvia(String empresaEnvia){
        this.empresaEnvia = empresaEnvia;
    }
    public String getEmpresaEnvia(){
        return this.empresaEnvia;
    }
    public void setEmpresaRecibe(String empresaRecibe) {
        this.empresaRecibe = empresaRecibe;
    }
    public String getEmpresaRecibe() {
        return empresaRecibe;
    }

    //metodo toString
    public String toString(){
        String s= "";
        s+= "ID: " + this.ID + "\n";
        s+= "Peso: " + this.peso + "\n";
        s+= "Pais procedencia: " + this.paisProcedencia + "\n";
        s+= "Prioridad: " + this.prioridad + "\n";
        s+= "Descripcion contenido: " + this.descripcionContenido + "\n";
        s+= "Empresa que lo envia: " + this.empresaEnvia + "\n";
        s+= "Empresa que lo recibe: " + this.empresaRecibe + "\n";
        if(inspeccionado){
            s+="Inspeccionado" + "\n";
        }else{
            s+="No inspeccionado" + "\n";
        }
        return s;
    }

    //metodo apilar
    /*public  void apilar(Contenedor c){
        if(c != null){
            int p;
            int col;
            p = c.getPrioridad();
            if(p == 1 || p == 2){
                col = p-1; //se resta 1 porque las columnas empiezan en 0
                for(int i = hub.length-1; i >=0; i--){
                    hub[i][col] = c;
                    return;
                }

            }
        } else{
            for(int j = 2; j < hub[0].length;j++)
                for(int i= hub.length-1; i >=0; i--){
                    hub[i][j]=c;
                    return;
                }
        }
    }

    //metodo desapilar
    public Contenedor desapilar(int columna){
        if(columna<0 || columna >= hub[0].length) return null;
        for (int i = 0; i <= hub.length ; i++) {
            if(hub[i][columna] != null){
                Contenedor aux = hub[i][columna];
                hub[i][columna] = null; //se ha quitado el contenedor
                return aux;
            }
        }
        return null;
    }

    //metodo para mostrar todos los datos de un contenedor a partir de su numero de ID
    public void mostrarDatos(Contenedor c, int ID){
        for (int i = 0; i < hub.length; i++) {
            for (int j = 0; j < hub[i].length; j++) {
                if(this.ID == hub[i][j].ID) {
                    System.out.println(c.toString());
                }
                if(this.ID != hub[i][j].ID){
                    System.out.println("El contenedor no esta en el hub");
                }
            }
        }
    }

    //metodo para calcular la cantidad de contenedores procedentes de un determinado país

    public void cantidadContenedores(String pais){
        int cont=0;
        for (int i = 0; i < hub.length; i++) {
            for (int j = 0; j < hub[i].length; j++) {
                if(this.paisProcedencia == hub[i][j].paisProcedencia) {
                    cont++;
                }
            }
        }
        System.out.println("Hay " + cont + "procedentes de " + paisProcedencia);
    }*/


}
