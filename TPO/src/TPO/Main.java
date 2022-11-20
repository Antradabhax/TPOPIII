package TPO;

import TPO.Intefaz.InterfazGrafo;
import TPO.Metodos.GrafoDinamicoE1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csvFile = "Vuelos.csv";
        List<Vuelos> v = Leer.read(csvFile);
        String csvFile2 = "Tripulaciones.csv";
        TripulacionesOrigen Tripulaciones = Leer.readTripulaciones(csvFile2);//DE DONDE SALE CADA TRIPULACION Y CUANTAS SON

        InterfazGrafo GV = CrearGrafoVuelos(v);//GRAFO DE AEROPUERTOS

        List<String> AeropuertosActuales = new ArrayList<String>();//LISTA DE AEROPUERTOS ACTUALES

        Vuelos[][] Viajes = new Vuelos[Tripulaciones.getTripulaciones()][];//DEVOLUCION DEL CODIGO

        for (int i = 0; i< Tripulaciones.getTripulaciones();i++){
            AeropuertosActuales.add(Tripulaciones.getOrigen());
        }//relleno de aeropuertos de origen de cada tripulacion

        Vuelos[][] VuelosResultado = BacktrackingVuelos.BV(GV,Tripulaciones.getTripulaciones(),Tripulaciones.getOrigen(),AeropuertosActuales,Viajes);
        //EL CODIGO DE BACKTRACKING DEVUELVE UNA MATRIZ DE VUELOS
        //PODRIA REQUERIR CAMBIOS...


    }

    private static InterfazGrafo CrearGrafoVuelos(List<Vuelos> v) {
        InterfazGrafo GV = new GrafoDinamicoE1();
        GV.InicializarGrafo();
        for (int i = 0; i< v.size();i++){
            Vuelos VUELO = v.get(i);
            if (!GV.Vertices().Pertenece(VUELO.getAeropuertoOrigen())){
                GV.AgregarVertice(VUELO.getAeropuertoOrigen());
            }
            if (!GV.Vertices().Pertenece(VUELO.getAeropuertoDestino())){
                GV.AgregarVertice(VUELO.getAeropuertoDestino());
            }
            for (Vuelos vuelos : v) {
                if (vuelos.getAeropuertoOrigen() == VUELO.getAeropuertoOrigen()) {
                    GV.AgregarAristas(VUELO.getAeropuertoOrigen(), VUELO.getAeropuertoDestino(), VUELO.getInicio(), VUELO.getFin());
                }
            }
        }
        return GV;
    }
}
