public class Main {

    public static void main(String[] args) {

        // EJERCICIO 1: Eliminar elementos repetidos
        System.out.println(">>> EJERCICIO 1: Eliminar elementos repetidos\n");

        // Caso positivo
        DLinkedList<String> l1 = new DLinkedList<>();
        l1.add("A");
        l1.add("B");
        l1.add("A");
        l1.add("C");
        l1.add("B");
        l1.add("D");
        System.out.println("  [POSITIVO] Lista original: " + l1);
        l1.eliminarRepetidos();
        System.out.println("  [POSITIVO] Sin repetidos:  " + l1);

        // Caso negativo: lista vacía
        DLinkedList<String> l1vacia = new DLinkedList<>();
        l1vacia.eliminarRepetidos();
        System.out.println("  [NEGATIVO] Lista vacía: '" + l1vacia
                + "' | size=" + l1vacia.size());

        // Caso negativo: todos repetidos
        DLinkedList<Integer> l1rep = new DLinkedList<>();
        l1rep.add(7);
        l1rep.add(7);
        l1rep.add(7);
        System.out.println("  [NEGATIVO] Todos iguales antes: " + l1rep);
        l1rep.eliminarRepetidos();
        System.out.println("  [NEGATIVO] Todos iguales después: " + l1rep
                + " | size=" + l1rep.size());

        System.out.println("\n-------------------------------------------------\n");

        // EJERCICIO 2: Rotar una posición a la derecha
        System.out.println(">>> EJERCICIO 2: Rotar una posición a la derecha\n");

        // Caso positivo
        DLinkedList<String> l2 = new DLinkedList<>();
        l2.add("A");
        l2.add("B");
        l2.add("C");
        l2.add("D");
        System.out.println("  [POSITIVO] Lista original: " + l2);
        l2.rotarDerecha();
        System.out.println("  [POSITIVO] Rotada:         " + l2);

        // Caso negativo: un solo elemento
        DLinkedList<String> l2uno = new DLinkedList<>();
        l2uno.add("Z");
        l2uno.rotarDerecha();
        System.out.println("  [NEGATIVO] Un elemento tras rotar: " + l2uno);

        // Caso negativo: lista vacía
        DLinkedList<String> l2vacia = new DLinkedList<>();
        l2vacia.rotarDerecha();
        System.out.println("  [NEGATIVO] Lista vacía tras rotar: '"
                + l2vacia + "' | size=" + l2vacia.size());

        System.out.println("\n-------------------------------------------------\n");

        // EJERCICIO 3: Concatenar dos listas
        System.out.println(">>> EJERCICIO 3: Concatenar dos listas\n");

        // Caso positivo
        DLinkedList<String> la = new DLinkedList<>();
        la.add("A");
        la.add("B");
        la.add("C");
        la.add("D");

        DLinkedList<String> lb = new DLinkedList<>();
        lb.add("E");
        lb.add("F");
        lb.add("G");
        lb.add("H");

        System.out.println("  [POSITIVO] Lista1: " + la);
        System.out.println("  [POSITIVO] Lista2: " + lb);
        la.concatenar(lb);
        System.out.println("  [POSITIVO] Concatenada: " + la);

        // Caso negativo: concatenar con null
        DLinkedList<String> ln = new DLinkedList<>();
        ln.add("X");
        ln.concatenar(null);
        System.out.println("  [NEGATIVO] Concatenar null: " + ln);

        // Caso negativo: concatenar con lista vacía
        DLinkedList<String> lv1 = new DLinkedList<>();
        lv1.add("P");
        DLinkedList<String> lv2 = new DLinkedList<>();
        lv1.concatenar(lv2);
        System.out.println("  [NEGATIVO] Concatenar lista vacía: " + lv1);

        // Caso negativo: concatenar a una lista vacía
        DLinkedList<String> lvacia = new DLinkedList<>();
        DLinkedList<String> llena = new DLinkedList<>();
        llena.add("M");
        llena.add("N");
        lvacia.concatenar(llena);
        System.out.println("  [NEGATIVO] Vacía + llena: " + lvacia);
    }
}
