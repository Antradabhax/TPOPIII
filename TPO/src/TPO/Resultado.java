package TPO;

import java.util.ArrayList;
import java.util.List;

public class Resultado {

    int Costo;

    List<Tripulacion> CopiaTripulaciones;

    public void setCosto(int NuevoCosto) {
        this.Costo = NuevoCosto;
    }

    public void setCopiaTripulaciones(List<Tripulacion> ListaTripulaciones){
        List<Tripulacion> CopiaTripulaciones = new ArrayList<>(ListaTripulaciones) {
        };
    }
}
