package TPO;

import java.util.ArrayList;
import java.util.List;

public class VuelosCostoTripulacion {
    List<String> VuelosTomados;
    int CostoTripulacion;

    public void InicializarVuelosCostoTripulacion(){
        VuelosTomados = new ArrayList<String>();
        CostoTripulacion = 0;
    }

    public List<String> getVuelosTomados() {
        return VuelosTomados;
    }

    public void setVuelosTomados(List<String> vuelosTomados) {
        VuelosTomados = vuelosTomados;
    }

    public int getCostoTripulacion() {
        return CostoTripulacion;
    }

    public void setCostoTripulacion(int costoTripulacion) {
        CostoTripulacion = costoTripulacion;
    }
}
