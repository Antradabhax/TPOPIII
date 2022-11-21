package TPO;
import TPO.Intefaz.InterfazConjunto;
import TPO.Intefaz.InterfazGrafo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BacktrackingVuelos() {
   public static VuelosCostoTripulacion BV(InterfazGrafo GVuelos, String AeropuertoOrigen, List<Vuelos> VuelosTomados, int CostoA, int MejorCosto, int largoA, int MejorLargo, String AeropuetoActual, VuelosCostoTripulacion MejorSolucion, VuelosCostoTripulacion SolucionActual, Date HoraActual) throws ParseException {

           if (AeropuetoActual == AeropuertoOrigen && largoA <0){
               SolucionActual.setVuelosTomados(VuelosTomados);
               SolucionActual.setCostoTripulacion(CostoA);
               if (largoA >= MejorLargo && CostoA < MejorCosto){
               }

           }else{
               InterfazConjunto Aeropuertos = GVuelos.Vertices();
               List<Vuelos> Posibles = new ArrayList<Vuelos>();
               for (int i = 0; i < Aeropuertos.Size();i++){
                   if (GVuelos.ExisteArista(AeropuetoActual, Aeropuertos.Elegir())){
                       Posibles.add(GVuelos.VueloArista(AeropuetoActual,Aeropuertos.Elegir()));
                       }
                   Aeropuertos.Sacar(Aeropuertos.Elegir());
                   }
               for (int l = 0; l < Posibles.size(); l++){
                   if (BacktrackingVuelos.getDateDiff(Posibles.get(l).getInicio(), HoraActual)+2 < CostoA){
                       
                   }
               }
           }
       return MejorSolucion;
   }

    public static long getDateDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
