package TPO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Vuelos {
    private String NumeroVuelo;
    private String AeropuertoOrigen;
    private String AeropuertoDestino;
    private Date inicio;
    private Date fin;

    public Vuelos() {
        this.NumeroVuelo = "";
        this.AeropuertoOrigen = "";
        this.AeropuertoDestino = "";
        this.inicio = null;
        this.fin = null;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date calDate = format.parse(inicio);
        System.out.println(calDate.getHours() + ":" + calDate.getMinutes());
        this.inicio = calDate;
    }

    public void setInicioConDate(Date inicio) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(String fin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date calDate = format.parse(fin);
        System.out.println(calDate.getHours() + ":" + calDate.getMinutes());
        this.fin = calDate;
    }

    public void setFinConDate(Date fin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.fin = fin;
    }

    public String getAll(){
        return getNumeroVuelo() + " " + getAeropuertoOrigen() + " " + getAeropuertoDestino() + " " + getInicio() + " " + getFin();
    }

}
