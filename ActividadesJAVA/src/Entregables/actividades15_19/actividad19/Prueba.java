package Entregables.actividades15_19.actividad19;

public class Prueba {
    public class PruebaConjuntos {

        public static void main(String[] args) {
            // 1. Instanciamos dos conjuntos: A y B
            Conjunto<String> conjuntoA = new Conjunto<>();
            Conjunto<String> conjuntoB = new Conjunto<>();

            // 2. Probamos addElt (Agregar elementos)
            conjuntoA.addElt("Manzana");
            conjuntoA.addElt("Pera");
            conjuntoA.addElt("Uva");
            conjuntoA.addElt("Manzana");

            conjuntoB.addElt("Uva");
            conjuntoB.addElt("Mango");
            conjuntoB.addElt("Sandía");

            System.out.println("Conjunto A: " + (conjuntoA.hasElt() ? "Con datos" : "Vacío") + " | Tamaño: " + conjuntoA.size());
            System.out.println("Conjunto B: " + (conjuntoB.hasElt() ? "Con datos" : "Vacío") + " | Tamaño: " + conjuntoB.size());

            System.out.println("--- PRUEBAS DE OPERACIONES ---");

            // 3. Prueba de Unión (A ∪ B)
            Conjuntable<String> union = conjuntoA.union(conjuntoB);
            System.out.println("Unión (A + B) tiene tamaño: " + union.size());

            // 4. Prueba de Intersección (A ∩ B)


            Conjuntable<String> interseccion = conjuntoA.interseccion(conjuntoB);
            System.out.println("¿Intersección contiene 'Uva'?: " + interseccion.contains("Uva"));
            System.out.println("¿Intersección contiene 'Mango'?: " + interseccion.contains("Mango"));

            // 5. Prueba de Diferencia (A - B)

            Conjuntable<String> diferencia = conjuntoA.diferens(conjuntoB);
            System.out.println("Diferencia (A - B) tamaño: " + diferencia.size());

            // 6. Prueba de Subconjunto
            System.out.println("¿A es subconjunto de Unión?: " + conjuntoA.subSet(union));
            System.out.println("¿B es subconjunto de A?: " + conjuntoB.subSet(conjuntoA));

            // 7. Prueba de Eliminar (RemElt) y Vaciar (ToEmpty)
            conjuntoA.remElt("Pera");
            System.out.println("Tamaño A tras borrar 'Pera': " + conjuntoA.size());

            conjuntoA.toEmpty();
            System.out.println("¿A está vacío tras toEmpty()?: " + !conjuntoA.hasElt());
        }
    }
}
