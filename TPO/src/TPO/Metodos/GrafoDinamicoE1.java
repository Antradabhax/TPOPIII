package TPO.Metodos;

import TPO.Intefaz.InterfazConjunto;
import TPO.Intefaz.InterfazGrafo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GrafoDinamicoE1 implements InterfazGrafo {
    class NodoArista {
        Date inicio;

        Date fin;
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    class NodoGrafo {
        String nodo;
        NodoArista arista;
        NodoGrafo sigNodo;
    }

    NodoGrafo origen;

    public void InicializarGrafo() {
        origen = null;
    }

    public void AgregarVertice(String v) {
        NodoGrafo aux = new NodoGrafo();
        aux.nodo = v;
        aux.arista = null;
        aux.sigNodo = origen;
        origen = aux;
    }

    private void EliminarAristaNodo(NodoGrafo nodo, String v) {
        NodoArista aux = nodo.arista;
        if (aux != null) {
            if (aux.nodoDestino.nodo == v) {
                nodo.arista = aux.sigArista;
            } else {
                while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
                    aux = aux.sigArista;
                if (aux.sigArista != null)
                    aux.sigArista = aux.sigArista.sigArista;
            }
        }
    }

    public void EliminarVertice(String v) {
        if (origen.nodo == v)
            origen = origen.sigNodo;
        NodoGrafo aux = origen;
        while (aux != null) {
            this.EliminarAristaNodo(aux, v);
            if (aux.sigNodo != null && aux.sigNodo.nodo == v) {
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private NodoGrafo Vert2Nodo(String v) {
        NodoGrafo aux = origen;
        while(aux !=null && aux.nodo != v)
            aux = aux.sigNodo;
        return aux;
    }

    public void AgregarAristas(String v1, String v2, Date inicio, Date fin) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoGrafo n2 = Vert2Nodo(v2);
        NodoArista aux = new NodoArista();
        aux.inicio = inicio;
        aux.fin = fin;
        aux.nodoDestino = n2;
        aux.sigArista = n1.arista;
        n1.arista = aux;
    }

    public void EliminarArista(String v1, String v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1, v2);
    }

    public List<Date> FechaArista(String v1, String v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux.nodoDestino.nodo != v2){
            aux = aux.sigArista;
        }
        List<Date> A = new ArrayList<Date>();
        A.set(0, aux.inicio);
        A.set(1, aux.fin);
        return A;
    }

    public boolean ExisteArista(String v1, String v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while (aux != null && aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;
        return (aux != null);
    }

    public InterfazConjunto Vertices() {
        InterfazConjunto C = new ConjuntoDE1();
        C.InicializarConjunto();
        NodoGrafo aux = origen;
        while (aux != null) {
            C.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return C;
    }
}
