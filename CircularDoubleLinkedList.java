/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 * @param <T>
 */
public class CircularDoubleLinkedList<T extends Comparable> implements Ilist<T> {

    DoubleNode<T> head;
    private Object miListaCD;

    public CircularDoubleLinkedList() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public DoubleNode<T> addNode(T d) {
        DoubleNode<T> newNode = new DoubleNode<>(d);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            newNode.setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(head.getPreviousNode());
            newNode.setNextNode(head);
            head.getPreviousNode().setNextNode(newNode);
            head.setPreviousNode(newNode);

        }
        return newNode;
    }

    @Override
    public void add(T d) {
        head = addNode(d);

    }

    @Override
    public void addLast(T d) {
        addNode(d);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean exist(T d) {
        DoubleNode<T> newNode = head;
        while (newNode.getPreviousNode() != head) {
            if (newNode.getData() == d) {
                return true;

            }
            newNode = newNode.getNextNode();

        }
        return newNode.getData() == d;

    }

    @Override
    public void addOrdered(T d) {
        //Agregar datos ordenados sin repetir valor
        //(si el dato ya se encuentra en la lista, no ingresarlo y mostrar advertencia).
        if (isEmpty() || head.getData().compareTo(d) > 0) {
            add(d);
        } else {
            if (exist(d)) {
                System.out.println("Dato existente");
            } else if (head.getPreviousNode().getData().compareTo(d) > 0) {
                addLast(d);
            } else {
                DoubleNode<T> current = head;
                while (current.getData().compareTo(d) < 0) {
                    current = current.getNextNode();
                }
                DoubleNode<T> previous = current.getPreviousNode();
                DoubleNode<T> newNode = new DoubleNode<>(previous, d, current);
                previous.setNextNode(newNode);
                current.setPreviousNode(newNode);
            }

        }

    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            head.getNextNode().setPreviousNode(null);
            head = head.getNextNode();
            //Eliminar el primer dato.
        }
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            head.getPreviousNode().setNextNode(null);
            head = head.getPreviousNode();
        }

        //Eliminar el último dato.
    }

    /**
     * Mostrar los datos de forma descendente.
     *
     * @return LIsta de datos en orden descendente
     */
    public String showDataDesc() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            DoubleNode<T> previous = head.getPreviousNode();
            for (DoubleNode<T> i = previous; i != head; i = i.getPreviousNode()) {
                data += i.getData() + "";

            }
           return data += head.getData();
        } 

    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            DoubleNode<T> tail = head.getPreviousNode();
            for (DoubleNode<T> i = head; i != tail; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            return data += tail.getData();

        }
    }

}
