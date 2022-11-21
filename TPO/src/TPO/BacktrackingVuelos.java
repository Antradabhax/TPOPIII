package TPO;
import TPO.Intefaz.InterfazConjunto;
import TPO.Intefaz.InterfazGrafo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BacktrackingVuelos {
   public static VuelosCostoTripulacion BV(InterfazGrafo GVuelos, String AeropuertoOrigen, Vuelos[][] VuelosTomadosporTrip/*HACER QUE SEA UNA MATRIZ DE 1 */, Vuelos[][] VuelosUtilizados, int CostoA, int MejorCostoPorTripulacion, int CostoTotal, int largoA, String AeropuetoActual, VuelosCostoTripulacion MejorSolucion, Date HoraActual, int TripulacionActual, int CantTrip) throws ParseException {

           if (AeropuetoActual == AeropuertoOrigen && largoA <0){//ENTRE TODAS LAS TRIPULACIONES
               if (CostoA < MejorCostoPorTripulacion){
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
                   Date T3 = new Date();
                   T3.setTime(0);

                   //RECURSIVIDAD
                  MejorSolucion = BV(GVuelos, AeropuertoOrigen,T,VuelosUtilizados,0,0,CostoTotal/*RECIBE CANTIDAD DE HORAS*/,0, AeropuertoOrigen, MejorSolucion, T3, TripulacionActual+1, CantTrip);
               }

           }else{//REALIZADO POR CADA TRIPULACION, BUSQUEDA DE VUELOS

               //BUSQUEDA DE VUELOS DE SALIDA
               InterfazConjunto Aeropuertos = GVuelos.Vertices();
               List<Vuelos> Posibles = new ArrayList<Vuelos>();
               boolean utilizado = false;
               for (int i = 0; i < Aeropuertos.Size();i++){
                   if (GVuelos.ExisteArista(AeropuetoActual, Aeropuertos.Elegir())){
                       for (int j = 0; j < CantTrip; j++) {
                           for (int g = 0; g < VuelosUtilizados[j].length;j++) {
                               if (VuelosUtilizados[j][g] == GVuelos.VueloArista(AeropuetoActual, Aeropuertos.Elegir())){
                                   utilizado = true;
                               }
                           }
                       }
                       if (!utilizado){
                           Posibles.add(GVuelos.VueloArista(AeropuetoActual,Aeropuertos.Elegir()));
                       }
                   }
                   Aeropuertos.Sacar(Aeropuertos.Elegir());
               }

               int CostoPorVuelo = Integer.MAX_VALUE; //INICIALIZAMOS UNA VARIABLE PARA QUE TOME EL VUELO QUE CUESTE MENOS Y NO TOME TODOS
               Vuelos VueloMenorCosto = null;
               for (Vuelos posible : Posibles) {
                   long time_difference = BacktrackingVuelos.getDateDiff(posible.getInicio(), HoraActual);//DIFERENCIA DE TIEMPO
                   long hours_difference = (time_difference / (1000*60*60)) % 24;//DIFERENCIA DE TIEMPO EN HORAS
                   if ((int)hours_difference < CostoPorVuelo){//SI LA DIFERENCIA DE HORAS ES MENOR AL COSTOPORVUELO
                       VueloMenorCosto = posible;//TOMA EL MEJOR VUELO EL POSIBLE
                       if (hours_difference>1){
                           CostoPorVuelo = hours_difference
                       }
                   }
                   VuelosTomadosporTrip[0][(VuelosTomadosporTrip[0].length)-1] = VueloMenorCosto;
                   MejorSolucion = BV(GVuelos, AeropuertoOrigen,VuelosTomadosporTrip,VuelosUtilizados,CostoA,0,CostoTotal/*RECIBE CANTIDAD DE HORAS*/,0, AeropuertoOrigen, MejorSolucion, T3, TripulacionActual+1, CantTrip);


               }
           }
       return MejorSolucion;
   }

    public static long getDateDiff(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }
}
