package TPO;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BacktrackingVuelos {


    public static Resultado Backtracking(String PuntoDeInicio, Resultado ResultadoParcial, Resultado mejorResultado, List<Vuelos> ListaDeVuelos, int puntero/*ordenada de menor a mayor por tiempo*/){


        if (todosLosVuelosEstanAsignados(ResultadoParcial,ListaDeVuelos) && EstanTodasLasTripulacionesEnOrigen(ResultadoParcial, PuntoDeInicio)){
            if (esMejorSolucion(ResultadoParcial,mejorResultado)){
                mejorResultado.CopiaTripulaciones = ResultadoParcial.CopiaTripulaciones;

            }//Cuando Todas Las Tripulaciones Estan En El Origen
        }else if (!todosLosVuelosEstanAsignados(ResultadoParcial,ListaDeVuelos)){

            List<Asignacion> Asignaciones = generarAsignValidas(ResultadoParcial.CopiaTripulaciones, ListaDeVuelos.get(puntero));

            for (Asignacion A : Asignaciones) {

                for (Tripulacion t: ResultadoParcial.CopiaTripulaciones){
                    if (t.IdentificadorTripulacion == A.Tripulacion){
                        if (t.VuelosAsignados.isEmpty()){
                            if (Objects.equals(A.VueloAsignado.getAeropuertoOrigen(), PuntoDeInicio)){
                                Resultado ResultadoParcialCopia = new Resultado();//para que cada asignacion tenga su propia lista de vuelos tomados por las tripulaciones
                                ResultadoParcialCopia.copiar(ResultadoParcial);//generamos una copia del resultado que contiene una copia de la lista de tripulaciones
                                ResultadoParcialCopia.agregar(A, A.Tripulacion);//AGREGO EL VUELO A ASIGNAR A LOS VUELOS ASIGNADOS A LA TRIPULACION EN ESPECIFICO
                                mejorResultado = Backtracking(PuntoDeInicio,ResultadoParcialCopia,mejorResultado,ListaDeVuelos,puntero+1);
                            }
                        }else if (Objects.equals(t.VuelosAsignados.get(t.VuelosAsignados.size() - 1).getAeropuertoDestino(), A.VueloAsignado.getAeropuertoOrigen())){
                            if (t.VuelosAsignados.get(t.VuelosAsignados.size()-1).getFin().plusHours(2).isBefore(A.VueloAsignado.getInicio()) || t.VuelosAsignados.get(t.VuelosAsignados.size()-1).getFin().plusHours(2).equals(A.VueloAsignado.getInicio())){
                                Resultado ResultadoParcialCopia = new Resultado();//para que cada asignacion tenga su propia lista de vuelos tomados por las tripulaciones
                                ResultadoParcialCopia.copiar(ResultadoParcial);//generamos una copia del resultado que contiene una copia de la lista de tripulaciones
                                ResultadoParcialCopia.agregar(A, A.Tripulacion);//AGREGO EL VUELO A ASIGNAR A LOS VUELOS ASIGNADOS A LA TRIPULACION EN ESPECIFICO
                                mejorResultado = Backtracking(PuntoDeInicio,ResultadoParcialCopia,mejorResultado,ListaDeVuelos,puntero+1);

                            }
                        }
                    }
                }



            }



        }
        return mejorResultado;
    }

    private static boolean todosLosVuelosEstanAsignados(Resultado resultadoParcial, List<Vuelos> ListaVuelos) {
        List<Vuelos> VuelosRealizadosPorTrip = new ArrayList<>();
        for (Tripulacion T:resultadoParcial.CopiaTripulaciones){
            VuelosRealizadosPorTrip.addAll(T.VuelosAsignados);
        }
        return new HashSet<>(VuelosRealizadosPorTrip).containsAll(ListaVuelos);
    }

    /*private static List<Vuelos> generarListaVuelosPosiblesATomar(LocalDateTime TiempoActual, String PuntoActual, List<Tripulacion> copiaTripulaciones, List<Vuelos> ListaVuelos) {
        List<Vuelos> ListaVuelosPosibles = new ArrayList<>();
        for (Vuelos v: ListaVuelos) {//veo todos los vuelos que salen del punto en el que estamos
            if (Objects.equals(v.getAeropuertoOrigen(), PuntoActual)) {
                if ((TiempoActual.isBefore(v.getInicio()) || TiempoActual.equals(v.getInicio()))){
                    ListaVuelosPosibles.add(v);
                }
            }
        }
        for (Tripulacion T: copiaTripulaciones) {//vemos si esos vuelos no estan ya asignados
            ListaVuelosPosibles.removeAll(T.VuelosAsignados);
        }

        return ListaVuelosPosibles;
    }*/


    public static List<Asignacion> generarAsignValidas( List<Tripulacion> CopiaTripulaciones, Vuelos vuelo){
        List<Asignacion> Asignaciones = new ArrayList<>();
            for (Tripulacion T: CopiaTripulaciones) {
                Asignacion A = new Asignacion();
                A.setTripulacion(T.IdentificadorTripulacion);
                A.setVueloAsignado(vuelo);
                Asignaciones.add(A);
            }

        return Asignaciones;
    }

    private static boolean esMejorSolucion(Resultado resultadoParcial, Resultado mejorResultado) {
        return resultadoParcial.getCosto() < mejorResultado.getCosto();
    }

    public static boolean EstanTodasLasTripulacionesEnOrigen(Resultado ResultadoParcial, String PuntoDeInicio){
        boolean Validacion = true;
        for (Tripulacion Trip: ResultadoParcial.CopiaTripulaciones) {
            if (!Trip.VuelosAsignados.isEmpty()) {
                Vuelos UltimoVueloDeTrip = Trip.VuelosAsignados.get(Trip.VuelosAsignados.size() - 1);
                if (!Objects.equals(UltimoVueloDeTrip.getAeropuertoDestino(), PuntoDeInicio)) {
                    Validacion = false;
                    break;
                }
            }
        }
        return Validacion;
    }

    /*public static void CheckearSolucion(Resultado resultado, List<Tripulacion> ListaTripulaciones){
        for (int i = 0; i < ListaTripulaciones.size()-1; i ++){
            if ListaTripulaciones[i].
        }
    }*/

}
