package TPO.Intefaz;

import TPO.Vuelos;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface InterfazGrafo {
    public void InicializarGrafo ();
    public void AgregarVertice (String x);
    public void EliminarVertice (String x);
    public void AgregarAristas (String x, String y, Vuelos Vuelo);
    public void EliminarArista (String x, String y);
    public Vuelos VueloArista (String x, String y) throws ParseException;
    public boolean ExisteArista (String x, String y);
    public InterfazConjunto Vertices();
}
