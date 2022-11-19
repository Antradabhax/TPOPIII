package TPO;
import java.io. * ;
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
                Vuelos vuelo = new Vuelos(tempArr[0], tempArr[1], tempArr[2], tempArr[3], tempArr[4]);
                Vuelos.add(vuelo);
            }
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return Vuelos;
    }

    public static int readTripulaciones(String csvFile){
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            int contador = 0;
            while ((line = br.readLine()) != null) {
                contador++;
            }
            br.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return contador;
    }

}
