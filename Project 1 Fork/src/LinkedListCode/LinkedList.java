package LinkedListCode;

import java.util.ArrayList;

public class LinkedList {

   public node head;

   public LinkedList(node head) {
       this.head = head;
   }

    public void add(int data) { this.head = new node(data, this.head); }

    public int getLength() {
       // returns the length of the given linked list, called LinkedListName.getLength()
        return this.toString().length();
    }

    public String toString() { // toString override
        if (this.head == null) {
            // if the list is empty, return an empty string
            return "";
        }

        // if length >= 1, create a new arraylist, append every value to it, and return the reversed list as a string
        ArrayList<Integer> numberStr = new ArrayList<>();
        node current = this.head;
        String returnStr = "";

        while (current.next != null) {
            numberStr.add(current.value);
            current = current.next;
        }

        numberStr.add(current.value);

        for (int digit: numberStr) {
            returnStr += digit;
        }

        return returnStr;
    }

    public void reverse() {
        node prev = null;
        node current = this.head;
        node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }

}