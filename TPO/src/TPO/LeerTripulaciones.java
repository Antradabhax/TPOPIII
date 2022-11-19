package TPO;
import java.io. * ;
import java.util.ArrayList;
import java.util.List;

public class Leer {
    public static final String delimiter = ",";
    public static int read(String csvFile) {
        try {
            int contador = 0;
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
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
