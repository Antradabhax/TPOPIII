package TPO;

import TPO.Intefaz.InterfazGrafo;
import TPO.Metodos.GrafoDinamicoE1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "Vuelos.csv";
        List<Vuelos> v = Leer.read(csvFile);
        String csvFile2 = "Tripulaciones.csv";
        TripulacionesOrigen Tripulaciones = Leer.readTripulaciones(csvFile2);//DE DONDE SALE CADA TRIPULACION Y CUANTAS SON

        List<Tripulacion> ListaTripulaciones = new ArrayList<>();
        for (int i = 0; i < Tripulaciones.getTripulaciones(); i++) {//la posicion el la lista es el identificador
            Tripulacion T = new Tripulacion();
            ListaTripulaciones.add(T);
        }

        BacktrackingVuelos (ListaTripulaciones, ListaVuelos)
    }
}