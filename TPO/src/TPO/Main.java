package TPO;

import TPO.Intefaz.InterfazGrafo;
import TPO.Metodos.GrafoDinamicoE1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //csv file to read
        String csvFile = "C:\\Users\\Marcos\\Downloads\\Vuelos.csv";
        List<Vuelos> v = Leer.read(csvFile);
        String csvFile2 = "C:\\Users\\Marcos\\Downloads\\Tripulaciones.csv";
        TripulacionesOrigen Tripulaciones = Leer.readTripulaciones(csvFile2);
        InterfazGrafo GV = CrearGrafoVuelos(v);
        Vuelos[][] VuelosResultado = BacktrackingVuelos.BV(GV,Tripulaciones.getTripulaciones(),Tripulaciones.getOrigen());
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
