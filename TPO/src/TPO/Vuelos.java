package TPO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Vuelos {
    private String NumeroVuelo;
    private String AeropuertoOrigen;
    private String AeropuertoDestino;
    private LocalDateTime inicio;
    private LocalDateTime fin;

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

    public LocalDateTime getInicio() {

        return inicio;
    }

    public void setInicio(String inicio) throws ParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.inicio = LocalDateTime.parse(inicio,format);
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(String fin) throws ParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.fin = LocalDateTime.parse(fin,format);
    }

    public String getAll(){
        return getNumeroVuelo() + " " + getAeropuertoOrigen() + " " + getAeropuertoDestino() + " " + getInicio() + " " + getFin();
    }

}
