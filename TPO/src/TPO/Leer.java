package TPO;
import java.io. * ;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Leer {
    public static final String delimiter = ",";
    public static List<Vuelos> read(String csvFile) {
        List<Vuelos> Vuelos = null;
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            Vuelos = new ArrayList<Vuelos>();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                Vuelos vuelo = new Vuelos();
                vuelo.setNumeroVuelo(tempArr[0]);
                vuelo.setAeropuertoOrigen(tempArr[1]);
                vuelo.setAeropuertoDestino(tempArr[2]);
                vuelo.setInicio(tempArr[3]);
                vuelo.setFin(tempArr[4]);
                Vuelos.add(vuelo);
            }
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return Vuelos;
    }

    public static TripulacionesOrigen readTripulaciones(String csvFile) {
        TripulacionesOrigen TO = new TripulacionesOrigen();
        String O = " ";
        try {
            int i =0;
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br2 = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br2.readLine()) != null) {
                i++;
                tempArr = line.split(delimiter);
                O = tempArr[1];
            }
            br2.close();
            TO.setTripulaciones(i);
            TO.setOrigen(O);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return TO;
    }

}
