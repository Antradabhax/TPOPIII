package TPO;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Tripulacion {
    List<Vuelos> VuelosAsignados;

    public Tripulacion(){
        List<Vuelos> V = new ArrayList<>();
    }

    public void agregarVuelo(Vuelos Vuelo) {
        VuelosAsignados.add(Vuelo);
    }

    public boolean PuedoHacerVuelo(Vuelos vuelo) {
        return vuelo.getAeropuertoOrigen() == VuelosAsignados.get(VuelosAsignados.size() - 1).getAeropuertoDestino();
    }

    public int CostoTripulacion(){
        int Costo = 0;
        for (int i = 0; i< VuelosAsignados.size(); i++){
            int a = (int) ChronoUnit.HOURS.between(VuelosAsignados.get(i+1).getInicio(),VuelosAsignados.get(i).getFin());

            if (a !=2){
             Costo+= a-2;
            }

        }
        return Costo;
    }
}
