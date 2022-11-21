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

        InterfazGrafo GV = CrearGrafoVuelos(v);//GRAFO DE AEROPUERTOS

        int GastoTotal = 0;

        VuelosCostoTripulacion VuelosResultado = new VuelosCostoTripulacion();//INICIAMOS LA VARIABLE DE DEVOLUCION


        for (int i = 0; i<Tripulaciones.getTripulaciones();i++){
            VuelosResultado.InicializarVuelosCostoTripulacion(); //REINICIALIZAMOS EL OBJETO A VALORES SIN NADA Y 0
            VuelosResultado = BacktrackingVuelos.BV(GV,Tripulaciones.getOrigen(),VuelosResultado);
            //EL CODIGO DE BACKTRACKING DEVUELVE UN OBJETO QUE TIENE LOS VUELOS QUE TOMO LA TRIPULACION Y EL COSTO QUE PRESENTO LA TRIPULACION

            //MOSTRADO DE RESULTADO
            for (int j = 0; j< VuelosResultado.getVuelosTomados().size(); j++){
                System.out.print(VuelosResultado.getVuelosTomados().get(j) + " ");
                GV.EliminarArista(VuelosResultado.getVuelosTomados().get(j).getAeropuertoOrigen(),VuelosResultado.getVuelosTomados().get(j).getAeropuertoDestino());
            }
            System.out.println();
            System.out.println("El costo de esta tripulacion es de: "+ VuelosResultado.getCostoTripulacion());
        }

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
                    GV.AgregarAristas(VUELO.getAeropuertoOrigen(), VUELO.getAeropuertoDestino(), vuelos);
                }
            }
        }
        return GV;
    }
}