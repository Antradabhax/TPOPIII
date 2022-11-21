package TPO.Metodos;

import TPO.Intefaz.InterfazConjunto;

public class ConjuntoDE1 implements InterfazConjunto {
    private class Nodo{
        String info;
        Nodo sig;
    }

    private Nodo c;

    public void InicializarConjunto() {
        c = null;
    }

    public String Elegir() {
        return c.info;
    }

    public void Sacar(String x) {
        if(c != null) {
            if (c.info == x) {
                c = c.sig;
            }
        }
        else {
            Nodo aux = c;
            while (aux.sig != null && aux.sig.info != x)
                aux = aux.sig;
            if (aux.sig != null) {
                aux.sig = aux.sig.sig;
            }
        }
    }

    public void Agregar(String x) {
        if (!this.Pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.sig = c;
            c = nuevo;
        }
    }

    public boolean Pertenece(String x) {
        Nodo aux = c;
        while(aux != null && aux.info != x)
            aux = aux.sig;
        return (aux != null);
    }

    public int Size() {
        Nodo aux = c;
        int i = 0;
        while (aux != null){
            aux = aux.sig;
        i++;
        }
        return i;
    }

    public boolean ConjuntoVacio() {
        return (c == null);
    }
}
