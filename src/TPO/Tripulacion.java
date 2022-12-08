package TPO;

import java.time.LocalDateTime;
import java.util.List;

public class Tripulacion {

    public int IdentificadorTripulacion;

    public List<Vuelos> VuelosAsignados;

    public Tripulacion(int identificadorTripulacion, List<Vuelos> vuelosAsignados) {
        IdentificadorTripulacion = identificadorTripulacion;
        VuelosAsignados = vuelosAsignados;
    }


    public int getIdentificadorTripulacion() {
        return IdentificadorTripulacion;
    }

    public void agregarAlistaDeVuelos(Vuelos V){
        VuelosAsignados.add(V);
    }

}
