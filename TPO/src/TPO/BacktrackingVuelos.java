package TPO;
import TPO.Intefaz.InterfazConjunto;
import TPO.Intefaz.InterfazGrafo;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BacktrackingVuelos {
    public static VuelosCostoTripulacion BV(InterfazGrafo GVuelos,List<Vuelos> ListaVuelosCompleta, String AeropuertoOrigen, Vuelos[][] VuelosTomadosporTrip/*HACER QUE SEA UNA MATRIZ DE 1 */, Vuelos[][] VuelosUtilizados, int CostoA, int MejorCostoPorTripulacion, int CostoTotal, int largoA, String AeropuetoActual, VuelosCostoTripulacion MejorSolucion, LocalDateTime HoraActual, int TripulacionActual, int CantTrip) throws ParseException {

        //podemos pasar la lista de todos los vuelos
        while (!ListaVuelosCompleta.isEmpty()){
                if (CostoA < MejorCostoPorTripulacion) {
                    MejorCostoPorTripulacion = CostoA;
                    //AGREGAR TODOS LOS VUELOS TOMADOS POR LA TRIPULACION A LOS VUELOS UTILIZADOS
                    System.arraycopy(VuelosTomadosporTrip[0], 0, VuelosUtilizados[TripulacionActual], 0, VuelosTomadosporTrip[0].length);
                    //COSTOTOTAL SUMADO AL COSTO ACTUAL
                    CostoTotal += CostoA;

                    //COLOCADO DE RESULTADO EN MEJOR SOLUCION
                    MejorSolucion.setVuelosTomados(VuelosUtilizados);
                    MejorSolucion.setCostoTripulacion(CostoTotal);

                    //INICIALIZADO DE VARIABLES VACIAS
                    Vuelos[][] T = new Vuelos[0][];


                    //RECURSIVIDAD
                    MejorSolucion = BV(GVuelos, AeropuertoOrigen, T, VuelosUtilizados, 0, 0, CostoTotal/*RECIBE CANTIDAD DE HORAS*/, 0, AeropuertoOrigen, MejorSolucion, T3, TripulacionActual + 1, CantTrip);

                }

            } else {//REALIZADO POR CADA TRIPULACION, BUSQUEDA DE VUELOS

                //BUSQUEDA DE VUELOS DE SALIDA
                List<Vuelos> Posibles = PosiblesVuelosATomar(GVuelos, AeropuetoActual, CantTrip, VuelosUtilizados);

                int CostoPorVuelo = Integer.MAX_VALUE; //INICIALIZAMOS UNA VARIABLE PARA QUE TOME EL VUELO QUE CUESTE MENOS Y NO TOME TODOS
                Vuelos VueloMenorCosto = null;
                for (Vuelos posible : Posibles) {
                    int time_difference = (int) ChronoUnit.HOURS.between(posible.getInicio(), HoraActual);//DIFERENCIA DE TIEMPO
                    if (time_difference < CostoPorVuelo) {//SI LA DIFERENCIA DE HORAS ES MENOR AL COSTOPORVUELO
                        CostoPorVuelo = time_difference;
                        VueloMenorCosto = posible;//TOMA EL MEJOR VUELO EL POSIBLE
                        //BUSCAR MEJOR COSTO
                    }
                    VuelosTomadosporTrip[0][(VuelosTomadosporTrip[0].length) - 1] = VueloMenorCosto;
                    MejorSolucion = BV(GVuelos, AeropuertoOrigen, VuelosTomadosporTrip, VuelosUtilizados, CostoA + CostoPorVuelo, MejorCostoPorTripulacion, CostoTotal/*RECIBE CANTIDAD DE HORAS*/, 0, AeropuertoOrigen, MejorSolucion, T3, TripulacionActual + 1, CantTrip);
                }
            }
        }
        return MejorSolucion;//cuando no hay mas vuelos libres
    }

    public static void GenerarHijos(InterfazGrafo G, String AeropuetoActual, List<Tripulacion> Tripulaciones, Vuelos[][] VuelosUtilizados) throws ParseException {
        List<Vuelos> Posib = PosiblesVuelosATomar( G, AeropuetoActual, Tripulaciones.size(), VuelosUtilizados);
        for (Vuelos vuelo: Posib){
            for (Tripulacion T: Tripulaciones){
                 if (T)
            }
        }
    }

    public static List<Vuelos> PosiblesVuelosATomar(InterfazGrafo G, String AeropuetoActual, int CantTrip, Vuelos[][] VuelosUtilizados) throws ParseException {
        InterfazConjunto Aeropuertos = G.Vertices();
        List<Vuelos> Posibles = new ArrayList<Vuelos>();
        boolean utilizado = false;
        for (int i = 0; i < Aeropuertos.Size(); i++) {
            if (G.ExisteArista(AeropuetoActual, Aeropuertos.Elegir())) {
                for (int j = 0; j < CantTrip; j++) {
                    for (int g = 0; g < VuelosUtilizados[j].length; j++) {
                        if (VuelosUtilizados[j][g] == G.VueloArista(AeropuetoActual, Aeropuertos.Elegir())) {
                            utilizado = true;
                        }
                    }
                }
                if (!utilizado) {
                    Posibles.add(G.VueloArista(AeropuetoActual, Aeropuertos.Elegir()));
                }
            }
            Aeropuertos.Sacar(Aeropuertos.Elegir());
        }
        return Posibles;
    }
}
