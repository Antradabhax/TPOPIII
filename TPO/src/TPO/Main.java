package TPO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //csv file to read
        String csvFile = "C:\\Users\\Marcos\\Downloads\\Vuelos.csv";
        List<Vuelos> v = Leer.read(csvFile);
        for (Vuelos vuelos : v) {
            System.out.println(vuelos.getAll());
        }

    }
}
