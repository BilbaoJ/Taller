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
public class CircularSingleLinkedList<T> implements Ilist<T> {

    private Node<T> head;
    private Node<T> tail;
    private Object circular1;

    public CircularSingleLinkedList() {
        head = tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private Node<T> addNode(T d) {
        Node<T> newNode = new Node<>(d);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNextNode(head);
            tail.setNextNode(newNode);
        }
        return newNode;
    }

    @Override
    public void add(T d) {
        head = addNode(d);
    }

    @Override
    public void addLast(T d) {
        tail = addNode(d);
    }

    @Override
    public void addOrdered(T d) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {
            tail.setNextNode(head.getNextNode());
            head = head.getNextNode();
        }

    }

    @Override

    public void deleteLast() {
        if (isEmpty()) {
        } else if (tail == head) {
            tail = null;
            head = null; //para cuando hay un nodo en la lista
        } else {
            Node<T> auxiliar = head;
            while (auxiliar.getNextNode() != tail) {
                auxiliar = auxiliar.getNextNode();
            }
            auxiliar.setNextNode(head);
            tail = auxiliar;
        }
    }

    public void joinList(CircularSingleLinkedList otherList) {
        if (otherList.head == null) {
            System.out.println("");
        } else {
            Node<T> current = otherList.head;
            while (current != null) {
                add((T) current.getData());
                current = current.getNextNode();
            }

        }

    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            for (Node<T> i = head; i != tail; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            return data += tail.getData();

        }
    }

}
