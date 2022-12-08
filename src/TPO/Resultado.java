package TPO;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Resultado {

    public List<Tripulacion> CopiaTripulaciones;

    public Resultado(){
        this.CopiaTripulaciones = new ArrayList<>();

    }

    public void setCopiaTripulaciones(List<Tripulacion> ListaTripulaciones){
        List<Tripulacion> nuevo = new ArrayList<>();

        if (ListaTripulaciones.size() != 0){
            for (Tripulacion t: ListaTripulaciones){
                List<Vuelos> v = new ArrayList<>(t.VuelosAsignados);
                Tripulacion t2 = new Tripulacion(t.IdentificadorTripulacion, v);
                nuevo.add(t2);
            }
            this.CopiaTripulaciones = nuevo;
        }



    }

    public void agregar(Asignacion A, int Identificador){
        for (Tripulacion T: CopiaTripulaciones){
            if (T.getIdentificadorTripulacion() == Identificador){
                T.agregarAlistaDeVuelos(A.VueloAsignado);
                break;//ASIGNAMOS EL VUELO A LA TRIPULACION Y LE CALCULAMOS EL NUEVO COSTO EN EL COSTO COMPLETO
            }
        }
    }

    public void copiar(Resultado R){
        setCopiaTripulaciones(R.CopiaTripulaciones);
    }

    public int getCosto(){
        int costo =0;
        for (Tripulacion t: CopiaTripulaciones){
            for (int i =0; i<t.VuelosAsignados.size()-1;i++){
                costo += (int) ChronoUnit.HOURS.between(t.VuelosAsignados.get(i).getFin().plusHours(2),t.VuelosAsignados.get(i+1).getInicio());
            }
        }

        if (CopiaTripulaciones.isEmpty()){
            costo = Integer.MAX_VALUE;
        }
        return costo;
    }
}

