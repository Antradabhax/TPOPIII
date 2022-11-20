package TPO.Intefaz;

import java.util.Date;
import java.util.List;

public interface InterfazGrafo {
    public void InicializarGrafo ();
    public void AgregarVertice (String x);
    public void EliminarVertice (String x);
    public void AgregarAristas (String x, String y, Date w, Date z);
    public void EliminarArista (String x, String y);
    public List<Date> FechaArista (String x, String y);
    public boolean ExisteArista (String x, String y);
    public InterfazConjunto Vertices();
}
