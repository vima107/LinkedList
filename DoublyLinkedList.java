package com.vima;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public DoublyLinkedList()
    {
        this.size = 0;
    }

    //for inserting element..
    public void insertFirst(int value)
    {
        Node node=new Node(value);

        node.next=head;
        node.prev=null;
        if(head!=null)
        {
            head.prev=node;
        }
        head=node;
        if(tail==null)
        {
            tail=head;
        }
        size++;
        display();

    }

    public void insertLast(int value)
    {
        if(tail==null)
        {
            insertFirst(value);
            return;
        }
        Node node =new Node(value);
        tail.next=node;
        node.prev=tail;
        node.next=null;
        tail=node;
        size++;
        display();
        //If u don't wanna use tail to add the element in the last node
        /*
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        node.next=null
        temp=node;*/

    }

    public void insert(int index, int value)
    {
        if(index==0)
        {
            insertFirst(value);
            return;
        }
        if(index==size)
        {
            insertLast(value);
            return;
        }
        Node node=new Node(value);
        Node temp=head;
        for(int i=0;i<index;i++)
        {
                temp=temp.next;
        }
        node.prev=temp.prev;
        node.prev.next=node;
        node.next=temp;
        temp.prev=node;
        size++;
        display();
    }

    public void deleteFirst()
    {
        if(head==null && tail==null)
        {
            System.out.println("LinkedList underflow");
            return;
        }
        head=head.next;
        if(head==null)
        {
            tail=null;
            size--;
            display();
            return;
        }
        head.prev.next=null;
        head.prev=null;
        size--;
        display();
    }

    public void deleteLast()
    {

        if(head==null && tail==null)
        {
            System.out.println("LinkedList underflow");
            return;
        }
        tail=tail.prev;
        if(tail==null)
        {
            head=null;
            size--;
            display();
            return;
        }
        tail.next.prev=null;
        tail.next=null;
        size--;
        display();
    }

    public void delete(int index)
    {
        if(index==0)
        {
            deleteFirst();
            return;
        }
        if(index==size-1)
        {
            deleteLast();
            return;
        }
        if(index<0 || index>=size)
        {
            System.out.println("Invalid index");
            return;
        }

        Node temp=deleteHelper(index);

        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        temp.prev=null;
        temp.next=null;
        size--;
        display();
    }

    public Node deleteHelper(int index)
    {
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    public void display()
    {
        Node temp=head;

        while(temp!=null)
        {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("end");
    }

    public void displayReverse()
    {
        Node temp=tail;
        while(temp!=null)
        {
            System.out.print(temp.value+"->");
            temp=temp.prev;
        }
        System.out.println("start");
    }

    public void update(int index, int value)
    {
        if(index<0 || index==size)
        {
            System.out.println("Invalid index");
            return;
        }
        Node temp=updateHelper(index);
        temp.value=value;
        display();
    }

    public Node updateHelper(int index)
    {
        Node temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        return temp;
    }

    // Searching an element is present or not
    public void search(int value)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        searchHelper(value,arr);
        if(arr.size()==0)
        {
            System.out.println("element is not present");
            return;
        }
        System.out.print("element is present at index: ");
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ,");
        }
        System.out.println();
    }

    public List<Integer> searchHelper(int value, List<Integer>arr)
    {
        Node temp=head;
        for(int i=0;i<size;i++)
        {
            if(temp.value==value)
            {
                arr.add(i);
            }
            temp=temp.next;
        }
        return arr;
    }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value)
        {
            this.value=value;
        }

        public Node(int value, Node next, Node prev)
        {
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
}
