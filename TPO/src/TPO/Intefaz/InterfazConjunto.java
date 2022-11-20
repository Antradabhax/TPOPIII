package TPO.Intefaz;

public interface InterfazConjunto {
    void InicializarConjunto();
    void Agregar(String x);
    String Elegir();
    boolean ConjuntoVacio();
    void Sacar(String x);
    boolean Pertenece(String x);
}
