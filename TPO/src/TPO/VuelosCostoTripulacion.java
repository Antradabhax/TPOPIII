package TPO;

import java.util.ArrayList;
import java.util.List;

public class VuelosCostoTripulacion {
    Vuelos[][] VuelosTomados;
    int CostoTripulacion;

    public void InicializarVuelosCostoTripulacion(int CantTrip){
        VuelosTomados = new Vuelos[CantTrip][];
        CostoTripulacion = 0;
    }

    public Vuelos[][] getVuelosTomados() {
        return VuelosTomados;
    }

    public void setVuelosTomados(Vuelos[][] vuelosTomados) {
        VuelosTomados = vuelosTomados;
    }

    public int getCostoTripulacion() {
        return CostoTripulacion;
    }

    public void setCostoTripulacion(int costoTripulacion) {
        CostoTripulacion = costoTripulacion;
    }
}
