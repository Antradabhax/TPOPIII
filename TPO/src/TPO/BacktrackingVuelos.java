package TPO;
import TPO.Intefaz.InterfazConjunto;
import TPO.Intefaz.InterfazGrafo;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BacktrackingVuelos {
    public static VuelosCostoTripulacion BV(InterfazGrafo GVuelos,List<Vuelos> ListaVuelosCompleta, String AeropuertoOrigen, , List<Vuelos> VuelosTotales, int CostoA, int MejorCostoPorTripulacion, int CostoTotal, int largoA, String AeropuetoActual, VuelosCostoTripulacion MejorSolucion, LocalDateTime HoraActual, List<Tripulacion> Tripulaciones) throws ParseException {

        //podemos pasar la lista de todos los vuelos
        while (!ListaVuelosCompleta.isEmpty()){
            GenerarHijos(GVuelos,AeropuetoActual,Tripulaciones,VuelosTotales);

        }
        return MejorSolucion;//cuando no hay mas vuelos libres
    }

    public static List<Asignacion> GenerarHijos(InterfazGrafo G, String AeropuetoActual, List<Tripulacion> Tripulaciones, List<Vuelos> VuelosTotales) throws ParseException {
        List<Vuelos> Posib = PosiblesVuelosATomar( G, AeropuetoActual, Tripulaciones, VuelosTotales);
        List<Asignacion> hijos = new ArrayList<>();
        List<Vuelos> vuelosAUX = new ArrayList<>();
        vuelosAUX.addAll(VuelosTotales);
        for (Vuelos vuelo: Posib){
            for (Tripulacion T: Tripulaciones){
                 if (T.PuedoHacerVuelo(vuelo)){//ESTOY PARADO EN EL MISMO AEROPUERTO
                     Asignacion Asig = new Asignacion();
                     Asig.setTripulacion(Tripulaciones.indexOf(T));
                     Asig.setVueloAsignado(vuelo);
                     vuelosAUX.remove(vuelo);
                     hijos.add(Asig);
                 }else if (){//ESTOY PARADO EN DISTINTOS AEROPUERTOS Y TENGO QUE HACER EL CAMINO

                 }
            }
        }
    }

    public static List<Vuelos> PosiblesVuelosATomar(InterfazGrafo G, String AeropuetoActual, List<Tripulacion> Tripulaciones, List<Vuelos> VuelosTotales) throws ParseException {
        InterfazConjunto Aeropuertos = G.Vertices();
        List<Vuelos> Posibles = new ArrayList<Vuelos>();
        boolean utilizado = false;
        for (int j = 0; j<Aeropuertos.Size(); j++){
            for (Tripulacion T: Tripulaciones) {
                for (Vuelos vuelo : T.VuelosAsignados) {
                    if (vuelo == G.VueloArista(AeropuetoActual, Aeropuertos.Elegir())) {
                        utilizado = true;
                    }
                }
            }
            if (!utilizado) {
                Posibles.add(G.VueloArista(AeropuetoActual, Aeropuertos.Elegir()));
            }
            Aeropuertos.Sacar(Aeropuertos.Elegir());
        }
        return Posibles;
    }

    public boolean PuedoLlegar(String AeropuertoOrigen/*t2.origen*/, List<Vuelos> VuelosNoAsignados, String AeropuertoDestino/*vuelo.origen*/){
        /**/

        /*else if
        * caminoMasCorto COMO EL TSP*/

    }

}
