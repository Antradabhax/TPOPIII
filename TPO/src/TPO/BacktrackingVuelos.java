package TPO;

import TPO.Intefaz.InterfazGrafo;

import java.util.List;

public class BacktrackingVuelos() {
   public static VuelosCostoTripulacion BV(InterfazGrafo GVuelos, int cantTrip, String AeropuertoOrigen, VuelosCostoTripulacion Valor, int GastoTotal){

      if (visitados.capacidad() == grafo.vertices().capacidad()) {
         solucionActual.agregarElemento(etapa + 1, solucionActual.recuperarElemento(0));
         costoActual = calcularCosto(grafo, solucionActual);
         if (costoActual < mejorCosto) {
            // mejorSolucion = solucionActual; Descomentar si necesitamos el recorrido
            mejorCosto = costoActual;
         }
      } else {
         VectorTDA<E> adyacentes = grafo.adyacentes(actual).aVector();
         for (int i = 0; i< adyacentes.capacidadVector(); i++) {
            E vecino = adyacentes.recuperarElemento(i);
            if (!visitados.pertenece(vecino)) {
               visitados.agregar(vecino);
               mejorCosto = tsp(grafo, vecino, visitados, solucionActual, costoActual, mejorSolucion, mejorCosto,etapa + 1);
               visitados.sacar(vecino);
            }
         }
      }
      return mejorCosto;
   }
}
