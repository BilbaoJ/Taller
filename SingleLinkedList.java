/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author samaniw
 */
public class SingleLinkedList<T extends Number & Comparable> implements Ilist<T> {

    private Node<T> head;
    private int maj;
    private int min;
    private int sum;
    private int size;

    public SingleLinkedList() {
        head = null;
        size = 0;
        maj = 0;
        min = Integer.MAX_VALUE;

    }

    @Override
    public boolean isEmpty() {
        return head == null;
        /*
        if(head==null){
            return true;
        }else{
            return false;
        }
         */
    }

    public double getAverage() {
        return sum / size;
    }

    @Override
    public void add(T d) {
        //1. Crear el nodo
        Node<T> newNode = new Node<>(d);
        //2. Modificar el siguiente nodo del nuevo nodo para sea la cabeza
        newNode.setNextNode(head);
        //3. Modificar la cabeza de la estructura: nuevo nodo
        head = newNode;
        //4. Incrementar el tamaño
        size++;

        if (newNode.getData().intValue() > maj) {
            maj = newNode.getData().intValue();
        }//Menor

        sum = sum + d.intValue();
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            add(d);
        } else {
            Node<T> current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            Node<T> newNode = new Node<>(d);
            current.setNextNode(newNode);
            size++;
        }
        sum = sum + d.intValue();
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
    }

    @Override
    public void addOrdered(T d) {
        /*Si la lista esta vacía, 
        o el valor del primer elemento de la lista(cabeza) 
        es mayor que el nuevo, insertar el nuevo nodo en la 
        primera posición de la lista y modificar la cabecera 
        respectivamente.
         */
        if (isEmpty() || head.getData().compareTo(d) > 0) {
            add(d);
        } else {
            /*
        Si no se cumple el caso anterior, buscar el lugar adecuado
        para la inserción: recorrer la lista conservando el nodo
        actual. Inicializar nodo actual con el valor de primera
        posición, y avanzar mientras el siguiente nodo no sea nulo 
        y el dato que contiene la siguiente posición sea menor 
        o igual que el dato a insertar.
             */

            Node<T> current = head;
            while (current.getNextNode() != null
                    && current.getNextNode().getData().compareTo(d) < 0) {
                current = current.getNextNode();
            }
            /*Con esto el nodo actual señala al nodo adecuado,
        a continuación insertar el nuevo nodo después de él.
             */
            Node<T> newNode = new Node<>(d);
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
            size++;
        }
        //validar el dato con el mayor y el menor para actualizar dato
        //sumar los datos
        sum = sum + d.intValue();
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("Lista vacia");
        } else {

            if (head.getData().intValue() == maj) {
                maj = 0;
                maj = getMaj();
            }
            if (head.getData().intValue() == min) {
                min = 0;
                min = getMin();
            }
            //apuntar la cabeza al segundo dato
            head = head.getNextNode();
            size--;

        }

        //verificar si el dato eliminado es el mínimo o máximo: actualizar(recorrer estructura)
        //restar de la suma de datos
    }

    @Override
    public void deleteLast() {
        //Si la lista solo tiene un elemento

        if (head != null) {
            if (head.getNextNode() == null) {
                head = null;
            }
            // cuando tiene más de un elemnto   
        } else {
            Node<T> pointer = head;
            while (pointer.getNextNode().getNextNode() != null) {
                pointer = pointer.getNextNode();
                
                //pointer.getNextNode() = null;
                
            }
        }

        sum -= head.getData().intValue();
        //localizar el nodo anterior a getNextNode()==null
        //restar de la suma de datos
    }

    @Override
    public String showData() {
        if (isEmpty()) {
            return "Lista vacia";
        } else {
            String data = "";
            //Forma tradicional de recorrer la estructura
//            Node<T> current=head;
//            while(current!=null){
//                data += current.getData() + " ";
//                current = current.getNextNode();
//            }

            //for (int i = 0; i < n; i=i+1) {
            for (Node<T> i = head; i != null; i = i.getNextNode()) {
                data += i.getData() + " ";
            }
            //verificar si el dato eliminado es el mínimo o máximo: actualizar(recorrer estructura)
            return data;

        }
    }

    /**
     * Muestra el total de datos
     *
     * @return El total de datos
     */
    public int getSize() {
        return size;
    }

    public int getMaj() {
        Node<T> node = head;
        if (isEmpty()) {
            System.out.println("La lista esta vacía");
        } else {
            while (node.getNextNode() != null) {
                if (node.getData().intValue() > maj) {
                    maj = node.getData().intValue();
                }
            }
            if (node.getData().intValue() > maj) {
                maj = node.getData().intValue();
            }

        }

        return maj;
    }

    public int getMin() {

        Node<T> node = head;
        if (isEmpty()) {
            System.out.println("La lista esta vacía");
        } else {
            while (node.getNextNode() != null) {
                if (node.getData().intValue() < min) {
                    min = node.getData().intValue();
                }
            }
            if (node.getData().intValue() < min) {
                min = node.getData().intValue();
            }

        }
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @param maj the maj to set
     */
    public void setMaj(int maj) {
        this.maj = maj;
    }

}
