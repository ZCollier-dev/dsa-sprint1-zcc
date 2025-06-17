package org.example.linkedlist;

import org.example.Task;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public int getSize(){
        return this.size;
    }

    public Node createSingleLinkedlist(Task nodeValue){
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    //Insert Method
    public void insertLinkedList(Task nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null){
            createSingleLinkedlist(nodeValue);
            return;
        } else if (location <= 0) {
            node.next = head;
            head = node;
        } else if (location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    //Traversing through a linked list
    public String traverseLinkedList(){
        if (head == null) {
            return "SSL does not exist";
        } else {
            String returnString = "";
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                returnString += i + ": " + tempNode.value.toString() + "\n";
                tempNode = tempNode.next;
            }
            return returnString;
        }
    }

    //Search for an element
    public boolean searchNode(Task nodeValue){
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue) {
                    System.out.print("Found the node at location: " +i+"\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("Node not found");
        return false;
    }

    //Search for an element by id
    public Node searchNode(int location){
        if (head != null){
            if (location > 0 && location < size){
                Node tempNode = head;
                for (int i = 0; i <= location; i++) {
                    if (i == location){
                        System.out.println("Node found.\n");
                        return tempNode;
                    }
                    tempNode = tempNode.next;
                }
            } else {
                System.out.println("Index out of bounds.");
                return null;
            }
        }
        System.out.println("Node not found.");
        return null;
    }

    //Delete Method
    public void delete(int position){
        if (position > size || position < 0){
            System.out.println("Node is out of bounds.");
        } else if (position == 0){
            if (head.next != null){
                head = head.next;
            } else {
                head = null; // if head is the sole item, it becomes null
            }
            size--;
        } else if (position == size - 1){
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                if (i == size - 2){
                    tempNode.next = null;
                    tail = tempNode;
                    size--;
                    return;
                }
                tempNode = tempNode.next;
            }
        } else {
            Node tempNode = head;
            Node prevNode = null;
            Node nextNode;
            for (int i = 0; i < position; i++) {
                if (i == position - 1){
                    prevNode = tempNode;
                    break;
                }
                tempNode = tempNode.next;
            }
            tempNode = tempNode.next;
            nextNode = tempNode.next;
            prevNode.next = nextNode;
            size--;
        }
    }

}
