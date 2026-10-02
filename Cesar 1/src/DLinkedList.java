public class DLinkedList<E> implements IList<E> {

    private DNode<E> first;
    private int size;

    public DLinkedList() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public void add(E e) {
        DNode<E> node = new DNode<>(e);
        if (isEmpty()) {
            first = node;
        } else {
            DNode<E> cursor = first;
            while (cursor.getNext() != null) {
                cursor = (DNode<E>) cursor.getNext();
            }
            cursor.setNext(node);
            node.setPrev(cursor);
        }
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            DNode<E> node = new DNode<>(e);
            if (index == 0) {
                node.setNext(first);
                if (first != null) {
                    first.setPrev(node);
                }
                first = node;
            } else {
                DNode<E> cursor = first;
                DNode<E> prev = null;
                for (int i = 0; i < index; i++) {
                    prev = cursor;
                    cursor = (DNode<E>) cursor.getNext();
                }
                node.setPrev(prev);
                node.setNext(cursor);
                prev.setNext(node);
                if (cursor != null) {
                    cursor.setPrev(node);
                }
            }
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            DNode<E> aux;
            if (index == 0) {
                aux = first;
                first = (DNode<E>) first.getNext();
                if (first != null) {
                    first.setPrev(null);
                }
            } else {
                DNode<E> cursor = first;
                DNode<E> prev = null;
                int i = 0;
                while (i < index) {
                    prev = cursor;
                    cursor = (DNode<E>) cursor.getNext();
                    i++;
                }
                prev.setNext(cursor.getNext());
                aux = cursor;
                cursor = (DNode<E>) cursor.getNext();
                if (cursor != null) {
                    cursor.setPrev(prev);
                }
            }
            size--;
            return aux.getInfo();
        } else {
            throw new UnsupportedOperationException("index out of range");
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            Node<E> cursor = first;
            int i = 0;
            while (i < index) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        } else {
            throw new UnsupportedOperationException("index out of range");
        }
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {

        return first == null;
    }
    public void eliminarRepetidos() {
        if (isEmpty() || first.getNext() == null) {
            return;
        }

        DNode<E> actual = first;
        while (actual != null) {
            DNode<E> comparador = (DNode<E>) actual.getNext();
            DNode<E> anterior = actual;

            while (comparador != null) {
                if (actual.getInfo().equals(comparador.getInfo())) {
                    DNode<E> siguiente = (DNode<E>) comparador.getNext();
                    anterior.setNext(siguiente);
                    if (siguiente != null) {
                        siguiente.setPrev(anterior);
                    }
                    size--;
                    comparador = siguiente;
                } else {
                    anterior = comparador;
                    comparador = (DNode<E>) comparador.getNext();
                }
            }
            actual = (DNode<E>) actual.getNext();
        }
    }
    public void rotarDerecha() {
        if (isEmpty() || first.getNext() == null) {
            return;
        }

        // Encontrar el último nodo
        DNode<E> ultimo = first;
        while (ultimo.getNext() != null) {
            ultimo = (DNode<E>) ultimo.getNext();
        }

        // Penúltimo nodo
        DNode<E> penultimo = (DNode<E>) ultimo.getPrev();

        // Ajustar referencias
        penultimo.setNext(null);
        ultimo.setNext(first);
        ultimo.setPrev(null);
        first.setPrev(ultimo);
        first = ultimo;
    }
    public void concatenar(DLinkedList<E> otraLista) {
        if (otraLista == null || otraLista.isEmpty()) {
            return;
        }

        if (this.isEmpty()) {
            this.first = otraLista.first;
            this.size = otraLista.size;
            return;
        }

        // Ir al último nodo de esta lista
        DNode<E> ultimo = first;
        while (ultimo.getNext() != null) {
            ultimo = (DNode<E>) ultimo.getNext();
        }

        // Enlazar con la otra lista
        ultimo.setNext(otraLista.first);
        otraLista.first.setPrev(ultimo);

        this.size += otraLista.size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cursor = first;
        while (cursor != null) {
            sb.append(cursor.getInfo());
            if (cursor.getNext() != null) {
                sb.append("-");
            }
            cursor = cursor.getNext();
        }
        return sb.toString();
    }
}