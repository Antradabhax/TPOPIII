package TPO;

public class Vuelos {
    private String NumeroVuelo;
    private String AeropuertoOrigen;
    private String AeropuertoDestino;
    private String inicio;
    private String fin;

    public Vuelos(String numeroVuelo, String aeropuertoOrigen, String aeropuertoDestino, String inicio, String fin) {
        NumeroVuelo = numeroVuelo;
        AeropuertoOrigen = aeropuertoOrigen;
        AeropuertoDestino = aeropuertoDestino;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getNumeroVuelo() {
        return NumeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        NumeroVuelo = numeroVuelo;
    }

    public String getAeropuertoOrigen() {
        return AeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        AeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return AeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        AeropuertoDestino = aeropuertoDestino;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getAll(){
        return getNumeroVuelo() + " " + getAeropuertoOrigen() + " " + getAeropuertoDestino() + " " + getInicio() + " " + getFin();
    }

}
