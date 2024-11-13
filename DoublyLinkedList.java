package com.vima;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;
    public DoublyLinkedList()
    {
        this.size = 0;
    }


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
