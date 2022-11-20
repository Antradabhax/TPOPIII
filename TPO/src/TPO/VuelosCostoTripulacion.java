package TPO;

import java.util.ArrayList;
import java.util.List;

public class VuelosCostoTripulacion {
    List<Vuelos> VuelosTomados;
    int CostoTripulacion;

    public void InicializarVuelosCostoTripulacion(){
        VuelosTomados = new ArrayList<Vuelos>();
        CostoTripulacion = 0;
    }

    public List<Vuelos> getVuelosTomados() {
        return VuelosTomados;
    }

    public void setVuelosTomados(List<Vuelos> vuelosTomados) {
        VuelosTomados = vuelosTomados;
    }

    public int getCostoTripulacion() {
        return CostoTripulacion;
    }

    public void setCostoTripulacion(int costoTripulacion) {
        CostoTripulacion = costoTripulacion;
    }
}
