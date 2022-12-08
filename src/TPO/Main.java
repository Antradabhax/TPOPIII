package TPO;

import TPO.LecturaYDevolucion.Leer;
import TPO.LecturaYDevolucion.TripulacionesOrigen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "Vuelos.csv";
        List<Vuelos> v = Leer.read(csvFile);
        String csvFile2 = "Tripulaciones.csv";
        TripulacionesOrigen Tripulaciones = Leer.readTripulaciones(csvFile2);//DE DONDE SALE CADA TRIPULACION Y CUANTAS SON

        Resultado ResultadoParcial = new Resultado();
        Resultado mejorResultado = new Resultado();

        for (int i = 0; i < Tripulaciones.getCantTripulaciones(); i++) {//la posicion el la lista es el identificador
            List<Vuelos> VuelosAsignacion = new ArrayList<>();
            Tripulacion T = new Tripulacion(i,VuelosAsignacion);
            ResultadoParcial.CopiaTripulaciones.add(T);
        }

        LocalDateTime TiempoActual = v.get(0).getInicio();

        Resultado R = new Resultado();
        R = BacktrackingVuelos.Backtracking(Tripulaciones.getOrigen(),ResultadoParcial,mejorResultado,v,0);

        System.out.println("COSTO TOTAL DE CAMINOS TOMADOS: "+R.getCosto());
        for(Tripulacion t: R.CopiaTripulaciones){
            System.out.println("IDENTIFICACION TRIPULACION: "+t.getIdentificadorTripulacion());
            for (Vuelos vue: t.VuelosAsignados){
                System.out.println(vue.getAll());
            }
        }
    }
}